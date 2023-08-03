package com.example.finanzi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Completado15Activity extends AppCompatActivity {

    public static String Llave = "completado";
    public static String Llave2 = "completado2";
    public static String Llave3 = "completado3";
    public static String Llave4 = "completado4";
    public static String Llave5 = "completado5";
    public static String Llave6 = "completado6";
    public static String Llave7 = "completado7";
    public static String Llave8 = "completado8";
    public static String Llave9 = "completado9";
    public static String Llave10 = "completado10";
    public static String Llave11 = "completado11";
    public static String Llave12 = "completado12";
    public static String Llave13 = "completado13";
    public static String Llave14 = "completado14";
    public static String Llave15 = "completado15";

    Button inicio,siguiente;
    boolean completado,completado2,completado3,completado4,completado5,completado6,completado7,completado8;
    boolean completado9,completado10,completado11,completado12,completado13,completado14,completado15;
    public static final String LlaveVida="LLavevida";
    public static final String LLaveDinero="Llavedinero";
    int vida,dinero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_completado);
        siguiente = findViewById(R.id.siguiente);
        inicio = findViewById(R.id.inicio);
        completado9 = true;
        completado8 = true;
        completado7 = true;
        completado6 = true;
        completado = true;
        completado5 = true;
        completado2 = true;
        completado3 = true;
        completado4 = true;
        completado10=true;
        completado11=true;
        completado12=true;
        completado13=true;
        completado14=true;
        completado15=true;
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
        Intent intent = new Intent(Completado15Activity.this,InicioActivity.class);
        intent.putExtra(Llave,completado);
        intent.putExtra(Llave2,completado2);
        intent.putExtra(Llave3,completado3);
        intent.putExtra(Llave4,completado4);
        intent.putExtra(Llave5,completado5);
        intent.putExtra(Llave6,completado6);
        intent.putExtra(Llave7,completado7);
        intent.putExtra(Llave8,completado8);
        intent.putExtra(Llave9,completado9);
        intent.putExtra(Llave10,completado10);
        intent.putExtra(Llave11,completado11);
        intent.putExtra(Llave12,completado12);
        intent.putExtra(Llave13,completado13);
        intent.putExtra(Llave14,completado14);
        intent.putExtra(Llave15,completado15);
        intent.putExtra(LlaveVida,vida);
        intent.putExtra(LLaveDinero,dinero);
        startActivity(intent);
        finish();
    }

    private void irsiguiente() {
        Intent intent = new Intent(Completado15Activity.this,InicioActivity.class);
        intent.putExtra(LlaveVida,vida);
        intent.putExtra(LLaveDinero,dinero);
        startActivity(intent);
        finish();
    }

}