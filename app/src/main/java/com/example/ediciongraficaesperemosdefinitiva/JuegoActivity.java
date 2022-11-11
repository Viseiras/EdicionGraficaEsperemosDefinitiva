package com.example.ediciongraficaesperemosdefinitiva;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.time.Duration;

//Bienvenido a mi obra maestra, Iniciamos el Juego Activity
public class JuegoActivity extends AppCompatActivity {

    //Declaración de animators
    private ObjectAnimator animatorX;
    private ObjectAnimator animatorY;
    private ObjectAnimator animatorTriple;
    private ObjectAnimator animatorAlpha;
    private ObjectAnimator animatorRotation;
    private ValueAnimator animatorColor;

    //Declaración de Objetos XML
    private TextView textContador;
    private Button btnGame;
    private Button btnAcabar;

    //Declaramos el AnimatorSet
    private AnimatorSet animatorSet;

    //Declaramos variables
    private int accion;
    private int clickcount;
    private  int fiesta=0;
    private int pos=(int)(Math.random()*720)+90;
    private float duracion=(int)(Math.random()*10)+1;

    //Declaramos las constantes de colores
    private static final int RED = 0xffFF8080;
    private static final int BLUE = 0xff8080FF;
    private static final int YELLOW = 0xffFFFF00;
    private static final int BLACK = 0xff000000;
    private static final int WHITE = 0xffFFFFFF;
    private static final int PURPLE = 0xff800080;
    private static final int GREEN = 0xff00FF00;

    //Iniciamos la Juegos Activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);

        //Inicializamos las counts a 0
        clickcount=0;
        accion=0;

        //Ligamos los objetos XML al main
        btnAcabar=findViewById(R.id.btnAcabar);
        textContador=findViewById(R.id.textContador);
        btnGame = findViewById(R.id.btnGame);
        TextView textContador =findViewById(R.id.textContador);

        //Iniciamos el setOnClick
        btnGame.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {

                //Cambiamos el contenido del TextView
                textContador.setText("Clicks: "+fiesta);

                //Comprobamos que no se pase de fuerza
                if(clickcount>2 || clickcount>-2)
                    clickcount= -(clickcount);


                //Sumamos los clicks
                clickcount++;
                fiesta++;

                accion= (int) (Math.random() * 7);

                //Iniciamos la animación
                animacion(accion);

            }
        });
        //Hacemos el ClickListener
        btnAcabar.setOnClickListener(v->{
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
        });
    }



    //Iniciamos Animación que nos pide un int para pedir la accion random que realizará
    private void animacion(int accion) {

        //Declaración de variables de la clase
        float alpha = (float)(Math.random());
        pos=(int)(Math.random()*720)+90;
        duracion-=0.01;

        //Inicio del switch basado en accion (parametro que pide el método)
        switch (accion) {
            //Este case nos mueve horizontalmente el botón
            case 0:
                //Iniciamos animator X
                animatorX = ObjectAnimator.ofFloat(btnGame, "x", 500 * clickcount);
                animatorX.setDuration((long) (200 *duracion));
                //Hacemos el animator set
                AnimatorSet animatorSetX = new AnimatorSet();
                //Ponemos la orden play en el animatorX
                animatorSetX.play(animatorX);
                //Hacemos el start de la animación
                animatorSetX.start();
            break;
            //Este case nos mueve verticalmente el botón
            case 1:
                //Lo mimso que en el case 0
                animatorY = ObjectAnimator.ofFloat(btnGame, "y", 1000 * clickcount);
                animatorY.setDuration((long) (200 *duracion));
                AnimatorSet animatorSetY = new AnimatorSet();
                animatorSetY.play(animatorY);
                animatorSetY.start();
            break;
            //Este case nos mueve horizontalmente, verticalmente y rota el botón
            case 2:
                //Iniciamos los 3 animators
                animatorX = ObjectAnimator.ofFloat(btnGame, "x", 500 * clickcount);
                animatorX.setDuration((long) (200 *duracion));
                animatorY = ObjectAnimator.ofFloat(btnGame, "y", 1000 * clickcount);
                animatorY.setDuration((long) (200 *duracion));
                animatorRotation = ObjectAnimator.ofFloat(btnGame,"rotation",pos,(long)(pos*0.25));
                animatorRotation.setDuration((long) (200L *duracion));
                //Declaramos las repeticiones que tendrá cada animación
                animatorRotation.setRepeatCount(2);
                animatorX.setRepeatCount(1);
                animatorY.setRepeatCount(4);
                AnimatorSet animatorSetTriple = new AnimatorSet();
                //Ponemos la orden playTogether que permite lanzar más de una animation
                animatorSetTriple.playTogether(animatorX,animatorY,animatorRotation);
                animatorSetTriple.start();
            break;
            //Este case nos rota el botón
            case 3:
                //Lo mismo que en el case 0
                animatorRotation = ObjectAnimator.ofFloat(btnGame,"rotation",pos,(long)(pos*0.25));
                animatorRotation.setDuration((long) (200L *duracion));
                AnimatorSet animatorSetRotation = new AnimatorSet();
                animatorSetRotation.play(animatorRotation);
                animatorSetRotation.start();
            break;
            //Este case nos cambia el Alpha del botón y lo vuelve transparente aleatoriamente
            case 4:
                //Iniciamos el Animation Alpha y le metemos los valores
                animatorAlpha = ObjectAnimator.ofFloat(btnGame, View.ALPHA, 1.0f,alpha);
                animatorAlpha.setDuration((long) (200L *duracion));
                AnimatorSet animatorSetAlpha = new AnimatorSet();
                animatorSetAlpha.play(animatorAlpha);
                animatorSetAlpha.start();
                break;
            //Este case nos cambia el color del botón en una transición con los colores especificados
            case 5:
                animatorColor = ObjectAnimator.ofInt(btnGame, "backgroundColor", RED,BLUE,YELLOW,GREEN,BLACK,PURPLE);
                animatorColor.setDuration(500);
                animatorColor.setEvaluator(new ArgbEvaluator());
                //animatorColor.setRepeatCount(ValueAnimator.INFINITE);
                animatorColor.setRepeatCount(5);
                animatorColor.start();
                break;
            //Este case nos cambia el color del texto con los colores especificados
            case 6:
                animatorColor = ObjectAnimator.ofInt(btnGame, "textColor", BLACK,WHITE);
                animatorColor.setDuration(500);
                animatorColor.setEvaluator(new ArgbEvaluator());
                //animatorColor.setRepeatCount(ValueAnimator.INFINITE);
                animatorColor.setRepeatCount(5);
                animatorColor.start();
                break;
        }
    }
}