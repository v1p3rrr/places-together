package com.vpr.places_together.data.remote.service

import com.vpr.places_together.data.remote.dto.GroupPlaceDto
import com.vpr.places_together.data.remote.dto.PlaceDto
import retrofit2.http.GET
import retrofit2.http.Path

interface PlaceApiService {
    @GET("/api/v1/place/group/{groupId}/by-dgis-id/{dgisId}")
    suspend fun getGroupPlaceByGroupIdAndDgisId(@Path("groupId") groupId: Long, @Path("dgisId") dgisId: Long): GroupPlaceDto

    @GET("/api/v1/place/group/{groupId}/by-name/{name}")
    suspend fun getGroupPlaceByNameAndGroupId(@Path("name") name: String, @Path("groupId") groupId: Long): GroupPlaceDto

    @GET("/api/v1/place/group/{groupId}/search-name/{partOfName}")
    suspend fun getGroupPlacesByPartOfNameAndGroupId(@Path("partOfName") partOfName: String, @Path("groupId") groupId: Long): List<GroupPlaceDto>

    @GET("/api/v1/place/group/{groupId}/by-address/{address}")
    suspend fun getGroupPlacesByAddressAndGroupId(@Path("address") address: String, @Path("groupId") groupId: Long): List<GroupPlaceDto>

    @GET("/api/v1/place/group/{groupId}/by-type/{type}")
    suspend fun getGroupPlacesByGroupIdAndType(@Path("groupId") groupId: Long, @Path("type") type: String): List<GroupPlaceDto>

    @GET("/api/v1/place/group/{groupId}/all")
    suspend fun getAllGroupPlacesByGroupId(@Path("groupId") groupId: Long): List<GroupPlaceDto>

    @GET("/api/v1/place/by-place-id/{placeId}/all-group-places")
    suspend fun getAllGroupPlacesByPlaceId(@Path("placeId") placeId: Long): List<GroupPlaceDto>

    @GET("/api/v1/place/by-dgis-id/{dgisId}")
    suspend fun getPlaceByDgisId(@Path("dgisId") dgisId: Long): PlaceDto

    @GET("/api/v1/place/by-name/{name}")
    suspend fun getPlaceByName(@Path("name") name: String): PlaceDto

    @GET("/api/v1/place/search-name/{partOfName}")
    suspend fun getPlacesByPartOfName(@Path("partOfName") partOfName: String): List<PlaceDto>

    @GET("/api/v1/place/by-address/{address}")
    suspend fun getPlacesByAddress(@Path("address") address: String): List<PlaceDto>

    @GET("/api/v1/place/by-type/{type}")
    suspend fun getPlacesByType(@Path("type") type: String): List<PlaceDto>

    @GET("/api/v1/place/all")
    suspend fun getAllPlaces(): List<PlaceDto>
}