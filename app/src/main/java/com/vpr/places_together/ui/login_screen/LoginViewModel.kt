package com.vpr.places_together.ui.login_screen

import android.content.Intent
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.common.api.ApiException
import com.google.android.play.core.tasks.Task
import com.vpr.places_together.data.remote.dto.AuthToken
import com.vpr.places_together.data.remote.service.AccountProfileApiService
import com.vpr.places_together.data.remote.service.CommentApiService
import com.vpr.places_together.data.remote.service.FriendshipApiService
import com.vpr.places_together.data.remote.service.GoogleSignInService
import com.vpr.places_together.data.remote.service.GroupApiService
import com.vpr.places_together.data.remote.service.MarkGroupPlaceApiService
import com.vpr.places_together.data.remote.service.PlaceApiService
import com.vpr.places_together.data.remote.service.RatingApiService
import com.vpr.places_together.data.repository.SessionManager
import com.vpr.places_together.domain.repository.AuthRepository
import com.vpr.places_together.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(

    private val authRepository: AuthRepository,
    private val sessionManager: SessionManager
) : ViewModel() {

    private val _loginState = MutableStateFlow<LoginState>(LoginState.Empty)
    val loginState: StateFlow<LoginState> = _loginState

    fun authenticate(idToken: AuthToken) {
        Log.d("LoginViewModel", "Authenticating with idToken: $idToken")
        viewModelScope.launch {
            _loginState.value = LoginState.Loading
            try {
                val account = authRepository.authenticate(idToken)
                sessionManager.activeAccount = account
                _loginState.value = LoginState.Success(account)
                Log.d("LoginViewModel", "Authentication successful, account: $account")
            } catch (e: Exception) {
                Log.e("LoginViewModel", "Authentication failed", e)
                _loginState.value = LoginState.Error(e)
            }
        }
    }
//
//    fun handleSignInResult(completedTask: Task<GoogleSignInAccount>) {
//        try {
//            val account = completedTask.getResult(ApiException::class.java)
//            val accessToken = account.idToken
//            authenticateWithBackend(accessToken)
//        } catch (e: ApiException) {
//            _signInResult.value = Resource.Error("Sign-in failed", null)
//        }
//    }
//
//    private fun authenticateWithBackend(accessToken: String) {
//        viewModelScope.launch {
//            _signInResult.value = authRepository.authenticate(accessToken)
//        }
//    }



}