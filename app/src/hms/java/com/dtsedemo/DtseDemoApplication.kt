package com.dtsedemo

import android.app.Application
import com.huawei.hms.api.HuaweiMobileServicesUtil

class DtseDemoApplication : Application(){


    override fun onCreate() {
        super.onCreate()
        HuaweiMobileServicesUtil.setApplication(this)
    }
}