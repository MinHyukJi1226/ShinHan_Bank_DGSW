package com.hmj.shinhanbank.network.dao

import com.hmj.shinhanbank.network.dto.Request.AccountCheck
import com.hmj.shinhanbank.network.dto.Request.CheckSendAccount
import com.hmj.shinhanbank.network.dto.Request.CreateAccount
import com.hmj.shinhanbank.network.dto.Request.SendAccount
import com.hmj.shinhanbank.network.dto.Response.HoldAccount
import com.hmj.shinhanbank.network.dto.Response.Msg
import retrofit2.Call
import retrofit2.http.*

interface AccountService {

    @POST("/account")
    fun createAccount(@Body createAccount: CreateAccount) : Call<Msg>

    @POST("/account/check")
    fun accountCheck(@Body accountCheck: AccountCheck) : Call<Msg>

    @GET("/send/check/{targetaccount}")
    fun checkTargetAccount(@Query("targetaccount") targetAccount: String) : Call<Msg>

    @PUT("/send")
    fun sendAccount(@Body sendAccount: SendAccount) : Call<Msg>

    @POST("/send/pw")
    fun checkSendAccount(@Body checkSendAccount: CheckSendAccount) : Call<Msg>

    @GET("/hold")
    fun holdAccount() : Call<List<HoldAccount>>
}