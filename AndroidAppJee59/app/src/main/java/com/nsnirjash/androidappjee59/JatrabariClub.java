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
import com.nsnirjash.androidappjee59.adapter.JatrabariClubAdapter;
import com.nsnirjash.androidappjee59.adapter.PurbachalModelAdapter;
import com.nsnirjash.androidappjee59.api.JatrabariClubApi;
import com.nsnirjash.androidappjee59.api.PurbachalClubApi;
import com.nsnirjash.androidappjee59.model.JatrabariClubModel;
import com.nsnirjash.androidappjee59.model.PurbachalModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JatrabariClub extends AppCompatActivity {

    private RecyclerView jatrabariRecyclerView;

    private JatrabariClubAdapter jatrabariClubAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_jatrabari_club);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        jatrabariRecyclerView=findViewById(R.id.jatrabariRecyclerView);

        jatrabariRecyclerView.setLayoutManager(new LinearLayoutManager(this));


        JatrabariClubApi clubApi = ApiClient.getRetrofit().create(JatrabariClubApi.class);

        Call<List<JatrabariClubModel>> call = clubApi.getJatrabariClub();

        call.enqueue(new Callback<List<JatrabariClubModel>>() {
            @Override
            public void onResponse(Call<List<JatrabariClubModel>> call, Response<List<JatrabariClubModel>> response) {
                if (response.isSuccessful()) {
                    List<JatrabariClubModel> jatrabariClubModelList = response.body();

                    // Set up RecyclerView with the adapter
                    jatrabariClubAdapter = new JatrabariClubAdapter(jatrabariClubModelList, getApplicationContext() );
                    jatrabariRecyclerView.setAdapter(jatrabariClubAdapter);
                }
            }

            @Override
            public void onFailure(Call<List<JatrabariClubModel>> call, Throwable t) {

            }
        });
    }
}