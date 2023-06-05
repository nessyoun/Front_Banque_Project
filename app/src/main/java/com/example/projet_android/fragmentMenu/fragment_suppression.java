package com.example.projet_android.fragmentMenu;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.projet_android.Persistence;
import com.example.projet_android.R;
import com.example.projet_android.Session;
import com.example.projet_android.mainActivity2;


public class fragment_suppression extends Fragment {


    public fragment_suppression() {
        // Required empty public constructor
    }

    private EditText edit_idC;
    private Button supprimer;

    private Context context;
    private Persistence persistence;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_suppression, container, false);
        edit_idC = v.findViewById(R.id.editTextNumber3);
        supprimer = v.findViewById(R.id.btn_supprimer);
        context = getContext();
        persistence = new Persistence(context);
        edit_idC.setText(String.valueOf(Session.compte.getId()));


        supprimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //if(){ verification de l'id du compte
                Integer id =Integer.parseInt(edit_idC.getText().toString()) ;
                if(id<200)
                {
                    persistence.supprimerCompte(id);
                    Toast.makeText(getContext(), "Votre compte a ete supprimer", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getActivity(), mainActivity2.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(context, "Erreur", Toast.LENGTH_SHORT).show();
                }

            }
        });
        return v;
    }
}