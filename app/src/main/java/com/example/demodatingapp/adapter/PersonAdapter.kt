package com.example.demodatingapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.navigation.findNavController
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.demodatingapp.databinding.ListItemPersonBinding
import com.example.demodatingapp.fragment.ListFragmentDirections
import com.example.demodatingapp.util.ImageLoader
import com.example.demodatingapp.vo.Person
import com.squareup.picasso.Picasso

class PersonAdapter : ListAdapter<Person, PersonAdapter.ViewHolder>(PersonDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ListItemPersonBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val person = getItem(position)
        holder.apply {
            bind(person, createOnClickListener(position))
            itemView.tag = person
        }
    }

    private fun createOnClickListener(index: Int): View.OnClickListener {
        return View.OnClickListener {
            val direction =
                ListFragmentDirections.navigationToDetail(index) // ez a navigation (jingle...) xml-ben felvett fragment és az abban lévő action meghívása
            it.findNavController().navigate(direction)
        }
    }

    class ViewHolder(private val binding: ListItemPersonBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Person, clickListener: View.OnClickListener) {
            binding.apply {
                person = item
                this.clickListener = clickListener
        //        Picasso.get().load(item.galleryImages.first()).into(binding.personPhoto)
                binding.listItemHeader.binding.person = item
                executePendingBindings()
            }
        }
    }

   /* companion object {
        @BindingAdapter("imageName")
        @JvmStatic
        fun ImageView.setRemoteImage(name: String) {
            ImageLoader.load(name, this)
        }
    }*/
}
