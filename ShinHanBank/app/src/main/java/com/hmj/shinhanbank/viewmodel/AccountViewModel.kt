package com.hmj.shinhanbank.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hmj.shinhanbank.network.RetrofitInstance
import com.hmj.shinhanbank.network.dto.Request.AccountCheck
import com.hmj.shinhanbank.network.dto.Request.CheckSendAccount
import com.hmj.shinhanbank.network.dto.Request.CreateAccount
import com.hmj.shinhanbank.network.dto.Request.SendAccount
import com.hmj.shinhanbank.network.dto.Response.HoldAccount
import com.hmj.shinhanbank.network.dto.Response.Msg
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AccountViewModel : ViewModel() {
    
    val msg: MutableLiveData<Msg> = MutableLiveData()
    val accountLiveData: MutableLiveData<List<HoldAccount>> = MutableLiveData()
    
    private val accountService by lazy { RetrofitInstance.accountService }
    
    fun createAccount(createAccount: CreateAccount) {
        accountService.createAccount(createAccount).enqueue(object: Callback<Msg> {
            override fun onResponse(call: Call<Msg>, response: Response<Msg>) {
                if (response.isSuccessful) {
                    msg.postValue(response.body())
                }
            }

            override fun onFailure(call: Call<Msg>, t: Throwable) {
                msg.postValue(null)
            }
        })
    }

    fun accountCheck(accountCheck: AccountCheck) {
        accountService.accountCheck(accountCheck).enqueue(object : Callback<Msg> {
            override fun onResponse(call: Call<Msg>, response: Response<Msg>) {
                if (response.isSuccessful) {
                    msg.postValue(response.body())
                }
            }

            override fun onFailure(call: Call<Msg>, t: Throwable) {
                msg.postValue(null)
            }
        })
    }

    fun checkTargetAccount(targetAccount: String) {
        accountService.checkTargetAccount(targetAccount).enqueue(object: Callback<Msg> {
            override fun onResponse(call: Call<Msg>, response: Response<Msg>) {
                if (response.isSuccessful) {
                    msg.postValue(response.body())
                }
            }

            override fun onFailure(call: Call<Msg>, t: Throwable) {
                msg.postValue(null)
            }
        })
    }

    fun sendAccount(sendAccount: SendAccount) {
        accountService.sendAccount(sendAccount).enqueue(object: Callback<Msg> {
            override fun onResponse(call: Call<Msg>, response: Response<Msg>) {
                if (response.isSuccessful) {
                    msg.postValue(response.body())
                }
            }

            override fun onFailure(call: Call<Msg>, t: Throwable) {
                msg.postValue(null)
            }
        })
    }

    fun checkSendAccount(checkSendAccount: CheckSendAccount) {
        accountService.checkSendAccount(checkSendAccount).enqueue(object: Callback<Msg> {
            override fun onResponse(call: Call<Msg>, response: Response<Msg>) {
                msg.postValue(response.body())
            }

            override fun onFailure(call: Call<Msg>, t: Throwable) {
                msg.postValue(null)
            }
        })
    }

    fun holdAccount() {
        accountService.holdAccount().enqueue(object: Callback<List<HoldAccount>> {
            override fun onResponse(
                call: Call<List<HoldAccount>>,
                response: Response<List<HoldAccount>>
            ) {
                accountLiveData.postValue(response.body())
            }

            override fun onFailure(call: Call<List<HoldAccount>>, t: Throwable) {
                accountLiveData.postValue(null)
            }
        })
    }
}