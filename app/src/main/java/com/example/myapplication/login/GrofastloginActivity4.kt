package com.example.myapplication.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.example.myapplication.GrofasthomescreenActivity4
import com.example.myapplication.signup.GrofastsignupActivity4
import com.example.myapplication.R
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class GrofastloginActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grofastlogin4)

        val emailAddress = findViewById<TextInputEditText>(R.id.email_address_input)



        val password = findViewById<TextInputEditText>(R.id.password_input)



        val forgotPassword = findViewById<TextView>(R.id.forget_password_label)


        val materialButton = findViewById<MaterialButton>(R.id.login_button)
        materialButton.setOnClickListener {

            val email = emailAddress.text.toString().trim()
            val passwordText = password.text.toString()

            if (email.isEmpty()) {
                emailAddress.error = "Enter your email"
                return@setOnClickListener
            }
            if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                emailAddress.error = "Enter a valid email address"
                return@setOnClickListener
            }


            if (passwordText.isEmpty()) {
                password.error = "Enter your password"
                return@setOnClickListener
            }
            val intent = Intent(this, GrofasthomescreenActivity4::class.java)
            startActivity(intent)
        }

        val signUp = findViewById<TextView>(R.id.signup_btn)
        signUp.setOnClickListener {
            intent = Intent(this, GrofastsignupActivity4::class.java)
            startActivity(intent)
        }
    }
}