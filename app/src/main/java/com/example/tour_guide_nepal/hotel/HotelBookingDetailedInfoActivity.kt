package com.example.tour_guide_nepal.hotel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.tour_guide_nepal.ENTITY.HotelBookDetails
import com.example.tour_guide_nepal.R
import kotlinx.android.synthetic.main.activity_hotel_booking_detailed_info.*

class HotelBookingDetailedInfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hotel_booking_detailed_info)

        val intent =intent.getParcelableExtra<HotelBookDetails>("hotelbookinfo")
        Log.i("name","${intent?.fullname}")
        Log.i("email","${intent?.email}")
        Log.i("phone","${intent?.phone}")
        Log.i("hotelname","${intent?.hotelname}")
        Log.i("roomtype","${intent?.roomtype}")
        Log.i("guestno","${intent?.numberofpeople}")
        Log.i("datefrom","${intent?.datefrom}")
        Log.i("dateto","${intent?.dateto}")
        Log.i("comments","${intent?.comments}")

        bname.text = intent?.fullname
        bemail.text = intent?.email
        bphone.text = intent?.phone
        bhotelname.text = intent?.hotelname
        broomtype.text = intent?.roomtype
        bnoofguest.text = intent?.numberofpeople
        bdatefrom.text = intent?.datefrom
        bdateto.text = intent?.dateto
        bcomment.text = intent?.comments

    }
}