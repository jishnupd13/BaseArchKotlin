package com.app.basearchmvvmapp.view.albums

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.app.basearchmvvmapp.R
import com.app.basearchmvvmapp.databinding.FragmentAlbumsBinding
import com.app.basearchmvvmapp.utils.NetworkResult
import com.app.basearchmvvmapp.utils.hide
import com.app.basearchmvvmapp.utils.show
import com.app.basearchmvvmapp.utils.toast
import com.app.basearchmvvmapp.view.albums.albums.AlbumsAdapter
import com.app.basearchmvvmapp.viewmodel.albums.AlbumsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AlbumsFragment:Fragment(R.layout.fragment_albums) {

    private lateinit var binding: FragmentAlbumsBinding
    private val viewModel by viewModels<AlbumsViewModel>()
    private lateinit var adapter:AlbumsAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAlbumsBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() = binding.apply {
        adapter = AlbumsAdapter(mutableListOf())
        recyclerviewAlbums.adapter = adapter
        observeAlbums()
        viewModel.fetchAlbums()
    }

    private fun observeAlbums() = binding.apply {

        viewModel.apiResponseLiveData.observe(viewLifecycleOwner){ response->

            when(response){

                is NetworkResult.Success->{
                    progressBar.hide()
                    response.data?.let { adapter.update(it) }
                }

                is NetworkResult.Error->{
                    toast(response.message?:"")
                    progressBar.hide()
                }

                is NetworkResult.Loading->{
                    progressBar.show()
                }
            }
        }
    }
}