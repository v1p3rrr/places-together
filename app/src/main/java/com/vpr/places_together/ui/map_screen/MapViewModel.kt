package com.vpr.places_together.ui.map_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vpr.places_together.data.remote.service.AccountProfileApiService
import com.vpr.places_together.data.remote.service.CommentApiService
import com.vpr.places_together.data.remote.service.FriendshipApiService
import com.vpr.places_together.data.remote.service.GroupApiService
import com.vpr.places_together.data.remote.service.MarkGroupPlaceApiService
import com.vpr.places_together.data.remote.service.PlaceApiService
import com.vpr.places_together.data.remote.service.RatingApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MapViewModel @Inject constructor(
    private val groupApi: GroupApiService,
    private val accountApi: AccountProfileApiService,
    private val friendshipApi: FriendshipApiService,
    private val markApi: MarkGroupPlaceApiService,
    private val placeApi: PlaceApiService,
    private val commentApi: CommentApiService,
    private val ratingApi: RatingApiService,
) : ViewModel()  {
    fun test(){
        viewModelScope.launch {
            println(groupApi.getGroup(1))
            println(groupApi.getGroupMemberships(1))
            println(accountApi.getAccountById(1))
            println(accountApi.getProfileById(1))
            println(friendshipApi.areFriends(1,2))
            println(markApi.getMarkById(1))
            println(placeApi.getPlaceByDgisId(123))
            println(placeApi.getAllGroupPlacesByGroupId(1))
            println(commentApi.addComment(1,123,1,"my first comment"))
            println(ratingApi.addRating(1,1,123,5))
            println(ratingApi.addRating(1,1,123,3))
            println(ratingApi.getRatingsByGroupIdAndDgisId(1,123))
        }
    }
}