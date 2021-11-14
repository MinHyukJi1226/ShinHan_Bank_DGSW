package com.hmj.shinhanbank.network

import com.hmj.shinhanbank.network.dao.LoginService
import com.hmj.shinhanbank.util.TokenInterceptor
import okhttp3.OkHttpClient
import com.google.gson.Gson
import com.hmj.shinhanbank.network.dao.AccountService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private const val URL = "http://10.80.161.222:5000"

    private val gson = Gson().newBuilder().setLenient().create()

    private val okHttpClient: OkHttpClient = OkHttpClient().newBuilder().addInterceptor(TokenInterceptor()).build()

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(okHttpClient)
            .build()
    }

    val loginService: LoginService = retrofit.create(LoginService::class.java)
    val accountService: AccountService = retrofit.create(AccountService::class.java)
}