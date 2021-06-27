package com.masai.quikit

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import android.util.Patterns
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.masai.quikit.ui.home.HomeViewModel
import com.nguyencse.URLEmbeddedData
import com.nguyencse.URLEmbeddedView

class ReceiverActivity : AppCompatActivity() {
    private lateinit var homeViewModel: HomeViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reciever)
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)
        when {
            intent?.action == Intent.ACTION_SEND -> {
                if ("text/plain" == intent.type) {
                    handleSendText(intent) // Handle text being sent
                } else if (intent.type?.startsWith("image/") == true) {
                    handleSendImage(intent,this@ReceiverActivity) // Handle single image being sent
                }
            }
            intent?.action == Intent.ACTION_SEND_MULTIPLE
                    && intent.type?.startsWith("image/") == true -> {
                handleSendMultipleImages(intent,this@ReceiverActivity) // Handle multiple images being sent
            }
            else -> {
                // Handle other intents, such as being started from the home screen
                Toast.makeText(this,"Other Data",Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun handleSendText(intent: Intent) {
        intent.getStringExtra(Intent.EXTRA_TEXT)?.let {
            // Update UI to reflect text being shared
            Log.d("TAG", "text: " + it)
            //homeViewModel.insertDetailsToDB(it)
            val link = it.split(" ").firstOrNull() { it -> Patterns.WEB_URL.matcher(it).find() }
            homeViewModel.insertLinktoDB(it, link)

            val urlEmbeddedView: URLEmbeddedView = findViewById(R.id.uev)
            val imageView : ImageView = findViewById(R.id.imageURLEmd)
            urlEmbeddedView.setURL(link, object : URLEmbeddedView.OnLoadURLListener {
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


            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)

    }
}

private fun handleSendImage(intent: Intent, receiverActivity: ReceiverActivity) {
    (intent.getParcelableExtra<Parcelable>(Intent.EXTRA_STREAM) as? Uri)?.let {
        Log.d("TAG", "handleSendImage: " + it)
        Toast.makeText(receiverActivity,"Image Data",Toast.LENGTH_SHORT).show()
//
//            val intent = Intent(this,MainActivity::class.java)
//            startActivity(intent)
//

    }
}

private fun handleSendMultipleImages(intent: Intent, receiverActivity: ReceiverActivity) {
    intent.getParcelableArrayListExtra<Parcelable>(Intent.EXTRA_STREAM)?.let {
        // Update UI to reflect multiple images being shared
        Log.d("TAG", "Multiuple: " + it.toString())
        Toast.makeText(receiverActivity,"Multiple Data",Toast.LENGTH_SHORT).show()
    }
}
