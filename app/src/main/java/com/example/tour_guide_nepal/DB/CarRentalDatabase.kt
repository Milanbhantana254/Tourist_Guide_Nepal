package com.example.tour_guide_nepal.DB;

import android.content.Context
import androidx.room.Database;
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.tour_guide_nepal.DAO.VehiclesDao
import com.example.tour_guide_nepal.ENTITY.Vehicle
import com.example.tour_guide_nepal.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

import kotlin.jvm.Volatile;

@Database(entities = arrayOf(Vehicle::class), version = 1, exportSchema = false)
public abstract class CarRentalDatabase : RoomDatabase() {



    abstract fun vehicleDao(): VehiclesDao

    companion object {
        @Volatile
        private var INSTANCE: CarRentalDatabase? = null

        fun getDatabase(
            context: Context,
            scope: CoroutineScope
        ): CarRentalDatabase {
            val carDatabaseInstance = INSTANCE
            if (carDatabaseInstance != null) {
                return carDatabaseInstance
            }

            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CarRentalDatabase::class.java,
                    "car_rent_db"
                )
                    .addCallback(DatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }

    private class DatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onOpen(db: SupportSQLiteDatabase) {
            super.onOpen(db)
            INSTANCE?.let { database ->
                scope.launch {
                    populateDatabase(database.vehicleDao())
                }
            }
        }

        suspend fun populateDatabase(vehicleDao: VehiclesDao) {
            val car1 = Vehicle(1, "Benze CLA", 2000.0, "available", R.drawable.benze_b);
            val car2 = Vehicle(2, "Jeep Wrangler", 4000.0, "available", R.drawable.jeep);
            val car3 = Vehicle(3, "Wagon", 1800.0, "available", R.drawable.wagon);
            val car4 = Vehicle(4, "Vintage Ride", 30000.0, "available", R.drawable.vintage);

            vehicleDao.insert(car1)
            vehicleDao.insert(car2)
            vehicleDao.insert(car3)
            vehicleDao.insert(car4)
        }
    }

}


