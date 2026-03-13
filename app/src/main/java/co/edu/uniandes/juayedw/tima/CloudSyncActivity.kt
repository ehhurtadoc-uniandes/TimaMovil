package co.edu.uniandes.juayedw.tima

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class CloudSyncActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cloud_sync)

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, SyncCompleteActivity::class.java))
        }, 3000)

        findViewById<MaterialButton>(R.id.btn_cancelar).setOnClickListener {
            finish()
        }
    }
}
