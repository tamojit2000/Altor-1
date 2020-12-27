package com.ysvg2tafy.altor1

import android.app.Application
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        Create_Notification_Channel()
    }

    fun Create_Notification_Channel(){
        if (Build.VERSION.SDK_INT>Build.VERSION_CODES.O){
            val service_channel=NotificationChannel(
                CHANNEL_ID,
                "Channel",
                NotificationManager.IMPORTANCE_HIGH
            )
            val manager=getSystemService(NotificationManager::class.java)
            manager.createNotificationChannel(service_channel)
        }
    }

}