package com.app.basearchmvvmapp.view.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.app.basearchmvvmapp.R
import com.app.basearchmvvmapp.databinding.FragmentHomeBinding

class HomeFragment:Fragment(R.layout.fragment_home) {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() = binding.apply {

        textAlbums.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToAlbumsFragment())
        }

        textAnimals.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToAnimalsFragment())
        }
    }
}