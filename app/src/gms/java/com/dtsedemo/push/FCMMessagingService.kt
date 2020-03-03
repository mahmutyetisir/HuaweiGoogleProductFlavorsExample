package com.dtsedemo.push

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import com.dtsedemo.R
import com.dtsedemo.login.LoginActivity
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class FCMMessagingService : FirebaseMessagingService() {

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)

        val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        val notificationBuilder = NotificationCompat.Builder(this, createNotificationChannel(this))

        val message = remoteMessage?.notification?.body ?: ""
        notificationBuilder.setContentTitle("content")
        notificationBuilder.setContentText(message)
        notificationBuilder.setSmallIcon(R.drawable.common_google_signin_btn_icon_dark)

        notificationBuilder.setAutoCancel(true)
        try {
            Log.d("FIREBASE", "Data: ${remoteMessage!!.data}")
            notificationBuilder.setContentIntent(PendingIntent.getActivity(this, 1,
                Intent(this, LoginActivity::class.java).apply {
                }, PendingIntent.FLAG_ONE_SHOT))
        } catch (t: Throwable) {
            Log.e("FIREBASE",t.message)
        }
        notificationManager.notify(message.hashCode(), notificationBuilder.build())
    }


    private fun createNotificationChannel(context: Context): String {
        if (Build.VERSION.SDK_INT >= 26) {
            val notificationManager = context.getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            val id = "WordMemorizer.db"
            if (notificationManager.getNotificationChannel(id) != null) {
                return id
            } else {
                val name = "WordMemorizer.db "
                val description = "WordMemorizer.db"
                val importance = NotificationManager.IMPORTANCE_DEFAULT
                val mChannel = NotificationChannel(id, name, importance)
                mChannel.description = description
                notificationManager.createNotificationChannel(mChannel)
            }
            return id
        }
        return ""
    }

}