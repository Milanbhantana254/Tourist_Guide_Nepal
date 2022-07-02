package com.example.tour_guide_nepal.Response

import com.example.tour_guide_nepal.ENTITY.VehicleRentEntity

class GetAllVehicleRentResponse (
    val success:Boolean?=null,

    val data: MutableList<VehicleRentEntity>?=null
        )