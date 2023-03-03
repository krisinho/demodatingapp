package com.example.demodatingapp.util

import android.content.Context
import android.net.ConnectivityManager
import android.net.Uri
import android.os.Build
import android.widget.ImageView
import androidx.annotation.RequiresApi
import com.example.demodatingapp.BuildConfig
import com.example.demodatingapp.network.livedata.ConnectivityLiveData
import com.squareup.picasso.NetworkPolicy
import com.squareup.picasso.Picasso

@RequiresApi(Build.VERSION_CODES.M)
class ImageLoader(context: Context) {

    @RequiresApi(Build.VERSION_CODES.M)
    private val connectivityLiveData =
        ConnectivityLiveData(context.getSystemService(ConnectivityManager::class.java))

    var isOnline = false

    init {
        connectivityLiveData.observeForever {
            isOnline = it
        }
    }

    fun load(url: String, placeHolder: Int? = null, errorImage: Int? = null, imageView: ImageView) {
        load(url, placeHolder, errorImage, null, imageView)
    }

    fun loadCircular(url: String, placeHolder: Int? = null, errorImage: Int? = null, imageView: ImageView) {
         load(url, placeHolder, errorImage, CircleTransform(), imageView)
    }

    private fun load(url: String, placeHolder: Int?, errorImage: Int?, circleTransform: CircleTransform?, imageView: ImageView) {
        val uri = Uri.parse("$BASE_URL/$url")
        var creator = Picasso.get().load(uri)
        placeHolder?.let { creator = creator.placeholder(placeHolder) }
        circleTransform?.let { creator = creator.transform(circleTransform) }
        errorImage?.let { creator = creator.error(errorImage)}
        if (!isOnline) {
            creator = creator.networkPolicy(NetworkPolicy.OFFLINE)
        }
        creator.into(imageView)
    }

    companion object : SingletonHolder<ImageLoader, Context>(::ImageLoader) {
        private const val BASE_URL = "${BuildConfig.BASE_URL}/static"
    }
}