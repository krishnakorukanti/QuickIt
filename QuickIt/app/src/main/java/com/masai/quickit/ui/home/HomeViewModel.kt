package com.masai.quickit.ui.home

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.masai.quickit.database.DetailsDataBase
import com.masai.quickit.database.DetailsEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class HomeViewModel(private val context: Context) : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "This is Home Fragment"
    }
    val text: LiveData<String> = _text

    fun fetchDetailsFromDB(): LiveData<List<DetailsEntity>> {
        return DetailsDataBase.getInstance(context)
            .detailsDao.getAllDetails()
    }

    fun deleteDetailFromDB(detailsEntity: DetailsEntity) {
        CoroutineScope(IO).launch {
            DetailsDataBase.getInstance(context)
                .detailsDao.deleteDetail(detailsEntity)
        }
    }
     fun insertDetailsToDB(title : String, description : String){
         CoroutineScope(Dispatchers.IO).launch {
             val detailsEntity = DetailsEntity(title = title,description = description)
             DetailsDataBase.getInstance(context).detailsDao.insertDetails(detailsEntity)
         }

    }
}