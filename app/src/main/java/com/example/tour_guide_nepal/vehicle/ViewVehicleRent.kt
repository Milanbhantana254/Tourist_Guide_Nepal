package com.example.tour_guide_nepal.vehicle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.tour_guide_nepal.R
import com.example.tour_guide_nepal.adapter.VehicleRentViewAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ViewVehicleRent : AppCompatActivity() {
    private lateinit var recyclerview: RecyclerView
    private lateinit var swipeRefresh: SwipeRefreshLayout
    private lateinit var emptyView : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_vehicle_rent)

        recyclerview = findViewById(R.id.recyclerview)
        swipeRefresh = findViewById(R.id.swiperefresh)
        emptyView = findViewById(R.id.empty_view)

        refreshapp()

        loadvehiclerent()
    }

    private fun loadvehiclerent() {

    }

    private fun refreshapp() {
        swipeRefresh.setOnRefreshListener {
            loadvehiclerent()

            swipeRefresh.isRefreshing = false
            Toast.makeText(this, "refreshed", Toast.LENGTH_SHORT).show()
        }
    }
}