package com.vpr.places_together.domain.repository

import com.vpr.places_together.data.remote.dto.AuthToken
import com.vpr.places_together.domain.model.Account
import com.vpr.places_together.utils.Resource
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    suspend fun authenticate(idToken: AuthToken): Account
}