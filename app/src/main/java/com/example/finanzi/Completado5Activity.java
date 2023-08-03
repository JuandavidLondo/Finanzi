package com.example.finanzi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Completado5Activity extends AppCompatActivity {

    public static String Llave = "completado";
    public static String Llave2 = "completado2";
    public static String Llave3 = "completado3";
    public static String Llave4 = "completado4";
    public static String Llave5 = "completado5";

    Button inicio,siguiente;
    boolean completado,completado2,completado3,completado4,completado5;
    public static final String LlaveVida="LLavevida";
    public static final String LLaveDinero="Llavedinero";
    int vida,dinero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_completado);
        siguiente = findViewById(R.id.siguiente);
        inicio = findViewById(R.id.inicio);
        completado = true;
        completado5 = true;
        completado2 = true;
        completado3 = true;
        completado4 = true;
        Intent intent =getIntent();
        vida = intent.getIntExtra(CuestionarioActivity.LlaveVida,3);
        dinero = intent.getIntExtra(CuestionarioActivity.LlaveDinero,10);
        dinero +=5;

        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                irsiguiente();
            }
        });
        inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                irInicio();
            }
        });
    }

    private void irInicio() {
        Intent intent = new Intent(Completado5Activity.this,InicioActivity.class);
        intent.putExtra(Llave,completado);
        intent.putExtra(Llave2,completado2);
        intent.putExtra(Llave3,completado3);
        intent.putExtra(Llave4,completado4);
        intent.putExtra(Llave5,completado5);
        intent.putExtra(LlaveVida,vida);
        intent.putExtra(LLaveDinero,dinero);
        startActivity(intent);
        finish();
    }

    private void irsiguiente() {
        Intent intent = new Intent(Completado5Activity.this,Cuestionario6Activity.class);
        intent.putExtra(LlaveVida,vida);
        intent.putExtra(LLaveDinero,dinero);
        startActivity(intent);
        finish();
    }

}