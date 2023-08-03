package com.example.finanzi;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PerfilFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PerfilFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public PerfilFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PerfilFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PerfilFragment newInstance(String param1, String param2) {
        PerfilFragment fragment = new PerfilFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    ImageButton mButtonCerrarSesion;
    private InicioActivity inicioActivity;
    public void onAttach(Context context) {
        super.onAttach(context);
        inicioActivity = (InicioActivity) context;
    }

    Button Editarbtn,eliminarbtm;
    TextView txtNonb,txtApell,txtCorreo;
    FirebaseAuth mAuth;
    FirebaseFirestore firestore;
    String Iduser;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_perfil, container, false);
        mAuth = FirebaseAuth.getInstance();
        firestore = FirebaseFirestore.getInstance();
        Iduser = mAuth.getCurrentUser().getUid();
        mButtonCerrarSesion = root.findViewById(R.id.btnCerrarsesion);
        Editarbtn = root.findViewById(R.id.btnedit);
        eliminarbtm = root.findViewById(R.id.btneliminar);
        txtNonb = root.findViewById(R.id.NombreUsu);
        txtApell = root.findViewById(R.id.ApellidosUsu);
        txtCorreo = root.findViewById(R.id.CorreoUsu);

        txtCorreo.setText(mAuth.getCurrentUser().getEmail());
        //DocumentReference documentReference = firestore.collection("Usuario").document(mAuth.getCurrentUser().getUid());
        //documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            //@Override
            //public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException error) {
              // txtNonb.setText(documentSnapshot.getString("Nombre"));
              // txtApell.setText(documentSnapshot.getString("Apellido"));
            //}
        //});

        Editarbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { Editarper() ;}
        });

        mButtonCerrarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logout();
            }
        });
        return root;
    }

    private void Editarper() {
        inicioActivity.editprof();
    }

    private void logout(){
        inicioActivity.logout();
    }
}