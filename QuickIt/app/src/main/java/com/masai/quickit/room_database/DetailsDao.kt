package com.masai.quickit.room_database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface DetailsDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
   suspend fun  addDetails(myEntity: DetailsEntity)

    @Query("SELECT * FROM details order by id DESC")
    fun getAllDetails(): LiveData<List<DetailsEntity>>

    @Query("DELETE FROM details WHERE id= :delId")
   suspend fun deleteDetails(delId:Int)

}