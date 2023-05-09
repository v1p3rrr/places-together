package com.vpr.places_together.data.remote.service

import com.vpr.places_together.data.remote.dto.FriendshipDto
import com.vpr.places_together.data.remote.dto.ProfileDto
import com.vpr.places_together.utils.enums.FriendshipStatus
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface FriendshipApiService {
    @POST("/api/v1/friendship/{profileRequestId}/{profileAcceptId}/request-friendship")
    suspend fun requestFriendship(@Path("profileRequestId") profileRequestId: Long, @Path("profileAcceptId") profileAcceptId: Long): FriendshipDto

    @POST("/api/v1/friendship/{profileRequestId}/{profileAcceptId}/accept-friendship")
    suspend fun acceptFriendship(@Path("profileRequestId") profileRequestId: Long, @Path("profileAcceptId") profileAcceptId: Long): FriendshipDto

    @DELETE("/api/v1/friendship/{profileRequestId}/{profileAcceptId}/remove-friendship")
    suspend fun removeFriendship(@Path("profileRequestId") profileRequestId: Long, @Path("profileAcceptId") profileAcceptId: Long)

    @GET("/api/v1/friendship/{profileRequestId}/friendship/{profileAcceptId}")
    suspend fun getFriendshipByProfileRequestIdOrProfileAcceptId(@Path("profileRequestId") profileRequestId: Long, @Path("profileAcceptId") profileAcceptId: Long): FriendshipDto

    @GET("/api/v1/friendship/{profileId1}/friendship-status/{profileId2}")
    suspend fun getFriendshipStatusByTwoProfilesId(@Path("profileId1") profileId1: Long, @Path("profileId2") profileId2: Long): FriendshipStatus

    @GET("/api/v1/friendship/{profileRequestId}/sent-requests")
    suspend fun getAllSentFriendshipRequestsProfiles(@Path("profileRequestId") profileRequestId: Long): List<ProfileDto>

    @GET("/api/v1/friendship/{profileAcceptId}/incoming-requests")
    suspend fun getAllIncomingFriendshipRequestsProfiles(@Path("profileAcceptId") profileAcceptId: Long): List<ProfileDto>

    @GET("/api/v1/friendship/{profileId}/confirmed-friends")
    suspend fun getAllConfirmedFriendsProfiles(@Path("profileId") profileId: Long): List<ProfileDto>

    @GET("/api/v1/friendship/{profile1Id}/are-friends/{profile2Id}")
    suspend fun areFriends(@Path("profile1Id") profile1Id: Long, @Path("profile2Id") profile2Id: Long): Boolean

    @GET("/api/v1/friendship/{profileId}/has-incoming-request/{requestingSideProfileId}")
    suspend fun hasIncomingRequest(@Path("profileId") profileId: Long, @Path("requestingSideProfileId") requestingSideProfileId: Long): Boolean

    @GET("/api/v1/friendship/{profileId}/has-outcoming-request/{acceptingSideProfileId}")
    suspend fun hasOutcomingRequest(@Path("profileId") profileId: Long, @Path("acceptingSideProfileId") acceptingSideProfileId: Long): Boolean
}
