package com.hmj.shinhanbank.application

import android.app.Application
import com.hmj.shinhanbank.util.PreferenceUtils

class App : Application() {
    override fun onCreate() {
        PreferenceUtils.init(applicationContext)
        super.onCreate()
    }
}