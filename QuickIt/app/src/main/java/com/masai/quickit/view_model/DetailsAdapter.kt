package com.masai.quickit.view_model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.masai.quickit.R
import com.masai.quickit.room_database.DetailsEntity
import kotlinx.android.synthetic.main.details_item_layout.view.*

class DetailsAdapter(val detailList:List<DetailsEntity>):
    RecyclerView.Adapter<DetailsAdapter.DetailViewHolder>() {

    inner class DetailViewHolder(view: View):RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(
            R.layout.details_item_layout, parent,
            false)
       return DetailViewHolder(view)
    }

    override fun onBindViewHolder(holder: DetailViewHolder, position: Int) {
         holder.itemView.tvTitle.text=detailList[position].title
         holder.itemView.tvDescription.text=detailList[position].description
         holder.itemView.tvAny.text=detailList[position].link

    }

    override fun getItemCount(): Int {
       return detailList.size
    }

}