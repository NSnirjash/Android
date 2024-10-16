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
import com.nsnirjash.androidappjee59.adapter.FriendsZoneAdapter;
import com.nsnirjash.androidappjee59.adapter.PurbachalModelAdapter;
import com.nsnirjash.androidappjee59.api.FriendsZoneApi;
import com.nsnirjash.androidappjee59.api.PurbachalClubApi;
import com.nsnirjash.androidappjee59.model.FriendsZoneModel;
import com.nsnirjash.androidappjee59.model.PurbachalModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FriendsZoneClub extends AppCompatActivity {

    private RecyclerView friendsZoneRecyclerView;

    private FriendsZoneAdapter friendsZoneAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_friends_zone_club);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        friendsZoneRecyclerView=findViewById(R.id.friendsZoneRecyclerView);

        friendsZoneRecyclerView.setLayoutManager(new LinearLayoutManager(this));


        FriendsZoneApi clubApi = ApiClient.getRetrofit().create(FriendsZoneApi.class);

        Call<List<FriendsZoneModel>> call = clubApi.getFriendsZoneClub();

        call.enqueue(new Callback<List<FriendsZoneModel>>() {
            @Override
            public void onResponse(Call<List<FriendsZoneModel>> call, Response<List<FriendsZoneModel>> response) {

                if (response.isSuccessful()) {
                    List<FriendsZoneModel> friendsZoneModelList = response.body();

                    friendsZoneAdapter = new FriendsZoneAdapter(friendsZoneModelList, getApplicationContext() );
                    friendsZoneRecyclerView.setAdapter(friendsZoneAdapter);
                }
            }

            @Override
            public void onFailure(Call<List<FriendsZoneModel>> call, Throwable t) {

            }
        });


        }

    }



