package com.vpr.places_together.data.remote.dto

import com.vpr.places_together.data.local.entity.AccountEntity
import com.vpr.places_together.domain.model.Account

data class AccountDto(
    val id: Long,
    val email: String,
    val password: String,
    val profile: ProfileDto
) {
    fun mapToAccount(): Account {
        return Account(
            id = id,
            email = email,
            password = password,
            profile = profile.mapToProfile()
        )
    }
    fun mapToAccountEntity(): AccountEntity {
        return AccountEntity(
            accountId = this.id,
            email = this.email,
            password = this.password
        )
    }
}