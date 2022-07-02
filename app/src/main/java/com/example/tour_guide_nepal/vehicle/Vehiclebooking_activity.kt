package com.example.tour_guide_nepal.vehicle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.tour_guide_nepal.R

class Vehiclebooking_activity : AppCompatActivity() {
    private lateinit var bike : ImageView
    private lateinit var fourwheel : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vehiclebooking)

        bike = findViewById(R.id.bike)
        fourwheel = findViewById(R.id.fourwheel)

        bike.setOnClickListener {
            startActivity(Intent(this,TwowheelActivity::class.java))
        }

        fourwheel.setOnClickListener {
            startActivity(Intent(this,Fourwheel_Activity::class.java))
        }
    }
}