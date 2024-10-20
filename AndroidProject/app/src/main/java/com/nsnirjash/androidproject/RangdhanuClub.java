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
import com.nsnirjash.androidproject.adapter.RangdhanuAdapter;
import com.nsnirjash.androidproject.api.RangdhanuApi;
import com.nsnirjash.androidproject.model.RangdhanuModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RangdhanuClub extends AppCompatActivity {

    private RecyclerView rangdhanuRecyclerView;

    private RangdhanuAdapter rangdhanuAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_rangdhanu_club);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        rangdhanuRecyclerView=findViewById(R.id.rangdhanuRecyclerView);

        rangdhanuRecyclerView.setLayoutManager(new LinearLayoutManager(this));


        RangdhanuApi clubApi = ApiClient.getRetrofit().create(RangdhanuApi.class);

        Call<List<RangdhanuModel>> call = clubApi.getRangdhanuClub();

        call.enqueue(new Callback<List<RangdhanuModel>>() {
            @Override
            public void onResponse(Call<List<RangdhanuModel>> call, Response<List<RangdhanuModel>> response) {
                if (response.isSuccessful()) {
                    List<RangdhanuModel> RangdhanuModelList = response.body();

                    // Set up RecyclerView with the adapter
                    rangdhanuAdapter = new RangdhanuAdapter(RangdhanuModelList, getApplicationContext() );
                    rangdhanuRecyclerView.setAdapter(rangdhanuAdapter);
                }
            }

            @Override
            public void onFailure(Call<List<RangdhanuModel>> call, Throwable t) {

            }
        });
    }
}