package com.hmj.shinhanbank.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hmj.shinhanbank.network.RetrofitInstance
import com.hmj.shinhanbank.network.dao.LoginService
import com.hmj.shinhanbank.network.dto.Request.LoginAuthNumRequest
import com.hmj.shinhanbank.network.dto.Request.SignUpAuthNumRequest
import com.hmj.shinhanbank.network.dto.Response.Msg
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AuthNumViewModel : ViewModel() {
    private val loginService: LoginService by lazy { RetrofitInstance.loginService }
    val authLiveData: MutableLiveData<Msg> = MutableLiveData()
    val errorLiveData: MutableLiveData<String> = MutableLiveData()

    fun signUpAuth(signUpAuthNumRequest: SignUpAuthNumRequest) {
        loginService.signUpAuthNum(signUpAuthNumRequest).enqueue(object: Callback<Msg> {
            override fun onResponse(call: Call<Msg>, response: Response<Msg>) {
                if (response.isSuccessful) {
                    authLiveData.postValue(response.body())
                } else {
                    errorLiveData.postValue(response.errorBody()?.string())
                }
            }

            override fun onFailure(call: Call<Msg>, t: Throwable) {
                authLiveData.postValue(null)
            }
        })
    }

    fun signInAuth(loginAuthNumRequest: LoginAuthNumRequest) {
        loginService.loginAuthNum(loginAuthNumRequest).enqueue(object: Callback<Msg> {
            override fun onResponse(call: Call<Msg>, response: Response<Msg>) {
                if (response.isSuccessful) {
                    authLiveData.postValue(response.body())
                } else {
                    errorLiveData.postValue(response.errorBody()?.string())
                }
            }

            override fun onFailure(call: Call<Msg>, t: Throwable) {
                authLiveData.postValue(null)
            }
        })
    }
}