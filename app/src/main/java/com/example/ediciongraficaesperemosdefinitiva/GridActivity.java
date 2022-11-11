package com.example.ediciongraficaesperemosdefinitiva;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

//Grid Activity con LongClick de Sarandonga y Click normal de Sarandonga que nos transporta a la Constraint
public class GridActivity extends AppCompatActivity {

    //Iniciamos la actividad Grid
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);

        //Declaramos el boton Sarandonga
        Button btnSarandonga= findViewById(R.id.btnSarandonga);

        //Declaramos el Long Click Listener que nos manda una Toast de Sarandonga!
        btnSarandonga.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Toast.makeText(GridActivity.this,"Sarandonga!",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent();
                return false;
            }
        });

        //Declaramos el On Click que nos manda a la Constraint Activity
        btnSarandonga.setOnClickListener(v-> {
                    Intent intent = new Intent(this, ConstraintActivity.class);
                    startActivity(intent);
                }
            );
    }
}