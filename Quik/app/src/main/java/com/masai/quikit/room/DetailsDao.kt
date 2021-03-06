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

    @Query("SELECT * FROM detailstable order by detailsId DESC")
    fun getAllDetails(): LiveData<List<Details>>

    @Query("DELETE FROM detailstable WHERE detailsId= :delId")
    fun deleteDetails(delId:Int)


    @Query("SELECT * FROM detailstable WHERE content LIKE '%' || :name || '%'")
    fun getData(name: String?): LiveData<List<Details>>



}