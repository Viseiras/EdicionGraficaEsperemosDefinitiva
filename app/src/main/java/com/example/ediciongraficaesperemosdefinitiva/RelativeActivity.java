package com.example.ediciongraficaesperemosdefinitiva;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

//Hacemos la relative Activity que nos enseña el calendario
public class RelativeActivity extends AppCompatActivity {

    //Iniciamos la Activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relative);
    }
}