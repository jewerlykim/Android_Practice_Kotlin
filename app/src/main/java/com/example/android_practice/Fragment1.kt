package com.example.android_practice

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.android_practice.databinding.Frag1Binding

class Fragment1 : Fragment() {

    private val TAG = "프레그먼트생명주기"

    private var fragmentHomeBinding : Frag1Binding? = null
    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(TAG, "onAttach: ")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate: ")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, "onCreateView: ")
        val binding = Frag1Binding.inflate(inflater, container, false)
//        return inflater.inflate(R.layout.frag1, container, false)
        fragmentHomeBinding = binding
        return fragmentHomeBinding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }


    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d(TAG, "onActivityCreated: ")
    }

    override fun onDestroyView() {
        fragmentHomeBinding = null // 메모리에서 날리기
        Log.d(TAG, "onDestroyView: ")
        super.onDestroyView()
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: ")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: ")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: ")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: ")
    }

    override fun onDestroy() {
        Log.d(TAG, "onDestroy: ")
        super.onDestroy()
        
    }

    override fun onDetach() {
        Log.d(TAG, "onDetach: ")
        super.onDetach()
    }

}