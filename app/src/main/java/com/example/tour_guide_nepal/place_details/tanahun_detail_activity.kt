package com.example.tour_guide_nepal.place_details

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintLayout
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.models.SlideModel
import com.example.tour_guide_nepal.R
import com.example.tour_guide_nepal.maps.chitwan_map_activity
import com.example.tour_guide_nepal.maps.tanahun_map_activity
import com.example.tour_guide_nepal.nearbyplaces.tanahun_nearbyplaces
import com.example.tour_guide_nepal.video.tanahun_video_activity
import com.example.tour_guide_nepal.weather.Tanahun_weatherActivity
import com.example.tour_guide_nepal.weather.chitwan_weatherActivity
import com.example.tour_guide_nepal.weather.dolakha_weatherActivity

class tanahun_detail_activity : AppCompatActivity() {
    private lateinit var tanahunmap : ConstraintLayout
    private lateinit var tanahunweather : ConstraintLayout
    private lateinit var tanahunnear : ConstraintLayout
    private lateinit var tanahunvideo : ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tanahun_detail)

        tanahunmap = findViewById(R.id.tanahunmap)
        tanahunweather = findViewById(R.id.tanahunweather)
        tanahunnear = findViewById(R.id.tanahunnear)
        tanahunvideo = findViewById(R.id.tanahunvideo)

        val imagelist = ArrayList<SlideModel>()

        imagelist.add(SlideModel("https://www.vivaanadventure.com/wp-content/uploads/2020/11/Manung-Kot-1080x540.jpg","Tanahun"))
        imagelist.add(SlideModel("https://www.nepaltrekkinginhimalaya.com/assets/userfiles/images/BC56C0B7-9752-4D39-A341-A93B3D8AB40D.jpeg","Tanahun"))
        imagelist.add(SlideModel("https://youimg1.tripcdn.com/target/10041c000001c1t7iE9B5_D_1180_558.jpg","Tanahun"))

        val imageSlider = findViewById<ImageSlider>(R.id.tanahunimage)
        imageSlider.setImageList(imagelist)


        tanahunmap.setOnClickListener {
            val intent = Intent(this, tanahun_map_activity::class.java)
            startActivity(intent)
        }
        tanahunweather.setOnClickListener {
            val intent = Intent(this, Tanahun_weatherActivity::class.java)
            startActivity(intent)
        }
        tanahunnear.setOnClickListener {
            val intent = Intent(this, tanahun_nearbyplaces::class.java)
            startActivity(intent)
        }
        tanahunvideo.setOnClickListener {
            val intent = Intent(this, tanahun_video_activity::class.java)
            startActivity(intent)
        }
    }
}