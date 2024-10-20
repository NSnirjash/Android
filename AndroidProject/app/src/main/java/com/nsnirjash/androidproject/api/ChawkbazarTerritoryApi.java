package com.nsnirjash.androidproject.api;

import com.nsnirjash.androidproject.model.ChawkbazarTerritoryModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ChawkbazarTerritoryApi {

    @GET("chawkbazar_territory.php?action=read")
    Call<List<ChawkbazarTerritoryModel>> getChawkbazarTerritoryClub();
}
