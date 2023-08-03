package com.example.finanzi;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Cuestionario11Activity extends AppCompatActivity {

    RadioButton rdOpc1, rdOpc2, rdOpc3;
    TextView txtNroPregunta, txtPregunta,txtvidas;
    Button btnSiguiente, btnSalir,btnfinalizar,Button;
    ImageView corazon,moneda,titulo;
    View vista;

    TextView txtmonedas;
    public static final String LlaveVida="LLavevida";
    public static final String LlaveDinero="LLavedinero";
    int vidas,dinero;

    //Se declaran las variables para modificar la pregunta y las opciones, para calcular la puntación
    double nota = 0.0;
    int NroPregunta = 1;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuestionario10);

        //Se le asigna a cada objeto el id de lo que va a usar
        rdOpc1 = (RadioButton) findViewById(R.id.rdBtnOpc1);
        rdOpc2 = (RadioButton) findViewById(R.id.rdBtnOpc2);
        rdOpc3 = (RadioButton) findViewById(R.id.rdBtnOpc3);

        txtNroPregunta = (TextView) findViewById(R.id.txtNroPregunta);
        txtPregunta = (TextView) findViewById(R.id.txtPregunta);
        txtvidas=(TextView) findViewById(R.id.txtvidas);

        btnSiguiente = (Button) findViewById(R.id.btnSiguiente);
        btnSalir = (Button) findViewById(R.id.btnSalir);
        btnfinalizar =(Button) findViewById(R.id.btnfinalizar);

        vista = (View) findViewById(R.id.view);
        corazon = (ImageView) findViewById(R.id.corazon);
        moneda = (ImageView) findViewById(R.id.moneda);
        titulo = (ImageView) findViewById(R.id.titulo);
        txtmonedas = (TextView) findViewById(R.id.txtmonedas);
        Intent intent=getIntent();
        vidas=intent.getIntExtra(InicioActivity.LlaveVida,3);
        dinero = intent.getIntExtra(InicioActivity.LLaveDinero,10);

        btnfinalizar.setVisibility(View.GONE);
        txtvidas.setText(String.valueOf(vidas));
        txtmonedas.setText(String.valueOf(dinero));
        txtNroPregunta.setText("1/6");
        txtPregunta.setText("¿Qué es una inversión?");
        rdOpc1.setText("Es la cantidad de recursos que se destinan a un fin específico con el objetivo de recibir un ingreso futuro (rendimientos).");
        rdOpc2.setText("Gastar todos los ahorros..");
        rdOpc3.setText("Ninguna de las anteriores.");


        btnfinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Irinicio();
            }
        });


        //NOTA: Oblicacion leer o si ya sabe no.
        // Las respuestas estan en la a o en el if de cada else if
        // Para poder colocar la respuesta correcta, en las condiciones de if o else-if en donde
        // dice rdOpc1 ese uno se puede cambiar por 2, 3, 4 por cualquiera de esos dos y
        // se debe de llevar tambien el acumulador de nota = nota + 0.5
        // Y para poder cambiar el tiempo de espera para la siguiente pregunta, debes de buscar
        // en el codigo con ctrl + f y pones ahi 500, ese 500 es el tiempo de espera en Milisegundos

    }

    public void siguiente(View v) {
        //if por si no se marca ninguna opcion
        if (rdOpc1.isChecked() == false && rdOpc2.isChecked() == false && rdOpc3.isChecked() == false) {

            Toast.makeText(this, "Elija una opción", Toast.LENGTH_SHORT).show();

        } else if (NroPregunta == 1) {
            if (rdOpc1.isChecked()) {
                rdOpc1.setBackgroundResource(R.drawable.correct);
                nota = nota + 0.833333;
                showDialog();
            } else if (rdOpc2.isChecked()) {
                rdOpc2.setBackgroundResource(R.drawable.incorrect);
                vidas--;
                txtvidas.setText(String.valueOf(vidas));
                showDialogbad();
            } else if (rdOpc3.isChecked()) {
                rdOpc3.setBackgroundResource(R.drawable.incorrect);
                vidas--;
                txtvidas.setText(String.valueOf(vidas));
                showDialogbad();
            }
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {

                    NroPregunta++;
                    txtNroPregunta.setText("2/6");
                    txtPregunta.setText("¿Qué es un rendimiento?");
                    rdOpc1.setText("Hacer que rindan los recursos.");
                    rdOpc2.setText("Rendir cuentas a otras personas.");
                    rdOpc3.setText("Ganancias que obtienen al invertir tu dinero en instrumentos financieros.");
                    rdOpc1.setChecked(false);
                    rdOpc2.setChecked(false);
                    rdOpc3.setChecked(false);
                    rdOpc1.setBackgroundResource(R.drawable.white);
                    rdOpc2.setBackgroundResource(R.drawable.white);
                    rdOpc3.setBackgroundResource(R.drawable.white);
                    rdOpc1.setBackgroundResource(R.drawable.opciones);
                    rdOpc2.setBackgroundResource(R.drawable.opciones);
                    rdOpc3.setBackgroundResource(R.drawable.opciones);
                    if (vidas==0){
                        perder();
                    }
                }
            },2000);
        } else if (NroPregunta == 2) {

            if (rdOpc1.isChecked()) {
                rdOpc1.setBackgroundResource(R.drawable.incorrect);
                vidas--;
                txtvidas.setText(String.valueOf(vidas));
                showDialogbad();
            } else if (rdOpc2.isChecked()) {
                rdOpc2.setBackgroundResource(R.drawable.correct);
                nota = nota + 0.833333;
                showDialog();
            } else if (rdOpc3.isChecked()) {
                rdOpc3.setBackgroundResource(R.drawable.incorrect);
                vidas--;
                txtvidas.setText(String.valueOf(vidas));
                showDialogbad();
            }
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    NroPregunta++;

                    txtNroPregunta.setText("3/6");
                    txtPregunta.setText("¿Qué son instrumentos financieros?");
                    rdOpc1.setText("Es una categoría especifica de productos financieros cuya finalidad son las inversiones de carácter financiero.");
                    rdOpc2.setText("Todo lo que tenga que ver con las finanzas.");
                    rdOpc3.setText("¡todas las anteriores!");
                    rdOpc1.setChecked(false);
                    rdOpc2.setChecked(false);
                    rdOpc3.setChecked(false);
                    rdOpc1.setBackgroundResource(R.drawable.white);
                    rdOpc2.setBackgroundResource(R.drawable.white);
                    rdOpc3.setBackgroundResource(R.drawable.white);
                    rdOpc1.setBackgroundResource(R.drawable.opciones);
                    rdOpc2.setBackgroundResource(R.drawable.opciones);
                    rdOpc3.setBackgroundResource(R.drawable.opciones);

                    if (vidas==0){
                        perder();
                    }
                }
            },2000);

        } else if (NroPregunta == 3) {

            if (rdOpc1.isChecked()) {
                rdOpc1.setBackgroundResource(R.drawable.correct);
                nota = nota + 0.8333333;
                showDialog();
            } else if (rdOpc2.isChecked()) {
                rdOpc2.setBackgroundResource(R.drawable.incorrect);
                vidas--;
                txtvidas.setText(String.valueOf(vidas));
                showDialogbad();
            } else if (rdOpc3.isChecked()) {
                rdOpc3.setBackgroundResource(R.drawable.incorrect);
                vidas--;
                txtvidas.setText(String.valueOf(vidas));
                showDialogbad();
            }
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {

                    NroPregunta++;

                    txtNroPregunta.setText("4/6");
                    txtPregunta.setText("¿Identifique cuáles son instrumentos financieros?");
                    rdOpc1.setText("Bonos, Acciones, participaciones.");
                    rdOpc2.setText("Dinero, créditos, trabajo.");
                    rdOpc3.setText("Ahorro, viajes, ganar.");

                    rdOpc1.setChecked(false);
                    rdOpc2.setChecked(false);
                    rdOpc3.setChecked(false);

                    rdOpc1.setBackgroundResource(R.drawable.white);
                    rdOpc2.setBackgroundResource(R.drawable.white);
                    rdOpc3.setBackgroundResource(R.drawable.white);

                    rdOpc1.setBackgroundResource(R.drawable.opciones);
                    rdOpc2.setBackgroundResource(R.drawable.opciones);
                    rdOpc3.setBackgroundResource(R.drawable.opciones);


                    if (vidas==0){
                        perder();
                    }
                }
            },2000);

        } else if (NroPregunta == 4) {

            if (rdOpc1.isChecked()) {
                rdOpc1.setBackgroundResource(R.drawable.correct);
                nota = nota + 0.83333;
                showDialog();
            } else if (rdOpc2.isChecked()) {
                rdOpc2.setBackgroundResource(R.drawable.incorrect);
                vidas--;
                txtvidas.setText(String.valueOf(vidas));
                showDialogbad();
            } else if (rdOpc3.isChecked()) {
                rdOpc3.setBackgroundResource(R.drawable.incorrect);
                vidas--;
                txtvidas.setText(String.valueOf(vidas));
                showDialogbad();
            }
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {

                    NroPregunta++;
                    txtNroPregunta.setText("5/6");
                    txtPregunta.setText("¿Qué es un bono?");
                    rdOpc1.setText("Multiplicar las ganancias.");
                    rdOpc2.setText("Los bonos del supermercado.");
                    rdOpc3.setText("Es un tipo de préstamo en el que el titular del bono presta dinero a una empresa o al gobierno.");
                    rdOpc1.setChecked(false);
                    rdOpc2.setChecked(false);
                    rdOpc3.setChecked(false);
                    rdOpc1.setBackgroundResource(R.drawable.white);
                    rdOpc2.setBackgroundResource(R.drawable.white);
                    rdOpc3.setBackgroundResource(R.drawable.white);
                    rdOpc1.setBackgroundResource(R.drawable.opciones);
                    rdOpc2.setBackgroundResource(R.drawable.opciones);
                    rdOpc3.setBackgroundResource(R.drawable.opciones);
                    if (vidas==0){
                        perder();
                    }
                }
            },2000);
        } else if (NroPregunta == 5) {
            if (rdOpc1.isChecked()) {
                rdOpc1.setBackgroundResource(R.drawable.incorrect);
                vidas--;
                txtvidas.setText(String.valueOf(vidas));
                showDialogbad();
            } else if (rdOpc2.isChecked()) {
                rdOpc2.setBackgroundResource(R.drawable.incorrect);
                vidas--;
                txtvidas.setText(String.valueOf(vidas));
                showDialogbad();
            } else if (rdOpc3.isChecked()) {
                rdOpc3.setBackgroundResource(R.drawable.correct);
                nota = nota + 0.83333333;
                showDialog();
            }
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {

                    NroPregunta++;
                    txtNroPregunta.setText("6/6");
                    txtPregunta.setText("¿Qué es una acción?");
                    rdOpc1.setText("Una acción para ganar plata.");
                    rdOpc2.setText("Tomar buenas decisiones. ");
                    rdOpc3.setText("Son títulos que representan el capital de una empresa o grupo corporativo.");
                    rdOpc1.setChecked(false);
                    rdOpc2.setChecked(false);
                    rdOpc3.setChecked(false);
                    rdOpc1.setBackgroundResource(R.drawable.white);
                    rdOpc2.setBackgroundResource(R.drawable.white);
                    rdOpc3.setBackgroundResource(R.drawable.white);
                    rdOpc1.setBackgroundResource(R.drawable.opciones);
                    rdOpc2.setBackgroundResource(R.drawable.opciones);
                    rdOpc3.setBackgroundResource(R.drawable.opciones);
                    if (vidas==0){
                        perder();
                    }
                }
            },2000);
        } else if (NroPregunta == 6) {
            if (rdOpc1.isChecked()) {
                rdOpc1.setBackgroundResource(R.drawable.incorrect);
                vidas--;
                txtvidas.setText(String.valueOf(vidas));
                showDialogbad();
            } else if (rdOpc2.isChecked()) {
                rdOpc2.setBackgroundResource(R.drawable.incorrect);
                vidas--;
                txtvidas.setText(String.valueOf(vidas));
                showDialogbad();
            } else if (rdOpc3.isChecked()) {
                rdOpc3.setBackgroundResource(R.drawable.correct);
                nota = nota + 0.8333;
                showDialog();
            }
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (vidas==0){
                        perder();
                    }

                    txtNroPregunta.setText("Nota obtenida: " + nota);


                    if (nota >= 3.0) {

                        txtPregunta.setText("Estado: Aprobado");
                        ircompletado11();

                    } else {

                        txtPregunta.setText("Estado: Reprobado");

                    }

                    rdOpc1.setVisibility(View.GONE);
                    rdOpc2.setVisibility(View.GONE);
                    rdOpc3.setVisibility(View.GONE);
                    txtNroPregunta.setVisibility(View.GONE);
                    txtPregunta.setVisibility(View.GONE);
                    btnSiguiente.setVisibility(View.GONE);
                    btnfinalizar.setVisibility(View.VISIBLE);
                    btnfinalizar.setText("Volver al inicio");
                    vista.setVisibility(View.GONE);
                    titulo.setVisibility(View.GONE);
                    corazon.setVisibility(View.GONE);
                    moneda.setVisibility(View.GONE);
                    txtvidas.setVisibility(View.GONE);
                    txtmonedas.setVisibility(View.GONE);

                }
            },2000);
        }
    }

    private void ircompletado11() {
        Intent intent = new Intent(Cuestionario11Activity.this,Completado11Activity.class);
        intent.putExtra(LlaveVida,vidas);
        intent.putExtra(LlaveDinero,dinero);
        startActivity(intent);
        finish();
    }

    public void Salir(View v) {
        Intent intent = new Intent(Cuestionario11Activity.this,InicioActivity.class);
        intent.putExtra(LlaveVida,vidas);
        intent.putExtra(LlaveDinero,dinero);
        startActivity(intent);
        finish();
    }
    private void Irinicio() {
        Intent intent = new Intent(Cuestionario11Activity.this,InicioActivity.class);
        intent.putExtra(LlaveVida,vidas);
        intent.putExtra(LlaveDinero,dinero);
        startActivity(intent);
        finish();
    }
    private void perder() {
        txtNroPregunta.setVisibility(View.GONE);
        txtPregunta.setText("Estado: Reprobado, Perdiste todas tus vidas!");
        rdOpc1.setVisibility(View.GONE);
        rdOpc2.setVisibility(View.GONE);
        rdOpc3.setVisibility(View.GONE);
        btnSiguiente.setVisibility(View.GONE);
        showDialogperdio();
    }
    private void showDialog() {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.menucorrect);
        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);
        Button = dialog.findViewById(R.id.button2);
        Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.hide();
            }
        });
    }
    private void showDialogbad() {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.menu2);
        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);
        Button = dialog.findViewById(R.id.button2);
        Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.hide();
            }
        });

    }
    private void showDialogperdio() {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.menu3);
        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);
        Button = dialog.findViewById(R.id.button2);
        Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.hide();
                Irinicio();
            }
        });

    }
}
