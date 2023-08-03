package com.example.finanzi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CompletadoActivity extends AppCompatActivity {

    Button inicio,siguiente;
    boolean completado;
    public static final String Llave="completado";
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
        Intent intent = new Intent(CompletadoActivity.this,InicioActivity.class);
        intent.putExtra(Llave,completado);
        intent.putExtra(LlaveVida,vida);
        intent.putExtra(LLaveDinero,dinero);
        startActivity(intent);
        finish();
    }

    private void irsiguiente() {
        Intent intent = new Intent(CompletadoActivity.this,Cuestionario2Activity.class);
        intent.putExtra(LlaveVida,vida);
        intent.putExtra(LLaveDinero,dinero);
        startActivity(intent);
        finish();
    }

}