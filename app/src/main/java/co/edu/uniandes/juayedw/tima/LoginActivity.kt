package co.edu.uniandes.juayedw.tima

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val goToSync = { startActivity(Intent(this, CloudSyncActivity::class.java)) }
        findViewById<MaterialButton>(R.id.btn_google).setOnClickListener { goToSync() }
        findViewById<MaterialButton>(R.id.btn_apple).setOnClickListener { goToSync() }
    }
}
