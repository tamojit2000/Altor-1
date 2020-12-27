package com.ysvg2tafy.altor1

import android.app.Notification
import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.IBinder
import androidx.annotation.RequiresApi

class MyService : Service() {
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        val counter_val=intent!!.getIntExtra("COUNTER",0)

        val notification_intent=Intent(this,MainActivity::class.java)
        val pending_intent=PendingIntent.getActivity(this,0,notification_intent,0)

        //val contentView=RemoteViews(packageName,R.layout.notification_layout)
        //contentView.setTextViewText(R.id.noti_display,counter_val.toString())

        val broadcastIntentIncrement=Intent(this,NotificationReceiverIncrement::class.java)

        val actionIntent1=PendingIntent.getBroadcast(this,0,broadcastIntentIncrement,PendingIntent.FLAG_UPDATE_CURRENT)

        val broadcastIntentStop=Intent(this,NotificationReceiverStop::class.java)

        val actionIntent2=PendingIntent.getBroadcast(this,0,broadcastIntentStop,PendingIntent.FLAG_UPDATE_CURRENT)

        val notification=Notification.Builder(this, CHANNEL_ID)
            .setContentTitle("Example Service")
            .setContentText(counter_val.toString())
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setContentIntent(pending_intent)
            //.setContent(contentView)
            .addAction(R.mipmap.ic_launcher,"Increment",actionIntent1)
            .addAction(R.mipmap.ic_launcher,"Stop",actionIntent2)
            .setColor(Color.MAGENTA)
            .build()

        startForeground(1,notification)

        return START_REDELIVER_INTENT
    }

}