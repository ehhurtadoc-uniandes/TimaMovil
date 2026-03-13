package co.edu.uniandes.juayedw.tima

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class ConfigureLocationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_configure_location)

        val etPasos = findViewById<EditText>(R.id.et_pasos)

        findViewById<TextView>(R.id.btn_menos_pasos).setOnClickListener {
            val v = etPasos.text.toString().toIntOrNull() ?: 0
            if (v > 100) etPasos.setText((v - 100).toString())
        }
        findViewById<TextView>(R.id.btn_mas_pasos).setOnClickListener {
            val v = etPasos.text.toString().toIntOrNull() ?: 0
            etPasos.setText((v + 100).toString())
        }

        findViewById<MaterialButton>(R.id.btn_guardar).setOnClickListener {
            setResult(RESULT_OK)
            finish()
        }
    }
}
