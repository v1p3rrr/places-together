package com.vpr.places_together.data.remote.service

import com.vpr.places_together.data.remote.dto.AccountDto
import com.vpr.places_together.data.remote.dto.AuthToken
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {
    @POST("/api/auth/authenticate")
    suspend fun authenticate(@Body idToken: AuthToken): AccountDto
}