package com.example.projet_android.fragmentMenu;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.projet_android.MainActivity;
import com.example.projet_android.Persistence;
import com.example.projet_android.R;
import com.example.projet_android.Session;
import com.example.projet_android.mainActivity2;


public class fragment_creation extends Fragment {


    public fragment_creation() {
        // Required empty public constructor
    }
    private EditText edit_name;
    private EditText edit_prenom;
    private Spinner spinner;
    private Button button_valider;
    private RadioButton radio_btn;
    private TextView text_insc;
    private Persistence persistence;
    private Context context;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View  v= inflater.inflate(R.layout.fragment_creation, container, false);
        edit_name= v.findViewById(R.id.edit_nom);
        edit_prenom = v.findViewById(R.id.edit_prenom);
        spinner = v.findViewById(R.id.spinner);
        radio_btn = v.findViewById(R.id.radio_btn);
        button_valider=v.findViewById(R.id.butt1);
        text_insc=v.findViewById(R.id.text_insc);
        context = getContext();
        persistence = new Persistence(context);
       radio_btn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
               button_valider.setEnabled(true);
           }
       });



            button_valider.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (edit_name.getText().toString().trim().length() > 0 &&
                            edit_prenom.getText().toString().trim().length() > 0 ) {
                        Integer idClient = Session.compte.getProprietaire();
                        String user = edit_name.getText().toString();
                        String password = edit_prenom.getText().toString();
                        String typeString = spinner.getSelectedItem().toString();
                        String type;
                        if(typeString.equals("Personal")){
                            type="P";
                        }else if(typeString.equals("Etreprise")){
                            type="E";
                        }else{
                            type="I";
                        }
                        persistence.createCompte(idClient,user,password,type);
                        Toast.makeText(getContext(), "Votre compte a ete creer avec succes", Toast.LENGTH_LONG).show();

                    } else
                        Toast.makeText(getContext(), "Veuillez renseigner tout les champs", Toast.LENGTH_LONG).show();
                }
            });

        text_insc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getActivity(), mainActivity2.class);
                startActivity(it);
            }
        });
        return v;
    }
}