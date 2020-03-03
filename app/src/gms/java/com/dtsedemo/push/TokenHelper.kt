package com.dtsedemo.push

import android.content.Context
import android.util.Log
import com.google.firebase.iid.FirebaseInstanceId
import kotlin.concurrent.thread

object TokenHelper{

    private const val TAG = "TokenHelper"

    fun getToken(context: Context){
       val token = FirebaseInstanceId.getInstance().getToken()
        Log.i(TAG,"GMS Token -> $token")
    }


}