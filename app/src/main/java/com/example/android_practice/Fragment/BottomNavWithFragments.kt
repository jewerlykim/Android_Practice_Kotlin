package com.example.android_practice.Fragment

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.android_practice.R
import com.example.android_practice.databinding.ActivityBottomNavWithFragmentsBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class BottomNavWithFragments : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {
    
    private lateinit var homeFragment: HomeFragment
    private lateinit var rankingFragment: RankingFragment
    private lateinit var profileFragment: ProfileFragment
    
    private lateinit var binding : ActivityBottomNavWithFragmentsBinding
    val TAG : String = HomeFragment.TAG
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBottomNavWithFragmentsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        binding.bottomNav.setOnNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu_home -> {
                Log.d(TAG, "onNavigationItemSelected: home")
            }
            R.id.menu_ranking -> {
                Log.d(TAG, "onNavigationItemSelected: ranking")
            }
            R.id.menu_profile -> {
                Log.d(TAG, "onNavigationItemSelected: profile")
            }
        }
        
        return true
    }
}