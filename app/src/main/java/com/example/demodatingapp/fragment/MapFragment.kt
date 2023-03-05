package com.example.demodatingapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.demodatingapp.R

class MapFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<com.example.demodatingapp.databinding.FragmentMapBinding>(inflater, R.layout.fragment_map, container, false)
        return binding.root
    }
}
