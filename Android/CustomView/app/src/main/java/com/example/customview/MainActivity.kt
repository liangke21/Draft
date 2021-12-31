package com.example.customview

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var musicButton: MusicButton

    //进度条
    private var mTasksView: MusicButtonLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        musicButton = findViewById(R.id.bb)
        musicButton.setOnClickListener {
            mTasksView?.stopMusic()
        }
        musicButton.playMusic()




        mTasksView = findViewById(R.id.tasks_view)
        mTasksView?.isDisplayText(false)
        mTasksView?.setTotalProgress(300)
        mTasksView?.setOnClickListener {
            mTasksView?.playMusic()
        }
        mTasksView?.playMusic()

    }

}