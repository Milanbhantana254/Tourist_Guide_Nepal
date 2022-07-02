package com.example.tour_guide_nepal.nearbyplaces

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tour_guide_nepal.hotel.Hotelbooking_Activity
import com.example.tour_guide_nepal.R
import com.example.tour_guide_nepal.service.model.NearByPlaceModel
import com.example.tour_guide_nepal.view.adapter.NearByPlacesAdapter
import com.example.tour_guide_nepal.viewmodel.NearByPlacesViewModel
import kotlinx.android.synthetic.main.activity_chitwan_nearbyplaces.*
import kotlinx.android.synthetic.main.activity_chitwan_nearbyplaces.Hospital
import kotlinx.android.synthetic.main.activity_chitwan_nearbyplaces.Restaurent
import java.lang.Exception

class dolakha_nearbyplaces : AppCompatActivity() {
    var nearByPlacesViewModel: NearByPlacesViewModel?= null

    var current_location: String ?= null
    var keyword: String ?= null
    val radious = "2000"
    val key = "AIzaSyBH_TExjnT7McUcM-x39Gl0PTDPc7mSiUs"

    var current_lat: Double ?= null
    var current_long: Double ?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dolakha_nearbyplaces)
        nearByPlacesViewModel = ViewModelProviders.of(this).get(NearByPlacesViewModel::class.java)

        getMyLatLong()

        Busstation.setOnClickListener { getPlaces("bus station")
        }
        Restaurent.setOnClickListener { getPlaces("Restaurant")
        }
        Hospital.setOnClickListener { getPlaces("hospital")
        }


        Atm.setOnClickListener { getPlaces("atm") }

        Hotel.setOnClickListener { getPlaces("Hotel")
            val intent = Intent(this, Hotelbooking_Activity::class.java)
            startActivity(intent)
        }
        Policestation.setOnClickListener { getPlaces("Police Station")


        }
        Shopingmall.setOnClickListener { getPlaces("Shopping mall")
        }


        Cafe.setOnClickListener { getPlaces("Cafe") }

        Livemap.setOnClickListener { getPlaces("Zoo")
         }



    }




    @SuppressLint("MissingPermission")
    private fun getMyLatLong()
    {

        var locationManager: LocationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager

        var location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER)

        current_lat = 27.666612
        current_long = 86.050411

        current_location = "$current_lat,$current_long"
    }



    private fun getPlaces(keyword: String)
    {
        try {
            nearByPlacesViewModel!!.getNearByPlacs(current_location, radious, keyword, key).observe(this, Observer {

                //activityMain2Binding!!.setVariable(BR.MainNearByPlacesRespopnse, it)
                nearByPlacesRecycle.layoutManager =
                    LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

                val nearByPlaceAdapterType = NearByPlacesAdapter(this, it.getResults() as List<NearByPlaceModel>)
                nearByPlacesRecycle.adapter = nearByPlaceAdapterType

            })
        }
        catch (e: Exception)
        {
            Log.d("dolakha nearby places","Exception: "+e)
        }



    }








}
