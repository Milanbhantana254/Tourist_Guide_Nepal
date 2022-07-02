package com.example.tour_guide_nepal.hotel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.tour_guide_nepal.ENTITY.HotelBookDetails
import com.example.tour_guide_nepal.R
import com.example.tour_guide_nepal.Repository.HotelBookRepository
import com.example.tour_guide_nepal.adapter.HotelBookViewAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HotelBookingInfo : AppCompatActivity(){
    private lateinit var recyclerview: RecyclerView
    private lateinit var swipeRefresh: SwipeRefreshLayout
    private lateinit var emptyView : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hotel_booking_info)

        recyclerview = findViewById(R.id.recyclerview)
        swipeRefresh = findViewById(R.id.swiperefresh)
        emptyView = findViewById(R.id.empty_view)

        refreshapp()

        loadbookingdetails()
    }

    private fun loadbookingdetails() {

        CoroutineScope(Dispatchers.IO).launch {
            try {
                val hotelBookDetails = HotelBookDetails()
                val hotelBookRepository = HotelBookRepository()
                val response = hotelBookRepository.getallBookHotel()
                if (response.data != null) {

                    val lstBookDetails = response.data
                    withContext(Dispatchers.Main) {

 
                        val adapter = HotelBookViewAdapter(this@HotelBookingInfo,lstBookDetails)
                        recyclerview.layoutManager=LinearLayoutManager(this@HotelBookingInfo)
                        recyclerview.adapter=adapter

 
                    }
                }
            } catch (ex: Exception) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(
                        this@HotelBookingInfo,
                        "Error : ${ex.toString()}", Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    private fun refreshapp() {
        swipeRefresh.setOnRefreshListener {
            loadbookingdetails()

            swipeRefresh.isRefreshing = false
            Toast.makeText(this, "refreshed", Toast.LENGTH_SHORT).show()
        }

    }
}