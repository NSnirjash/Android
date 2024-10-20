package com.nsnirjash.androidproject.api;

import com.nsnirjash.androidproject.model.FriendAllienceModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface FriendAllienceApi {

    @GET("friends_alliance.php?action=read")
    Call<List<FriendAllienceModel>> getFriendAllienceModel();
}
