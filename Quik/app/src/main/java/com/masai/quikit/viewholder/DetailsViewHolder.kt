package com.masai.quikit.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.masai.quikit.R
import com.masai.quikit.interfaces.RecyclerClickListener
import com.masai.quikit.room.Details
import com.overflowarchives.linkpreview.SkypePreview
import com.overflowarchives.linkpreview.TelegramPreview
import com.overflowarchives.linkpreview.ViewListener

class DetailsViewHolder(
    private val view: View,
    private val listener: RecyclerClickListener
) : RecyclerView.ViewHolder(view) {

    fun setData(details: Details){
        view.apply {
           val textView : TextView = findViewById(R.id.detailsText)
            textView.text = details.content


            val preview : TelegramPreview = findViewById(R.id.link_preview)
            preview.loadUrl(details.content,object : ViewListener{
                override fun onFailedToLoad(e: Exception?) {

                }

                override fun onPreviewSuccess(status: Boolean) {
                textView.visibility = View.GONE
                }

            })
        }
    }
}