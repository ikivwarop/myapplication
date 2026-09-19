package com.example.myapplication.signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.example.myapplication.GrofasthomescreenActivity4
import com.example.myapplication.GrofastnumberActivity4
import com.example.myapplication.R
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class GrofastsigninActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grofastsignin4)

        data class country(
                val name: String,
                val code: String
        )



        val countryCodeedit = findViewById<TextInputEditText>(R.id.country_code_edit)
        countryCodeedit.setOnClickListener {

            val countries = listOf(
                    country("Nigeria", "+234"),
                    country("India", "+91"),
                    country("Brazil", "+55"),
                    country("Germany", "+49")
            )
            val names = countries.map {"${it.name} (${it.code})"}.toTypedArray()
            AlertDialog.Builder(this)
                    .setTitle("select a country")
                    .setItems(names) { _, position ->

                        val intent = Intent(this, GrofastnumberActivity4::class.java)
                        intent.putExtra("countryCode", countries[position].code)
                        startActivity(intent)

                    }
                    .show()

        }




        val button = findViewById<MaterialButton>(R.id.googleBtn)
        button.setOnClickListener {
            val intent = Intent(this, GrofasthomescreenActivity4::class.java)
            startActivity(intent)
        }

        val facebookbutton = findViewById<MaterialButton>(R.id.facebookBtn)
        facebookbutton.setOnClickListener {
            val intent = Intent(this, GrofasthomescreenActivity4::class.java)
            startActivity(intent)

        }
    }
}