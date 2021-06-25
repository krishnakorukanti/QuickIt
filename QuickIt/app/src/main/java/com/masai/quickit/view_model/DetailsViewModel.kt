package com.masai.quickit.view_model

import android.app.Application
import android.telecom.Call
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.masai.quickit.room_database.DetailsDatabase
import com.masai.quickit.room_database.DetailsEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailsViewModel(application: Application):AndroidViewModel(application) {

   private val repository:DetailsRepository
   val getAllDetails:LiveData<List<DetailsEntity>>
   init {
       val dao=DetailsDatabase.getDatabase(application).getMyDao()
       repository=DetailsRepository(dao)
       getAllDetails=repository.getAllDetails()
   }
    fun addDetails(detailsEntity: DetailsEntity)=viewModelScope.launch(Dispatchers.IO){
        repository.addDetails(detailsEntity)
    }
    fun deleteDetails(id:Int)=viewModelScope.launch(Dispatchers.IO){
        repository.deleteDetails(id)
    }
}