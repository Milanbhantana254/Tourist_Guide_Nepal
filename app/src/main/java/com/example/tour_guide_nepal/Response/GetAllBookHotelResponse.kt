package com.example.tour_guide_nepal.Response

import com.example.tour_guide_nepal.ENTITY.HotelBookDetails

class GetAllBookHotelResponse (
    val success:Boolean?=null,
    
    val data: MutableList<HotelBookDetails>?=null
)