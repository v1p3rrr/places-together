package com.vpr.places_together.data.remote.service

import com.vpr.places_together.data.remote.dto.GroupDto
import com.vpr.places_together.data.remote.dto.GroupMembershipDto
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface GroupApiService {

    @GET("/api/v1/group/{groupId}")
    suspend fun getGroup(@Path("groupId") groupId: Long): GroupDto

    @GET("/api/v1/group/{groupId}/memberships")
    suspend fun getGroupMemberships(@Path("groupId") groupId: Long): List<GroupMembershipDto>

    @POST("/api/v1/group/create/{adminProfileId}")
    suspend fun createGroup(
        @Body groupName: String,
        @Path("adminProfileId") adminProfileId: Long
    ): GroupDto

    @PATCH("/api/v1/group/{groupId}/change-name")
    suspend fun changeGroupName(
        @Body newName: String,
        @Path("adminProfileId") adminProfileId: Long
    ): GroupDto

    @POST("/api/v1/group/{groupId}/invite/{invitedProfileId}")
    suspend fun inviteProfileToGroup(
        @Path("groupId") groupId: Long,
        @Path("invitedProfileId") invitedProfileId: Long
    ): GroupMembershipDto

    @PUT("/api/v1/group/{groupId}/promote-moderator/{adminProfileId}/{promotedProfileId}")
    suspend fun promoteMemberToModerator(
        @Path("groupId") groupId: Long,
        @Path("adminProfileId") adminProfileId: Long,
        @Path("promotedProfileId") promotedProfileId: Long
    ): GroupMembershipDto

    @PUT("/api/v1/group/{groupId}/promote-admin/{adminProfileId}/{promotedProfileId}")
    suspend fun promoteToAdmin(
        @Path("groupId") groupId: Long,
        @Path("adminProfileId") adminProfileId: Long,
        @Path("promotedProfileId") promotedProfileId: Long
    ): GroupMembershipDto

    @PUT("/api/v1/group/{groupId}/demote-moderator/{adminProfileId}/{demotedProfileId}")
    suspend fun demoteModeratorToMember(
        @Path("groupId") groupId: Long,
        @Path("adminProfileId") adminProfileId: Long,
        @Path("demotedProfileId") demotedProfileId: Long
    ): GroupMembershipDto

    @DELETE("/api/v1/group/{groupId}/leave/{leavingProfileId}")
    suspend fun leaveGroup(
        @Path("groupId") groupId: Long,
        @Path("leavingProfileId") leavingProfileId: Long
    )

    @DELETE("/api/v1/group/{groupId}/remove-member/{moderatorProfileId}/{removedProfileId}")
    suspend fun removeMemberByModerator(
        @Path("groupId") groupId: Long,
        @Path("moderatorProfileId") moderatorProfileId: Long,
        @Path("removedProfileId") removedProfileId: Long
    )

    @DELETE("/api/v1/group/{groupId}/remove-member-admin/{adminProfileId}/{removedProfileId}")
    suspend fun removeMemberByAdmin(
        @Path("groupId") groupId: Long,
        @Path("adminProfileId") adminProfileId: Long,
        @Path("removedProfileId") removedProfileId: Long
    )

    @DELETE("/api/v1/group/{groupId}/delete/{adminProfileId}")
    suspend fun deleteGroup(
        @Path("groupId") groupId: Long,
        @Path("adminProfileId") adminProfileId: Long
    )

    @GET("/api/v1/group/by-name/{groupName}")
    suspend fun getGroupByName(@Path("groupName") groupName: String): GroupDto

    @GET("/api/v1/group/{profileId}/groups")
    suspend fun getGroupsByProfileId(@Path("profileId") profileId: Long): List<GroupDto>

    @GET("/api/v1/group/memberships/{profileId}")
    suspend fun getGroupMembershipsByProfileId(@Path("profileId") profileId: Long): List<GroupMembershipDto>

    @GET("/api/v1/group/{groupId}/{profileId}/membership")
    suspend fun getGroupMembershipByGroupIdAndProfileId(
        @Path("groupId") groupId: Long,
        @Path("profileId") profileId: Long
    ): GroupMembershipDto

    @GET("/api/v1/group/search/{partOfName}")
    suspend fun getGroupsByPartOfName(@Path("partOfName") partOfName: String): List<GroupDto>

}
