package com.clasemanel.actividad3;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.jar.JarEntry;

public class mostrarPreferencias extends AppCompatActivity {

    private Button volver;

    private TextView nombre;
    private TextView usuario;
    private TextView fecha;
    private TextView genero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_preferencias);

        nombre = (TextView) findViewById(R.id.nombre_most);
        usuario = (TextView) findViewById(R.id.usuario_most);
        fecha = (TextView) findViewById(R.id.fecha_most);
        genero = (TextView) findViewById(R.id.genero_most);

        SharedPreferences preferencias = getSharedPreferences(MainActivity.PREFS, Activity.MODE_PRIVATE);

        nombre.setText("Nombre: "+preferencias.getString("nombre", "No hay nombre"));
        usuario.setText("Usuario: "+preferencias.getString("usuario", "No hay usuario"));
        fecha.setText("Fecha Nacimineto: "+preferencias.getString("fecha", "No hay fecha"));
        genero.setText("Género: "+preferencias.getString("genero", "No hay género"));

        volver = (Button) findViewById(R.id.volver_most);
        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });
    }
}
