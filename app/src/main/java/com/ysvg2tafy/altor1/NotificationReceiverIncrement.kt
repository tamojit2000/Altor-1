package com.ysvg2tafy.altor1

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class NotificationReceiverIncrement : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if (context != null) {
            Start_Service(context)
        }

    }
}