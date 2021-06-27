package com.masai.quikit.viewholder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.masai.quikit.R
import com.masai.quikit.interfaces.RecyclerClickListener
import com.masai.quikit.room.Details
import com.nguyencse.URLEmbeddedData
import com.nguyencse.URLEmbeddedView
import com.overflowarchives.linkpreview.TelegramPreview
import com.overflowarchives.linkpreview.ViewListener


class DashBoardViewHolder(
    private val view: View,
) : RecyclerView.ViewHolder(view) {

    fun setData(details: Details){
        view.apply {
            val urlEmbeddedView: URLEmbeddedView = findViewById(R.id.uevDash)
            urlEmbeddedView.setURL(details.link, object : URLEmbeddedView.OnLoadURLListener {
                override fun onLoadURLCompleted(data: URLEmbeddedData?) {
                    urlEmbeddedView.title(data?.getTitle());
                    urlEmbeddedView.description(data?.getDescription());
                    urlEmbeddedView.host(data?.getHost());
                    urlEmbeddedView.thumbnail(data?.getThumbnailURL());
                    urlEmbeddedView.favor(data?.getFavorURL());
                }

            })
        }
    }
}