package com.ysvg2tafy.altor1

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Integer.max

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val x=Load_Value(this)

        if (x!=0){
            COUNTER=Math.max(x,COUNTER)
        }

        display.text= COUNTER.toString()

        start_btn.setOnClickListener {
            Start_Service(this)
            display.text= COUNTER.toString()
        }

        stop_btn.setOnClickListener {
            Stop_Service(this)
            display.text= COUNTER.toString()
        }

        increment_btn.setOnClickListener {
            Start_Service(this)
            display.text= COUNTER.toString()
        }

    }
}
