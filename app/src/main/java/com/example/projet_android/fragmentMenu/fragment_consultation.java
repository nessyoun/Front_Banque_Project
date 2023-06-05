package com.example.projet_android.fragmentMenu;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.projet_android.Client;
import com.example.projet_android.Persistence;
import com.example.projet_android.R;
import com.example.projet_android.Session;

public class fragment_consultation extends Fragment {
    public fragment_consultation() {
        // Required empty public constructor
    }
    private TextView nom,dateN,sexe,textSolde;
    private int nombre;   //nombre des comptes
    private float solde;  // solde de compte actif
    private Persistence persistence;
    private Context context;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
      View v=inflater.inflate(R.layout.fragment_consultation, container, false);
        nom=v.findViewById(R.id.text_nom);
        dateN=v.findViewById(R.id.text_dateN);
        sexe=v.findViewById(R.id.text_sexe);
        textSolde=v.findViewById(R.id.text_solde);
        context = getContext();
        persistence = new Persistence(context);
        textSolde.setText(Session.compte.getSolde().toString());
        persistence.findClient(Session.compte.getProprietaire(), new Persistence.VolleyOnEventListener<Client>() {
            @Override
            public void onSuccess(Client object) {
                nom.setText(object.getNom());
                dateN.setText(object.getDateN().toString());
                sexe.setText(object.getSexe());
            }

            @Override
            public void onFailure(Exception e) {

            }
        });

        //recuperer les infomations du client puis
        //nom.setText("  ");
       // dateN.setText("  ");
        //sexe.setText("  ");   nombreCompte.setText(Integer.toString(nombre)); textSolde.setText(Float.toString(solde));
        return v;
    }
}