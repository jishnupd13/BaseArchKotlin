package com.app.basearchmvvmapp.view

/***
 * @author Jishnu P Dileep
 * This is an sample base mvvm application
 * Created at Mon 15 january 2023
 * */

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.app.basearchmvvmapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}