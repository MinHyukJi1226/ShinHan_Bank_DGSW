package com.hmj.shinhanbank.util

import com.hmj.shinhanbank.util.PreferenceUtils.token
import okhttp3.Interceptor
import okhttp3.Response

class TokenInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder().addHeader("authorization", token?:"").build()
        return chain.proceed(request)
    }

}