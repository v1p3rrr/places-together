package com.vpr.places_together.ui.groups_list_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.google.android.material.appbar.MaterialToolbar
import com.vpr.places_together.R
import com.vpr.places_together.databinding.FragmentGroupListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GroupsListFragment: Fragment() {
    private val viewModel: GroupsListViewModel by viewModels()
    private lateinit var binding: FragmentGroupListBinding
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGroupListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = findNavController()
        setupMenu()
        setListeners()
    }

    private fun setupMenu() {
        val toolbar = requireActivity().findViewById<MaterialToolbar>(R.id.top_app_bar)
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back)
        toolbar.title = getString(R.string.groups_screen_title)
        toolbar.setNavigationOnClickListener {
            println("back btn pressed")
            navController.navigateUp()
        }

        (requireActivity() as MenuHost).addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menu.clear()
                menuInflater.inflate(R.menu.menu_done, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return when (menuItem.itemId) {
                    R.id.action_done -> {
                        println("clicked on done btn")
                        true
                    }

                    else -> false
                }
            }

            override fun onMenuClosed(menu: Menu) {
                menu.clear()
                super.onMenuClosed(menu)
            }

        })
    }

    private fun setListeners() {

    }
}