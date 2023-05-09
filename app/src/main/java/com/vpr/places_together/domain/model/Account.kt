package com.vpr.places_together.domain.model

data class Account(
val id: Long,
val email: String,
val password: String,
val profile: Profile
)