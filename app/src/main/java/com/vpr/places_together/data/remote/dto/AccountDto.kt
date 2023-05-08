package com.vpr.places_together.data.remote.dto

data class AccountDto(
    val id: Long,
    val email: String,
    val password: String,
    val profile: ProfileDto
)