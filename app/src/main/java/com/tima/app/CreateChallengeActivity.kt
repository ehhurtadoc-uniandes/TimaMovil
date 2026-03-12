package com.tima.app

import android.content.Intent
import android.os.Bundle
import android.widget.CheckBox
import android.widget.LinearLayout
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class CreateChallengeActivity : AppCompatActivity() {

    private val exerciseLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK) {
            findViewById<CheckBox>(R.id.cb_ejercicios).isChecked = true
        }
    }

    private val heartRateLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK) {
            findViewById<CheckBox>(R.id.cb_frecuencia).isChecked = true
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_challenge)

        findViewById<LinearLayout>(R.id.row_ejercicios).setOnClickListener {
            exerciseLauncher.launch(Intent(this, ExerciseTypeActivity::class.java))
        }

        findViewById<LinearLayout>(R.id.row_frecuencia).setOnClickListener {
            heartRateLauncher.launch(Intent(this, HeartRateActivity::class.java))
        }

        // btn_continuar sin acción por el momento
    }
}
