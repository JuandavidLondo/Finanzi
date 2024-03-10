package com.example.finanzi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MainActivity extends AppCompatActivity {
    private static final int RC_SIGN_IN = 1;
    GoogleSignInClient mGoogleSignInClient;
    FirebaseAuth mAuth;
    Button mSignInButtonGoogle;
    TextView mTextViewRespuesta;
    EditText mcorreo;
    EditText mcontraseña;
    TextView molvicontra;
    Button mbtniniciar;
    TextView mbtnCrear;
    private String Correo;
    private String Contraseña;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Theme_Finanzi);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
        mSignInButtonGoogle = findViewById(R.id.btnGoogle);
        mTextViewRespuesta = findViewById(R.id.textViewRespuesta);
        mcorreo = findViewById(R.id.Editcorreo);
        mcontraseña = findViewById(R.id.Editcontraseña);
        mbtniniciar = findViewById(R.id.BtniniciarCorreo);
        mbtnCrear = findViewById(R.id.txtclickCrearcuenta);

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        mSignInButtonGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signIn();
            }
        });
        mbtnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                irRegistro();
            }
        });
        mbtniniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Correo = mcorreo.getText().toString().trim();
                Contraseña = mcontraseña.getText().toString().trim();
                if(Correo.isEmpty()||Contraseña.isEmpty()){
                    mTextViewRespuesta.setText("Ingrese el correo y la contraseña");
                    mTextViewRespuesta.setTextColor(Color.RED);
                    mTextViewRespuesta.setVisibility(View.VISIBLE);
                }else{
                    if(emailValido(Correo)){
                        mAuth.signInWithEmailAndPassword(Correo,Contraseña).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    mTextViewRespuesta.setText("Inicio Correcto");
                                    mTextViewRespuesta.setTextColor(Color.BLUE);
                                    mTextViewRespuesta.setVisibility(View.VISIBLE);
                                    irHome();
                                }else{
                                    mTextViewRespuesta.setText("Credenciales Incorrectas");
                                    mTextViewRespuesta.setTextColor(Color.RED);
                                    mTextViewRespuesta.setVisibility(View.VISIBLE);
                                }
                            }
                        });
                    }else{
                        mTextViewRespuesta.setText("Correo no valido");
                        mTextViewRespuesta.setTextColor(Color.RED);
                        mTextViewRespuesta.setVisibility(View.VISIBLE);
                    }
                }
            }
        });
    }
    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = task.getResult(ApiException.class);
                firebaseAuthWithGoogle(account.getIdToken());
            } catch (ApiException e) {
                // Google Sign In failed, update UI appropriately
                mTextViewRespuesta.setText(e.getMessage());
                mTextViewRespuesta.setVisibility(View.VISIBLE);
            }
        }
    }

    private void firebaseAuthWithGoogle(String idToken) {
        AuthCredential credential = GoogleAuthProvider.getCredential(idToken, null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information

                            irHome();
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            mTextViewRespuesta.setText(task.getException().toString());
                            updateUI(null);
                        }
                    }
                });
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }
    private void updateUI(FirebaseUser user) {
        user = mAuth.getCurrentUser();
        if (user != null){
            irHome();
        }
    }
    private void irRegistro() {
        Intent intent = new Intent(MainActivity.this,RegistroActivity.class);
        startActivity(intent);
        finish();
    }

    private void irHome() {
        Intent intent = new Intent(MainActivity.this,InicioActivity.class);
        startActivity(intent);
        finish();
    }
    private boolean emailValido(String correo){
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(correo);
        return matcher.matches();
    }


}