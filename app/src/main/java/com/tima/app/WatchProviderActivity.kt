package com.tima.app

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class WatchProviderActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_watch_provider)

        findViewById<com.google.android.material.button.MaterialButton>(R.id.btn_continuar).setOnClickListener {
            startActivity(Intent(this, SyncingWatchActivity::class.java))
        }
    }
}
