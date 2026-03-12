package com.tima.app

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class SyncWatchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sync_watch)

        findViewById<MaterialButton>(R.id.btn_connect).setOnClickListener {
            startActivity(Intent(this, WatchProviderActivity::class.java))
        }

        findViewById<MaterialButton>(R.id.btn_no_watch).setOnClickListener {
            startActivity(Intent(this, WatchProviderActivity::class.java))
        }
    }
}
