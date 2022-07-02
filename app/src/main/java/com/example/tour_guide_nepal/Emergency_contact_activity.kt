package com.example.tour_guide_nepal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Emergency_contact_activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_emergency_contact)


        val actionBar = supportActionBar
        actionBar!!.hide()

    }
}