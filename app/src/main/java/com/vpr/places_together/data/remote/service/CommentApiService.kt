package com.vpr.places_together.data.remote.service

import com.vpr.places_together.data.remote.dto.CommentPlaceDto
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface CommentApiService {
    @POST("/api/v1/comments/{groupId}/add/dgisid/{placeDgisId}/profile/{profileId}")
    suspend fun addComment(
        @Path("groupId") groupId: Long,
        @Path("placeDgisId") placeDgisId: Long,
        @Path("profileId") profileId: Long,
        @Body commentText: String
    ): CommentPlaceDto

    @PUT("/api/v1/comments/{groupId}/update/dgisid/{placeDgisId}/profile/{profileId}/comment/{commentId}")
    suspend fun updateComment(
        @Path("groupId") groupId: Long,
        @Path("placeDgisId") placeDgisId: Long,
        @Path("profileId") profileId: Long,
        @Path("commentId") commentId: Long,
        @Body newCommentText: String
    ): CommentPlaceDto

    @DELETE("/api/v1/comments/{groupId}/delete/dgisid/{placeDgisId}/profile/{editorProfileId}/comment/{commentId}")
    suspend fun deleteComment(
        @Path("groupId") groupId: Long,
        @Path("placeDgisId") placeDgisId: Long,
        @Path("editorProfileId") editorProfileId: Long,
        @Path("commentId") commentId: Long
    )

    @GET("/api/v1/comments/{groupId}/comments-by-profile/{profileId}")
    suspend fun getCommentsByGroupIdAndProfileId(
        @Path("groupId") groupId: Long,
        @Path("profileId") profileId: Long
    ): List<CommentPlaceDto>

    @GET("/api/v1/comments/{groupId}/comments-by-dgisid/{dgisId}")
    suspend fun getCommentsByGroupIdAndDgisId(
        @Path("groupId") groupId: Long,
        @Path("dgisId") dgisId: Long
    ): List<CommentPlaceDto>

    @GET("/api/v1/comments/{groupId}/comments-by-placename/{placeName}")
    suspend fun getCommentsByGroupIdAndPlaceName(
        @Path("groupId") groupId: Long,
        @Path("placeName") placeName: String
    ): List<CommentPlaceDto>

    @GET("/api/v1/comments/{groupId}/comments-by-profile/{profileId}/by-dgisid/{dgisId}")
    suspend fun getCommentsByGroupIdAndProfileIdAndDgisId(
        @Path("groupId") groupId: Long,
        @Path("profileId") profileId: Long,
        @Path("dgisId") dgisId: Long
    ): List<CommentPlaceDto>

    @GET("/api/v1/comments/{groupId}/comments-by-profile/{profileId}/by-placename/{placeName}")
    suspend fun getCommentsByGroupIdAndProfileIdAndPlaceName(
        @Path("groupId") groupId: Long,
        @Path("profileId") profileId: Long,
        @Path("placeName") placeName: String
    ): List<CommentPlaceDto>
}
