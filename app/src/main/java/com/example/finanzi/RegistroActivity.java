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

import android.view.View.OnClickListener;
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

                if(correo.isEmpty()||clave.isEmpty()||confirmarclave.isEmpty()||nombre.isEmpty()||apellido.isEmpty()){
                    txtrespuestaR.setText("Ingrese los datos solicitados");
                    Toast.makeText(RegistroActivity.this, "Ingrese los datos solicitados", Toast.LENGTH_SHORT).show();
                    txtrespuestaR.setTextColor(Color.RED);
                    txtrespuestaR.setVisibility(View.VISIBLE);
                }else if(!correo.isEmpty()&&!clave.isEmpty()&&!confirmarclave.isEmpty()&&!nombre.isEmpty()&&!apellido.isEmpty()){
                    if(emailValido(correo)){
                        if(clave.equals(confirmarclave)){
                            if(confirmarclave.length()>6){
                                if(mterminos.isChecked()) {
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
                                }else{
                                    txtrespuestaR.setText("No aceptaste los terminos y condiciones");
                                    txtrespuestaR.setTextColor(Color.RED);
                                    txtrespuestaR.setVisibility(View.VISIBLE);
                                }
                            }else{
                                txtrespuestaR.setText("Contraseña muy corta");
                                txtrespuestaR.setTextColor(Color.RED);
                                txtrespuestaR.setVisibility(View.VISIBLE);
                            }
                        }else{
                            txtrespuestaR.setText("Las contraseñas no coinciden");
                            txtrespuestaR.setTextColor(Color.RED);
                            txtrespuestaR.setVisibility(View.VISIBLE);
                        }
                    }else{
                        txtrespuestaR.setText("Ingrese un correo valido");
                        txtrespuestaR.setTextColor(Color.RED);
                        txtrespuestaR.setVisibility(View.VISIBLE);
                    }
                }
            }
        });

    }


    private boolean emailValido(String correo){
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(correo);
        return matcher.matches();
    }
    private void irMain() {
        Intent intent = new Intent(RegistroActivity.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}