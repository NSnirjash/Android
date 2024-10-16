package com.nsnirjash.dailynews;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HomeActivity extends AppCompatActivity {

    private Button btnBdnews;
    private Button btnProthomAlo;
    private Button btnDhakaTribune;
    private Button btnDW;
    private Button btnbusinessstandard;
    private Button btnBonikBarta;
    private Button btnFinancialExpress;
    private Button btnJayJayDin;
    private Button btnDailyStar;
    private Button btnDailySun;
    private Button btnsomokal;
    private Button bangladeshprotidin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnBdnews = findViewById(R.id.btnBdnews);
        btnBdnews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), BdNews24.class);
                startActivity(intent);
            }
        });

        btnProthomAlo = findViewById(R.id.btnProthomAlo);
        btnProthomAlo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ProthomAlo.class);
                startActivity(intent);
            }
        });

        btnDhakaTribune = findViewById(R.id.btnDhakaTribune);
        btnDhakaTribune.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), DhakaTribune.class);
                startActivity(intent);
            }
        });

        btnDW = findViewById(R.id.btnDW);
        btnDW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), DW.class);
                startActivity(intent);
            }
        });

        btnbusinessstandard = findViewById(R.id.btnbusinessstandard);
        btnbusinessstandard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), BusinessStanderd.class);
                startActivity(intent);
            }
        });

        btnBonikBarta = findViewById(R.id.btnBonikBarta);
        btnBonikBarta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), BonikBarta.class);
                startActivity(intent);
            }
        });

        btnFinancialExpress = findViewById(R.id.btnFinancialExpress);
        btnFinancialExpress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), FinancialExpress.class);
                startActivity(intent);
            }
        });

        btnJayJayDin = findViewById(R.id.btnJayJayDin);
        btnJayJayDin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), JayJayDin.class);
                startActivity(intent);
            }
        });

        btnDailyStar = findViewById(R.id.btnDailyStar);
        btnDailyStar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), DailyStar.class);
                startActivity(intent);
            }
        });

        btnDailySun = findViewById(R.id.btnDailySun);
        btnDailySun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), DailySun.class);
                startActivity(intent);
            }
        });

        btnsomokal = findViewById(R.id.btnsomokal);
        btnsomokal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Somokal.class);
                startActivity(intent);
            }
        });

        bangladeshprotidin = findViewById(R.id.bangladeshprotidin);
        bangladeshprotidin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), BangladeshProtidin.class);
                startActivity(intent);
            }
        });
    }
}