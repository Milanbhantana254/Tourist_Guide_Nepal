package com.example.tour_guide_nepal


import com.example.tour_guide_nepal.API.ServiceBuilder
import com.example.tour_guide_nepal.ENTITY.HotelBookDetails
import com.example.tour_guide_nepal.ENTITY.User
import com.example.tour_guide_nepal.ENTITY.VehicleRentEntity
import com.example.tour_guide_nepal.Repository.HotelBookRepository
import com.example.tour_guide_nepal.Repository.UserRepository
import com.example.tour_guide_nepal.Repository.VehicleRentRepository
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

class unittesting {

    private lateinit var userRepository: UserRepository
    private lateinit var hotelbookrepository: HotelBookRepository
    private lateinit var vehiclerentrepository: VehicleRentRepository
    //=======login testing======
    @Test
    fun checklogin() = runBlocking {
        userRepository = UserRepository()
        val response = userRepository.loginUser("roshni1234@gmail.com","123456780")
        val expectedResult = true
        val actualresult = response.success
        Assert.assertEquals(expectedResult,actualresult)
    }

    //register
    @Test
    fun registerCustomer() = runBlocking {
        val user = User(

            email= "roshni111@gmail.com",
            fullname = "kritijoshi0111",
            phone = "9809897653",
            password = "15678"


        )
        userRepository = UserRepository()
        val response = userRepository.registerUser(user)
        val expectedResult = true
        val actualResult = response.success
        Assert.assertEquals(expectedResult, actualResult)
    }
    @Test
    fun addhotelbook() = runBlocking {
        userRepository = UserRepository()
        hotelbookrepository = HotelBookRepository()

        val hotel =
            HotelBookDetails(fullname = "aaditya chhrsg",email = "rohan@gmail.com", phone = "8888888888", hotelname = "jacob", roomtype = "single", datefrom = "9/6/2021", dateto = "9/8/2021",numberofpeople = "4",comments = "hello")

        ServiceBuilder.token ="Bearer " + userRepository.loginUser("roshan11@gmail.com","11111111").token
        val expectedResult = true
        val actualResult = hotelbookrepository.bookHotel(hotel).success
        Assert.assertEquals(expectedResult, actualResult)
    }
    @Test
    fun addvehiclebook() = runBlocking {
        userRepository = UserRepository()
        vehiclerentrepository = VehicleRentRepository()

        val Vehicle =
            VehicleRentEntity(fullname = "aaditya chhrsg",email = "rohan@gmail.com", phone = "8888888888",   tripstartdate = "9/6/2021", tripenddate = "9/8/2021",numberofpeople = "4",traveldetail = "hello")

        ServiceBuilder.token ="Bearer " + userRepository.loginUser("roshan11@gmail.com","11111111").token
        val expectedResult = true
        val actualResult = vehiclerentrepository.rentvehicle(Vehicle).success
        Assert.assertEquals(expectedResult, actualResult)
    }
}
