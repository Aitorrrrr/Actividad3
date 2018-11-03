package com.clasemanel.actividad3;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class estudiante extends AppCompatActivity {

    private Button guardar;
    private Button volver;
    private MyDBAdapter adaptador;

    private EditText nombre;
    private EditText edad;
    private EditText curso;
    private EditText ciclo;
    private EditText nota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estudiante);

        nombre = (EditText) findViewById(R.id.nombre_est);
        edad = (EditText) findViewById(R.id.edad_est);
        curso = (EditText) findViewById(R.id.curso_est);
        ciclo = (EditText) findViewById(R.id.ciclo_est);
        nota = (EditText) findViewById(R.id.nota_est);

        guardar = (Button) findViewById(R.id.guardar_est);
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adaptador = new MyDBAdapter(getApplicationContext());
                adaptador.open();
                adaptador.insertarEstudiantes(nombre.getText().toString(), edad.getText().toString(), ciclo.getText().toString(), curso.getText().toString(), nota.getText().toString());
            }
        });

        volver = (Button) findViewById(R.id.volver_est);
        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Actividad3b.class);
                startActivity(i);
            }
        });
    }
}
