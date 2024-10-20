package com.nsnirjash.androidproject.api;

import com.nsnirjash.androidproject.model.PurbachalModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PurbachalClubApi {

    @GET("purbachal.php?action=read")
    Call<List<PurbachalModel>> getPurbachalModels();
}
