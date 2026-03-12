package com.tima.app

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class HeartRateActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_heart_rate)

        val etPace = findViewById<EditText>(R.id.et_bpm_pace)

        findViewById<TextView>(R.id.btn_menos).setOnClickListener {
            val v = etPace.text.toString().toIntOrNull() ?: 0
            if (v > 1) etPace.setText((v - 1).toString())
        }
        findViewById<TextView>(R.id.btn_mas).setOnClickListener {
            val v = etPace.text.toString().toIntOrNull() ?: 0
            etPace.setText((v + 1).toString())
        }

        findViewById<MaterialButton>(R.id.btn_guardar).setOnClickListener {
            setResult(RESULT_OK)
            finish()
        }
    }
}
