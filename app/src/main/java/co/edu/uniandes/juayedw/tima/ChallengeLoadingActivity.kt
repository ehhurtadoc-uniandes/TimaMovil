package co.edu.uniandes.juayedw.tima

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

class ChallengeLoadingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_challenge_loading)

        val time = intent.getStringExtra("EXTRA_TIME") ?: "07:30 AM"
        val exercise = intent.getStringExtra("EXTRA_EXERCISE") ?: "20 burpees"
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, AchievementActivity::class.java)
                .putExtra("EXTRA_TIME", time)
                .putExtra("EXTRA_EXERCISE", exercise))
        }, 5000)
    }
}
