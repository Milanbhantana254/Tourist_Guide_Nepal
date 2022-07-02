package com.example.tour_guide_nepal.place_details

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintLayout
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.models.SlideModel
import com.example.tour_guide_nepal.R
import com.example.tour_guide_nepal.maps.chitwan_map_activity
import com.example.tour_guide_nepal.maps.gorkha_map_activity
import com.example.tour_guide_nepal.nearbyplaces.gorkha_nearbyplaces
import com.example.tour_guide_nepal.video.gorkha_video_activity
import com.example.tour_guide_nepal.weather.chitwan_weatherActivity
import com.example.tour_guide_nepal.weather.dolakha_weatherActivity
import com.example.tour_guide_nepal.weather.gorkha_weatherActivity

class gorkha_detail_activity : AppCompatActivity() {

    private lateinit var gorkhamap : ConstraintLayout
    private lateinit var gorkhaweather : ConstraintLayout
    private lateinit var gorkhanear : ConstraintLayout
    private lateinit var gorkhavideo : ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gorkha_detail)

        gorkhamap = findViewById(R.id.gorkhamap)
        gorkhaweather = findViewById(R.id.gorkhaweather)
        gorkhavideo = findViewById(R.id.gorkhavideo)
 

        val imagelist = ArrayList<SlideModel>()

        imagelist.add(SlideModel("https://www.go2trek.com/wp-content/uploads/2018/09/Gorkha-Trek-02-1024x438.jpg","Gorkha"))
        imagelist.add(SlideModel("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQvZQ_WoUWfUvhyvM05waSBFbBxrYM2eyERC2_06NxgTpq4LZWcxF53brQlL_cPEWc-cxM&usqp=CAU","Gorkha"))
        imagelist.add(SlideModel("https://cdn.kimkim.com/files/a/content_articles/featured_photos/04223636612c5f58f1ceaa070d56ad94fbf6280e/big-db100f816ef6d1ec52a37ae38bc64675.jpg","Gorkha"))

        val imageSlider = findViewById<ImageSlider>(R.id.gorkhaimage)
        imageSlider.setImageList(imagelist)

 
        gorkhanear = findViewById(R.id.gorkhanear)
 

        gorkhamap.setOnClickListener {
            val intent = Intent(this, gorkha_map_activity::class.java)
            startActivity(intent)
        }
        gorkhaweather.setOnClickListener {
            val intent = Intent(this, gorkha_weatherActivity::class.java)
            startActivity(intent)
        }
        gorkhanear.setOnClickListener {
            val intent = Intent(this, gorkha_nearbyplaces::class.java)
            startActivity(intent)
        }

        gorkhavideo.setOnClickListener {
            val intent = Intent(this, gorkha_video_activity::class.java)
            startActivity(intent)
        }
    }
}