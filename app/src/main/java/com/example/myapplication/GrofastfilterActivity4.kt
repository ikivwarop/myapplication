package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class GrofastfilterActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grofastfilter4)


        val egg = findViewById<com.google.android.material.checkbox.MaterialCheckBox>(R.id.eggs)
        val noodleAndPasta = findViewById<com.google.android.material.checkbox.MaterialCheckBox>(R.id.noodle)
        val chipAndCrisps = findViewById<com.google.android.material.checkbox.MaterialCheckBox>(R.id.chips)
        val fastFood = findViewById<com.google.android.material.checkbox.MaterialCheckBox>(R.id.fast)

        val individualCollection = findViewById<com.google.android.material.checkbox.MaterialCheckBox>(R.id.individual)
        val cocaCola = findViewById<com.google.android.material.checkbox.MaterialCheckBox>(R.id.coca)

        val applyButton = findViewById<com.google.android.material.button.MaterialButton>(R.id.apply_button)

        applyButton.setOnClickListener {

            val selectedCategories = arrayListOf<String>()
            if (egg.isChecked) {
                selectedCategories.add("Eggs")
            }

            if (noodleAndPasta.isChecked) {
               selectedCategories.add("noodleAndPasta")
            }

            val intent = Intent()
            intent.putStringArrayListExtra("categories", selectedCategories)
            setResult(RESULT_OK, intent)
            finish()

            if (chipAndCrisps.isChecked) {
                Toast.makeText(this, "chipAndCrisps selected", Toast.LENGTH_SHORT).show()
            }

            if (fastFood.isChecked) {
                Toast.makeText(this, "fastFood selected", Toast.LENGTH_SHORT).show()
            }

            if (individualCollection.isChecked) {
                Toast.makeText(this, "individualCollection selected", Toast.LENGTH_SHORT).show()
            }
            if (cocaCola.isChecked) {
                Toast.makeText(this, "cocaCola selection", Toast.LENGTH_SHORT).show()
            }

        }

    }
}