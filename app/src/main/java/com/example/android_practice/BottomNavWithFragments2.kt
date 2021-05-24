package com.example.android_practice

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.android_practice.databinding.ActivityBottomNavWithFragmentsBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class BottomNavWithFragments2 : AppCompatActivity() {
    
    private lateinit var homeFragment: HomeFragment
    private lateinit var rankingFragment: RankingFragment
    private lateinit var profileFragment: ProfileFragment
    
    private lateinit var binding : ActivityBottomNavWithFragmentsBinding
    val TAG : String = HomeFragment.TAG
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBottomNavWithFragmentsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        homeFragment = HomeFragment.newInstance()
        supportFragmentManager.beginTransaction().add(R.id.framelayout, homeFragment).commit()
        
        binding.bottomNav.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
    }

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener{
        when(it.itemId){
            R.id.menu_home -> {
                Log.d(TAG, "onNavigationItemSelected: home2")
                homeFragment = HomeFragment.newInstance()
                supportFragmentManager.beginTransaction().replace(R.id.framelayout, homeFragment).commit()
            }
            R.id.menu_ranking -> {
                Log.d(TAG, "onNavigationItemSelected: ranking2")
                rankingFragment = RankingFragment.newInstance()
                supportFragmentManager.beginTransaction().replace(R.id.framelayout, rankingFragment).commit()
            }
            R.id.menu_profile -> {
                Log.d(TAG, "onNavigationItemSelected: profile2")
                profileFragment = ProfileFragment.newInstance()
                supportFragmentManager.beginTransaction().replace(R.id.framelayout, profileFragment).commit()
            }
        }
        true
    }

}