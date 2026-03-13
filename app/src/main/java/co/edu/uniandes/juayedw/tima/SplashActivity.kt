package co.edu.uniandes.juayedw.tima

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class SplashActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "TIMA_SPLASH"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate: inflando splash_screen")
        setContentView(R.layout.splash_screen)

        val btn = findViewById<MaterialButton>(R.id.btn_start)
        Log.d(TAG, "onCreate: btn_start encontrado = ${btn != null}")

        btn.setOnClickListener {
            Log.d(TAG, "btn_start CLICK — navegando a SyncWatchActivity")
            try {
                startActivity(Intent(this, SyncWatchActivity::class.java))
                Log.d(TAG, "startActivity OK")
            } catch (e: Exception) {
                Log.e(TAG, "ERROR al navegar: ${e.message}", e)
            }
        }

    }
}
