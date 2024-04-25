package com.example.finanzi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegistroActivity extends AppCompatActivity {

    EditText mnonbres;
    EditText mapellidos;
    EditText meditTextCorreoR;
    EditText meditcontraseñaR;
    EditText meditCcontraseñaR;
    Button mbtnregistrar;
    TextView txtrespuestaR;
    FirebaseAuth mAuth;
    FirebaseFirestore firestore;
    RadioButton mterminos;
    private String correo,clave,confirmarclave,nombre,apellido;
    public static String mensaje;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        mnonbres = findViewById(R.id.txtnombre);
        mapellidos = findViewById(R.id.txtapellido);
        meditTextCorreoR = findViewById(R.id.EditcorreoR);
        meditcontraseñaR = findViewById(R.id.EditcontraseñaR);
        meditCcontraseñaR = findViewById(R.id.EditCcontraseñaR);
        mbtnregistrar = findViewById(R.id.Btnregistrar);
        txtrespuestaR = findViewById(R.id.txtrespuestaR);
        mAuth = FirebaseAuth.getInstance();
        mterminos = findViewById(R.id.btnTerminos);

        mbtnregistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nombre = mnonbres.getText().toString().trim();
                apellido = mapellidos.getText().toString().trim();
                correo = meditTextCorreoR.getText().toString().trim();
                clave = meditcontraseñaR.getText().toString().trim();
                confirmarclave = meditCcontraseñaR.getText().toString().trim();

                if((campoVacio(correo)||campoVacio(clave)||campoVacio(confirmarclave)||campoVacio(nombre)
                        ||campoVacio(apellido))&& (verificarNombre(nombre) && verificarNombre(apellido))
                        && emailValido(correo) && verificarClaves(clave,confirmarclave) && verificarTerminos(mterminos)){
                    txtrespuestaR.setText(mensaje);
                    Toast.makeText(RegistroActivity.this, "Ingrese los datos solicitados", Toast.LENGTH_SHORT).show();
                    txtrespuestaR.setTextColor(Color.RED);
                    txtrespuestaR.setVisibility(View.VISIBLE);
                }else if(!correo.isEmpty()&&!clave.isEmpty()&&!confirmarclave.isEmpty()&&!nombre.isEmpty()&&!apellido.isEmpty()){
                    mAuth.createUserWithEmailAndPassword(correo, confirmarclave).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                txtrespuestaR.setText("Se crreo la cuenta correctamente");
                                txtrespuestaR.setTextColor(Color.BLUE);
                                txtrespuestaR.setVisibility(View.VISIBLE);
                                irMain();
                            } else {
                                txtrespuestaR.setText("La cuenta ya existe");
                                txtrespuestaR.setTextColor(Color.RED);
                                txtrespuestaR.setVisibility(View.VISIBLE);
                            }
                        }
                    });
                }
            }
        });
    }


    public static boolean emailValido(String correo){
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(correo);
        if(!matcher.matches()){
            mensaje += " Ingrese un correo valido";
        }
        return matcher.matches();
    }
    public static boolean verificarNombre(String cadena) {
        if (cadena == null || cadena.isEmpty()) {
            mensaje += " El Nombre y apellido no pueden tener numeros ni caracteres especiales.";
            return false;
        }
        for (char c : cadena.toCharArray()) {
            if (!Character.isLetter(c) && !Character.isWhitespace(c)) {
                return false;
            }
        }
        return true;
    }
    private void irMain() {
        Intent intent = new Intent(RegistroActivity.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
    public static boolean campoVacio(String campo){
        if(campo.isEmpty()){
            mensaje += " Ingrese el correo y la contraseña";
            return false;
        }else {
            return true;
        }
    }
    public static boolean verificarClaves(String contra,String verfiContra){
        if(contra.equals(verfiContra)){
            if(contra.length()>6){
                return true;
            }else{
                mensaje += " Contraseñas muy cortas";
                return false;
            }
        }else {
            mensaje += " Las contraseñas no coinciden";
            return false;
        }
    }
    public boolean verificarTerminos(RadioButton radio){
        if(radio.isChecked()){
            return true;
        }else{
            mensaje += " No aceptaste los terminos y condiciones";
            return false;
        }
    }
}