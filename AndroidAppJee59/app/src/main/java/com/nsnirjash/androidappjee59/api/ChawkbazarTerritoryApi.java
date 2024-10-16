package com.nsnirjash.androidappjee59.api;

import com.nsnirjash.androidappjee59.model.ChawkbazarTerritoryModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ChawkbazarTerritoryApi {

    @GET("chawkbazar_territory.php?action=read")
    Call<List<ChawkbazarTerritoryModel>> getChawkbazarTerritoryClub();
}
