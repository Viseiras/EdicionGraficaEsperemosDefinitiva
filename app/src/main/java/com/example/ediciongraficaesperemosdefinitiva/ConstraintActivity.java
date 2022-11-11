package com.example.ediciongraficaesperemosdefinitiva;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

//Iniciamos el Constraint Activity
public class ConstraintActivity extends AppCompatActivity {

    //Iniciamos el Constraint Activity
    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constraint);

        //Creamos los botones Start y Game
        Button btnStart1 = findViewById(R.id.btnStart1);
        Button btnStart2 = findViewById(R.id.btnStart2);

        //Iniciamos la URL del video
        String url = "<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/w0-ZcjHUbd0\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>";
        WebView myWebView = (WebView) findViewById(R.id.webview);
        //Metemos la URL en el WebView
        myWebView.loadData(url, "text/html", "UTF-8");
        myWebView.setWebViewClient(new WebViewClient());
        //Damos permisos de uso en la configuración WebView para que use JavaScrop
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        //Cambiamos el color con 0xff que sirve para pasar a int un color en Hexadecimal
        btnStart1.setBackgroundColor(0xFFFFFF00);
        btnStart1.setTextColor(R.color.black);
        btnStart2.setBackgroundColor(0xFFFF0000);

        //Nos Movemos a la activity Juegos desde el Botón Start
        btnStart1.setOnClickListener(v -> {
                Intent intent = new Intent(this, JuegoActivity.class);
                startActivity(intent);
                }
        );

        //Nos Movemos a la activity Juegos desde el botón Game
        btnStart2.setOnClickListener(v -> {
                Intent intent = new Intent(this, JuegoActivity.class);
                startActivity(intent);
                }
        );
    }
}