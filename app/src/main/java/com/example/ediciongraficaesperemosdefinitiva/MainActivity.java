package com.example.ediciongraficaesperemosdefinitiva;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;

//Main Activity con el Slider Izquierda y Derecha
public class MainActivity extends AppCompatActivity {

    //Declaración de los float que usaremos para movernos
    float x1,x2,y1,y2;


    //Iniciamos la actividad Main
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Iniciamos el TouchScreen para que podamos deslizar Izquierda y Derecha
    public boolean onTouchEvent(MotionEvent touchevent){
        //Hacemos una TouchScreen para aplicar movimientos
        switch (touchevent.getAction()){
            //Declaramos posición inicial
            case MotionEvent.ACTION_DOWN:
                x1 = touchevent.getX();
                y1 = touchevent.getY();
                break;
            //Declaramos posición final
            case MotionEvent.ACTION_UP:
                x2 = touchevent.getX();
                y2= touchevent.getY();
                //Movimento a la derecha
                if(x1>x2)
                {
                    Intent i = new Intent(MainActivity.this, GridActivity.class);
                    startActivity(i);
                }
                //Movimiento a la izquierda
                if(x1<x2)
                {
                    Intent i = new Intent(MainActivity.this, RelativeActivity.class);
                    startActivity(i);
                }
                break;
        }
        return false;
    }

}