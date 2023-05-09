package com.vpr.places_together.ui.map_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.vpr.places_together.databinding.FragmentMapBinding
import dagger.hilt.android.AndroidEntryPoint
import ru.dgis.sdk.Context
import ru.dgis.sdk.DGis
import ru.dgis.sdk.map.MapView

@AndroidEntryPoint
class MapFragment: Fragment() {
    private val viewModel: MapViewModel by viewModels()
    private lateinit var sdkContext: Context
    private lateinit var binding: FragmentMapBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        sdkContext = DGis.initialize(requireContext())
        binding = FragmentMapBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapView = binding.mapView
        lifecycle.addObserver(mapView)

        mapView.getMapAsync { map ->
            // Действия с картой
            val camera = map.camera
        }
        viewModel.test()
    }
}