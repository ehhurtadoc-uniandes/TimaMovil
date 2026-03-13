package co.edu.uniandes.juayedw.tima

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class WatchSyncedActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_watch_synced)

        findViewById<MaterialButton>(R.id.btn_continuar).setOnClickListener {
            startActivity(Intent(this, CreateAlarmActivity::class.java))
        }
    }
}
