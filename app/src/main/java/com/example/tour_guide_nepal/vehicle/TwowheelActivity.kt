package com.example.tour_guide_nepal.vehicle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import com.example.tour_guide_nepal.R

class TwowheelActivity : AppCompatActivity() {
    private lateinit var duke390 : LinearLayout
    private lateinit var ktmrc390 : LinearLayout
    private lateinit var r6 : LinearLayout
    private lateinit var crf250 : LinearLayout
    private lateinit var crossx250 : LinearLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_twowheel)

        duke390 = findViewById(R.id.duke390)
        ktmrc390 = findViewById(R.id.ktmrc390)
        r6 = findViewById(R.id.r6)
        crf250 = findViewById(R.id.crf250)
        crossx250 = findViewById(R.id.crossx250)

        duke390.setOnClickListener {
            startActivity(Intent(this,Vehicle_booking_form_activity::class.java))
        }

        ktmrc390.setOnClickListener {
            startActivity(Intent(this,Vehicle_booking_form_activity::class.java))
        }

        r6.setOnClickListener {
            startActivity(Intent(this,Vehicle_booking_form_activity::class.java))
        }

        crf250.setOnClickListener {
            startActivity(Intent(this,Vehicle_booking_form_activity::class.java))
        }

        crossx250.setOnClickListener {
            startActivity(Intent(this,Vehicle_booking_form_activity::class.java))
        }
    }
}