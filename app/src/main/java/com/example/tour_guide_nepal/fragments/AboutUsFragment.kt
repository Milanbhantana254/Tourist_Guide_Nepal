package com.example.tour_guide_nepal.fragments

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.example.tour_guide_nepal.R
import com.example.tour_guide_nepal.SliderAdapter
import com.example.tour_guide_nepal.imageslider.SliderItem
import kotlin.math.abs


class AboutUsFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var viewPager2: ViewPager2
    private val sliderHandler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment

       val view = inflater.inflate(R.layout.fragment_about_us, container, false)
        viewPager2=view.findViewById(R.id.viewPager_ImageSlider)

        val sliderItems: MutableList<SliderItem> = ArrayList()
        sliderItems.add(SliderItem(R.drawable.roshan_don))
        sliderItems.add(SliderItem(R.drawable.tamanddon))
        sliderItems.add(SliderItem(R.drawable.bhantanadon))
        sliderItems.add(SliderItem(R.drawable.roshnidon))
        sliderItems.add(SliderItem(R.drawable.sujandon))

        viewPager2.adapter = SliderAdapter(sliderItems, viewPager2)

        viewPager2.clipToPadding = false
        viewPager2.clipChildren = false
        viewPager2.offscreenPageLimit = 3
        viewPager2.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER

        val compositePageTransformer = CompositePageTransformer()
        compositePageTransformer.addTransformer(MarginPageTransformer(30))
        compositePageTransformer.addTransformer { page, position ->
            val r= 1 - abs(position)
            page.scaleY = 0.85f + r+ 0.25f

        }

        viewPager2.setPageTransformer(compositePageTransformer)

        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                sliderHandler.removeCallbacks(sliderRunnable)
                sliderHandler.postDelayed(sliderRunnable, 3000)
            }

        })

        return view
    }

        private val sliderRunnable = Runnable {
            viewPager2.currentItem = viewPager2.currentItem + 1
        }

    override fun onPause() {
        super.onPause()
        sliderHandler.postDelayed(sliderRunnable, 4000)
    }

    override fun onResume() {
        super.onResume()
        sliderHandler.postDelayed(sliderRunnable, 4000)
    }

}