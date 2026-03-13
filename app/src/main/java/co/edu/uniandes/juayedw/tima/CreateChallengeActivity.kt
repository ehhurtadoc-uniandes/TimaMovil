package co.edu.uniandes.juayedw.tima

import android.content.Intent
import android.os.Bundle
import android.widget.CheckBox
import android.widget.LinearLayout
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class CreateChallengeActivity : AppCompatActivity() {

    private var selectedExercise: String = "20 burpees"

    private val exerciseLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK) {
            selectedExercise = result.data?.getStringExtra("EXTRA_EXERCISE") ?: selectedExercise
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

    private val locationLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK) {
            findViewById<CheckBox>(R.id.cb_posicion).isChecked = true
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

        findViewById<LinearLayout>(R.id.row_posicion).setOnClickListener {
            locationLauncher.launch(Intent(this, ConfigureLocationActivity::class.java))
        }

        findViewById<com.google.android.material.button.MaterialButton>(R.id.btn_continuar).setOnClickListener {
            val time = intent.getStringExtra("EXTRA_TIME") ?: "07:30 AM"
            startActivity(Intent(this, AlarmScheduledActivity::class.java)
                .putExtra("EXTRA_TIME", time)
                .putExtra("EXTRA_EXERCISE", selectedExercise))
        }
    }
}
