package co.edu.uniandes.juayedw.tima

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class AlarmScheduledActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alarm_scheduled)

        val time = intent.getStringExtra("EXTRA_TIME") ?: "07:30 AM"
        val exercise = intent.getStringExtra("EXTRA_EXERCISE") ?: "20 burpees"

        findViewById<TextView>(R.id.tv_hora).text = time
        findViewById<TextView>(R.id.tv_reto).text = exercise

        findViewById<MaterialButton>(R.id.btn_continuar).setOnClickListener {
            startActivity(Intent(this, ChallengeLoadingActivity::class.java)
                .putExtra("EXTRA_TIME", time)
                .putExtra("EXTRA_EXERCISE", exercise))
        }
    }
}
