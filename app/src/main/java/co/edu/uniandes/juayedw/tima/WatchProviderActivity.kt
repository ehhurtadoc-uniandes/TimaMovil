package co.edu.uniandes.juayedw.tima

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class WatchProviderActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_watch_provider)

        val goToSyncing = { startActivity(Intent(this, SyncingWatchActivity::class.java)) }

        listOf(
            R.id.row_apple,
            R.id.row_huawei,
            R.id.row_polar,
            R.id.row_samsung,
            R.id.row_garmin
        ).forEach { id ->
            findViewById<LinearLayout>(id).setOnClickListener { goToSyncing() }
        }
    }
}
