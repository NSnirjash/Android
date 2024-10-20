package com.nsnirjash.androidproject;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.nsnirjash.androidproject.ApiClient.ApiClient;
import com.nsnirjash.androidproject.adapter.RisingStarAdapter;
import com.nsnirjash.androidproject.api.RisingStarApi;
import com.nsnirjash.androidproject.model.RisingStarModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RisingStarClub extends AppCompatActivity {

    private RecyclerView risingStarRecyclerView;

    private RisingStarAdapter risingStarAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_rising_star_club);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        risingStarRecyclerView=findViewById(R.id.risingStarRecyclerView);

        risingStarRecyclerView.setLayoutManager(new LinearLayoutManager(this));


        RisingStarApi clubApi = ApiClient.getRetrofit().create(RisingStarApi.class);

        Call<List<RisingStarModel>> call = clubApi.getRisingStarModelClub();

        call.enqueue(new Callback<List<RisingStarModel>>() {
            @Override
            public void onResponse(Call<List<RisingStarModel>> call, Response<List<RisingStarModel>> response) {
                if (response.isSuccessful()) {
                    List<RisingStarModel> risingStarModelList = response.body();

                    // Set up RecyclerView with the adapter
                    risingStarAdapter = new RisingStarAdapter(risingStarModelList, getApplicationContext() );
                    risingStarRecyclerView.setAdapter(risingStarAdapter);
                }
            }

            @Override
            public void onFailure(Call<List<RisingStarModel>> call, Throwable t) {

            }
        });
    }
}