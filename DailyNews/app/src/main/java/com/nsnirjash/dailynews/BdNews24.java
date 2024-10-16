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

public class BdNews24 extends AppCompatActivity {

    private WebView bdnews24;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bd_news24);

        bdnews24 = findViewById(R.id.bdnews24);

        WebSettings webSettings = bdnews24.getSettings();
        bdnews24.setWebViewClient(new SameView());
        webSettings.setJavaScriptEnabled(true);
        bdnews24.loadUrl("https://bangla.bdnews24.com/");

    }

    public class SameView extends WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}