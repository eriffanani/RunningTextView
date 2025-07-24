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

    }
}