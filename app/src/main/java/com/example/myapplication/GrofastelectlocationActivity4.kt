package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class GrofastelectlocationActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grofastelectlocation4)


        val cities = arrayOf(
                "Abuja",
                "Lagos",
                "Delta",
                "Calaber",
                "Ibadun",
                "Abia"
        )

        val cityEdit = findViewById<AutoCompleteTextView>(R.id.city_dropdown)
        val adapter = ArrayAdapter(
                this,
                android.R.layout.simple_dropdown_item_1line,
                cities
        )
        cityEdit.setAdapter(adapter)


        cityEdit.setOnItemClickListener { parent, _, position, _ ->
            val city = parent.getItemAtPosition(position).toString()

            Toast.makeText(this, city,  Toast.LENGTH_SHORT).show()
        }

       val button = findViewById<MaterialButton>(R.id.submit_button)
        button.setOnClickListener {
            intent = Intent(this, GrofastloginActivity4::class.java)
            startActivity(intent)
        }

    }
}