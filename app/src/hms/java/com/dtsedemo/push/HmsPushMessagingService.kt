package com.dtsedemo.push

import android.util.Log
import com.huawei.hms.push.HmsMessageService
import com.huawei.hms.push.RemoteMessage

class HmsPushMessagingService : HmsMessageService() {

    private val TAG = "HMS_PUSH_SERVICE_LOG"
    override fun onNewToken(p0: String?) {
        super.onNewToken(p0)
        Log.i(TAG, "receive token:$p0")
    }


    override fun onMessageReceived(remoteMessage: RemoteMessage?) {
        super.onMessageReceived(remoteMessage)

        if (remoteMessage != null) {
            if (remoteMessage.data.isNotEmpty()) {
                Log.i(TAG, "Message data payload: " + remoteMessage.data)
            }
            if (remoteMessage.notification != null) {
                Log.i(TAG, "Message Notification Body: " + remoteMessage.notification.body)
            }
        }

    }




    override fun onMessageSent(p0: String?) {
        super.onMessageSent(p0)
        Log.i(TAG, "receive token:$p0")

    }


}