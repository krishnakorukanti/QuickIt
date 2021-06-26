package com.masai.quikit.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.masai.quikit.R
import com.masai.quikit.interfaces.RecyclerClickListener
import com.masai.quikit.room.Details
import com.masai.quikit.viewholder.DashBoardViewHolder
import com.masai.quikit.viewholder.DetailsViewHolder

class DashboardAdapter(private var detailsList: List<Details>
) : RecyclerView.Adapter<DashBoardViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DashBoardViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.dashboard_item_layout,parent,false)
        return DashBoardViewHolder(view)
    }

    override fun onBindViewHolder(holder: DashBoardViewHolder, position: Int) {
        val details = detailsList[position]
        holder.setData(details)
    }

    override fun getItemCount(): Int {
        return detailsList.size
    }

    fun updateDetails(detailsList: List<Details>){
        this.detailsList=detailsList
        notifyDataSetChanged()
    }



}