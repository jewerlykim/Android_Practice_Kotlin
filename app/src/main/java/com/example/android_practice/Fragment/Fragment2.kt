package com.example.android_practice.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.android_practice.databinding.Frag2Binding

class Fragment2 : Fragment(){
    private var binding : Frag2Binding? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = Frag2Binding.inflate(inflater, container, false)
        return binding!!.root
    }

}