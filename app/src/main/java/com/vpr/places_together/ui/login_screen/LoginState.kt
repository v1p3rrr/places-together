package com.vpr.places_together.ui.login_screen

import com.vpr.places_together.domain.model.Account

sealed class LoginState {
    object Empty : LoginState()
    object Loading : LoginState()
    data class Success(val account: Account) : LoginState()
    data class Error(val exception: Throwable) : LoginState()
}