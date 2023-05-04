package com.vpr.places_together.ui.registration_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.google.android.material.appbar.MaterialToolbar
import com.vpr.places_together.R
import com.vpr.places_together.databinding.FragmentRegistrationBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegistrationFragment: Fragment() {
    private val viewModel: RegistrationViewModel by viewModels()
    private lateinit var binding: FragmentRegistrationBinding
    private lateinit var navController: NavController
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegistrationBinding.inflate(inflater, container, false)
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
        toolbar.navigationIcon = null
        toolbar.title = getString(R.string.sign_up_screen_title)
        toolbar.setNavigationOnClickListener {
            println("back btn pressed")
            //todo pass username password when navigation to login screen
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

        binding.registerButton.setOnClickListener {
            println("register! " + binding.usernameEdittext.text + ", " + binding.passwordEdittext.text + ", " + binding.passwordRepeatEdittext.text)
        }

        binding.accountExists.setOnClickListener{
            //todo pass username password when navigation to login screen
            navController.navigate(R.id.action_registration_fragment_to_login_fragment)
        }

        val googleButtonText = binding.googleRegisterButton.getChildAt(0) as? TextView
        googleButtonText?.text = getString(R.string.sign_up_google)

        binding.googleRegisterButton.setOnClickListener {
            println("register via google")
        }

    }
}