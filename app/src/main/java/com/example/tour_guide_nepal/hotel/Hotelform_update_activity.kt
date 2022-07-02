package com.example.tour_guide_nepal.hotel

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.tour_guide_nepal.ENTITY.HotelBookDetails
import com.example.tour_guide_nepal.R
import com.example.tour_guide_nepal.Repository.HotelBookRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.*

class Hotelform_update_activity : AppCompatActivity() {

    private lateinit var etfullname: EditText
    private lateinit var etemail: EditText
    private lateinit var etphonenumber: EditText
    private lateinit var hotelname : EditText
    private lateinit var roomtype : EditText
    private lateinit var datefrom: TextView
    private lateinit var dateto: TextView
    private lateinit var etguestnumber: EditText
    private lateinit var comments: EditText
    private lateinit var btnupdate: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hotelform_update)

        etfullname = findViewById(R.id.etfullname)
        etemail = findViewById(R.id.etemail)
        etphonenumber = findViewById(R.id.etphonenumber)
        hotelname = findViewById(R.id.ethotelname)
        roomtype = findViewById(R.id.etroomtype)
        datefrom = findViewById(R.id.datefrom)
        dateto = findViewById(R.id.dateto)
        etguestnumber = findViewById(R.id.etguestnumber)
        comments = findViewById(R.id.comments)
        btnupdate = findViewById(R.id.btnupdate)


        val intent = intent.getParcelableExtra<HotelBookDetails>("HotelBookingDetails")
        if (intent !=null){
            etfullname.setText(intent.fullname)
            etemail.setText(intent.email)
            etphonenumber.setText(intent.phone)
            hotelname.setText(intent.hotelname)
            roomtype.setText(intent.roomtype)
            etguestnumber.setText(intent.numberofpeople)
            datefrom.setText(intent.datefrom)
            dateto.setText(intent.dateto)
            comments.setText(intent.comments)
        }

        //calendar
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        //click date to show datepickerdialogue
        datefrom.setOnClickListener {
            val dpd =
                DatePickerDialog(
                    this,
                    DatePickerDialog.OnDateSetListener { view, mYear, mMonth, mDay ->
                        //set to textview
                        datefrom.setText("" + mDay + "/" + mMonth + "/" + mYear)
                    },
                    year,
                    month,
                    day
                )

            //show dialog
            dpd.show()

        }
        //click date to show datepickerdialogue
        dateto.setOnClickListener {
            val dpd =
                DatePickerDialog(
                    this,
                    DatePickerDialog.OnDateSetListener { view, mYear, mMonth, mDay ->
                        //set to textview
                        dateto.setText("" + mDay + "/" + mMonth + "/" + mYear)
                    },
                    year,
                    month,
                    day
                )

            //show dialog
            dpd.show()

        }

        btnupdate.setOnClickListener {
            hotelbookupdate()
        }
    }


    private fun hotelbookupdate() {
        val intent = intent.getParcelableExtra<HotelBookDetails>("HotelBookingDetails")
        val fullname = etfullname.text.toString()
        val email = etemail.text.toString()
        val phnumber = etphonenumber.text.toString()
        val hotelname = hotelname.text.toString()
        val roomtype = roomtype.text.toString()
        val datefrom = datefrom.text.toString()
        val dateto = dateto.text.toString()
        val guestno = etguestnumber.text.toString()
        val comments = comments.text.toString()

        val hotelBookDetails = HotelBookDetails(
            fullname = fullname,
            email = email,
            phone = phnumber,
            hotelname = hotelname,
            roomtype = roomtype,
            datefrom = datefrom,
            dateto = dateto,
            numberofpeople = guestno,
            comments = comments
        )
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val hotelBookRepository = HotelBookRepository()
                val response = hotelBookRepository.updateBookHotel(intent?._id!!,hotelBookDetails)
                if (response.message != null){
                    withContext(Dispatchers.Main){
                        Toast.makeText(this@Hotelform_update_activity, "updated successfully", Toast.LENGTH_SHORT).show()
                    }
                }
            } catch (ex:Exception){
                withContext(Dispatchers.Main){
                }
            }
        }
    }
}