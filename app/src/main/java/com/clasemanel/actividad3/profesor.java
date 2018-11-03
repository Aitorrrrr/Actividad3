package com.clasemanel.actividad3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class profesor extends AppCompatActivity {

    private Button guardar;
    private Button volver;
    private MyDBAdapter adaptador;

    private EditText nombre;
    private EditText edad;
    private EditText curso;
    private EditText ciclo;
    private EditText despacho;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profesor);

        nombre = (EditText) findViewById(R.id.nombre_pro);
        edad = (EditText) findViewById(R.id.edad_pro);
        curso = (EditText) findViewById(R.id.curso_pro);
        ciclo = (EditText) findViewById(R.id.ciclo_pro);
        despacho = (EditText) findViewById(R.id.despacho_pro);

        guardar = (Button) findViewById(R.id.guardar_pro);
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adaptador = new MyDBAdapter(getApplicationContext());
                adaptador.open();
                adaptador.insertarProfesores(nombre.getText().toString(), edad.getText().toString(), ciclo.getText().toString(), curso.getText().toString(), despacho.getText().toString());
            }
        });

        volver = (Button) findViewById(R.id.volver_pro);
        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Actividad3b.class);
                startActivity(i);
            }
        });
    }
}
