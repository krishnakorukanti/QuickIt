package com.masai.quickit.room_database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "details")
data class DetailsEntity(
    @PrimaryKey(autoGenerate = true)
    var Id: Int = 0,

    @ColumnInfo(name = "title")
    val title: String,

    @ColumnInfo(name = "link")
    val link: String,

    @ColumnInfo(name = "description")
    val description: String

)


