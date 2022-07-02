package com.example.tour_guide_nepal.Repository

import com.example.tour_guide_nepal.API.MyApiRequest
import com.example.tour_guide_nepal.API.ServiceBuilder
import com.example.tour_guide_nepal.API.HotelBookAPI
import com.example.tour_guide_nepal.ENTITY.HotelBookDetails
import com.example.tour_guide_nepal.Response.BookHotelResponse
import com.example.tour_guide_nepal.Response.DeleteBookHotelResponse
import com.example.tour_guide_nepal.Response.GetAllBookHotelResponse
import com.example.tour_guide_nepal.Response.UpdateBookHotelResponse

class HotelBookRepository : MyApiRequest() {
    private val hotelBookAPI =
        ServiceBuilder.buildService(HotelBookAPI::class.java)

    //Book Hotel
    suspend fun bookHotel(hotelBookDetails: HotelBookDetails): BookHotelResponse{
        return apiRequest {
            hotelBookAPI.bookHotel(
                ServiceBuilder.token!!,hotelBookDetails
            )
        }
    }

    //update bookHotel
    suspend fun updateBookHotel(id: String,hotelBookDetails: HotelBookDetails):UpdateBookHotelResponse{
        return apiRequest {
            hotelBookAPI.updateBookHotel(
                ServiceBuilder.token!!,id,hotelBookDetails
            )
        }
    }

    //Delete bookHotel
    suspend fun deletebookHotel(id: String):DeleteBookHotelResponse{
        return apiRequest {
            hotelBookAPI.deletebookHotel(
                ServiceBuilder.token!!,id
            )
        }
    }

    //get all bookHotel
    suspend fun getallBookHotel():GetAllBookHotelResponse{
        return apiRequest {
            hotelBookAPI.getallBookHotel(
                ServiceBuilder.token!!
            )
        }
    }
}