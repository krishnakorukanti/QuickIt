package com.masai.quikit.ui.home

import android.app.Application
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

    fun insertDetailsToDB(content : String){
        CoroutineScope(Dispatchers.IO).launch {
            DetailsDatabase.getInstance(getApplication()).detailsDao.insertDetails(Details(content = content))
        }
    }

    fun getAllDetails(): LiveData<List<Details>>{
        return DetailsDatabase.getInstance(getApplication()).detailsDao.getAllDetails()
    }

}