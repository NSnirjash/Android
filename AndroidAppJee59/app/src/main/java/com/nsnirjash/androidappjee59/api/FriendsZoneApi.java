package com.nsnirjash.androidappjee59.api;

import com.nsnirjash.androidappjee59.model.FriendsZoneModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface FriendsZoneApi {

    @GET("friends_zone.php?action=read")
    Call<List<FriendsZoneModel>> getFriendsZoneClub();
}
