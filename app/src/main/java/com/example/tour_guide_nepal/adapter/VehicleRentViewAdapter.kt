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
import com.example.tour_guide_nepal.ENTITY.VehicleRentEntity
import com.example.tour_guide_nepal.R
import com.example.tour_guide_nepal.Repository.HotelBookRepository
import com.example.tour_guide_nepal.Repository.VehicleRentRepository
import com.example.tour_guide_nepal.vehicle.Updatevehiclebooking_activity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

class VehicleRentViewAdapter(
    val context: Context,
    val lstVehicleRentView:MutableList<VehicleRentEntity>
): RecyclerView.Adapter<VehicleRentViewAdapter.VehicleRentViewHolder>() {
    class VehicleRentViewHolder(view:View) : RecyclerView.ViewHolder(view) {
        val ttitle : TextView
        val tname : TextView
        val temail : TextView
        val tphone : TextView
        val tnoofperson : TextView
        val vehicletype : TextView
        val tnoofvehicle : TextView
        val tripdatefrom : TextView
        val tripdateto : TextView
        val tcomment : TextView
        val tupdate : ImageButton
        val tdelete : ImageButton
        init {
            ttitle = view.findViewById(R.id.ttitle)
            tname = view.findViewById(R.id.tname)
            temail = view.findViewById(R.id.temail)
            tphone = view.findViewById(R.id.tphone)
            tnoofperson = view.findViewById(R.id.tnoofperson)
            vehicletype = view.findViewById(R.id.vehicletype)
            tnoofvehicle = view.findViewById(R.id.tnoofvehicle)
            tripdatefrom = view.findViewById(R.id.tripdatefrom)
            tripdateto = view.findViewById(R.id.tripdateto)
            tcomment = view.findViewById(R.id.tcomment)
            tupdate = view.findViewById(R.id.teditupdate)
            tdelete = view.findViewById(R.id.tdelete)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VehicleRentViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.vehicle_rent_custom_layout,parent,false)
        return VehicleRentViewHolder(view)
    }

    override fun onBindViewHolder(holder: VehicleRentViewHolder, position: Int) {
        val vehiclerentlist = lstVehicleRentView[position]
        holder.ttitle.text = vehiclerentlist.title
        holder.tname.text = vehiclerentlist.fullname
        holder.temail.text = vehiclerentlist.email
        holder.tphone.text = vehiclerentlist.phone
        holder.tnoofperson.text = vehiclerentlist.numberofpeople
        holder.vehicletype.text = vehiclerentlist.vehicletype
        holder.tnoofvehicle.text = vehiclerentlist.numberofvehicle
        holder.tripdatefrom.text = vehiclerentlist.tripstartdate
        holder.tripdateto.text = vehiclerentlist.tripenddate
        holder.tcomment.text = vehiclerentlist.traveldetail

        holder.tupdate.setOnClickListener {
            val intent = Intent(context, Updatevehiclebooking_activity::class.java)
            intent.putExtra("VehicleRentDetails",vehiclerentlist)
            context.startActivity(intent)
        }

        holder.tdelete.setOnClickListener {
            val builder = AlertDialog.Builder(context)
            builder.setTitle("Delete ${vehiclerentlist.vehicletype}")
            builder.setMessage("Are you sure do you want to delete ${vehiclerentlist.vehicletype} ?")
            builder.setIcon(android.R.drawable.ic_delete)
            builder.setPositiveButton("Yes") {_,_ ->
                deleterentvehicle(vehiclerentlist)
            }
            builder.setNegativeButton("No") {_,_ ->
                Toast.makeText(context,"Cancelled", Toast.LENGTH_SHORT).show()
            }
            val alertDialog: AlertDialog = builder.create()
            alertDialog.setCancelable(false)
            alertDialog.show()
        }

    }

    private fun deleterentvehicle(vehiclerentlist: VehicleRentEntity) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val vehicleRentRepository = VehicleRentRepository()
                val response = vehicleRentRepository.deleteVehicleRent(vehiclerentlist._id!!)
                if (response.success == true) {
                    withContext(Dispatchers.Main) {
                        Toast.makeText(context, "${vehiclerentlist.vehicletype} deleted successfully", Toast.LENGTH_SHORT).show()

                        lstVehicleRentView.remove(vehiclerentlist)
                        notifyDataSetChanged()
                    }
                }
            } catch (ex: Exception) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(context, "Error ${ex.localizedMessage}", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return lstVehicleRentView.size
    }
}