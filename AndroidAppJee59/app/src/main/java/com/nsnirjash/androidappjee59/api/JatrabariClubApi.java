package com.nsnirjash.androidappjee59.api;

import com.nsnirjash.androidappjee59.model.JatrabariClubModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JatrabariClubApi {

    @GET("jatrabari.php?action=read")
    Call<List<JatrabariClubModel>> getJatrabariClub();
}
