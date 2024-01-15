package com.app.basearchmvvmapp.view.animals

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.app.basearchmvvmapp.R
import com.app.basearchmvvmapp.databinding.FragmentAnimalsBinding
import com.app.basearchmvvmapp.utils.NetworkResult
import com.app.basearchmvvmapp.utils.hide
import com.app.basearchmvvmapp.utils.show
import com.app.basearchmvvmapp.utils.toast
import com.app.basearchmvvmapp.viewmodel.animals.AnimalsViewModel
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnimalsFragment:Fragment(R.layout.fragment_animals) {

    private lateinit var binding : FragmentAnimalsBinding
    private val viewModel by viewModels<AnimalsViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAnimalsBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() = binding.apply {
        observeAnimalImage()
        viewModel.getDogs()
    }

    private fun observeAnimalImage() = binding.apply{
        viewModel.apiResponseLiveData.observe(viewLifecycleOwner){ response->
            when(response){
                is NetworkResult.Success->{
                    progressBar.hide()
                    Glide.with(requireContext()).load(
                        response.data?.message
                    ).into(binding.animalImage)
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