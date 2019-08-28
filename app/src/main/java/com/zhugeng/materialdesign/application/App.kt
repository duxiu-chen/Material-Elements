package com.zhugeng.materialdesign.application

import android.app.Application
import android.content.Context
import android.support.multidex.MultiDex
import com.tencent.bugly.crashreport.CrashReport
import com.umeng.commonsdk.UMConfigure
import com.zhugeng.materialdesign.R

class App: Application() {

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    override fun onCreate() {
        super.onCreate()
        UMConfigure.init(this, resources.getString(R.string.umeng_appkey), "Material Design", UMConfigure.DEVICE_TYPE_PHONE, "")
        CrashReport.initCrashReport(applicationContext, resources.getString(R.string.bugly_appid), false)
    }

}