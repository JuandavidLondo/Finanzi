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

public class Cuestionario15Activity extends AppCompatActivity {

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
        setContentView(R.layout.activity_cuestionario15);

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
        txtNroPregunta.setText("1/7");
        txtPregunta.setText("¿Qué es un crédito comercial?");
        rdOpc1.setText("Ganar dinero.");
        rdOpc2.setText("Son los créditos otorgados a los asociados que sean personas naturales o jurídicas para el desarrollo de acciones económicas organizadas.");
        rdOpc3.setText("Comercializar más.");


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
                rdOpc1.setBackgroundResource(R.drawable.incorrect);
                vidas--;
                txtvidas.setText(String.valueOf(vidas));
                showDialogbad();
            } else if (rdOpc2.isChecked()) {
                rdOpc2.setBackgroundResource(R.drawable.correct);
                nota = nota + 0.83333333;
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
                    txtNroPregunta.setText("2/7");
                    txtPregunta.setText("¿Qué es un crédito de consumo?");
                    rdOpc1.setText("Este está predestinado a financiar la adquisición de varios bienes o servicios, como por ejemplo adquirir un electrodoméstico.");
                    rdOpc2.setText("Consumir más de la cuenta.");
                    rdOpc3.setText("Ninguna de las anteriores.");
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

                    txtNroPregunta.setText("3/7");
                    txtPregunta.setText("¿Qué es un microcrédito?");
                    rdOpc1.setText("Es lo contrario a un crédito.");
                    rdOpc2.setText("No existe");
                    rdOpc3.setText("Es un préstamo que se hace a una persona o un grupo de personas que puedan desplegar algún proyecto, por ejemplo, una tienda o un restaurante pequeño.");
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
                nota = nota + 0.833333;
                showDialog();
            }
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {

                    NroPregunta++;

                    txtNroPregunta.setText("4/7");
                    txtPregunta.setText("¿Qué es un Crédito garantizado?");
                    rdOpc1.setText("Mantener el mismo crédito.");
                    rdOpc2.setText("Es un crédito que otorgan las entidades con garantía real, ya sea a través de hipoteca, prenda, caución bursátil, fideicomiso de garantía o cualquier otra forma.");
                    rdOpc3.setText("Que si o si te dan un crédito.");

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
                rdOpc2.setBackgroundResource(R.drawable.incorrect);
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
                    txtNroPregunta.setText("5/7");
                    txtPregunta.setText("¿Qué es un crédito personal?");
                    rdOpc1.setText("Nadie mas sabe sobre ese crédito. ");
                    rdOpc2.setText("Es una línea de crédito que ayuda a financiar proyectos a largo plazo, garantizando liquidez con cuota y tasa fija.");
                    rdOpc3.setText("Que es de una sola persona.");
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
                rdOpc2.setBackgroundResource(R.drawable.correct);
                nota = nota + 0.83333333;
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
                    txtNroPregunta.setText("6/7");
                    txtPregunta.setText("¿Qué es un crédito hipotecario?");
                    rdOpc1.setText("Es una alternativa de crédito donde la persona natural puede cumplir la meta de una casa propia, a través de un préstamo a largo plazo.");
                    rdOpc2.setText("Vender productos.");
                    rdOpc3.setText("Todos los créditos hacen lo mismo.");
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
                rdOpc1.setBackgroundResource(R.drawable.correct);
                nota = nota + 0.83333333;
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
                    txtNroPregunta.setText("7/7");
                    txtPregunta.setText("¿Qué es un crédito rotativo?");
                    rdOpc1.setText("No existe.");
                    rdOpc2.setText("Que va cambiando con el tiempo.");
                    rdOpc3.setText("Producto financiero de consumo que se puede comparar con una tarjeta de crédito, dado que a medida que se va cancelando la deuda se va liberando el cupo de crédito.");
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
        } else if (NroPregunta == 7) {
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
                    if (vidas==0){
                        perder();
                    }

                    txtNroPregunta.setText("Nota obtenida: " + nota);


                    if (nota >= 3.0) {

                        txtPregunta.setText("Estado: Aprobado");
                        ircompletado15();

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

    private void ircompletado15() {
        Intent intent = new Intent(Cuestionario15Activity.this,Completado15Activity.class);
        intent.putExtra(LlaveVida,vidas);
        intent.putExtra(LlaveDinero,dinero);
        startActivity(intent);
        finish();
    }

    public void Salir(View v) {
        Intent intent = new Intent(Cuestionario15Activity.this,InicioActivity.class);
        intent.putExtra(LlaveVida,vidas);
        intent.putExtra(LlaveDinero,dinero);
        startActivity(intent);
        finish();
    }
    private void Irinicio() {
        Intent intent = new Intent(Cuestionario15Activity.this,InicioActivity.class);
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
