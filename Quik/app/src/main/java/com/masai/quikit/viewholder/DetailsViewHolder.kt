package com.masai.quikit.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.masai.quikit.R
import com.masai.quikit.interfaces.RecyclerClickListener
import com.masai.quikit.room.Details

class DetailsViewHolder(
    private val view: View,
    private val listener: RecyclerClickListener
) : RecyclerView.ViewHolder(view) {

    fun setData(details: Details){
        view.apply {
           val textView : TextView = findViewById(R.id.detailsText)
            textView.text = details.content
        }
    }
}