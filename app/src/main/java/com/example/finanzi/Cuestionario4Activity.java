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
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Cuestionario4Activity extends AppCompatActivity {

    RadioButton rdOpc1, rdOpc2, rdOpc3;
    TextView txtNroPregunta, txtPregunta,txtvidas,txtmonedas;
    Button btnSiguiente, btnSalir,btnfinalizar,Button,compra;
    ImageView completado;
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
        setContentView(R.layout.activity_cuestionario4);

        //Se le asigna a cada objeto el id de lo que va a usar
        rdOpc1 = (RadioButton) findViewById(R.id.rdBtnOpc1);
        rdOpc2 = (RadioButton) findViewById(R.id.rdBtnOpc2);
        rdOpc3 = (RadioButton) findViewById(R.id.rdBtnOpc3);
        grupo = findViewById(R.id.radioGroup);

        txtNroPregunta = (TextView) findViewById(R.id.txtNroPregunta);
        txtPregunta = (TextView) findViewById(R.id.txtPregunta);
        txtvidas=(TextView) findViewById(R.id.txtvidas);

        btnSiguiente = (Button) findViewById(R.id.btnSiguiente);
        btnSalir = (Button) findViewById(R.id.btnSalir);
        btnfinalizar =(Button) findViewById(R.id.btnfinalizar);
        txtmonedas= (TextView) findViewById(R.id.txtmonedas);
        Intent intent=getIntent();
        vidas=intent.getIntExtra(InicioActivity.LlaveVida,3);
        dinero = intent.getIntExtra(InicioActivity.LLaveDinero,10);

        btnfinalizar.setVisibility(View.GONE);
        txtvidas.setText(String.valueOf(vidas));
        txtmonedas.setText(String.valueOf(dinero));
        txtNroPregunta.setText("1/5");
        txtPregunta.setText("¿Qué mide el IPC?");
        rdOpc1.setText("Mide la evolución del costo promedio de una canasta de bienes y servicios representativa del consumo final de los hogares, expresado en relación con un período base.");
        rdOpc2.setText("Mide todo lo que tenga que ver con gastos.");
        rdOpc3.setText("¡Todas las anteriores!");


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
                    txtNroPregunta.setText("2/5");
                    txtPregunta.setText("¿Qué significan las siglas PIB?");
                    rdOpc1.setText("Pulpo, iguana, burro.");
                    rdOpc2.setText("Producto Interno Bruto.");
                    rdOpc3.setText("Personas inteligentes buenas.");
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
        } else if (NroPregunta == 2) {
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

                    txtNroPregunta.setText("3/5");
                    txtPregunta.setText("¿Qué mide el PIB?");
                    rdOpc1.setText("Medir cuantas monedas hay en el país.");
                    rdOpc2.setText("PIB mide el valor monetario de los bienes y servicios finales, es decir, los que adquiere el consumidor final producidos por un país en un período determinado.");
                    rdOpc3.setText("Ninguna de las anteriores.");
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

                    txtNroPregunta.setText("4/5");
                    txtPregunta.setText("¿Qué es un impuesto?");
                    rdOpc1.setText("Comprar propiedades.");
                    rdOpc2.setText("Cobrar dinero.");
                    rdOpc3.setText("Son tributos que las personas y empresas pagan al Estado con la finalidad de cubrir los gastos públicos y obtener fuentes de financiamiento para mejorar la calidad de vida de la población.");
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
                    txtNroPregunta.setText("5/5");
                    txtPregunta.setText("¿Qué es la tasa de intervención?");
                    rdOpc1.setText("Una tasa de té que se toma mientras se habla.");
                    rdOpc2.setText("Tasa de interés mínima que le cobra el Banco de la República a las entidades financieras por la liquidez que les suministra");
                    rdOpc3.setText("Ninguna de las anteriores.");
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
            }new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (vidas==0){
                        perder();
                    }

                    txtNroPregunta.setText("Nota obtenida: " + nota);


                    if (nota >= 3.0) {
                        ircompletado4();
                        txtPregunta.setText("Estado: Aprobado");

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
    private void ircompletado4() {
        Intent intent = new Intent(Cuestionario4Activity.this,Completado4Activity.class);
        intent.putExtra(LlaveVida,vidas);
        intent.putExtra(LlaveDinero,dinero);
        startActivity(intent);
        finish();
    }
    public void Salir(View v) {
        Intent intent = new Intent(Cuestionario4Activity.this,InicioActivity.class);
        intent.putExtra(LlaveVida,vidas);
        intent.putExtra(LlaveDinero,dinero);
        startActivity(intent);
        finish();
    }
    private void Irinicio() {
        Intent intent = new Intent(Cuestionario4Activity.this,InicioActivity.class);
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
