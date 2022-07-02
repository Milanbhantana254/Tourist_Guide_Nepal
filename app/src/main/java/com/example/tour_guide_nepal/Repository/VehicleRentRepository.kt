package com.example.tour_guide_nepal.Repository

import com.example.tour_guide_nepal.API.MyApiRequest
import com.example.tour_guide_nepal.API.ServiceBuilder
import com.example.tour_guide_nepal.API.VehicleRentApi
import com.example.tour_guide_nepal.ENTITY.VehicleRentEntity
import com.example.tour_guide_nepal.Response.DeleteVehicleRentResponse
import com.example.tour_guide_nepal.Response.GetAllVehicleRentResponse
import com.example.tour_guide_nepal.Response.UpdateVehicleRentResponse
import com.example.tour_guide_nepal.Response.VehicleRentResponse

class VehicleRentRepository : MyApiRequest() {
    private val vehicleRentApi =
        ServiceBuilder.buildService(VehicleRentApi::class.java)

    //Rent Vehicle
    suspend fun rentvehicle(vehicleRentEntity: VehicleRentEntity):VehicleRentResponse{
        return apiRequest {
            vehicleRentApi.rentvehicle(
                ServiceBuilder.token!!,vehicleRentEntity
            )
        }
    }

    //update rent vehicle
    suspend fun updateVehicleRent(id: String,vehicleRentEntity: VehicleRentEntity):UpdateVehicleRentResponse{
        return apiRequest {
            vehicleRentApi.updatevehclerent(
                ServiceBuilder.token!!,id,vehicleRentEntity
            )
        }
    }

    //Delete vehicle rent
    suspend fun deleteVehicleRent(id: String):DeleteVehicleRentResponse{
        return apiRequest {
            vehicleRentApi.deletevehiclerent(
                ServiceBuilder.token!!,id
            )
        }
    }

    //get all vehiclerent
    suspend fun getallvehiclerent():GetAllVehicleRentResponse{
        return apiRequest {
            vehicleRentApi.getallvehiclerent(
                ServiceBuilder.token!!
            )
        }
    }
}