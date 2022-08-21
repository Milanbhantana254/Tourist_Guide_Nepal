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
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_gorkha_detail.*
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
        var database = FirebaseDatabase.getInstance().reference
        var getdata = object : ValueEventListener{
            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

            override fun onDataChange(snapshot: DataSnapshot) {

                var sb = StringBuilder()
                for(i in snapshot.children){
                    var name = i.child("fullname").getValue()
                    var email = i.child("email").getValue()
                    var phone = i.child("phone").getValue()
                    var hotelname = i.child("hotelname").getValue()
                    var roomtype = i.child("roomtype").getValue()
                    var datefrom = i.child("datefrom").getValue()
                    var dateto = i.child("dateto").getValue()
                    var numberofpeople = i.child("numberofpeople").getValue()
                    var comments = i.child("comments").getValue()

                    sb.append("${i.key} $name $email $phone $hotelname $roomtype $datefrom $dateto $numberofpeople $comments")

                }
            }
        }
        database.addValueEventListener(getdata)
        database.addListenerForSingleValueEvent(getdata)
//        CoroutineScope(Dispatchers.IO).launch {
//            try {
//                val hotelBookDetails = HotelBookDetails()
//                val hotelBookRepository = HotelBookRepository()
//                val response = hotelBookRepository.getallBookHotel()
//                if (response.data != null) {
//
//                    val lstBookDetails = response.data
//                    withContext(Dispatchers.Main) {
//
//
//                        val adapter = HotelBookViewAdapter(this@HotelBookingInfo,lstBookDetails)
//                        recyclerview.layoutManager=LinearLayoutManager(this@HotelBookingInfo)
//                        recyclerview.adapter=adapter
//
//
//                    }
//                }
//            } catch (ex: Exception) {
//                withContext(Dispatchers.Main) {
//                    Toast.makeText(
//                        this@HotelBookingInfo,
//                        "Error : ${ex.toString()}", Toast.LENGTH_SHORT
//                    ).show()
//                }
//            }
//        }
    }

    private fun refreshapp() {
        swipeRefresh.setOnRefreshListener {
            loadbookingdetails()

            swipeRefresh.isRefreshing = false
            Toast.makeText(this, "refreshed", Toast.LENGTH_SHORT).show()
        }

    }
}