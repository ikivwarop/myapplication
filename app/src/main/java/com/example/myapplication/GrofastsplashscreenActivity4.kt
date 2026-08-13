package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.core.os.postDelayed

class GrofastsplashscreenActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grofastsplashscreen4)

        Handler(Looper.getMainLooper()).postDelayed({

            val intent = Intent(this, GrofastonboardingActivity4::class.java)
            startActivity(intent)

            finish()

        }, 3000)
    }
}