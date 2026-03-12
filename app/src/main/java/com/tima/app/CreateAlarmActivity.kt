package com.tima.app

import android.app.TimePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class CreateAlarmActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_alarm)

        val tvHour = findViewById<TextView>(R.id.tv_hour)
        val tvMinute = findViewById<TextView>(R.id.tv_minute)

        findViewById<LinearLayout>(R.id.time_picker_container).setOnClickListener {
            val h = tvHour.text.toString().toIntOrNull() ?: 7
            val m = tvMinute.text.toString().toIntOrNull() ?: 30
            TimePickerDialog(this, { _, hour, minute ->
                tvHour.text = String.format("%02d", hour)
                tvMinute.text = String.format("%02d", minute)
            }, h, m, false).show()
        }

        findViewById<MaterialButton>(R.id.btn_continuar).setOnClickListener {
            startActivity(Intent(this, CreateChallengeActivity::class.java))
        }
    }
}
