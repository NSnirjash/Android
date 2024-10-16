package com.nsnirjash.dailynews;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class BangladeshProtidin extends AppCompatActivity {

    private WebView bangladeshprotidin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bangladesh_protidin);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        bangladeshprotidin = findViewById(R.id.bangladeshprotidin);

        WebSettings webSettings = bangladeshprotidin.getSettings();
        bangladeshprotidin.setWebViewClient(new SameView());
        webSettings.setJavaScriptEnabled(true);
        bangladeshprotidin.loadUrl("https://www.bd-pratidin.com/");
    }

    public class SameView extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}