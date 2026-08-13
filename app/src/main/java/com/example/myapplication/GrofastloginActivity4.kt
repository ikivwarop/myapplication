package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.TextBoundsInfo
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class GrofastloginActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grofastlogin4)

        val emailAddress = findViewById<TextInputEditText>(R.id.email_address_input)
        emailAddress.setOnClickListener {
            AlertDialog.Builder(this)
                    .setMessage("Enter your email address")
                    .setPositiveButton("Ok", null)
                    .show()
        }
        val email = emailAddress.text.toString()

        val password = findViewById<TextInputEditText>(R.id.password_input)
        password.setOnClickListener {
            AlertDialog.Builder(this)
                    .setMessage("Enter your password")
                    .setPositiveButton("Ok", null)
                    .show()

        }
        val passwordText = password.text.toString()

        val forgotPassword = findViewById<TextView>(R.id.forget_password_label)
        forgotPassword.setOnClickListener {

        }

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