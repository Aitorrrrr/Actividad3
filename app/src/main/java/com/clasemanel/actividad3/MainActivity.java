package com.clasemanel.actividad3;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.RadialGradient;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    protected final static String PREFS = "preferencias";

    private Button actividad3b;
    private Button actividad3c;
    private Button guardar;
    private Button mostrar;

    private EditText nombre;
    private EditText usuario;
    private EditText fecha;
    private RadioGroup rg;
    private RadioButton rb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre = (EditText) findViewById(R.id.nombre_pref);
        usuario = (EditText) findViewById(R.id.usuario_pref);
        fecha = (EditText) findViewById(R.id.fecha_pref);
        rg = (RadioGroup) findViewById(R.id.grupo_pref);
        rb = (RadioButton) findViewById(R.id.varon_pref);

        actividad3b = (Button) findViewById(R.id.act3b);
        actividad3b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Actividad3b.class);
                startActivity(i);
            }
        });

        actividad3c = (Button) findViewById(R.id.act3c);
        actividad3c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Actividad3c.class);
                startActivity(i);
            }
        });

        guardar = (Button) findViewById(R.id.Guardar_pref);
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (comprobarCampos())
                {
                    SharedPreferences preferencias = getSharedPreferences(PREFS,Activity.MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferencias.edit();

                    editor.putString("nombre", nombre.getText().toString());
                    editor.putString("usuario", usuario.getText().toString());
                    editor.putString("fecha", fecha.getText().toString());
                    if (rb.isChecked())
                    {
                        editor.putString("genero", "Varón");
                    }
                    else
                    {
                        editor.putString("genero", "Hembra");
                    }

                    editor.commit();
                }
            }
        });

        mostrar = (Button) findViewById(R.id.Mostrar_pref);
        mostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), mostrarPreferencias.class);
                startActivity(i);
            }
        });
    }

    public boolean comprobarCampos()
    {
        if (nombre.getText().toString()=="" || usuario.getText().toString()=="" || fecha.getText().toString()=="" || rg.getCheckedRadioButtonId()==-1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
}
