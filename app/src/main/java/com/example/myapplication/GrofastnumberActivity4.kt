package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.google.android.material.textfield.TextInputEditText


class GrofastnumberActivity4 : AppCompatActivity() {

    private var hasShownPhoneDialog = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grofastnumber4)

        val countryCode = intent.getStringExtra("countryCode")
        val countryCodeTv = findViewById<TextView>(R.id.country_code_tv)
        countryCodeTv.text = countryCode ?: "+234"

        val phoneEdit = findViewById<TextInputEditText>(R.id.phone_edittext)
        phoneEdit.onFocusChangeListener = View.OnFocusChangeListener { _, hasFocus ->
            if (hasFocus && !hasShownPhoneDialog) {
                hasShownPhoneDialog = true

            AlertDialog.Builder(this)
                    .setMessage("Phone number field")
                    .setPositiveButton("Ok", null)
                    .show()
        }
    }


        val nextButton = findViewById<LinearLayout>(R.id.next_button)
        nextButton.setOnClickListener {
            val phoneNumber = phoneEdit.text.toString()

            if (phoneNumber.isEmpty()) {
                phoneEdit.error = "enter your phone number"
                return@setOnClickListener
            }


            val intent = Intent (this, GrofastverificationActivity4 :: class.java)
            intent.putExtra("phoneNumber", phoneNumber)
            startActivity(intent)
        }
    }
}



