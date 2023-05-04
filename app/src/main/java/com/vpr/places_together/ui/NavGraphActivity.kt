package com.vpr.places_together.ui

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.vpr.places_together.R
import com.vpr.places_together.databinding.ActivityNavGraphBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class NavGraphActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNavGraphBinding

    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNavGraphBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.topAppBar)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        //todo split repositories for map/users/groups(?)/map objects

    }


}