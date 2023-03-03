package com.example.demodatingapp.util

import android.net.Uri
import android.os.Build
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.databinding.BindingAdapter
import com.example.demodatingapp.R
import com.google.android.material.textfield.TextInputEditText

object BindingAdapters {

    @BindingAdapter("visibleGone")
    @JvmStatic
    fun View.visibleGone(visible: Boolean) {
        visibility = if (visible) {
            View.VISIBLE
        } else {
            View.GONE
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    @BindingAdapter("imageName")
    @JvmStatic
    fun ImageView.setRemoteImage(name: String) {
        ImageLoader.getInstance(context).load(name, R.drawable.placeholder, R.drawable.error_image, this)
    }

    @BindingAdapter("starCount")
    @JvmStatic
    fun TextView.starEmoji(count: Int) {
        val starEmojiHex = 0x2B50
        val starEmojiString = String(Character.toChars(starEmojiHex))
        text = starEmojiString.repeat(count)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    @BindingAdapter("roundedResource")
    @JvmStatic
    fun ImageView.setRoundedResource(imageName: String?) {
        imageName?.let {
            ImageLoader.getInstance(context).loadCircular(it, R.drawable.placeholder, R.drawable.error_image,this)
        }
    }

}