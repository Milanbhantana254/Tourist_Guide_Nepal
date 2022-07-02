package com.example.tour_guide_nepal.place_details

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintLayout
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.models.SlideModel
import com.example.tour_guide_nepal.R
import com.example.tour_guide_nepal.maps.chitwan_map_activity
import com.example.tour_guide_nepal.maps.solukhumbu_map_activity
import com.example.tour_guide_nepal.nearbyplaces.solukhumbu_nearbyplaces
import com.example.tour_guide_nepal.video.solukhumbu_video_activity
import com.example.tour_guide_nepal.weather.chitwan_weatherActivity
import com.example.tour_guide_nepal.weather.dolakha_weatherActivity
import com.example.tour_guide_nepal.weather.solukhumbhu_weatherActivity

class solukhumbu_detail_activity : AppCompatActivity() {
    private lateinit var solukhumbumap : ConstraintLayout
    private lateinit var solukhumbuweather : ConstraintLayout
    private lateinit var solukhumbunear : ConstraintLayout
    private lateinit var solukhumbuvideo : ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_solukhumbu_detail)

        solukhumbumap = findViewById(R.id.solukhumbumap)
        solukhumbuweather = findViewById(R.id.solukhumbuweather)
        solukhumbuvideo = findViewById(R.id.solukhumbuvideo)
 

        val imagelist = ArrayList<SlideModel>()

        imagelist.add(SlideModel("https://i.pinimg.com/736x/65/86/fd/6586fd1e1b0d26de4e68fbfe8a1b069a.jpg","Solukhumbu"))
        imagelist.add(SlideModel("https://i.ytimg.com/vi/6Oglc9nfmWA/maxresdefault.jpg","Solukhumbu"))
        imagelist.add(SlideModel("https://hoteleverestview.com/slider/images/hev1.jpg","Solukhumbu"))

        val imageSlider = findViewById<ImageSlider>(R.id.solukhumbuimage)
        imageSlider.setImageList(imagelist)
 
        solukhumbunear = findViewById(R.id.solukhumbunear)
 

        solukhumbumap.setOnClickListener {
            val intent = Intent(this, solukhumbu_map_activity::class.java)
            startActivity(intent)
        }
        solukhumbuweather.setOnClickListener {
            val intent = Intent(this, solukhumbhu_weatherActivity::class.java)
            startActivity(intent)
        }
        solukhumbunear.setOnClickListener {
            val intent = Intent(this, solukhumbu_nearbyplaces::class.java)
            startActivity(intent)
        }
        solukhumbuvideo.setOnClickListener {
            val intent = Intent(this, solukhumbu_video_activity::class.java)
            startActivity(intent)
        }
    }
}