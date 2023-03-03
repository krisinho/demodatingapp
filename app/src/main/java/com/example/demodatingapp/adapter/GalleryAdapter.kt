package com.example.demodatingapp.adapter

import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.viewpager.widget.PagerAdapter
import com.example.demodatingapp.R
import com.example.demodatingapp.databinding.ItemGalleryBinding
import com.example.demodatingapp.util.ImageLoader

interface GalleryListener {
    fun onGalleryItemClicked(position: Int, imageNames: Array<String>)
}

class GalleryAdapter(private val imageNames: Array<String>,
                     private val context: Context,
                     private val galleryListener: GalleryListener? = null): PagerAdapter() {

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun getCount(): Int {
        return imageNames.size
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val binding = ItemGalleryBinding.inflate(LayoutInflater.from(context), container, false)

        //Picasso.get().load(imageIds[position]).into(binding.galleryItemImageView)
        ImageLoader.getInstance(context).load(imageNames[position], R.drawable.placeholder, R.drawable.error_image, binding.galleryItemImageView)

        binding.galleryItemImageView.setOnClickListener {
            galleryListener?.onGalleryItemClicked(position, imageNames)
        }

        container.addView(binding.root)

        return binding.root
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View?)
    }
}