package com.nsnirjash.androidappjee59;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LionsClubsDashboard extends AppCompatActivity {

    ImageView clubPurbachal;
    ImageView clubFriendAllience;
    ImageView clubRangdhanu;
    ImageView clubRisingStar;
    ImageView clubChawkbazarTerritory;
    ImageView clubFriendsZone;
    ImageView clubJatrabari;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lions_clubs_dashboard);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        clubPurbachal = findViewById(R.id.clubPurbachal);
        clubPurbachal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), PurbachalClubDetails.class);
                startActivity(intent);

            }
        });

        clubFriendAllience = findViewById(R.id.clubFriendAllience);
        clubFriendAllience.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), FriendAllienceClub.class);
                startActivity(intent);

            }
        });

        clubRangdhanu = findViewById(R.id.clubRangdhanu);
        clubRangdhanu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), RangdhanuClub.class);
                startActivity(intent);

            }
        });

        clubRisingStar = findViewById(R.id.clubRisingStar);
        clubRisingStar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), RisingStarClub.class);
                startActivity(intent);

            }
        });

        clubChawkbazarTerritory = findViewById(R.id.clubChawkbazarTerritory);
        clubChawkbazarTerritory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), ChawkbazarTerritory.class);
                startActivity(intent);

            }
        });

        clubFriendsZone = findViewById(R.id.clubFriendsZone);
        clubFriendsZone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), FriendsZoneClub.class);
                startActivity(intent);

            }
        });

        clubJatrabari = findViewById(R.id.clubJatrabari);
        clubJatrabari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), JatrabariClub.class);
                startActivity(intent);

            }
        });
    }
}