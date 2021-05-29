package com.example.android_practice.Fragment

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.android_practice.R
import com.example.android_practice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
    }

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnFragment1.setOnClickListener { setFrag(0) }
        binding.btnFragment2.setOnClickListener { setFrag(1) }
        binding.btnFragment3.setOnClickListener { setFrag(2) }

    }

    private fun setFrag(fragNum : Int) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        when(fragNum){
            0 -> {
                fragmentTransaction.replace(R.id.main_frame, Fragment1()).commit()
            }
            1 -> {
                fragmentTransaction.replace(R.id.main_frame, Fragment2()).commit()
            }
            2 -> {
                fragmentTransaction.replace(R.id.main_frame, Fragment3()).commit()
            }
        }// when
    }// setFrag
}