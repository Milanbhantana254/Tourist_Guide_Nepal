package com.example.tour_guide_nepal.adapter

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.tour_guide_nepal.ENTITY.HotelBookDetails
import com.example.tour_guide_nepal.hotel.Hotelform_update_activity
import com.example.tour_guide_nepal.R
import com.example.tour_guide_nepal.Repository.HotelBookRepository
import com.example.tour_guide_nepal.hotel.HotelBookingInfo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

class HotelBookViewAdapter(
    val context: Context,
    val lstHotelBookView:MutableList<HotelBookDetails>
) : RecyclerView.Adapter<HotelBookViewAdapter.HotelBookViewHolder>() {

    class HotelBookViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val fullname : TextView
        val bemail : TextView
        val cnumber : TextView
        val hotelname : TextView
        val roomtype : TextView
        val noofguest : TextView
        val datefrom : TextView
        val dateto : TextView
        val comments : TextView
        val update: ImageButton
        val delete: ImageButton
        init {
            fullname = view.findViewById(R.id.bname)
            bemail = view.findViewById(R.id.bemail)
            cnumber = view.findViewById(R.id.bphone)
            hotelname = view.findViewById(R.id.bhotelname)
            roomtype = view.findViewById(R.id.broomtype)
            noofguest = view.findViewById(R.id.bnoofguest)
            datefrom = view.findViewById(R.id.bdatefrom)
            dateto = view.findViewById(R.id.bdateto)
            comments = view.findViewById(R.id.bcomment)
            update=view.findViewById(R.id.editupdate)
            delete=view.findViewById(R.id.delete)
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HotelBookViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.hotelbooking_custom_layout,parent,false)
        return HotelBookViewHolder(view)
    }


    override fun onBindViewHolder(holder: HotelBookViewHolder, position: Int) {
        val hotelbooklist = lstHotelBookView[position]
        holder.fullname.text = hotelbooklist.fullname
        holder.bemail.text = hotelbooklist.email
        holder.cnumber.text = hotelbooklist.phone
        holder.hotelname.text = hotelbooklist.hotelname
        holder.roomtype.text = hotelbooklist.roomtype
        holder.noofguest.text = hotelbooklist.numberofpeople
        holder.datefrom.text = hotelbooklist.datefrom
        holder.dateto.text = hotelbooklist.dateto
        holder.comments.text = hotelbooklist.comments

        holder.update.setOnClickListener {
            val intent = Intent(context, Hotelform_update_activity::class.java)
            intent.putExtra("HotelBookingDetails",hotelbooklist)
            context.startActivity(intent)
        }

        holder.delete.setOnClickListener {
            val builder = AlertDialog.Builder(context)
            builder.setTitle("Delete ${hotelbooklist.fullname}")
            builder.setMessage("Are you sure do you want to delete ${hotelbooklist.hotelname} ?")
            builder.setIcon(android.R.drawable.ic_delete)
            builder.setPositiveButton("Yes") {_,_ ->
                deleteHotebook(hotelbooklist)
            }
            builder.setNegativeButton("No") {_,_ ->
                Toast.makeText(context,"Cancelled", Toast.LENGTH_SHORT).show()
            }
            val alertDialog: AlertDialog = builder.create()
            alertDialog.setCancelable(false)
            alertDialog.show()
        }


    }

    private fun deleteHotebook(hotelbooklist: HotelBookDetails) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val hotelBookRepository = HotelBookRepository()
                val response = hotelBookRepository.deletebookHotel(hotelbooklist._id!!)
                if (response.success == true) {
                    withContext(Dispatchers.Main) {
                        Toast.makeText(context, "${hotelbooklist.hotelname} deleted successfully", Toast.LENGTH_SHORT).show()

                        lstHotelBookView.remove(hotelbooklist)
                        notifyDataSetChanged()
                    }
                }
            } catch (ex:Exception) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(context, "Error ${ex.localizedMessage}", Toast.LENGTH_SHORT).show()
                }
            }
        }

    }

    override fun getItemCount(): Int {
        return lstHotelBookView.size
    }

}