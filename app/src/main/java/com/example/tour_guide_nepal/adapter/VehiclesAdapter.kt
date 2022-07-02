package com.example.tour_guide_nepal.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.tour_guide_nepal.ENTITY.Vehicle
import com.example.tour_guide_nepal.R
import java.util.*

class VehiclesAdapter internal constructor(
    context: Context, listener: OnVehiclesClickedListener
) : RecyclerView.Adapter<VehiclesAdapter.ViewHolder>(), Filterable {

    private val TAG = "VehiclesAdapter"
    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var vehicles = emptyList<Vehicle>()
    private var vehiclesFilterList = emptyList<Vehicle>();
    private var listener = listener;
    private var context:Context = context;

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = inflater.inflate(R.layout.item_vehicle_layout, parent, false)
        return ViewHolder(itemView,listener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val current = vehicles[position]
        holder.nameTextView.setText(current.name)
        holder.priceTextView.setText(
            String.format(
                Locale.ENGLISH,
                "Ksh %.2f Per Day",
                current.price
            )
        )

        holder.imageView.setImageDrawable(context.resources.getDrawable(current.imageId))
    }

    internal fun setVehicles(words: List<Vehicle>) {
        this.vehicles = words
        notifyDataSetChanged()
    }

    override fun getItemCount() = vehicles.size

    inner class ViewHolder(itemView: View, listener: OnVehiclesClickedListener) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        val listener: OnVehiclesClickedListener = listener;
        val container: CardView = itemView.findViewById(R.id.item_container)
        val nameTextView: TextView = itemView.findViewById(R.id.item_vehicle_name_text_view)
        val imageView: ImageView = itemView.findViewById(R.id.item_vehicle_image_view)
        val priceTextView: TextView = itemView.findViewById(R.id.item_vehicle_price_text_view)

        init {
            container.setOnClickListener(this)
        }

        override fun onClick(view: View?) {
            this.listener.onVehicleClicked(adapterPosition);
        }

    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charSearch = constraint.toString()
                if (charSearch.isEmpty()) {
                    vehiclesFilterList = vehicles
                } else {
                    val resultList = ArrayList<Vehicle>()
                    for (row in vehicles) {
                        if (row.name.toLowerCase(Locale.ROOT)
                                .contains(charSearch.toLowerCase(Locale.ROOT))
                        ) {
                            resultList.add(row)
                        }
                    }
                    vehiclesFilterList = resultList
                }
                val filterResults = FilterResults()
                filterResults.values = vehiclesFilterList

                Log.e(TAG, "performFiltering: filter result " + filterResults.toString())

                return filterResults
            }

            @Suppress("UNCHECKED_CAST")
            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                vehiclesFilterList = results?.values as ArrayList<Vehicle>
                notifyDataSetChanged()
            }

        }
    }

    interface OnVehiclesClickedListener {
        fun onVehicleClicked(position: Int);
    }
}