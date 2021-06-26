package com.masai.quikit.ui.home

import android.app.Application
import android.net.Uri
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.masai.quikit.room.Details
import com.masai.quikit.room.DetailsDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel(application : Application) :AndroidViewModel(application) {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text
    //private val context = getApplication<Application>().applicationContext

    fun insertDetailsToDB(content : String?=null){
        CoroutineScope(Dispatchers.IO).launch {
            DetailsDatabase.getInstance(getApplication()).detailsDao.insertDetails(Details(content = content))
        }
    }

    fun deleteDetails(id:Int){
        CoroutineScope(Dispatchers.IO).launch {
            DetailsDatabase.getInstance(getApplication()).detailsDao.deleteDetails(id)
            Log.d("TAG", "deleteDetails: "+id)
        }
    }
    fun insertLinktoDB(content : String?=null,link : String?=null){
        CoroutineScope(Dispatchers.IO).launch {
            DetailsDatabase.getInstance(getApplication()).detailsDao.insertDetails(Details(content=content,link=link))
        }
    }


    fun getAllDetails(): LiveData<List<Details>>{
        return DetailsDatabase.getInstance(getApplication()).detailsDao.getAllDetails()
    }

    fun getData(name : String?=null): LiveData<List<Details>>{
            return DetailsDatabase.getInstance(getApplication()).detailsDao.getData(name)

    }


}