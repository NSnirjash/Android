package com.nsnirjash.androidproject.api;

import com.nsnirjash.androidproject.model.RangdhanuModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RangdhanuApi {

    @GET("purbachal_rangdhanu.php?action=read")
    Call<List<RangdhanuModel>> getRangdhanuClub();
}
