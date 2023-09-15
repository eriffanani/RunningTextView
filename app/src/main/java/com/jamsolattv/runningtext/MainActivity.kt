package com.jamsolattv.runningtext

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.erif.library.RunningTextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val txtRun: RunningTextView = findViewById(R.id.act_main_txtRun)
        val minutes = 1
        val duration = minutes * 60000
        txtRun.rndDuration = duration
        txtRun.startScroll()
    }
}