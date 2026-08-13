package com.example.myapplication

import android.content.Intent
import android.widget.Button
import android.widget.EditText

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class LoginActivity44 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_login44)

        val emailData: EditText = findViewById(R.id.emailEditText)
        val passwordData: EditText = findViewById(R.id.passwordEditText)


        val loginButton: Button = findViewById(R.id.loginButton)

        loginButton.setOnClickListener {
            //extract data from email input
            val typedEmailAddress = emailData.text.toString()
            val typedPassword = passwordData.text.toString()

//            println("email: ==> $typedEmailAddress and password is $typedPassword")
            val intent = Intent(this, DashboardActivity44::class.java)
            intent.putExtra("email", typedEmailAddress)
            intent.putExtra("password",typedPassword)



            startActivity(intent)
        }
    }
}