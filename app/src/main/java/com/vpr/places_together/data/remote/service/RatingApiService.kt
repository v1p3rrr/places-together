package com.vpr.places_together.data.remote.service

import com.vpr.places_together.data.remote.dto.RatingPlaceDto
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface RatingApiService {

    @POST("/api/v1/ratings/{groupId}/add/{profileId}/{placeDgisId}/{stars}")
    suspend fun addRating(
        @Path("groupId") groupId: Long,
        @Path("profileId") profileId: Long,
        @Path("placeDgisId") placeDgisId: Long,
        @Path("stars") stars: Int
    ): RatingPlaceDto

    @PUT("/api/v1/ratings/{groupId}/update/{editorProfileId}/{placeDgisId}/{ratingId}/{newStars}")
    suspend fun updateRating(
        @Path("groupId") groupId: Long,
        @Path("editorProfileId") editorProfileId: Long,
        @Path("placeDgisId") placeDgisId: Long,
        @Path("ratingId") ratingId: Long,
        @Path("newStars") newStars: Int
    ): RatingPlaceDto

    @DELETE("/api/v1/ratings/{groupId}/delete/{editorProfileId}/{placeDgisId}/{ratingId}")
    suspend fun deleteRating(
        @Path("groupId") groupId: Long,
        @Path("editorProfileId") editorProfileId: Long,
        @Path("placeDgisId") placeDgisId: Long,
        @Path("ratingId") ratingId: Long
    )

    @GET("/api/v1/ratings/{groupId}/by-profile/{profileId}")
    suspend fun getRatingsByGroupIdAndProfileId(
        @Path("groupId") groupId: Long,
        @Path("profileId") profileId: Long
    ): List<RatingPlaceDto>

    @GET("/api/v1/ratings/{groupId}/by-dgis/{dgisId}")
    suspend fun getRatingsByGroupIdAndDgisId(
        @Path("groupId") groupId: Long,
        @Path("dgisId") dgisId: Long
    ): List<RatingPlaceDto>

    @GET("/api/v1/ratings/{groupId}/by-name/{placeName}")
    suspend fun getRatingsByGroupIdAndPlaceName(
        @Path("groupId") groupId: Long,
        @Path("placeName") placeName: String
    ): List<RatingPlaceDto>

    @GET("/api/v1/ratings/{groupId}/by-profile/{profileId}/by-dgis/{dgisId}")
    suspend fun getRatingByGroupIdAndProfileIdAndDgisId(
        @Path("groupId") groupId: Long,
        @Path("profileId") profileId: Long,
        @Path("dgisId") dgisId: Long
    ): RatingPlaceDto

    @GET("/api/v1/ratings/{groupId}/by-profile/{profileId}/by-name/{placeName}")
    suspend fun getRatingByGroupIdAndProfileIdAndPlaceName(
        @Path("groupId") groupId: Long,
        @Path("profileId") profileId: Long,
        @Path("placeName") placeName: String
    ): RatingPlaceDto
}
