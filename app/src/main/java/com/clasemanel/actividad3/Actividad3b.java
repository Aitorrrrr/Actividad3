package com.clasemanel.actividad3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Actividad3b extends AppCompatActivity {

    private Button estudiante;
    private Button profesor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad3b);

        estudiante = (Button) findViewById(R.id.est_3b);
        estudiante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), estudiante.class);
                startActivity(i);
            }
        });

        profesor = (Button) findViewById(R.id.prof_3b);
        profesor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), profesor.class);
                startActivity(i);
            }
        });
    }
}
