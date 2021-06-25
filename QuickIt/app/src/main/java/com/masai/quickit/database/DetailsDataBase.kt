package com.masai.quickit.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [DetailsEntity::class], version = 1, exportSchema = false)
abstract class DetailsDataBase : RoomDatabase() {

    abstract val detailsDao: DetailsDao

    companion object {
        private var INSTANCE: DetailsDataBase? = null

        fun getInstance(context: Context): DetailsDataBase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance =
                        Room.databaseBuilder(context, DetailsDataBase::class.java, "Details_DB")
                            .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}