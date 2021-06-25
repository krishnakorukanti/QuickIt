package com.masai.quickit.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface DetailsDao {

    @Insert
    suspend fun insertDetails(detailsEntity: DetailsEntity)

    @Query("SELECT * FROM Details")
    fun getAllDetails(): LiveData<List<DetailsEntity>>

    @Delete
    fun deleteDetail(detailsEntity: DetailsEntity)
}