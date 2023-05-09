package com.vpr.places_together.data.remote.service

import com.vpr.places_together.data.remote.dto.MarkPlaceDto
import com.vpr.places_together.data.remote.dto.PlaceDto
import com.vpr.places_together.utils.enums.MarkPlaceStatus
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface MarkGroupPlaceApiService {
    @GET("/api/v1/marks/group/{groupId}/profile/{profileId}")
    suspend fun getMarksByProfileIdAndGroupId(@Path("profileId") profileId: Long, @Path("groupId") groupId: Long): List<MarkPlaceDto>

    @GET("/api/v1/marks/group/{groupId}/dgisid/{dgisId}")
    suspend fun getMarksByGroupIdAndDgisId(@Path("groupId") groupId: Long, @Path("dgisId") dgisId: Long): List<MarkPlaceDto>

    @GET("/api/v1/marks/group/{groupId}/placename/{placeName}")
    suspend fun getMarksByGroupIdAndPlaceName(@Path("groupId") groupId: Long, @Path("placeName") placeName: String): List<MarkPlaceDto>

    @GET("/api/v1/marks/group/{groupId}/profile/{profileId}/placename/{placeName}")
    suspend fun getMarksByGroupIdAndProfileIdAndPlaceName(@Path("groupId") groupId: Long, @Path("profileId") profileId: Long, @Path("placeName") placeName: String): MarkPlaceDto

    @GET("/api/v1/marks/group/{groupId}/profile/{profileId}/dgisid/{dgisId}")
    suspend fun getMarksByGroupIdAndProfileIdAndDgisId(@Path("groupId") groupId: Long, @Path("profileId") profileId: Long, @Path("dgisId") dgisId: Long): MarkPlaceDto

    @GET("/api/v1/marks/group/{groupId}")
    suspend fun getMarksByGroupId(@Path("groupId") groupId: Long): List<MarkPlaceDto>

    @GET("/api/v1/marks/by-id/{id}")
    suspend fun getMarkById(@Path("id") id: Long): MarkPlaceDto

    @POST("/api/v1/marks/mark/{profileId}/{groupId}/{markStatus}")
    suspend fun markPlace(@Path("profileId") profileId: Long, @Path("groupId") groupId: Long, @Body place: PlaceDto, @Path("markStatus") markStatus: String): MarkPlaceDto

    @PUT("/api/v1/marks/update/{placeDgisId}/{groupId}/{editorProfileId}/{targetProfileId}/{newStatus}")
    suspend fun updateMark(@Path("placeDgisId") placeDgisId: Long, @Path("groupId") groupId: Long, @Path("editorProfileId") editorProfileId: Long, @Path("targetProfileId") targetProfileId: Long, @Path("newStatus") newStatus: MarkPlaceStatus): MarkPlaceDto

    @DELETE("/api/v1/marks/delete/{placeDgisId}/{groupId}/{editorProfileId}/{targetProfileId}")
    suspend fun deleteMark(@Path("placeDgisId") placeDgisId: Long, @Path("groupId") groupId: Long, @Path("editorProfileId") editorProfileId: Long, @Path("targetProfileId") targetProfileId: Long)
}
