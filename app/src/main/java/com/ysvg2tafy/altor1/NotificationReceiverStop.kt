package com.ysvg2tafy.altor1

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class NotificationReceiverStop:BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if (context != null) {
            Stop_Service(context)
        }
    }
}