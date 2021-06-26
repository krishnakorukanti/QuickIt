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
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element


class DetailsViewHolder(
    private val view: View,
    private val listener: RecyclerClickListener
) : RecyclerView.ViewHolder(view) {
    private val TAG = "DetailsViewHolder"
    fun setData(details: Details) {
        view.apply {
            val urlEmbeddedView: URLEmbeddedView = findViewById(R.id.uev)
            val imageView : ImageView = findViewById(R.id.imageURLEmd)
            urlEmbeddedView.setURL(details.link, object : URLEmbeddedView.OnLoadURLListener {
                override fun onLoadURLCompleted(data: URLEmbeddedData?) {
                    urlEmbeddedView.title(data?.getTitle());
                    urlEmbeddedView.description(data?.getDescription());
                    urlEmbeddedView.host(data?.getHost());
                    urlEmbeddedView.thumbnail(data?.getThumbnailURL());
                    urlEmbeddedView.favor(data?.getFavorURL());
                    Glide.with(imageView).load(data?.getThumbnailURL()).into(imageView)
                    imageView.visibility = View.VISIBLE
                }

            })






        }
    }
}