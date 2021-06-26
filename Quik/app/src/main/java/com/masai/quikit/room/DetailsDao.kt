package com.masai.quikit.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface DetailsDao {

    @Insert
    suspend fun insertDetails(details: Details)

    @Query("Select * From DetailsTable")
    fun getAllDetails(): LiveData<List<Details>>

    @Delete
    fun deleteDetail(details: Details)
}