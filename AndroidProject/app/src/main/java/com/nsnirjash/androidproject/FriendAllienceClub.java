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
import com.nsnirjash.androidproject.adapter.FriendAllienceAdapter;
import com.nsnirjash.androidproject.api.FriendAllienceApi;
import com.nsnirjash.androidproject.model.FriendAllienceModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FriendAllienceClub extends AppCompatActivity {

    private RecyclerView friendAllienceRecyclerView;

    private FriendAllienceAdapter friendAllienceAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_friend_allience_club);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        friendAllienceRecyclerView = findViewById(R.id.friendAllienceRecyclerView);
//        friendAllienceRecyclerView=findViewById(R.id.friendAllienceRecyclerView);

        friendAllienceRecyclerView.setLayoutManager(new LinearLayoutManager(this));


        FriendAllienceApi clubApi = ApiClient.getRetrofit().create(FriendAllienceApi.class);

        Call<List<FriendAllienceModel>> call = clubApi.getFriendAllienceModel();


        call.enqueue(new Callback<List<FriendAllienceModel>>() {
            @Override
            public void onResponse(Call<List<FriendAllienceModel>> call, Response<List<FriendAllienceModel>> response) {
                if (response.isSuccessful()) {
                    List<FriendAllienceModel> friendAllienceModelList = response.body();

                    // Set up RecyclerView with the adapter
                    friendAllienceAdapter = new FriendAllienceAdapter(friendAllienceModelList, getApplicationContext() );
                    friendAllienceRecyclerView.setAdapter(friendAllienceAdapter);
                }
            }

            @Override
            public void onFailure(Call<List<FriendAllienceModel>> call, Throwable t) {

            }
        });
    }
}