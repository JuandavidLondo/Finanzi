package com.example.finanzi;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;



import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();

        return fragment;
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    private InicioActivity inicioActivity;
    public void onAttach(Context context) {
        super.onAttach(context);
        inicioActivity = (InicioActivity) context;
    }
    Boolean comple1,comple2,comple3,comple4,comple5,comple6,comple7,comple8,comple9,comple10;
    Boolean comple11,comple12,comple13,comple14,comple15,comple16;
    ImageButton nivel1,nivel2,nivel3,nivel4,nivel5,nivel6,nivel7,nivel8,nivel9,nivel10;
    ImageButton nivel11,nivel12,nivel13,nivel14,nivel15,nivel16,nivel17;
    RelativeLayout seccion1,seccion2,seccion3,seccion4,seccion5,seccion6,seccion7,seccion8,seccion9;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        nivel1 = root.findViewById(R.id.firstlevel);
        nivel2 = root.findViewById(R.id.secondlevel);
        nivel3 = root.findViewById(R.id.firstlevel2);
        nivel4 = root.findViewById(R.id.secondlevel2);
        nivel5 = root.findViewById(R.id.firstlevel3);
        nivel6 = root.findViewById(R.id.secondlevel3);
        nivel7 = root.findViewById(R.id.firstlevel4);
        nivel8 = root.findViewById(R.id.secondlevel4);
        nivel9 = root.findViewById(R.id.firstlevel5);
        nivel10 = root.findViewById(R.id.firstlevel6);
        nivel11 = root.findViewById(R.id.secondlevel6);
        nivel12 = root.findViewById(R.id.firstlevel7);
        nivel13 = root.findViewById(R.id.secondlevel7);
        nivel14 = root.findViewById(R.id.firstlevel8);
        nivel15 = root.findViewById(R.id.secondlevel8);
        nivel16 = root.findViewById(R.id.firstlevel9);
        nivel17 = root.findViewById(R.id.secondlevel9);
        seccion2=root.findViewById(R.id.seccion2);
        seccion3=root.findViewById(R.id.seccion3);
        seccion4=root.findViewById(R.id.seccion4);
        seccion5=root.findViewById(R.id.seccion5);
        seccion6=root.findViewById(R.id.seccion6);
        seccion7=root.findViewById(R.id.seccion7);
        seccion8=root.findViewById(R.id.seccion8);
        seccion9=root.findViewById(R.id.seccion9);
        comple1=inicioActivity.completado;
        comple2=inicioActivity.completado2;
        comple3=inicioActivity.completado3;
        comple4=inicioActivity.completado4;
        comple5=inicioActivity.completado5;
        comple6=inicioActivity.completado6;
        comple7=inicioActivity.completado7;
        comple8=inicioActivity.completado8;
        comple9=inicioActivity.completado9;
        comple10=inicioActivity.completado10;
        comple11=inicioActivity.completado11;
        comple12=inicioActivity.completado12;
        comple13=inicioActivity.completado13;
        comple14=inicioActivity.completado14;
        comple15 = inicioActivity.completado15;
        comple16= inicioActivity.completado16;

        if(!comple16) {
            nivel17.setImageResource(R.drawable.candado_nivel);
            if (!comple15) {
                nivel16.setImageResource(R.drawable.candado_nivel);
                if (!comple14) {
                    nivel15.setImageResource(R.drawable.candado_nivel);
                    seccion9.setBackgroundResource(R.drawable.barrasuperiorbloqueada);
                    if (!comple13) {
                        nivel14.setImageResource(R.drawable.candado_nivel);
                        seccion8.setBackgroundResource(R.drawable.barrasuperiorbloqueada);
                        if (!comple12) {
                            nivel13.setImageResource(R.drawable.candado_nivel);
                            if (!comple11) {
                                nivel12.setImageResource(R.drawable.candado_nivel);
                                seccion7.setBackgroundResource(R.drawable.barrasuperiorbloqueada);
                                if (!comple10) {
                                    nivel11.setImageResource(R.drawable.candado_nivel);
                                    if (!comple9) {
                                        nivel10.setImageResource(R.drawable.candado_nivel);
                                        seccion6.setBackgroundResource(R.drawable.barrasuperiorbloqueada);
                                        if (!comple8) {
                                            nivel9.setImageResource(R.drawable.candado_nivel);
                                            seccion5.setBackgroundResource(R.drawable.barrasuperiorbloqueada);
                                            if (!comple7) {
                                                nivel8.setImageResource(R.drawable.candado_nivel);
                                                if (!comple6) {
                                                    nivel7.setImageResource(R.drawable.candado_nivel);
                                                    seccion4.setBackgroundResource(R.drawable.barrasuperiorbloqueada);
                                                    if (!comple5) {
                                                        nivel6.setImageResource(R.drawable.candado_nivel);
                                                        if (!comple4) {
                                                            nivel5.setImageResource(R.drawable.candado_nivel);
                                                            seccion3.setBackgroundResource(R.drawable.barrasuperiorbloqueada);
                                                            if (!comple3) {
                                                                nivel4.setImageResource(R.drawable.candado_nivel);
                                                                if (!comple2) {
                                                                    nivel3.setImageResource(R.drawable.candado_nivel);
                                                                    seccion2.setBackgroundResource(R.drawable.barrasuperiorbloqueada);
                                                                    if (!comple1) {
                                                                        nivel2.setImageResource(R.drawable.candado_nivel);
                                                                    } else {
                                                                        nivel2.setImageResource(R.drawable.mod1);
                                                                    }
                                                                } else {
                                                                    nivel3.setImageResource(R.drawable.mod2);
                                                                    seccion2.setBackgroundResource(R.drawable.barrasuperior2);
                                                                }
                                                            } else {
                                                                nivel4.setImageResource(R.drawable.mod2);
                                                            }
                                                        } else {
                                                            nivel5.setImageResource(R.drawable.mod3);
                                                            seccion3.setBackgroundResource(R.drawable.barrasuperior3);
                                                        }
                                                    } else {
                                                        nivel6.setImageResource(R.drawable.mod3);
                                                    }
                                                } else {
                                                    nivel7.setImageResource(R.drawable.mod4);
                                                    seccion4.setBackgroundResource(R.drawable.barrasuperior4);
                                                }
                                            } else {
                                                nivel8.setImageResource(R.drawable.mod4);
                                            }
                                        } else {
                                            nivel9.setImageResource(R.drawable.mod5);
                                            seccion5.setBackgroundResource(R.drawable.barrasuperior5);
                                        }
                                    } else {
                                        nivel10.setImageResource(R.drawable.mod6);
                                        seccion6.setBackgroundResource(R.drawable.barrasuperior6);
                                    }
                                } else {
                                    nivel11.setImageResource(R.drawable.mod6);
                                }
                            } else {
                                nivel12.setImageResource(R.drawable.mod7);
                                seccion7.setBackgroundResource(R.drawable.barrasuperior7);
                            }
                        } else {
                            nivel13.setImageResource(R.drawable.mod7);
                        }
                    } else {
                        nivel14.setImageResource(R.drawable.mod8);
                        seccion8.setBackgroundResource(R.drawable.barrasuperior8);
                    }
                } else {
                    nivel15.setImageResource(R.drawable.mod8);
                }
            }else{
                nivel16.setImageResource(R.drawable.mod9);
                seccion9.setBackgroundResource(R.drawable.barrasuperior9);
            }
        }else{
            nivel17.setImageResource(R.drawable.mod9);
        }


        nivel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iniciar1();
            }
        });
        nivel2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!comple1){
                    Toast.makeText(inicioActivity, "Nivel bloqueado, completa el nivel anterior", Toast.LENGTH_SHORT).show();
                }else {
                    iniciar2();
                }
            }
        });
        nivel3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { if(!comple2){
                Toast.makeText(inicioActivity, "Nivel bloqueado, completa el nivel anterior", Toast.LENGTH_SHORT).show();
            }else {
                iniciar3();
            } }
        });
        nivel4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {if(!comple3){
                Toast.makeText(inicioActivity, "Nivel bloqueado, completa el nivel anterior", Toast.LENGTH_SHORT).show();
            }else {
                iniciar4();
            } }
        });
        nivel5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { if(!comple4){
                Toast.makeText(inicioActivity, "Nivel bloqueado, completa el nivel anterior", Toast.LENGTH_SHORT).show();
            }else {
                iniciar5();
            } }
        });
        nivel6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {if(!comple5){
                Toast.makeText(inicioActivity, "Nivel bloqueado, completa el nivel anterior", Toast.LENGTH_SHORT).show();
            }else {
                iniciar6();
            } }
        });
        nivel7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {if(!comple6){
                Toast.makeText(inicioActivity, "Nivel bloqueado, completa el nivel anterior", Toast.LENGTH_SHORT).show();
            }else {
                iniciar7();
            } }
        });
        nivel8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {if(!comple7){
                Toast.makeText(inicioActivity, "Nivel bloqueado, completa el nivel anterior", Toast.LENGTH_SHORT).show();
            }else {
                iniciar8();
            }}
        });
        nivel9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {if(!comple8){
                Toast.makeText(inicioActivity, "Nivel bloqueado, completa el nivel anterior", Toast.LENGTH_SHORT).show();
            }else {
                iniciar9();
            }}
        });
        nivel10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {if(!comple9){
                Toast.makeText(inicioActivity, "Nivel bloqueado, completa el nivel anterior", Toast.LENGTH_SHORT).show();
            }else {
                iniciar10();
            }}
        });
        nivel11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {if(!comple10){
                Toast.makeText(inicioActivity, "Nivel bloqueado, completa el nivel anterior", Toast.LENGTH_SHORT).show();
            }else {
                iniciar11();
            }}
        });
        nivel12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {if(!comple11){
                Toast.makeText(inicioActivity, "Nivel bloqueado, completa el nivel anterior", Toast.LENGTH_SHORT).show();
            }else {
                iniciar12();
            }}
        });
        nivel13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {if(!comple12){
                Toast.makeText(inicioActivity, "Nivel bloqueado, completa el nivel anterior", Toast.LENGTH_SHORT).show();
            }else {
                iniciar13();
            }}
        });
        nivel14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {if(!comple13){
                Toast.makeText(inicioActivity, "Nivel bloqueado, completa el nivel anterior", Toast.LENGTH_SHORT).show();
            }else {
                iniciar14();
            }}
        });
        nivel15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {if(!comple14){
                Toast.makeText(inicioActivity, "Nivel bloqueado, completa el nivel anterior", Toast.LENGTH_SHORT).show();
            }else {
                iniciar15();
            }}
        });
        nivel16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {if(!comple15){
                Toast.makeText(inicioActivity, "Nivel bloqueado, completa el nivel anterior", Toast.LENGTH_SHORT).show();
            }else {
                iniciar16();
            }}
        });
        nivel17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {if(!comple16){
                Toast.makeText(inicioActivity, "Nivel bloqueado, completa el nivel anterior", Toast.LENGTH_SHORT).show();
            }else {
                iniciar17();
            }}
        });


        return root;
    }

    private void iniciar17() { inicioActivity.ircuestionario17();
    }
    private void iniciar16() { inicioActivity.ircuestionario16();

    }
    private void iniciar15() {inicioActivity.ircuestionario15();  }
    private void iniciar14() {inicioActivity.ircuestionario14();  }
    private void iniciar13() {inicioActivity.ircuestionario13();  }
    private void iniciar12() {inicioActivity.ircuestionario12();  }
    private void iniciar11() {inicioActivity.ircuestionario11();  }
    private void iniciar10() {inicioActivity.ircuestionario10();  }
    private void iniciar9() {inicioActivity.ircuestionario9();  }
    private void iniciar8() {inicioActivity.ircuestionario8();  }
    private void iniciar7() { inicioActivity.ircuestionario7(); }
    private void iniciar6() { inicioActivity.ircuestionario6(); }
    private void iniciar5() { inicioActivity.ircuestionario5(); }
    private void iniciar4() { inicioActivity.ircuestionario4(); }
    private void iniciar3() { inicioActivity.ircuestionario3(); }
    private void iniciar2() { inicioActivity.ircuestionario2();}
    private void iniciar1() {inicioActivity.ircuestionario1();}
}