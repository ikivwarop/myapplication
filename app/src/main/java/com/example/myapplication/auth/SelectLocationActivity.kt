package com.example.myapplication.auth
import com.example.myapplication.R
import com.example.myapplication.home.HomeActivity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast
import com.google.android.material.button.MaterialButton

class SelectLocationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_location)


        val cities = arrayOf(
                "Abuja",
                "Lagos",
                "Delta",
                "Calaber",
                "Ibadun",
                "Abia"
        )
        val areas = arrayOf(
                "Central",
                "North",
                "South",
                "East",
                "West"
        )

        val cityEdit = findViewById<AutoCompleteTextView>(R.id.city_dropdown)
        cityEdit.setAdapter(ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, cities))
        cityEdit.threshold = 0
        cityEdit.setOnClickListener { cityEdit.showDropDown() }

        val areaEdit = findViewById<AutoCompleteTextView>(R.id.your_area_dropdown)
        areaEdit.setAdapter(ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, areas))
        areaEdit.threshold = 0
        areaEdit.setOnClickListener { areaEdit.showDropDown() }

        cityEdit.setOnItemClickListener { parent, _, position, _ ->
            val city = parent.getItemAtPosition(position).toString()

            Toast.makeText(this, city,  Toast.LENGTH_SHORT).show()
        }

       val button = findViewById<MaterialButton>(R.id.submit_button)
        button.setOnClickListener {
            intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }

    }
}