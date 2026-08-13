package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class GrofastonboardingActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grofastonboarding4)

        val loginButton : Button = findViewById(R.id.button)

        loginButton.setOnClickListener{
            val intent = Intent(this, GrofastsigninActivity4::class.java)
            startActivity(intent)
        }
    }
}