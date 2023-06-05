package com.example.projet_android.fragmentMenu;

import android.content.Context;
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


public class fragment_versement extends Fragment {
    public fragment_versement() {

    }
    private EditText edit_idD, edit_montant,editTextNumber2;
    private Button confirmer;
    private Context context;
    private Persistence persistence;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_versement, container, false);
        edit_idD=v.findViewById(R.id.edit_idD);
        editTextNumber2 = v.findViewById(R.id.editTextNumber2);
        edit_montant=v.findViewById(R.id.edit_montant);
        confirmer=v.findViewById(R.id.btn_confirmer);
        context = getContext();
        persistence = new Persistence(context);
        editTextNumber2.setText(String.valueOf(Session.compte.getId())); //idCompte
        confirmer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //if(){ verification de l'id du destinataire et le montant
                Integer id2 = Integer.parseInt(edit_idD.getText().toString()) ;
                if(id2>300){
                    Toast.makeText(context, "Erreur: identifiant inexistant:", Toast.LENGTH_SHORT).show();
                }
                else {
                    persistence.verser(Session.compte.getId(),Integer.parseInt(edit_idD.getText().toString()),Float.parseFloat(edit_montant.getText().toString()) );
                }

             //}
                //else     Toast.makeText(getContext(), "l'identifiant ou le montant non valide", Toast.LENGTH_LONG).show();
            }
        });
        return v;
    }


}