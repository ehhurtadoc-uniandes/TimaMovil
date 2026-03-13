package co.edu.uniandes.juayedw.tima

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

class SyncingWatchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_syncing_watch)

        // Simula sincronización durante 2.5 segundos y navega automáticamente
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, WatchSyncedActivity::class.java))
        }, 2500)
    }
}
