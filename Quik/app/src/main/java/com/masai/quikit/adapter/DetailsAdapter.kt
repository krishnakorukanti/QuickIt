package com.masai.quikit.adapter

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.masai.quikit.R
import com.masai.quikit.interfaces.RecyclerClickListener
import com.masai.quikit.room.Details
import com.masai.quikit.viewholder.DetailsViewHolder

class DetailsAdapter(
    private var detailsList: List<Details>,
    private val listener: RecyclerClickListener
) : RecyclerView.Adapter<DetailsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.details_layout,parent,false)
        return DetailsViewHolder(view,listener)
    }

    override fun onBindViewHolder(holder: DetailsViewHolder, position: Int) {
       val details = detailsList[position]
        holder.setData(details)
        holder.itemView.setOnClickListener {
            val shareIntent = Intent( Intent.ACTION_VIEW, Uri.parse(details.content))
            holder.itemView.context.startActivity(shareIntent)

        }
    }

    override fun getItemCount(): Int {
        return detailsList.size
    }

    fun updateDetails(detailsList: List<Details>){
        this.detailsList=detailsList
        notifyDataSetChanged()
    }



}