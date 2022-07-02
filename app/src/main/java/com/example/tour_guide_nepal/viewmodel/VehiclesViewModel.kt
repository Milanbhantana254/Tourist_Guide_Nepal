package com.example.tour_guide_nepal.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.tour_guide_nepal.DAO.VehiclesDao
import com.example.tour_guide_nepal.DB.CarRentalDatabase
import com.example.tour_guide_nepal.ENTITY.Vehicle
import com.example.tour_guide_nepal.Repository.VehiclesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class VehiclesViewModel(application: Application) : AndroidViewModel(application) {

    private val database: CarRentalDatabase =
        CarRentalDatabase.getDatabase(application, viewModelScope)
    private val repository: VehiclesRepository;
    private val dao: VehiclesDao;

    init {
        dao = database.vehicleDao()
        repository = VehiclesRepository(dao);
    }

    suspend fun insert(e: Vehicle) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(e);
    }

    fun getById(id: Long): LiveData<Vehicle> {
        return repository.findById(id);
    }

    fun getAll(): LiveData<List<Vehicle>> {
        return repository.findAll();
    }

    fun deleteById(id: Long) = viewModelScope.launch(Dispatchers.IO) {
        repository.deleteById(id);
    }

    fun deleteAll() = viewModelScope.launch(Dispatchers.IO) {
        repository.deleteAll()
    }
}