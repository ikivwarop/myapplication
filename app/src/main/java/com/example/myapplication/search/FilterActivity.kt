package com.example.myapplication.search
import com.example.myapplication.R
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.checkbox.MaterialCheckBox

class FilterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filter)

        findViewById<android.widget.ImageView>(R.id.close_button).setOnClickListener { finish() }

        val egg = findViewById<MaterialCheckBox>(R.id.eggs)
        val noodleAndPasta = findViewById<MaterialCheckBox>(R.id.noodle)
        val chipAndCrisps = findViewById<MaterialCheckBox>(R.id.chips)
        val fastFood = findViewById<MaterialCheckBox>(R.id.fast)

        val applyButton = findViewById<com.google.android.material.button.MaterialButton>(R.id.apply_button)

        applyButton.setOnClickListener {

            val selectedCategories = arrayListOf<String>()
            if (egg.isChecked) {
                selectedCategories.add("Eggs")
            }
            if (noodleAndPasta.isChecked) {
                selectedCategories.add("Noodles and Pasta")
            }
            if (chipAndCrisps.isChecked) {
                selectedCategories.add("Chips and Crisps")
            }
            if (fastFood.isChecked) {
                selectedCategories.add("Fast Food")
            }

            val intent = Intent()
            intent.putStringArrayListExtra("categories", selectedCategories)
            setResult(RESULT_OK, intent)
            finish()
        }

    }
}