package com.nsnirjash.androidappjee59.api;

import com.nsnirjash.androidappjee59.model.Notification;
import com.nsnirjash.androidappjee59.model.Slide;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NotificationApi {

    @GET("get_notices.php")
    Call<List<Notification>> getNotifications();
}
