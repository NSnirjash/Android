package com.nsnirjash.androidappjee59.api;

import com.nsnirjash.androidappjee59.model.FriendAllienceModel;
import com.nsnirjash.androidappjee59.model.NotificationModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface FriendAllienceApi {

    @GET("friends_alliance.php?action=read")
    Call<List<FriendAllienceModel>> getFriendAllienceModel();

}
