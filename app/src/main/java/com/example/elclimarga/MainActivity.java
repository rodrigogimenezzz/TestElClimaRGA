package com.example.elclimarga;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button botonASU;
    private Button botonCDE;
    private Button botonENC;
    private Button botonLMP;
    private Button botonVRC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botonASU = (Button) findViewById(R.id.btnASU);
        botonCDE = (Button) findViewById(R.id.btnCDE);
        botonENC = (Button) findViewById(R.id.btnENC);
        botonLMP = (Button) findViewById(R.id.btnLMP);
        botonVRC = (Button) findViewById(R.id.btnVRC);

        botonASU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirAsuncion();
            }
        });

        botonCDE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirCiudadDelEste();
            }
        });

        botonENC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirEncarnacion();
            }
        });

        botonLMP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirLomaPlata();
            }
        });

        botonVRC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirVillaRica();
            }
        });
    }

    public void abrirAsuncion (){
        Intent intent = new Intent(this, asuncion.class);
        startActivity(intent);
    }

    public void abrirCiudadDelEste (){
        Intent intent = new Intent(this, ciudadDelEste.class);
        startActivity(intent);
    }

    public void abrirEncarnacion (){
        Intent intent = new Intent(this, encarnacion.class);
        startActivity(intent);
    }

    public void abrirLomaPlata (){
        Intent intent = new Intent(this, lomaPlata.class);
        startActivity(intent);
    }

    public void abrirVillaRica (){
        Intent intent = new Intent(this, villaRica.class);
        startActivity(intent);
    }
}