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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Cuestionario2Activity extends AppCompatActivity {

    RadioButton rdOpc1, rdOpc2, rdOpc3;
    TextView txtNroPregunta, txtPregunta,txtvidas,txtmonedas;
    Button btnSiguiente, btnSalir,btnfinalizar,Button,compra;
    RadioGroup grupo;


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
        setContentView(R.layout.activity_cuestionario);

        //Se le asigna a cada objeto el id de lo que va a usar
        rdOpc1 = (RadioButton) findViewById(R.id.rdBtnOpc1);
        rdOpc2 = (RadioButton) findViewById(R.id.rdBtnOpc2);
        rdOpc3 = (RadioButton) findViewById(R.id.rdBtnOpc3);
        grupo = findViewById(R.id.radioGroup);

        txtNroPregunta = (TextView) findViewById(R.id.txtNroPregunta);
        txtPregunta = (TextView) findViewById(R.id.txtPregunta);
        txtvidas=(TextView) findViewById(R.id.txtvidas);
        txtmonedas=(TextView) findViewById(R.id.txtmonedas);

        btnSiguiente = (Button) findViewById(R.id.btnSiguiente);
        btnSalir = (Button) findViewById(R.id.btnSalir);
        btnfinalizar =(Button) findViewById(R.id.btnfinalizar);
        Intent intent=getIntent();
        vidas=intent.getIntExtra(InicioActivity.LlaveVida,3);
        dinero = intent.getIntExtra(InicioActivity.LLaveDinero,10);

        btnfinalizar.setVisibility(View.GONE);
        txtvidas.setText(String.valueOf(vidas));
        txtmonedas.setText(String.valueOf(dinero));
        txtNroPregunta.setText("1/5");
        txtPregunta.setText("¿Qué es un fondo de emergencia?");
        rdOpc1.setText("Dinero para incendios");
        rdOpc2.setText("es el porcentaje de los ingresos que la persona no gasta, con el propósito de contar con recursos económicos para un desembolso que podría efectuarse más adelante");
        rdOpc3.setText("Es un monto de dinero que se tiene ahorrado por si en algún momento surge un imprevisto o un gasto importante que no se tenía en el presupuesto");


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
                rdOpc2.setBackgroundResource(R.drawable.incorrect);
                vidas--;
                txtvidas.setText(String.valueOf(vidas));
                showDialogbad();
            } else if (rdOpc3.isChecked()) {
                rdOpc3.setBackgroundResource(R.drawable.correct);
                nota = nota + 1;
                showDialog();
            }
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {

                    NroPregunta++;
                    txtNroPregunta.setText("2/6");
                    txtPregunta.setText("¿Cuáles son algunos ejemplos para fondos de emergencia?");
                    rdOpc1.setText("Hay una fuga de agua en tu hogar, te ponen una multa, se daña el televisor, Se estalla una llanta.");
                    rdOpc2.setText("Dinero para compara dulces y juguetes nuevos.");
                    rdOpc3.setText("Ir al cine e invitar a todos los amigos.");
                    rdOpc1.setChecked(false);
                    rdOpc2.setChecked(false);
                    rdOpc3.setChecked(false);
                    rdOpc1.setBackgroundResource(R.drawable.white);
                    rdOpc2.setBackgroundResource(R.drawable.white);
                    rdOpc3.setBackgroundResource(R.drawable.white);
                    grupo.clearCheck();
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
                nota = nota + 1;
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

                    txtNroPregunta.setText("3/5");
                    txtPregunta.setText("¿Qué estudian las finanzas?");
                    rdOpc1.setText("La forma de desarollar documentos sobre los arboles");
                    rdOpc2.setText("Cerdo");
                    rdOpc3.setText("Estudia los mercados de dinero, la obtención de recursos, formas de ahorro e inversión.");
                    rdOpc1.setChecked(false);
                    rdOpc2.setChecked(false);
                    rdOpc3.setChecked(false);
                    grupo.clearCheck();
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
                nota = nota + 1;
                showDialog();
            }
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {


                    NroPregunta++;


                    txtNroPregunta.setText("4/5");
                    txtPregunta.setText("¿Cuál es la importancia de las finanzas?");
                    rdOpc1.setText("Tomar decisiones serias.");
                    rdOpc2.setText("Gestionar la liquidez de la empresa. Administrar deudas. Aumentar el rendimiento de capital");
                    rdOpc3.setText("Son una rama de la economía que tiene que ver con cómo se obtiene y gestiona el dinero");

                    rdOpc1.setChecked(false);
                    rdOpc2.setChecked(false);
                    rdOpc3.setChecked(false);
                    grupo.clearCheck();

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
                rdOpc1.setBackgroundResource(R.drawable.incorrect);
                vidas--;
                txtvidas.setText(String.valueOf(vidas));
                showDialogbad();
            } else if (rdOpc2.isChecked()) {
                rdOpc2.setBackgroundResource(R.drawable.correct);
                nota = nota + 1;
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
                    txtNroPregunta.setText("5/5");
                    txtPregunta.setText("¿Qué son las finanzas?");
                    rdOpc1.setText("Son una rama de la economía que tiene que ver con cómo se obtiene y gestiona el dinero.");
                    rdOpc2.setText("c.\tEs el porcentaje de los ingresos que la persona no gasta, con el propósito de contar con recursos económicos para un desembolso que podría efectuarse más adelante.");
                    rdOpc3.setText("Es lo que se da o se recibe generalmente por la compra o la venta de artículos, servicios u otras cosas.");
                    rdOpc1.setChecked(false);
                    rdOpc2.setChecked(false);
                    rdOpc3.setChecked(false);
                    grupo.clearCheck();
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
                rdOpc1.setBackgroundResource(R.drawable.correct);
                nota = nota + 1;
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
                    if (vidas==0){
                        perder();
                    }

                    txtNroPregunta.setText("Nota obtenida: " + nota);


                    if (nota >= 3.0) {
                        txtPregunta.setText("Estado: Aprobado");
                        ircompletado2();

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
                }
            },2000);
        }
    }
    private void ircompletado2() {
        Intent intent = new Intent(Cuestionario2Activity.this,Completado2Activity.class);
        intent.putExtra(LlaveVida,vidas);
        intent.putExtra(LlaveDinero,dinero);
        startActivity(intent);
        finish();
    }
    public void Salir(View v) {
        Intent intent = new Intent(Cuestionario2Activity.this,InicioActivity.class);
        intent.putExtra(LlaveVida,vidas);
        intent.putExtra(LlaveDinero,dinero);
        startActivity(intent);
        finish();
    }
    private void Irinicio() {
        Intent intent = new Intent(Cuestionario2Activity.this,InicioActivity.class);
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
        compra = dialog.findViewById(R.id.button3);
        compra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dinero = dinero - 5;
                vidas = vidas + 1;
                dialog.hide();
            }
        });
        Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.hide();
                Irinicio();
            }
        });

    }
}