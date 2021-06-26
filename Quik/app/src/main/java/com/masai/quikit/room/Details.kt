package com.masai.quikit.room

import android.net.Uri
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "DetailsTable")
data class Details(


    @ColumnInfo(name = "content")
    val content : String?=null,

    @ColumnInfo(name="flag")
    val flag: Boolean =false


//
//    @ColumnInfo(name = "image")
//    val image : Uri? =null
){
    @PrimaryKey(autoGenerate = true)
    var detailsId : Int =0
}



