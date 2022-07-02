package com.example.tour_guide_nepal.termsandservices

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import com.example.tour_guide_nepal.LoginActivity
import com.example.tour_guide_nepal.R
import org.jetbrains.anko.find
import org.jetbrains.anko.toast
import javax.annotation.meta.When

class front_terms_and_services : AppCompatActivity() {
    private lateinit var backlogin: Button
    private lateinit var termspage: TextView
    private lateinit var checkbox1: CheckBox
    private lateinit var checkbox2: CheckBox
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_front_terms_and_services)

        backlogin = findViewById(R.id.backlogin)
        termspage = findViewById(R.id.termspage)
        checkbox1 = findViewById(R.id.checkbox1)
        checkbox2 = findViewById(R.id.checkbox2)


        termspage.setOnClickListener {
            startActivity(Intent(this, termsandconditions::class.java))
        }
        backlogin.setOnClickListener {
            onCheckboxClicked()
        }
    }

    private fun onCheckboxClicked() {
        if (checkbox1.isChecked && checkbox2.isChecked) {

            startActivity(Intent(this,LoginActivity::class.java))
        }
        if (!checkbox1.isChecked) {
            Toast.makeText(this@front_terms_and_services, "Accept terms and conditions", Toast.LENGTH_SHORT).show()
        }
        if (!checkbox2.isChecked) {
            Toast.makeText(this@front_terms_and_services, "Accept terms and conditions", Toast.LENGTH_SHORT).show()
        }
        if (!checkbox1.isChecked && !checkbox2.isChecked) {
            Toast.makeText(this@front_terms_and_services, "Accept terms and conditions", Toast.LENGTH_SHORT).show()
        }

    }
}