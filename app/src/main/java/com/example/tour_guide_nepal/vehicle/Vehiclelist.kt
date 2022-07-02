package com.example.tour_guide_nepal.vehicle

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tour_guide_nepal.ENTITY.Vehicle
import com.example.tour_guide_nepal.R
import com.example.tour_guide_nepal.adapter.VehiclesAdapter
import com.example.tour_guide_nepal.viewmodel.VehiclesViewModel

class Vehiclelist : AppCompatActivity() , VehiclesAdapter.OnVehiclesClickedListener {

    private val TAG = "MainActivity"

    val requestCode: Int = 1211

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: VehiclesAdapter
    lateinit var vehicles: ArrayList<Vehicle>
    lateinit var searchView: SearchView
    lateinit var layoutManager: LinearLayoutManager
    lateinit var viewModel: VehiclesViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vehiclelist)
        initializeResources();
        loadData();
        initalizeSearch();
    }

    private fun initalizeSearch() {
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                Log.e(TAG, "onQueryTextChange: newText" + newText)
                adapter.filter.filter(newText)
                return true
            }

        })
    }

    private fun loadData() {
        val model = VehiclesViewModel(application)
        model.getAll().observe(this, Observer<List<Vehicle>> { vehicles ->
            Log.e(TAG, "loadData: vehicle " + vehicles)
            this.vehicles.addAll(vehicles);
        })
        adapter.notifyDataSetChanged()
    }

    fun initializeResources() {
        recyclerView = findViewById(R.id.recycler_view);
        vehicles = ArrayList();
        layoutManager = LinearLayoutManager(applicationContext)
        adapter = VehiclesAdapter(applicationContext, this)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter;


        viewModel = ViewModelProvider(this).get(VehiclesViewModel::class.java)
        viewModel.getAll().observe(this, Observer { vehicles ->
            vehicles?.let { adapter.setVehicles(it) }
        })

    }

    override fun onVehicleClicked(position: Int) {
        val builder: AlertDialog.Builder? = this?.let {
            AlertDialog.Builder(it)
        }
        builder?.setTitle("Hire this Car")
        builder?.setMessage("Confirm vehicle hiring request")
        builder?.setPositiveButton("Confirm Request", DialogInterface.OnClickListener { dialog, id ->
            Toast.makeText(applicationContext,"Request has been sent", Toast.LENGTH_LONG).show()
        })
        builder?.setNegativeButton("Cancel", DialogInterface.OnClickListener { dialog, id ->
            Toast.makeText(applicationContext,"Request has been cancelled...", Toast.LENGTH_LONG).show()
        })
        val dialog: AlertDialog? = builder?.create()
        dialog?.show()
    }
}