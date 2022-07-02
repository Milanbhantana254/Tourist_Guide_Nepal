package com.example.tour_guide_nepal.Repository

import androidx.lifecycle.LiveData

interface CrudeRepository<T,E> {

    fun findById(id:T) : LiveData<E>

    fun findAll() : LiveData<List<E>>

    suspend fun insert(e:E);

    suspend fun update(e:E);

    suspend fun deleteById(id:Long);

    suspend fun deleteAll();
}