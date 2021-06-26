package com.masai.quikit.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "DetailsTable")
data class Details(
    @PrimaryKey(autoGenerate = true)
    var detailsId : Int =0,

    @ColumnInfo(name = "Content")
    val content : String
)