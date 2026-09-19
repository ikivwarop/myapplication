package com.example.myapplication.auth
import com.example.myapplication.R
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText


class PhoneNumberActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_number)

        val countryCode = intent.getStringExtra("countryCode")
        val countryCodeTv = findViewById<TextView>(R.id.country_code_tv)
        countryCodeTv.text = countryCode ?: ""

        findViewById<ImageView>(R.id.arrow).setOnClickListener { finish() }

        val phoneEdit = findViewById<TextInputEditText>(R.id.phone_edittext)

        val nextButton = findViewById<LinearLayout>(R.id.next_button)
        nextButton.setOnClickListener {
            val phoneNumber = phoneEdit.text.toString()

            if (phoneNumber.isEmpty()) {
                phoneEdit.error = "enter your phone number"
                return@setOnClickListener
            }


            val intent = Intent (this, VerificationActivity :: class.java)
            intent.putExtra("phoneNumber", phoneNumber)
            startActivity(intent)
        }
    }
}



