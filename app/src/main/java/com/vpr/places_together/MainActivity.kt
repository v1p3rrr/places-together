package com.vpr.places_together

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.dgis.sdk.DGis
import ru.dgis.sdk.map.MapView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val sdkContext = DGis.initialize(applicationContext)
        setContentView(R.layout.map_layout)

        val mapView = findViewById<MapView>(R.id.mapView)
        lifecycle.addObserver(mapView)

        mapView.getMapAsync { map ->
            // Действия с картой
            val camera = map.camera
        }
    }
}