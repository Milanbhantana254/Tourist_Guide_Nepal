package com.example.tour_guide_nepal.hotel

import android.app.DatePickerDialog
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.tour_guide_nepal.ENTITY.HotelBookDetails
import com.example.tour_guide_nepal.R
import com.example.tour_guide_nepal.Repository.HotelBookRepository
import com.example.tour_guide_nepal.notification.NotificationChannels
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.*

class Hotelbooking_Activity : AppCompatActivity() {

    private var type_of_room = arrayOf("Single","Double","Triple","Quad")

    private lateinit var etfullname: EditText
    private lateinit var etemail: EditText
    private lateinit var etphonenumber: EditText
    private lateinit var hotelname : EditText
    private lateinit var roomtype : Spinner
    private lateinit var datefrom: TextView
    private lateinit var dateto: TextView
    private lateinit var etguestnumber: EditText
    private lateinit var comments: EditText
    private lateinit var btnbook: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hotelbooking)

        etfullname = findViewById(R.id.etfullname)
        etemail = findViewById(R.id.etemail)
        etphonenumber = findViewById(R.id.etphonenumber)
        hotelname = findViewById(R.id.ethotelname)
        roomtype = findViewById(R.id.etroomtype)
        datefrom = findViewById(R.id.datefrom)
        dateto = findViewById(R.id.dateto)
        etguestnumber = findViewById(R.id.etguestnumber)
        comments = findViewById(R.id.comments)
        btnbook = findViewById(R.id.btnbook)

        val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,type_of_room)
        roomtype.adapter = adapter

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


        btnbook.setOnClickListener {
            hotelBook()
        }
    }

    private fun hotelBook() {
        val fullname = etfullname.text.toString()
        val email = etemail.text.toString()
        val phnumber = etphonenumber.text.toString()
        val hotelname = hotelname.text.toString()
        val roomtype = roomtype.selectedItem.toString()
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
                val response = hotelBookRepository.bookHotel(hotelBookDetails)

                if (response.success == true) {
                    withContext(Dispatchers.Main) {
                        Toast.makeText(
                            this@Hotelbooking_Activity,
                            "Hotel Booked Successfully",
                            Toast.LENGTH_SHORT
                        ).show()
                        hotelbooknotification()
                    }
                }
            } catch (ex: Exception) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(
                        this@Hotelbooking_Activity,
                        "Error ${ex.localizedMessage}",
                        Toast.LENGTH_SHORT
                    ).show()

                }
            }
        }
    }

    private fun hotelbooknotification() {
        val notificationManager = NotificationManagerCompat.from(this)

        val notificationChannels = NotificationChannels(this)
        notificationChannels.createNotificationChannels()

        val notification = NotificationCompat.Builder(this, notificationChannels.channel_1)
            .setSmallIcon(R.drawable.notification)
            .setContentTitle("Tour Guide Nepal")
            .setContentText("Hotel Book Successfully")
            .setColor(Color.GREEN)
            .build()

        notificationManager.notify(1, notification)
    }
}