package com.hmj.shinhanbank.network.dao

import com.hmj.shinhanbank.network.dto.Request.LoginAuthNumRequest
import com.hmj.shinhanbank.network.dto.Request.LoginRequest
import com.hmj.shinhanbank.network.dto.Request.SignUpAuthNumRequest
import com.hmj.shinhanbank.network.dto.Request.SignUpRequest
import com.hmj.shinhanbank.network.dto.Response.Token
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Body

interface LoginService {
//    @GET("signup/id")

    @POST("/signup")
    fun signup(@Body signUpRequest: SignUpRequest): Call<Token>

    @POST("/signup/quick")
    fun signUpAuthNum(@Body signUpAuthNumRequest: SignUpAuthNumRequest)

    @POST("/login")
    fun login(@Body loginRequest: LoginRequest): Call<Token>

    @POST("/login/quick")
    fun loginAuthNum(@Body loginAuthNumRequest: LoginAuthNumRequest): Call<Token>
}