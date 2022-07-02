package com.example.tour_guide_nepal.place_details

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintLayout
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.models.SlideModel
import com.example.tour_guide_nepal.R
import com.example.tour_guide_nepal.maps.chitwan_map_activity
import com.example.tour_guide_nepal.maps.pokhara_map_activity
import com.example.tour_guide_nepal.nearbyplaces.pokhara_nearbyplaces
import com.example.tour_guide_nepal.video.pokhara_video_activity
import com.example.tour_guide_nepal.weather.chitwan_weatherActivity
import com.example.tour_guide_nepal.weather.dolakha_weatherActivity
import com.example.tour_guide_nepal.weather.pokhara_weatherActivity

class pokhara_detail_activity : AppCompatActivity() {
    private lateinit var pokharamap : ConstraintLayout
    private lateinit var pokharaweather : ConstraintLayout
    private lateinit var pokharanear : ConstraintLayout
    private lateinit var pokharavideo : ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokhara_detail)

        pokharamap = findViewById(R.id.pokharamap)
        pokharaweather = findViewById(R.id.pokharaweather)
        pokharavideo = findViewById(R.id.pokharavideo)
 

        val imagelist = ArrayList<SlideModel>()

        imagelist.add(SlideModel("https://img.traveltriangle.com/blog/wp-content/uploads/2018/10/Phewa-Lake-Cover.jpg","Pokhara"))
        imagelist.add(SlideModel("https://www.traveltipsor.com/wp-content/uploads/2015/01/Paragliding-In-Pokhara.jpg","Pokhara"))
        imagelist.add(SlideModel("https://www.wondersofnepal.com/wp-content/uploads/2019/11/nepal-pokhara-9.jpg","Pokhara"))

        val imageSlider = findViewById<ImageSlider>(R.id.pokharaimage)
        imageSlider.setImageList(imagelist)
 
        pokharanear = findViewById(R.id.pokharanear)
 

        pokharamap.setOnClickListener {
            val intent = Intent(this, pokhara_map_activity::class.java)
            startActivity(intent)
        }
        pokharaweather.setOnClickListener {
            val intent = Intent(this, pokhara_weatherActivity::class.java)
            startActivity(intent)
        }
        pokharanear.setOnClickListener {
            val intent = Intent(this, pokhara_nearbyplaces::class.java)
            startActivity(intent)
        }
        pokharavideo.setOnClickListener {
            val intent = Intent(this, pokhara_video_activity::class.java)
            startActivity(intent)
        }
    }
}