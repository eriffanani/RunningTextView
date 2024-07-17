package com.jamsolattv.runningtext

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.erif.library.RunningTextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val runningText: RunningTextView = findViewById(R.id.act_main_txtRun)
        val btn: Button = findViewById(R.id.actMain_btn)
        btn.setOnClickListener {
            if (runningText.isPaused) {
                runningText.resume()
                btn.text = "Pause"
            } else {
                runningText.pause()
                btn.text = "Start"
            }
        }

        //runningText.setDuration(1) // 1 Minutes (Integer)
        //runningText.setDuration(10.0) // 10 Seconds (Double)
        //runningText.duration = 10000L // 10 Seconds (Long)
        //runningText.start()
        //runningText.pause()
        //runningText.resume()

    }
}