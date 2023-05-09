package com.vpr.places_together.data.remote.service

import com.vpr.places_together.data.remote.dto.AccountDto
import com.vpr.places_together.data.remote.dto.ProfileDto
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface AccountProfileApiService {
    @GET("/api/v1/account/{accountId}")
    suspend fun getAccountById(@Path("accountId") accountId: Long): AccountDto

    @GET("/api/v1/account/profile/{profileId}")
    suspend fun getProfileById(@Path("profileId") profileId: Long): ProfileDto

    @GET("/api/v1/account/username/{profileUsername}")
    suspend fun getAccountByUsername(@Path("profileUsername") profileUsername: String): AccountDto

    @GET("/api/v1/account/profile/username/{profileUsername}")
    suspend fun getProfileByUsername(@Path("profileUsername") profileUsername: String): ProfileDto

    @GET("/api/v1/account/profile/username-search/{partOfUsername}")
    suspend fun getProfilesByPartOfUsername(@Path("partOfUsername") partOfUsername: String): List<ProfileDto>

    @GET("/api/v1/account/email")
    suspend fun getAccountByEmail(@Body email: String): AccountDto

    @GET("/api/v1/account/profile/email")
    suspend fun getProfileByAccountEmail(@Body email: String): ProfileDto

    @POST("/api/v1/account/create-with-generated-profile")
    suspend fun createAccountWithGeneratedProfile(@Body account: AccountDto): AccountDto

    @POST("/api/v1/account/create")
    suspend fun createAccountWithoutProfile(@Body account: AccountDto): AccountDto

    @POST("/api/v1/account/profile/create-with-account/{accountId}")
    suspend fun createProfileAndLinkToAccount(@Body profile: ProfileDto, @Path("accountId") accountId: Long): ProfileDto

    @PATCH("/api/v1/account/change-email/{accountId}")
    suspend fun changeEmail(@Path("accountId") accountId: Long, @Body newEmail: String): AccountDto

    @PATCH("/api/v1/account/change-password/{accountId}")
    suspend fun changePassword(@Path("accountId") accountId: Long, @Body newPassword: String): AccountDto

    @DELETE("/api/v1/account/account/delete/{accountId}")
    suspend fun deleteAccount(@Path("accountId") accountId: Long)

    @PATCH("/api/v1/account/profile/{profileId}/change-username")
    suspend fun changeUsername(@Path("profileId") profileId: Long, @Body newUsername: String): ProfileDto

    @PATCH("/api/v1/account/profile/{profileId}/change-status")
    suspend fun changeStatus(@Path("profileId") profileId: Long, @Body newStatus: String): ProfileDto

    @PATCH("/api/v1/account/profile/{profileId}/change-profile-picture")
    suspend fun changeProfilePicture(@Path("profileId") profileId: Long, @Body newProfilePictureLink: String): ProfileDto

    @PUT("/api/v1/account/profile/{profileId}/update-profile")
    suspend fun updateProfile(@Path("profileId") profileId: Long, @Body profile: ProfileDto): ProfileDto
}