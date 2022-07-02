package com.example.tour_guide_nepal.DAO

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.tour_guide_nepal.ENTITY.Vehicle


@Dao
interface VehiclesDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(vehicle: Vehicle);

    @Query("SELECT * FROM vehicles WHERE id = :id")
    fun getVehicleById(id: Long): LiveData<Vehicle>

    @Query("SELECT * FROM vehicles WHERE name = :name")
    fun getVehicleByName(name: String): LiveData<List<Vehicle>>

    @Query("SELECT * FROM vehicles")
    fun getAllVehicles(): LiveData<List<Vehicle>>

    @Update
    suspend fun updateVehicle(vehicle: Vehicle);

    @Query("DELETE FROM vehicles WHERE id = :id")
    suspend fun deleteVehicle(id: Long);

    @Query("DELETE FROM vehicles")
    suspend fun deleteAllVehicles();
}