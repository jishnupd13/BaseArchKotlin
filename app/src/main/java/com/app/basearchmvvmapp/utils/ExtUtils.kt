package com.app.basearchmvvmapp.utils

import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment


fun Fragment.toast(msg:String){
    Toast.makeText(requireContext(),msg,Toast.LENGTH_LONG).show()
}

fun View.show(){
    visibility = View.VISIBLE
}

fun View.hide(){
    visibility = View.GONE
}

fun View.invisible(){
    visibility = View.INVISIBLE
}