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
import com.nsnirjash.androidappjee59.adapter.PurbachalModelAdapter;
import com.nsnirjash.androidappjee59.adapter.RisingStarAdapter;
import com.nsnirjash.androidappjee59.api.PurbachalClubApi;
import com.nsnirjash.androidappjee59.api.RisingStarApi;
import com.nsnirjash.androidappjee59.model.PurbachalModel;

import java.util.List;

import retrofit2.Call;

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


    }
}