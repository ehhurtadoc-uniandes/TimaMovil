package co.edu.uniandes.juayedw.tima

import android.os.Bundle
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class ExerciseTypeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise_type)

        val radios = listOf(
            findViewById<RadioButton>(R.id.rb_abdominales),
            findViewById<RadioButton>(R.id.rb_burpees),
            findViewById<RadioButton>(R.id.rb_sentadillas),
            findViewById<RadioButton>(R.id.rb_flexiones)
        )

        // Exclusión mutua manual (RadioButtons anidados en LinearLayouts)
        radios.forEach { selected ->
            selected.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) radios.filter { it != selected }.forEach { it.isChecked = false }
            }
        }

        val etCantidad = findViewById<EditText>(R.id.et_cantidad)
        findViewById<TextView>(R.id.btn_menos).setOnClickListener {
            val v = etCantidad.text.toString().toIntOrNull() ?: 0
            if (v > 1) etCantidad.setText((v - 1).toString())
        }
        findViewById<TextView>(R.id.btn_mas).setOnClickListener {
            val v = etCantidad.text.toString().toIntOrNull() ?: 0
            etCantidad.setText((v + 1).toString())
        }

        // Guardar regresa a CreateChallenge con resultado OK
        findViewById<MaterialButton>(R.id.btn_guardar).setOnClickListener {
            val exerciseNames = mapOf(
                R.id.rb_abdominales to "abdominales",
                R.id.rb_burpees to "burpees",
                R.id.rb_sentadillas to "sentadillas",
                R.id.rb_flexiones to "flexiones"
            )
            val selected = radios.firstOrNull { it.isChecked }
            val type = exerciseNames[selected?.id] ?: "burpees"
            val qty = etCantidad.text.toString().toIntOrNull() ?: 20
            val resultIntent = android.content.Intent()
                .putExtra("EXTRA_EXERCISE", "$qty $type")
            setResult(RESULT_OK, resultIntent)
            finish()
        }
    }
}
