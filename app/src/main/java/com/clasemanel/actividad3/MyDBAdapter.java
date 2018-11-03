package com.clasemanel.actividad3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;


public class MyDBAdapter {

    //Parámetros bd
    private static final String DATABASE_NAME = "guardar.db";
    private static final String  TABLA_PROFESORES= "profesores";
    private static final String TABLA_ESTUDIANTES = "estudiantes";
    private static final int DATABASE_VERSION = 1;

    //Campos de las tablas
    private static final String NOMBRE = "name";
    private static final String EDAD = "edad";
    private static final String CICLO = "ciclo";
    private static final String CURSO = "curso";
    private static final String NOTA_MEDIA = "notaMedia";
    private static final String DESPACHO = "despacho";

    //Sentencias CREATE TABLE
    private static final String DATABASE_CREATE = "CREATE TABLE "+TABLA_PROFESORES+" (_id integer primary key autoincrement, name text, edad integer, ciclo text, curso text, despacho integer );";
    private static final String DATABASE_CREATE2 = "CREATE TABLE "+TABLA_ESTUDIANTES+" (_id integer primary key autoincrement, name text, edad integer, ciclo text, curso text, notaMedia text );";

    //Sentencias DROP TABLE
    private static final String DATABASE_DROP = "DROP TABLE IF EXISTS "+TABLA_PROFESORES+";";
    private static final String DATABASE_DROP2 = "DROP TABLE IF EXISTS "+TABLA_ESTUDIANTES+";";

    private final Context context;
    // Clase SQLiteOpenHelper para crear/actualizar la base de datos
    private MyDbHelper dbHelper;
    // Instancia de la base de datos
    private SQLiteDatabase db;

    public MyDBAdapter(Context context) {
        this.context = context;
        dbHelper = new MyDbHelper(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    public void open(){
        try{
            db = dbHelper.getWritableDatabase();
            Log.d("MIO", "Escritura");
        }catch(SQLiteException e){
            Log.d("MIO", "Solo lectura");
            db = dbHelper.getReadableDatabase();
        }
    }

    //Recibo e introduzco todos los parámetros como strings para facilitarme inserción
    public void insertarEstudiantes(String nombre, String edad, String ciclo, String curso, String nota){
        ContentValues newEstudiantes = new ContentValues();

        newEstudiantes.put(NOMBRE,nombre);
        newEstudiantes.put(EDAD,edad);
        newEstudiantes.put(CICLO,ciclo);
        newEstudiantes.put(CURSO,curso);
        newEstudiantes.put(NOTA_MEDIA,nota);

        db.insert(TABLA_ESTUDIANTES,null,newEstudiantes);
    }

    //Recibo e introduzco todos los parámetros como strings para facilitarme la inserción
    public void insertarProfesores(String nombre, String edad, String ciclo, String curso, String despacho){
        ContentValues newProfesores = new ContentValues();

        newProfesores.put(NOMBRE,nombre);
        newProfesores.put(EDAD,edad);
        newProfesores.put(CICLO,ciclo);
        newProfesores.put(CURSO,curso);
        newProfesores.put(DESPACHO,despacho);

        db.insert(TABLA_PROFESORES,null,newProfesores);
    }

    public ArrayList<String[]> recuperarEstudiantes(){
        //Devuelvo una lista de arrays de Strings no una lista de Strings, cada array, es un alumno
        ArrayList<String[]> est = new ArrayList<String[]>();

        Cursor cursor = db.query(TABLA_ESTUDIANTES,null,null,null,null,null,null);
        if (cursor != null && cursor.moveToFirst()){
            do{
                //Cada columna es un valor del array
                String [] valores = new String [5];
                valores[0]=(cursor.getString(1));
                valores[1]=(cursor.getString(2));
                valores[2]=(cursor.getString(3));
                valores[3]=(cursor.getString(4));
                valores[4]=(cursor.getString(5));

                est.add(valores);
            }while (cursor.moveToNext());
        }

        return est;
    }

    public ArrayList<String[]> recuperarEstudiantesPorCiclo(String ciclo){
        //Devuelvo una lista de arrays de Strings no una lista de Strings, cada array, es un alumno
        ArrayList<String[]> est = new ArrayList<String[]>();

        //Filtramos introduciendo un filtro estilo SQL en el parámetro "selection"
        Cursor cursor = db.query(TABLA_ESTUDIANTES,null,"ciclo='"+ciclo+"'",null,null,null,null);
        if (cursor != null && cursor.moveToFirst()){
            do{
                //Cada columna es un valor del array
                String [] valores = new String [5];
                valores[0]=(cursor.getString(1));
                valores[1]=(cursor.getString(2));
                valores[2]=(cursor.getString(3));
                valores[3]=(cursor.getString(4));
                valores[4]=(cursor.getString(5));

                est.add(valores);
            }while (cursor.moveToNext());
        }

        return est;
    }

    public ArrayList<String[]> recuperarEstudiantesPorCurso(String curso){
        //Devuelvo una lista de arrays de Strings no una lista de Strings, cada array, es un alumno
        ArrayList<String[]> est = new ArrayList<String[]>();

        //Filtramos introduciendo un filtro estilo SQL en el parámetro "selection"
        Cursor cursor = db.query(TABLA_ESTUDIANTES,null,"curso='"+curso+"'",null,null,null,null);
        if (cursor != null && cursor.moveToFirst()){
            do{
                //Cada columna es un valor del array
                String [] valores = new String [5];
                valores[0]=(cursor.getString(1));
                valores[1]=(cursor.getString(2));
                valores[2]=(cursor.getString(3));
                valores[3]=(cursor.getString(4));
                valores[4]=(cursor.getString(5));

                est.add(valores);
            }while (cursor.moveToNext());
        }

        return est;
    }

    public ArrayList<String[]> recuperarProfesores(){
        //Devuelvo una lista de arrays de Strings no una lista de Strings, cada array, es un profesor
        ArrayList<String[]> pro = new ArrayList<String[]>();

        Cursor cursor = db.query(TABLA_PROFESORES,null,null,null,null,null,null);
        if (cursor != null && cursor.moveToFirst()){
            do{
                //Cada columna es un valor del array
                String [] valores = new String [5];
                valores[0]=(cursor.getString(1));
                valores[1]=(cursor.getString(2));
                valores[2]=(cursor.getString(3));
                valores[3]=(cursor.getString(4));
                valores[4]=(cursor.getString(5));

                pro.add(valores);
            }while (cursor.moveToNext());
        }

        return pro;
    }

    private static class MyDbHelper extends SQLiteOpenHelper{

        public MyDbHelper(Context context,String name,SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(DATABASE_CREATE);
            db.execSQL(DATABASE_CREATE2);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL(DATABASE_DROP);
            db.execSQL(DATABASE_DROP2);
            onCreate(db);
        }
    }
}
