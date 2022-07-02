package com.example.tour_guide_nepal.vehicle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import com.example.tour_guide_nepal.R
import org.jetbrains.anko.find

class Fourwheel_Activity : AppCompatActivity() {
    private lateinit var mustang : LinearLayout
    private lateinit var bmw : LinearLayout
    private lateinit var scorpio : LinearLayout
    private lateinit var tesla : LinearLayout
    private lateinit var suv : LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fourwheel)

        mustang = findViewById(R.id.mustang_gadi)
        bmw = findViewById(R.id.bmw)
        scorpio = findViewById(R.id.scorpio)
        tesla = findViewById(R.id.tesla)
        suv = findViewById(R.id.suv)

        mustang.setOnClickListener {
            startActivity(Intent(this,Vehicle_booking_form_activity::class.java))
        }

        bmw.setOnClickListener {
            startActivity(Intent(this,Vehicle_booking_form_activity::class.java))
        }

        scorpio.setOnClickListener {
            startActivity(Intent(this,Vehicle_booking_form_activity::class.java))
        }

        tesla.setOnClickListener {
            startActivity(Intent(this,Vehicle_booking_form_activity::class.java))
        }

        suv.setOnClickListener {
            startActivity(Intent(this,Vehicle_booking_form_activity::class.java))
        }
    }
}