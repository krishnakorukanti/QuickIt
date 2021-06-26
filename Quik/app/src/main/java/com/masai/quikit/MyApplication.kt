package com.masai.quikit

import android.app.Application
import com.masai.quikit.room.DetailsDatabase

class MyApplication : Application() {

    companion object{
        var detailsDatabase : DetailsDatabase?=null
    }

    override fun onCreate() {
        super.onCreate()
        detailsDatabase= DetailsDatabase.getInstance(this)
    }
}