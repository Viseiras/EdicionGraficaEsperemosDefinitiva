package com.example.ediciongraficaesperemosdefinitiva;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class ConstraintActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constraint);

        String url= "<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/9li2mDPPhT0\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>";
        WebView myWebView = (WebView) findViewById(R.id.webview);
        myWebView.loadData(url, "text/html","UTF-8");
    }
}