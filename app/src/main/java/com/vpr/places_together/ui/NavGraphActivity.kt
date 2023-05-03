package com.vpr.places_together.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import com.vpr.places_together.R
import com.vpr.places_together.databinding.ActivityNavGraphBinding
import dagger.hilt.android.AndroidEntryPoint
import ru.dgis.sdk.DGis
import ru.dgis.sdk.map.MapView

@AndroidEntryPoint
class NavGraphActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNavGraphBinding

    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNavGraphBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        //todo split repositories for map/users/groups(?)/map objects
//        val sdkContext = DGis.initialize(applicationContext)
//        setContentView(R.layout.fragment_map)
//
//        val mapView = findViewById<MapView>(R.id.mapView)
//        lifecycle.addObserver(mapView)
//
//        mapView.getMapAsync { map ->
//            // Действия с картой
//            val camera = map.camera
//        }
    }


}