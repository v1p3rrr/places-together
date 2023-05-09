package com.vpr.places_together.ui.login_screen

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.google.android.material.appbar.MaterialToolbar
import com.vpr.places_together.R
import com.vpr.places_together.data.remote.dto.AuthToken
import com.vpr.places_together.databinding.FragmentLoginBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class LoginFragment : Fragment() {
    private val viewModel: LoginViewModel by viewModels()
    @Inject lateinit var googleSignInClient: GoogleSignInClient
    private lateinit var binding: FragmentLoginBinding
    private lateinit var navController: NavController
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = findNavController()
        setupMenu()
        setListeners()
        collectFlows()
    }

    private fun setupMenu() {
        val toolbar = requireActivity().findViewById<MaterialToolbar>(R.id.top_app_bar)
        toolbar.navigationIcon = null
        toolbar.title = getString(R.string.sign_in_screen_title)
        toolbar.setNavigationOnClickListener {
            println("back btn pressed")
            //todo pass username password when navigation to reg screen
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

        binding.forgotPassword.setOnClickListener {
            println("password forgotten")
        }

        binding.loginButton.setOnClickListener {
            println("login! " + binding.usernameEdittext.text + ", " + binding.passwordEdittext.text)
        }

        binding.createAccount.setOnClickListener{
            //todo pass username password when navigation to reg screen
            navController.navigate(R.id.action_login_fragment_to_registration_fragment)
        }

        val googleButtonText = binding.googleLoginButton.getChildAt(0) as? TextView
        googleButtonText?.text = getString(R.string.sign_in_google)

        binding.googleLoginButton.setOnClickListener {
            println("login via google")
            signIn()
        }

    }

    private fun collectFlows() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.loginState.collect { state ->
                when (state) {
                    is LoginState.Loading -> {
                        binding.progressBar.visibility = View.VISIBLE
                    }

                    is LoginState.Success -> {
                        // Navigate to the next screen
                        binding.progressBar.visibility = View.GONE
                        findNavController().navigate(R.id.action_login_fragment_to_map_fragment)
                    }

                    is LoginState.Error -> {
                        // Show error message
                        binding.progressBar.visibility = View.GONE

                        Toast.makeText(
                            requireContext(),
                            "Error: ${state.exception.message}",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    else -> {
                        // Do nothing
                        binding.progressBar.visibility = View.GONE
                    }
                }
            }
        }
    }

    private fun signIn() {
        println("val signInIntent = googleSignInClient.signInIntent")
        val signInIntent = googleSignInClient.signInIntent
        println("signInLauncher.launch(signInIntent) start")
        signInLauncher.launch(signInIntent)
        println("signInLauncher.launch(signInIntent) END")
    }

    private val signInLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        println("registerForActivityResult START")
        if (result.resultCode == Activity.RESULT_OK) {
            println("result.resultCode == Activity.RESULT_OK")
            val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
            println("GoogleSignIn.getSignedInAccountFromIntent(result.data)")
            handleSignInResult(task)
            println("handleSignInResult(task)")
        } else println("result.resultCode != Activity.RESULT_OK, code: " + result.resultCode + ", data: " + result.data)
    }

    private fun handleSignInResult(completedTask: Task<GoogleSignInAccount>) {
        try {
            val account = completedTask.getResult(ApiException::class.java)
            Log.d("LoginFragment", "Google sign in successful, account: $account")
            println("Google sign in successful, account: $account")
            viewModel.authenticate(AuthToken(account.idToken!!))
        } catch (e: ApiException) {
            Log.e("LoginFragment", "Google sign in failed, status code: ${e.statusCode}", e)
            Toast.makeText(requireContext(), "Error: ${e.statusCode}", Toast.LENGTH_SHORT).show()
        }
    }

}