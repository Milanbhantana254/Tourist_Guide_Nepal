package com.example.tour_guide_nepal.fragments

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import com.example.tour_guide_nepal.R
import com.example.tour_guide_nepal.place_details.*

class Selectplaces : AppCompatActivity() {
    private lateinit var kathmandu : LinearLayout
    private lateinit var chitwan : LinearLayout
    private lateinit var dolakha : LinearLayout
    private lateinit var gorkha : LinearLayout
    private lateinit var janakpur : LinearLayout
    private lateinit var lumbini : LinearLayout
    private lateinit var mustang : LinearLayout
    private lateinit var pokhara : LinearLayout
    private lateinit var solukhumbu : LinearLayout
    private lateinit var tanahun : LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selectplaces)
        kathmandu = findViewById(R.id.kathmandu)
        chitwan = findViewById(R.id.chitwan)
        janakpur = findViewById(R.id.janakpur)
        dolakha = findViewById(R.id.dolakha)
        pokhara = findViewById(R.id.pokhara)
        solukhumbu = findViewById(R.id.solukhumbu)
        lumbini = findViewById(R.id.lumbini)
        mustang = findViewById(R.id.mustang)
        tanahun = findViewById(R.id.tanahun)
        gorkha = findViewById(R.id.gorkha)

        kathmandu.setOnClickListener {
            startActivity(Intent(this, kathmandu_detail_activity::class.java))

        }
        dolakha.setOnClickListener {
            startActivity(Intent(this, dolakha_detail_activity::class.java))
        }
        chitwan.setOnClickListener {
            startActivity(Intent(this, chitwan_detail_activity::class.java))
        }
        gorkha.setOnClickListener {
            startActivity(Intent(this, gorkha_detail_activity::class.java))
        }
        janakpur.setOnClickListener {
            startActivity(Intent(this, janakpur_detail_activity::class.java))
        }
        lumbini.setOnClickListener {
            startActivity(Intent(this, lumbini_detail_activity::class.java))
        }
        mustang.setOnClickListener {
            startActivity(Intent(this, mustang_detail_activity::class.java))
        }
        pokhara.setOnClickListener {
            startActivity(Intent(this, pokhara_detail_activity::class.java))
        }
        solukhumbu.setOnClickListener {
            startActivity(Intent(this, solukhumbu_detail_activity::class.java))
        }
        tanahun.setOnClickListener {
            startActivity(Intent(this, tanahun_detail_activity::class.java))
        }

    }
}