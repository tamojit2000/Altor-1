package com.ysvg2tafy.altor1

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences


val CHANNEL_ID="CHANNEL ID"

var COUNTER=0


fun Start_Service(context: Context){
    val service_intent= Intent(context, MyService::class.java)
    service_intent.putExtra("COUNTER", ++COUNTER)
    context.startService(service_intent)
}

fun Stop_Service(context: Context){
    val service_intent= Intent(context, MyService::class.java)
    context.stopService(service_intent)
    Dump_Value(context)
}

fun Dump_Value(context: Context){
    val sharedpreferences: SharedPreferences = context.getSharedPreferences(
        "DATA",
        Context.MODE_PRIVATE
    )
    val editor = sharedpreferences.edit()
    editor.putInt("COUNTER", COUNTER)
    editor.commit()
}

fun Load_Value(context: Context): Int{
    val sharedpreferences: SharedPreferences = context.getSharedPreferences(
        "DATA",
        Context.MODE_PRIVATE
    )
    return sharedpreferences.getInt("COUNTER",0)
}