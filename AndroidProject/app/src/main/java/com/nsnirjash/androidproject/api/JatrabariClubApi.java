package com.nsnirjash.androidproject.api;

import com.nsnirjash.androidproject.model.JatrabariClubModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JatrabariClubApi {

    @GET("jatrabari.php?action=read")
    Call<List<JatrabariClubModel>> getJatrabariClub();
}
