package com.example.tour_guide_nepal.place_details

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintLayout
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.models.SlideModel
import com.example.tour_guide_nepal.R
import com.example.tour_guide_nepal.maps.chitwan_map_activity
import com.example.tour_guide_nepal.maps.janakpur1_map
import com.example.tour_guide_nepal.nearbyplaces.janakpur_nearbyplaces
import com.example.tour_guide_nepal.video.janakpur_video_activity
import com.example.tour_guide_nepal.weather.chitwan_weatherActivity
import com.example.tour_guide_nepal.weather.dolakha_weatherActivity
import com.example.tour_guide_nepal.weather.janakpur_weatherActivity

class janakpur_detail_activity : AppCompatActivity() {
    private lateinit var janakpurmap : ConstraintLayout
    private lateinit var janakpurweather : ConstraintLayout
    private lateinit var janakpurnear : ConstraintLayout
    private lateinit var janakpurvideo : ConstraintLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_janakpur_detail)

        janakpurmap = findViewById(R.id.janakpurmap)
        janakpurweather = findViewById(R.id.janakpurweather)
        janakpurvideo = findViewById(R.id.janakpurvideo)
 

        val imagelist = ArrayList<SlideModel>()

        imagelist.add(SlideModel("https://www.welcomenepal.com/uploads/destination/janakpur-ss-lt.jpeg","Janakpur"))
        imagelist.add(SlideModel("https://images.squarespace-cdn.com/content/v1/5ba835d87fdcb8cb90743f28/1540712521611-0BJ6FQHXC915AXXBFUG9/Ganga+Sagar_Janakpur_Nepal.jpeg","Janakpur"))
        imagelist.add(SlideModel("https://lh3.googleusercontent.com/proxy/5ef3WiPVoMAZcrcorcP4Afuq2Lkt_BXKs8Hkon5pdNUC6sdCWdgN_RhDDpKzBEGPSD27Kg9T6wIRPtsN-9kGY29EFirZLeAnoF6FHRZmxOyogXgjENfFhr3wm0n-TL9XYRtKvw_KTq2p0qGl4s9wmcfCig","Janakpur"))

        val imageSlider = findViewById<ImageSlider>(R.id.janakpurimage)
        imageSlider.setImageList(imagelist)

 
        janakpurnear = findViewById(R.id.janakpurnear)
 

        janakpurmap.setOnClickListener {
            val intent = Intent(this, janakpur1_map::class.java)
            startActivity(intent)
        }
        janakpurweather.setOnClickListener {
            val intent = Intent(this, janakpur_weatherActivity::class.java)
            startActivity(intent)
        }
        janakpurnear.setOnClickListener {
            val intent = Intent(this, janakpur_nearbyplaces::class.java)
            startActivity(intent)
        }
        janakpurvideo.setOnClickListener {
            val intent = Intent(this, janakpur_video_activity::class.java)
            startActivity(intent)
        }
    }
}