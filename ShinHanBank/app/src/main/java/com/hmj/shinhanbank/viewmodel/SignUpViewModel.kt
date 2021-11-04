package com.hmj.shinhanbank.viewmodel

import android.content.ContentResolver
import android.net.Uri
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hmj.shinhanbank.network.RetrofitInstance
import com.hmj.shinhanbank.network.dao.LoginService
import com.hmj.shinhanbank.network.dto.Request.SignUpRequest
import com.hmj.shinhanbank.network.dto.Response.Msg
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.Multipart
import java.io.File

class SignUpViewModel: ViewModel() {
    val signUpLiveData: MutableLiveData<Msg> = MutableLiveData()
    val errorLiveData: MutableLiveData<String> = MutableLiveData()
    val imgLiveData: MutableLiveData<Uri> = MutableLiveData()

    private val loginService: LoginService by lazy { RetrofitInstance.loginService }

    fun signUp(signUpRequest: SignUpRequest) {
        loginService.signup(signUpRequest).enqueue(object: Callback<Msg>{
            override fun onResponse(call: Call<Msg>, response: Response<Msg>) {
                if (response.isSuccessful) {
                    Log.d("signUp", response.code().toString())
                    signUpLiveData.postValue(response.body())
                } else {
                    Log.d("signUp", response.code().toString())
                    errorLiveData.postValue(response.errorBody()?.string())
                }
            }
            override fun onFailure(call: Call<Msg>, t: Throwable) {
                signUpLiveData.postValue(null)
            }
        })
    }

    fun signUpMultiPart() {
        val file = imgLiveData.value!!.toString()

        val fileBody: RequestBody = RequestBody.create(MediaType.parse("image/jpeg"), file)

        val filePart: MultipartBody.Part =
            MultipartBody.Part.createFormData("attachment", "profile.jpg", fileBody)

        loginService.signUpMultipart(fileBody, filePart).enqueue(object : Callback<Msg> {
            override fun onResponse(call: Call<Msg>, response: Response<Msg>) {
                if (response.isSuccessful) {
                    Log.d("signUpMulti", response.code().toString())
                    signUpLiveData.postValue(response.body())
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