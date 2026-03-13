package co.edu.uniandes.juayedw.tima

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class SyncCompleteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sync_complete)

        val statsUrl = "https://www.figma.com/proto/Q9S1zuZBzFoge33RfSjd96/Design-kit---Design-System---TIMA?node-id=60994-1046&p=f&t=BhmnpZUK3yb6x5CU-0&scaling=scale-down&content-scaling=fixed&page-id=60994%3A1045&starting-point-node-id=60994%3A1046"

        findViewById<MaterialButton>(R.id.btn_estadisticas).setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(statsUrl)))
        }

        findViewById<MaterialButton>(R.id.btn_continuar).setOnClickListener {
            startActivity(Intent(this, CreateAlarmActivity::class.java))
        }
    }
}
