package com.masai.quickit.view_model

import androidx.lifecycle.LiveData
import com.masai.quickit.room_database.DetailsDao
import com.masai.quickit.room_database.DetailsEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class DetailsRepository(val detailsDao: DetailsDao) {

    fun addDetails(detailsEntity: DetailsEntity) {
        CoroutineScope(Dispatchers.IO).launch {
            detailsDao.addDetails(detailsEntity)
        }
    }

    fun getAllDetails(): LiveData<List<DetailsEntity>> {
          return detailsDao.getAllDetails()

    }
    fun deleteDetails(delId: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            detailsDao.deleteDetails(delId)
        }
    }
}