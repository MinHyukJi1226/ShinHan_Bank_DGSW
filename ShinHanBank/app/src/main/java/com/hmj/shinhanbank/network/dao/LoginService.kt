package com.hmj.shinhanbank.network.dao

import com.hmj.shinhanbank.network.dto.Request.LoginAuthNumRequest
import com.hmj.shinhanbank.network.dto.Request.LoginRequest
import com.hmj.shinhanbank.network.dto.Request.SignUpAuthNumRequest
import com.hmj.shinhanbank.network.dto.Request.SignUpRequest
import com.hmj.shinhanbank.network.dto.Response.Msg
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

interface LoginService {
//    @GET("signup/id")

    @POST("/signup")
    fun signup(@Body signUpRequest: SignUpRequest): Call<Msg>

    @POST("/signup/quick")
    fun signUpAuthNum(@Body signUpAuthNumRequest: SignUpAuthNumRequest) : Call<Msg>

    @POST("/login")
    fun login(@Body loginRequest: LoginRequest): Call<Msg>

    @POST("/login/quick")
    fun loginAuthNum(@Body loginAuthNumRequest: LoginAuthNumRequest): Call<Msg>
}