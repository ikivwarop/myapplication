package com.example.myapplication.auth
import com.example.myapplication.R
import com.example.myapplication.home.HomeActivity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val username = findViewById<TextInputEditText>(R.id.username_input)


        val email = findViewById<TextInputEditText>(R.id.email_input)


        val password = findViewById<TextInputEditText>(R.id.password_input)


        val signUpButton = findViewById<MaterialButton>(R.id.signup_btn)

        signUpButton.setOnClickListener {

            val usernameText = username.text.toString().trim()
            val emailText = email.text.toString().trim()
            val passwordText = password.text.toString()

            if(usernameText.isEmpty()) {
                username.error = "Enter your username"
                return@setOnClickListener
            }

            if (emailText.isEmpty()) {
                email.error = "Enter your email"
                return@setOnClickListener
            }
            
            if (!android.util.Patterns.EMAIL_ADDRESS.matcher(emailText).matches()) {
                email.error = "enter a valid email address"
                return@setOnClickListener
            }

            if (passwordText.isEmpty()) {
                password.error = "enter your password"
                return@setOnClickListener
            }

            if (passwordText.length < 8) {
                password.error = "Password must be at least 8 characters"
                return@setOnClickListener
            }

            val intent = Intent (this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }

        val login = findViewById<TextView>(R.id.login)
        login.setOnClickListener {
            val intent = Intent (this, LoginActivity::class.java)
            startActivity(intent)
        }

    }
}