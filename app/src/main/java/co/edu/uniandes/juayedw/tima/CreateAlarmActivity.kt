package co.edu.uniandes.juayedw.tima

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
            val h = tvHour.text.toString().toIntOrNull() ?: 7
            val m = tvMinute.text.toString().toIntOrNull() ?: 30
            val amPm = if (h < 12) "AM" else "PM"
            val h12 = when { h == 0 -> 12; h > 12 -> h - 12; else -> h }
            val timeStr = String.format("%02d:%02d %s", h12, m, amPm)
            startActivity(Intent(this, CreateChallengeActivity::class.java)
                .putExtra("EXTRA_TIME", timeStr))
        }
    }
}
