package com.example.myapplication


import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DashboardActivity44 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard44)


        val emailFromPreviousPage = intent.getStringExtra("email")
        val passwordFromPreviousPage = intent.getStringExtra("password")

        println("Data from previous page is: $emailFromPreviousPage and $passwordFromPreviousPage")

        val resultTv: TextView = findViewById(R.id.resultTv)

        resultTv.text = emailFromPreviousPage

    }
}