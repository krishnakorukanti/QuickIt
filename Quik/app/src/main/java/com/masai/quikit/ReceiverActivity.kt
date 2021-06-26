package com.masai.quikit

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import android.util.Patterns
import androidx.lifecycle.ViewModelProvider
import com.masai.quikit.ui.home.HomeViewModel

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
                    handleSendImage(intent) // Handle single image being sent
                }
            }
            intent?.action == Intent.ACTION_SEND_MULTIPLE
                    && intent.type?.startsWith("image/") == true -> {
                handleSendMultipleImages(intent) // Handle multiple images being sent
            }
            else -> {
                // Handle other intents, such as being started from the home screen
            }
        }
    }
    private fun handleSendText(intent: Intent) {
        intent.getStringExtra(Intent.EXTRA_TEXT)?.let {
            // Update UI to reflect text being shared
            Log.d("TAG", "text: "+it)
            //homeViewModel.insertDetailsToDB(it)
            val link = it.split(" ").firstOrNull(){ it -> Patterns.WEB_URL.matcher(it).find()}
            homeViewModel.insertLinktoDB(it,link)
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)

        }
    }

    private fun handleSendImage(intent: Intent) {
        (intent.getParcelableExtra<Parcelable>(Intent.EXTRA_STREAM) as? Uri)?.let {
            Log.d("TAG", "handleSendImage: "+it)
//
//            val intent = Intent(this,MainActivity::class.java)
//            startActivity(intent)
//

        }
    }

    private fun handleSendMultipleImages(intent: Intent) {
        intent.getParcelableArrayListExtra<Parcelable>(Intent.EXTRA_STREAM)?.let {
            // Update UI to reflect multiple images being shared
        }
    }
}