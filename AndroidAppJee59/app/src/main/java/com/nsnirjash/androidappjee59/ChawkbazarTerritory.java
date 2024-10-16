package com.nsnirjash.androidappjee59;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.nsnirjash.androidappjee59.ApiClient.ApiClient;
import com.nsnirjash.androidappjee59.adapter.ChawkbazarTerritoryAdapter;
import com.nsnirjash.androidappjee59.adapter.PurbachalModelAdapter;
import com.nsnirjash.androidappjee59.api.ChawkbazarTerritoryApi;
import com.nsnirjash.androidappjee59.api.PurbachalClubApi;
import com.nsnirjash.androidappjee59.model.ChawkbazarTerritoryModel;
import com.nsnirjash.androidappjee59.model.PurbachalModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChawkbazarTerritory extends AppCompatActivity {

    private RecyclerView chawkbazarTerritoryRecyclerView;

    private ChawkbazarTerritoryAdapter chawkbazarTerritoryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_chawkbazar_territory);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        chawkbazarTerritoryRecyclerView=findViewById(R.id.chawkbazarTerritoryRecyclerView);

        chawkbazarTerritoryRecyclerView.setLayoutManager(new LinearLayoutManager(this));


        ChawkbazarTerritoryApi clubApi = ApiClient.getRetrofit().create(ChawkbazarTerritoryApi.class);

        Call<List<ChawkbazarTerritoryModel>> call = clubApi.getChawkbazarTerritoryClub();

        call.enqueue(new Callback<List<ChawkbazarTerritoryModel>>() {
            @Override
            public void onResponse(Call<List<ChawkbazarTerritoryModel>> call, Response<List<ChawkbazarTerritoryModel>> response) {
                if (response.isSuccessful()) {
                    List<ChawkbazarTerritoryModel> chawkbazarTerritoryModelList = response.body();

                    // Set up RecyclerView with the adapter
                    chawkbazarTerritoryAdapter = new ChawkbazarTerritoryAdapter(chawkbazarTerritoryModelList, getApplicationContext() );
                    chawkbazarTerritoryRecyclerView.setAdapter(chawkbazarTerritoryAdapter);
                }
            }

            @Override
            public void onFailure(Call<List<ChawkbazarTerritoryModel>> call, Throwable t) {

            }
        });
    }
}