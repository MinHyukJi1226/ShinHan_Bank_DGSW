package com.hmj.shinhanbank.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hmj.shinhanbank.network.RetrofitInstance
import com.hmj.shinhanbank.network.dao.LoginService
import com.hmj.shinhanbank.network.dto.Request.SignUpRequest
import com.hmj.shinhanbank.network.dto.Response.Token
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpViewModel: ViewModel() {
    val signUpLiveData: MutableLiveData<Token> = MutableLiveData()
    private val loginService: LoginService by lazy { RetrofitInstance.loginService }

    fun callApi(signUpRequest: SignUpRequest) {
        loginService.signup(signUpRequest).enqueue(object: Callback<Token>{
            override fun onResponse(call: Call<Token>, response: Response<Token>) {
                if (response.isSuccessful) {
                    signUpLiveData.postValue(response.body())
                }
            }
            override fun onFailure(call: Call<Token>, t: Throwable) {
                signUpLiveData.postValue(null)
            }
        })
    }
}