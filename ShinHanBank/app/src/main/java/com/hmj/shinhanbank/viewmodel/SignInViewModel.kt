package com.hmj.shinhanbank.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hmj.shinhanbank.network.RetrofitInstance
import com.hmj.shinhanbank.network.dao.LoginService
import com.hmj.shinhanbank.network.dto.Request.LoginRequest
import com.hmj.shinhanbank.network.dto.Response.Msg
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SignInViewModel : ViewModel() {
    val signInLiveData: MutableLiveData<Msg> = MutableLiveData()
    val errorLiveData: MutableLiveData<String> = MutableLiveData()
    private val loginService: LoginService by lazy { RetrofitInstance.loginService }

    fun login(loginRequest: LoginRequest) {
        loginService.login(loginRequest).enqueue(object : Callback<Msg> {
            override fun onResponse(call: Call<Msg>, response: Response<Msg>) {
                Log.d("SignIn", "${response.code()}-${response.message()}: ${response.body()}")
                Log.d("SignIn", response.raw().toString())
                if (response.isSuccessful){
                    signInLiveData.postValue(response.body())
//                    signInLiveData.postValue(response.body())
                } else {
                    errorLiveData.postValue(response.errorBody()?.string())
                }
            }

            override fun onFailure(call: Call<Msg>, t: Throwable) {
                Log.d("SignIn", t.message.toString())
                signInLiveData.postValue(null)
            }
        })
    }

}