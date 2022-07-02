package com.example.tour_guide_nepal.place_details

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintLayout
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.models.SlideModel
import com.example.tour_guide_nepal.R
import com.example.tour_guide_nepal.maps.chitwan_map_activity
import com.example.tour_guide_nepal.maps.mustang_map_activity
import com.example.tour_guide_nepal.nearbyplaces.mustang_nearbyplaces
import com.example.tour_guide_nepal.video.mustang_video_activity
import com.example.tour_guide_nepal.weather.chitwan_weatherActivity
import com.example.tour_guide_nepal.weather.dolakha_weatherActivity
import com.example.tour_guide_nepal.weather.mustang_weatherActivity

class mustang_detail_activity : AppCompatActivity() {
    private lateinit var mustangmap : ConstraintLayout
    private lateinit var mustangweather : ConstraintLayout
    private lateinit var mustangnear : ConstraintLayout
    private lateinit var mustangvideo : ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mustang_detail)

        mustangmap = findViewById(R.id.mustangmap)
        mustangweather = findViewById(R.id.mustangweather)
        mustangnear = findViewById(R.id.mustangnear)
        mustangvideo = findViewById(R.id.mustngvideo)

        val imagelist = ArrayList<SlideModel>()

        imagelist.add(SlideModel("https://www.welcomenepal.com/uploads/destination/mustang-tk-adventure.jpeg","Mustang"))
        imagelist.add(SlideModel("https://www.nepalguideinfo.com/new/wp-content/uploads/2017/04/upper_mustang_mansoon-768x388.jpg","Mustang"))
        imagelist.add(SlideModel("https://www.nepaltraveladventure.com/blog/wp-content/uploads/2018/08/upper-mustang-trek-2-800x334.jpg","Mustang"))

        val imageSlider = findViewById<ImageSlider>(R.id.mustangimage)
        imageSlider.setImageList(imagelist)


        mustangmap.setOnClickListener {
            val intent = Intent(this, mustang_map_activity::class.java)
            startActivity(intent)
        }
        mustangweather.setOnClickListener {
            val intent = Intent(this, mustang_weatherActivity::class.java)
            startActivity(intent)
        }
        mustangnear.setOnClickListener {
            val intent = Intent(this, mustang_nearbyplaces::class.java)
            startActivity(intent)
        }

        mustangvideo.setOnClickListener {
            val intent = Intent(this, mustang_video_activity::class.java)
            startActivity(intent)
        }
    }
}