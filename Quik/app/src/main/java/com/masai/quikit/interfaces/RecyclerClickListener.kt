package com.masai.quikit.interfaces

import com.masai.quikit.room.Details

interface RecyclerClickListener {

    fun onDeleteClicked(position : Int,details: Details)
}