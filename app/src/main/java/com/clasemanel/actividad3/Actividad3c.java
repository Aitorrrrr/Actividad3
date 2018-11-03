package com.clasemanel.actividad3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Actividad3c extends AppCompatActivity {

    private Button recuperarEst;
    private Button recuperarEstPorCiclo;
    private Button recuperarEstPorCurso;
    private Button recuperarPro;
    private Button recuperarTodos;

    private ArrayList<String[]> auxiliar;
    private MyDBAdapter adaptador;

    private TextView texto;
    private EditText ciclo;
    private EditText curso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad3c);

        auxiliar = new ArrayList<String[]>();
        texto = (TextView) findViewById(R.id.texto_3c);
        ciclo = (EditText) findViewById(R.id.cicloCiclo_3c);
        curso = (EditText) findViewById(R.id.cursoCurso_3c);

        recuperarEst = (Button) findViewById(R.id.estTodos_3c);
        recuperarEst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adaptador = new MyDBAdapter(getApplicationContext());
                adaptador.open();

                auxiliar = adaptador.recuperarEstudiantes();

                texto.setText("");
                for (String [] aux: auxiliar)
                {
                    texto.setText(texto.getText()+"Nombre: "+aux[0]+"\n");
                    texto.setText(texto.getText()+"Edad: "+aux[1]+"\n");
                    texto.setText(texto.getText()+"Ciclo: "+aux[2]+"\n");
                    texto.setText(texto.getText()+"Curso: "+aux[3]+"\n");
                    texto.setText(texto.getText()+"Nota Media: "+aux[4]+"\n");

                    texto.setText(texto.getText()+"\n"+"\n");
                }
            }
        });

        recuperarEstPorCurso = (Button) findViewById(R.id.estCurso_3c);
        recuperarEstPorCurso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adaptador = new MyDBAdapter(getApplicationContext());
                adaptador.open();

                auxiliar = adaptador.recuperarEstudiantesPorCurso(curso.getText().toString());

                texto.setText("");
                for (String [] aux: auxiliar)
                {
                    texto.setText(texto.getText()+"Nombre: "+aux[0]+"\n");
                    texto.setText(texto.getText()+"Edad: "+aux[1]+"\n");
                    texto.setText(texto.getText()+"Ciclo: "+aux[2]+"\n");
                    texto.setText(texto.getText()+"Curso: "+aux[3]+"\n");
                    texto.setText(texto.getText()+"Nota Media: "+aux[4]+"\n");

                    texto.setText(texto.getText()+"\n"+"\n");
                }
            }
        });

        recuperarEstPorCiclo = (Button) findViewById(R.id.estCiclo_3c);
        recuperarEstPorCiclo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adaptador = new MyDBAdapter(getApplicationContext());
                adaptador.open();

                auxiliar = adaptador.recuperarEstudiantesPorCiclo(ciclo.getText().toString());

                texto.setText("");
                for (String [] aux: auxiliar)
                {
                    texto.setText(texto.getText()+"Nombre: "+aux[0]+"\n");
                    texto.setText(texto.getText()+"Edad: "+aux[1]+"\n");
                    texto.setText(texto.getText()+"Ciclo: "+aux[2]+"\n");
                    texto.setText(texto.getText()+"Curso: "+aux[3]+"\n");
                    texto.setText(texto.getText()+"Nota Media: "+aux[4]+"\n");

                    texto.setText(texto.getText()+"\n"+"\n");
                }
            }
        });

        recuperarPro = (Button) findViewById(R.id.proTodos_3c);
        recuperarPro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adaptador = new MyDBAdapter(getApplicationContext());
                adaptador.open();

                auxiliar = adaptador.recuperarProfesores();

                texto.setText("");
                for (String [] aux: auxiliar)
                {
                    texto.setText(texto.getText()+"Nombre: "+aux[0]+"\n");
                    texto.setText(texto.getText()+"Edad: "+aux[1]+"\n");
                    texto.setText(texto.getText()+"Ciclo: "+aux[2]+"\n");
                    texto.setText(texto.getText()+"Curso: "+aux[3]+"\n");
                    texto.setText(texto.getText()+"Despacho: "+aux[4]+"\n");

                    texto.setText(texto.getText()+"\n"+"\n");
                }
            }
        });

        recuperarTodos = (Button) findViewById(R.id.todos_3c);
        recuperarTodos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adaptador = new MyDBAdapter(getApplicationContext());
                adaptador.open();

                auxiliar = adaptador.recuperarProfesores();

                texto.setText("Estudiantes");
                for (String [] aux: auxiliar)
                {
                    texto.setText(texto.getText()+"Nombre: "+aux[0]+"\n");
                    texto.setText(texto.getText()+"Edad: "+aux[1]+"\n");
                    texto.setText(texto.getText()+"Ciclo: "+aux[2]+"\n");
                    texto.setText(texto.getText()+"Curso: "+aux[3]+"\n");
                    texto.setText(texto.getText()+"Nota Media: "+aux[4]+"\n");

                    texto.setText(texto.getText()+"\n"+"\n");
                }

                auxiliar = adaptador.recuperarProfesores();

                texto.setText("Profesores");
                for (String [] aux: auxiliar)
                {
                    texto.setText(texto.getText()+"Nombre: "+aux[0]+"\n");
                    texto.setText(texto.getText()+"Edad: "+aux[1]+"\n");
                    texto.setText(texto.getText()+"Ciclo: "+aux[2]+"\n");
                    texto.setText(texto.getText()+"Curso: "+aux[3]+"\n");
                    texto.setText(texto.getText()+"Despacho: "+aux[4]+"\n");

                    texto.setText(texto.getText()+"\n"+"\n");
                }
            }
        });
    }
}
