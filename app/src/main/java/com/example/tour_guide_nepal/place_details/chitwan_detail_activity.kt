package com.example.tour_guide_nepal.place_details

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintLayout
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.models.SlideModel
import com.example.tour_guide_nepal.R
import com.example.tour_guide_nepal.maps.chitwan_map_activity
import com.example.tour_guide_nepal.nearbyplaces.chitwan_nearbyplaces
import com.example.tour_guide_nepal.video.Chitwan_video_activity
import com.example.tour_guide_nepal.weather.chitwan_weatherActivity

class chitwan_detail_activity : AppCompatActivity() {
    private lateinit var chitwanmap : ConstraintLayout
    private lateinit var chitwanweather : ConstraintLayout
    private lateinit var chitwannear : ConstraintLayout
    private lateinit var chitwanvideo : ConstraintLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chitwan_detail)

        chitwanmap = findViewById(R.id.chitwanmap)
        chitwanweather = findViewById(R.id.chitwanweather)
        chitwannear = findViewById(R.id.chitwannear)
        chitwanvideo = findViewById(R.id.chitwanvideo)

        val imagelist = ArrayList<SlideModel>()

        imagelist.add(SlideModel("https://cdn2.wanderlust.co.uk/media/1037/cropped-dreamstime_xxl_68762448.jpg?anchor=center&mode=crop&width=600&height=225&format=auto&quality=30&rnd=131522023390000000","Chitwan"))
        imagelist.add(SlideModel("https://www.nepaltour.info/wp-content/uploads/2017/06/chitwan-jungle-safari-tour.jpg","Chitwan"))
        imagelist.add(SlideModel("https://i.ytimg.com/vi/lRViVaDBn3E/maxresdefault.jpg","Chitwan"))

        val imageSlider = findViewById<ImageSlider>(R.id.chitwanimage)
        imageSlider.setImageList(imagelist)


        chitwanmap.setOnClickListener {
            val intent = Intent(this, chitwan_map_activity::class.java)
            startActivity(intent)
        }
        chitwanweather.setOnClickListener {
            val intent = Intent(this, chitwan_weatherActivity::class.java)
            startActivity(intent)
        }
        chitwannear.setOnClickListener {
            val intent = Intent(this, chitwan_nearbyplaces::class.java)
            startActivity(intent)
        }

        chitwanvideo.setOnClickListener {
            val intent = Intent(this, Chitwan_video_activity::class.java)
            startActivity(intent)
        }

    }
}