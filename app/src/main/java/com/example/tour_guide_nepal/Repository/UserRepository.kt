package com.example.tour_guide_nepal.Repository


import com.example.tour_guide_nepal.API.MyApiRequest

import com.example.tour_guide_nepal.API.ServiceBuilder

import com.example.tour_guide_nepal.ENTITY.User
import com.example.tour_guide_nepal.API.UserAPI


import com.example.tour_guide_nepal.Response.LoginResponse

class UserRepository:  MyApiRequest() {
    private val userAPI = ServiceBuilder.buildService(UserAPI::class.java)

    //Register User
    suspend fun registerUser(user: User) : LoginResponse {
        return apiRequest {
            userAPI.registerUser(user)
        }
    }

    //login User
    suspend fun loginUser(email:String, password:String):LoginResponse{
        return apiRequest {
            userAPI.checkUser(email, password)
        }
    }

}




