package com.androidlk.processthreadcommunication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.util.Log
import android.widget.Toast
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    private val updateText = 1
    val handler = @SuppressLint("HandlerLeak")
    object : Handler() {

        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)

            when (msg.what) {

                updateText -> {
                    Log.i("我在子线程", "我在子线程")
                    Log.i("我在子线程1", "${android.os.Process.myTid()}" )

                }
            }
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Thread {
            Log.i("我在子线程2", "${android.os.Process.myTid()}" )
        }.start()


        Log.i("我在子线程3", "${android.os.Process.myTid()}" )

        thread {
            val mag = Message()
            mag.what = updateText
            handler.sendMessage(mag)

            Log.i("我在子线程4", "${android.os.Process.myTid()}" )

        }

    }


}