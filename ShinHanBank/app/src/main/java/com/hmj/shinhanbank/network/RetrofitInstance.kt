package com.hmj.shinhanbank.network

import com.hmj.shinhanbank.network.dao.LoginService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private const val URL = "http://10.80.161.222:3000"

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val loginService: LoginService = retrofit.create(LoginService::class.java)
}