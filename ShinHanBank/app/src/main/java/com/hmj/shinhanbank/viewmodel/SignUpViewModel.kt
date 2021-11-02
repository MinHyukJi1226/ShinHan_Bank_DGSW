package com.hmj.shinhanbank.viewmodel

import android.net.Uri
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hmj.shinhanbank.network.RetrofitInstance
import com.hmj.shinhanbank.network.dao.LoginService
import com.hmj.shinhanbank.network.dto.Request.SignUpRequest
import com.hmj.shinhanbank.network.dto.Response.Msg
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpViewModel: ViewModel() {
    val signUpLiveData: MutableLiveData<Msg> = MutableLiveData()
    val errorLiveData: MutableLiveData<String> = MutableLiveData()
    val imgLiveData: MutableLiveData<Uri> = MutableLiveData()

    private val loginService: LoginService by lazy { RetrofitInstance.loginService }

    fun signUp(signUpRequest: SignUpRequest) {
        loginService.signup(signUpRequest).enqueue(object: Callback<Msg>{
            override fun onResponse(call: Call<Msg>, response: Response<Msg>) {
                if (response.isSuccessful) {
                    signUpLiveData.postValue(response.body())
                } else {
                    errorLiveData.postValue(response.errorBody()?.string())
                }
            }
            override fun onFailure(call: Call<Msg>, t: Throwable) {
                signUpLiveData.postValue(null)
            }
        })
    }

    fun overlapId(id: String) {
        loginService.overlapId(id).enqueue(object : Callback<Msg> {
            override fun onResponse(call: Call<Msg>, response: Response<Msg>) {
                if (response.isSuccessful) {
                    signUpLiveData.postValue(response.body())
                } else {
                    errorLiveData.postValue(response.errorBody()?.string())
                }
            }

            override fun onFailure(call: Call<Msg>, t: Throwable) {
                signUpLiveData.postValue(null)
            }
        })
    }
}