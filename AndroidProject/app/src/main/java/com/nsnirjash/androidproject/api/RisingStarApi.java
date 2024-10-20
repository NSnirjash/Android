package com.nsnirjash.androidproject.api;

import com.nsnirjash.androidproject.model.RisingStarModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RisingStarApi {

    @GET("purbachal_rising_star.php?action=read")
    Call<List<RisingStarModel>> getRisingStarModelClub();
}
