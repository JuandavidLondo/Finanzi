package com.example.finanzi;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class InicioActivity extends AppCompatActivity {
    public Boolean completado,completado2,completado3,completado4,completado5,completado6,completado7;
    public Boolean completado8,completado9,completado10,completado11,completado12,completado13,completado14;
    public Boolean completado15,completado16,completado17;
    public static final String LlaveVida="LLavevida";
    public static final String LLaveDinero="Llavedinero";
    MeowBottomNavigation bn_Main;

    FirebaseAuth mAuth;
    TextView Dinero, Vidas;
    Button Button;

    int vidas,monedas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        mAuth = FirebaseAuth.getInstance();
        Dinero = findViewById(R.id.Dinero);
        Vidas = findViewById(R.id.vidas);



        bn_Main = findViewById(R.id.bn_Main);
        bn_Main.add(new MeowBottomNavigation.Model(1, R.drawable.hogar_color));
        bn_Main.add(new MeowBottomNavigation.Model(2, R.drawable.tienda_color));
        bn_Main.add(new MeowBottomNavigation.Model(3, R.drawable.grafico_color));
        bn_Main.add(new MeowBottomNavigation.Model(4, R.drawable.usuario_color));

        Intent intent = getIntent();
        monedas=intent.getIntExtra(CompletadoActivity.LLaveDinero,10);
        vidas = intent.getIntExtra(CompletadoActivity.LlaveVida,3);
        completado = intent.getBooleanExtra(CompletadoActivity.Llave,false);
        completado2 = intent.getBooleanExtra(Completado2Activity.Llave2,false);
        completado3 = intent.getBooleanExtra(Completado3Activity.Llave3,false);
        completado4 = intent.getBooleanExtra(Completado4Activity.Llave4,false);
        completado5 = intent.getBooleanExtra(Completado5Activity.Llave5,false);
        completado6 = intent.getBooleanExtra(Completado6Activity.Llave6,false);
        completado7 = intent.getBooleanExtra(Completado7Activity.Llave7,false);
        completado8 = intent.getBooleanExtra(Completado8Activity.Llave8,false);
        completado9 = intent.getBooleanExtra(Completado9Activity.Llave9,false);
        completado10 = intent.getBooleanExtra(Completado10Activity.Llave10,false);
        completado11 = intent.getBooleanExtra(Completado11Activity.Llave11,false);
        completado12 = intent.getBooleanExtra(Completado12Activity.Llave12,false);
        completado13 = intent.getBooleanExtra(Completado13Activity.Llave13,false);
        completado14 = intent.getBooleanExtra(Completado14Activity.Llave14,false);
        completado15 = intent.getBooleanExtra(Completado15Activity.Llave15,false);
        completado16=false;
        completado17=false;
        Dinero.setText(String.valueOf(monedas));
        Vidas.setText(String.valueOf(vidas));

        bn_Main.setOnShowListener(new MeowBottomNavigation.ShowListener() {
            @Override
            public void onShowItem(MeowBottomNavigation.Model item) {
                Fragment fragment = null;
                if(item.getId()==1){
                    fragment = new HomeFragment();
                }else if(item.getId()==2){
                    fragment = new TiendaFragment();
                }else if (item.getId()==3){
                    fragment = new EstadisticasFragment();
                }else if (item.getId()==4){
                    fragment = new PerfilFragment();
                }
                loadFragment(fragment);
            }
        });
        bn_Main.show(1,true);

        bn_Main.setOnClickMenuListener(new MeowBottomNavigation.ClickListener() {
            @Override
            public void onClickItem(MeowBottomNavigation.Model item) {
                Toast.makeText(getApplicationContext(),"seleccionaste "+item.getId(),Toast.LENGTH_SHORT).show();
            }
        });

        bn_Main.setOnReselectListener(new MeowBottomNavigation.ReselectListener() {
            @Override
            public void onReselectItem(MeowBottomNavigation.Model item) {
                Toast.makeText(getApplicationContext(),"Volviste a selecionar "+item.getId(),Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.FragmentView,fragment,null)
                .commit();
    }
    private void irMain() {
        Intent intent = new Intent(InicioActivity.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
    public void editprof(){
        Intent intent = new Intent(InicioActivity.this,EditPerActivity.class);
        startActivity(intent);
    }
    public void onStart(){
        super.onStart();
        FirebaseUser user = mAuth.getCurrentUser();
        if (user == null){
            irMain();
        }
    }
    public void logout() {
        mAuth.signOut();
        irMain();
    }

    public void ircuestionario1() {
        Intent intent = new Intent(InicioActivity.this,CuestionarioActivity.class);
        intent.putExtra(LlaveVida,vidas);
        intent.putExtra(LLaveDinero,monedas);
        startActivity(intent);

    }
    public void ircuestionario2() {
        Intent intent = new Intent(InicioActivity.this,Cuestionario2Activity.class);
        intent.putExtra(LlaveVida,vidas);
        intent.putExtra(LLaveDinero,monedas);
        startActivity(intent);

    }
    public void ircuestionario3() {
        Intent intent = new Intent(InicioActivity.this,Cuestionario3Activity.class);
        intent.putExtra(LlaveVida,vidas);
        intent.putExtra(LLaveDinero,monedas);
        startActivity(intent);

    }
    public void ircuestionario4() {
        Intent intent = new Intent(InicioActivity.this,Cuestionario4Activity.class);
        intent.putExtra(LlaveVida,vidas);
        intent.putExtra(LLaveDinero,monedas);
        startActivity(intent);

    }
    public void ircuestionario5() {
        Intent intent = new Intent(InicioActivity.this,Cuestionario5Activity.class);
        intent.putExtra(LlaveVida,vidas);
        intent.putExtra(LLaveDinero,monedas);
        startActivity(intent);

    }
    public void ircuestionario6() {
        Intent intent = new Intent(InicioActivity.this,Cuestionario6Activity.class);
        intent.putExtra(LlaveVida,vidas);
        intent.putExtra(LLaveDinero,monedas);
        startActivity(intent);
        finish();
    }
    public void ircuestionario7() {
        Intent intent = new Intent(InicioActivity.this,Cuestionario7Activity.class);
        intent.putExtra(LlaveVida,vidas);
        intent.putExtra(LLaveDinero,monedas);
        startActivity(intent);
        finish();
    }
    public void ircuestionario8() {
        Intent intent = new Intent(InicioActivity.this,Cuestionario8Activity.class);
        intent.putExtra(LlaveVida,vidas);
        intent.putExtra(LLaveDinero,monedas);
        startActivity(intent);
        finish();
    }
    public void ircuestionario9() {
        Intent intent = new Intent(InicioActivity.this,Cuestionario9Activity.class);
        intent.putExtra(LlaveVida,vidas);
        intent.putExtra(LLaveDinero,monedas);
        startActivity(intent);

    }
    public void ircuestionario10() {
        Intent intent = new Intent(InicioActivity.this,Cuestionario10Activity.class);
        intent.putExtra(LlaveVida,vidas);
        intent.putExtra(LLaveDinero,monedas);
        startActivity(intent);

    }
    public void ircuestionario11() {
        Intent intent = new Intent(InicioActivity.this,Cuestionario11Activity.class);
        intent.putExtra(LlaveVida,vidas);
        intent.putExtra(LLaveDinero,monedas);
        startActivity(intent);

    }
    public void ircuestionario12() {
        Intent intent = new Intent(InicioActivity.this,Cuestionario12Activity.class);
        intent.putExtra(LlaveVida,vidas);
        intent.putExtra(LLaveDinero,monedas);
        startActivity(intent);

    }
    public void ircuestionario13() {
        Intent intent = new Intent(InicioActivity.this,Cuestionario13Activity.class);
        intent.putExtra(LlaveVida,vidas);
        intent.putExtra(LLaveDinero,monedas);
        startActivity(intent);
    }
    public void ircuestionario14() {
        Intent intent = new Intent(InicioActivity.this,Cuestionario14Activity.class);
        intent.putExtra(LlaveVida,vidas);
        intent.putExtra(LLaveDinero,monedas);
        startActivity(intent);

    }
    public void ircuestionario15() {
        Intent intent = new Intent(InicioActivity.this,Cuestionario15Activity.class);
        intent.putExtra(LlaveVida,vidas);
        intent.putExtra(LLaveDinero,monedas);
        startActivity(intent);

    }
    public void ircuestionario16() {
        Intent intent = new Intent(InicioActivity.this,CuestionarioActivity.class);
        intent.putExtra(LlaveVida,vidas);
        intent.putExtra(LLaveDinero,monedas);
        startActivity(intent);

    }
    public void ircuestionario17() {
        Intent intent = new Intent(InicioActivity.this,CuestionarioActivity.class);
        intent.putExtra(LlaveVida,vidas);
        intent.putExtra(LLaveDinero,monedas);
        startActivity(intent);

    }
    public void Comprar1(){
        if (monedas<5){
            showDialogSinM();
        }else if(vidas == 3){
            showDialogfullV();
        }else{
            vidas ++;
            monedas -= 5;
            Dinero.setText(String.valueOf(monedas));
            Vidas.setText(String.valueOf(vidas));
        }
    }
    public void Comprar3(){
        if (monedas<12){
            showDialogSinM();
        }else if(vidas > 0){
            showDialogfullV();
        }else{
            vidas +=3;
            monedas -= 12;
            Dinero.setText(String.valueOf(monedas));
            Vidas.setText(String.valueOf(vidas));
        }
    }
    private void showDialogSinM() {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.menu4);
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
    private void showDialogfullV() {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.menu5);
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

}