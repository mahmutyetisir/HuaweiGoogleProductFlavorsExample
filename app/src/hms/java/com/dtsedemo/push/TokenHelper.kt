package com.dtsedemo.push

import android.content.Context
import android.util.Log
import com.huawei.agconnect.config.AGConnectServicesConfig
import com.huawei.hms.aaid.HmsInstanceId
import kotlin.concurrent.thread

object TokenHelper{

    private const val TAG = "TokenHelper"

    fun getToken(context: Context){
        thread {
            try {
                val appId = AGConnectServicesConfig.fromContext(context).getString("client/app_id")
                val token = HmsInstanceId.getInstance(context).getToken("101608059", "HCM")
                Log.d(TAG,"HMS Token -> $token")

            } catch (e: Exception) {
                Log.i(TAG, "getToken failed, $e")
            }
        }.run()
    }





}