package com.masai.quikit.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Details::class],version = 3,exportSchema = false)
abstract class DetailsDatabase : RoomDatabase() {

    abstract val detailsDao : DetailsDao
    companion object {

        private var INSTANCE: DetailsDatabase? = null

        fun getInstance(context: Context): DetailsDatabase {
            synchronized(this) {

                if (INSTANCE==null){
                    val builder= Room.databaseBuilder(context.applicationContext,DetailsDatabase::class.java,"database_Details")
                    builder.fallbackToDestructiveMigration()
                    return builder.build()
                    return INSTANCE!!
                }else{
                    return INSTANCE!!
                }

            }
        }
    }
}