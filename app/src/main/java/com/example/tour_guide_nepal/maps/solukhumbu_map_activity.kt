package com.example.tour_guide_nepal.maps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tour_guide_nepal.R
import com.example.tour_guide_nepal.databinding.ActivitySolukhumbuMapBinding

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class solukhumbu_map_activity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_solukhumbu_map)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        val solukhumbu = LatLng(27.7909733, 86.6611083)
        // Add a marker in pokhara and move the camera
        mMap.addMarker(
            MarkerOptions().position(solukhumbu)
                .title("solukhumbu")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN))
        )
        mMap.animateCamera(
            CameraUpdateFactory.newLatLngZoom(solukhumbu, 15F), 3000, null
        )
        //  mMap.moveCamera(CameraUpdateFactory.newLatLng(solukhumbu))
        mMap.uiSettings.isZoomControlsEnabled = true
    }
}