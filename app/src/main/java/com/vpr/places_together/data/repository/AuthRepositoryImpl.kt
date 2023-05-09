package com.vpr.places_together.data.repository

import android.util.Log
import com.vpr.places_together.data.local.entity.AccountEntity
import com.vpr.places_together.data.remote.dto.AuthToken
import com.vpr.places_together.data.remote.service.AccountProfileApiService
import com.vpr.places_together.data.remote.service.AuthService
import com.vpr.places_together.domain.model.Account
import com.vpr.places_together.domain.repository.AuthRepository
import com.vpr.places_together.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val apiService: AuthService
)  : AuthRepository {
    override suspend fun authenticate(idToken: AuthToken): Account {
        Log.d("AuthRepository", "Sending authentication request")
        val account = apiService.authenticate(idToken).mapToAccount()
        Log.d("AuthRepository", "Authentication request successful, account: $account")
        return account
    }
}