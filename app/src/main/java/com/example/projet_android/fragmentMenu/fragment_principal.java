package com.example.projet_android.fragmentMenu;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.projet_android.Client;
import com.example.projet_android.Persistence;
import com.example.projet_android.R;
import com.example.projet_android.Session;

public class fragment_principal extends Fragment {
    public fragment_principal() {
        // Required empty public constructor
    }
    private TextView textnomPrenom,textSolde,textid,typeCompte;
    private ImageView image;
    private Button verser , consulter , supprimer , creer;
    private int id ;
    private float solde;
    private Context context;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_principal, container, false);
        textnomPrenom=v.findViewById(R.id.text_nomPrenom);
        textSolde=v.findViewById(R.id.textSolde);
        typeCompte = v.findViewById(R.id.textView3);
        textid=v.findViewById(R.id.text_id);
        image=v.findViewById(R.id.eye);
        verser=v.findViewById(R.id.btnVerser);
        consulter=v.findViewById(R.id.btnConsulter);
        supprimer=v.findViewById(R.id.btnSupprimer);
        creer=v.findViewById(R.id.btnCreer);
        context= getContext();
        Persistence persistence =  new Persistence(context);
        //recuperer les infomations du client puis
        //textnomPrenom.setText("  ");
        //   textSolde.setText(Float.toString(solde));
        //
        //
        textid.setText(String.valueOf(Session.compte.getId()) );
        typeCompte.setText(Session.compte.getType());
        persistence.findClient(Session.compte.getProprietaire(), new Persistence.VolleyOnEventListener<Client>() {
            @Override
            public void onSuccess(Client object) {
                textnomPrenom.setText(object.getNom());
            }

            @Override
            public void onFailure(Exception e) {

            }
        });
        //Toast.makeText(context, Session.compte.toString(), Toast.LENGTH_SHORT).show();
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(textSolde.getVisibility() != View.VISIBLE)
                    persistence.consulterSold(Session.compte.getId(), new Persistence.VolleyOnEventListener<Double>() {
                        @Override
                        public void onSuccess(Double object) {
                            textSolde.setText(object.toString());
                            textSolde.setVisibility(View.VISIBLE);
                        }

                        @Override
                        public void onFailure(Exception e) {

                        }
                    });

                else   textSolde.setVisibility(View.INVISIBLE);
            }
        });

        verser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Obtenez l'instance du FragmentManager
                FragmentManager fragmentManager = getChildFragmentManager();

                // Créez une nouvelle instance du fragment à afficher
                fragment_versement fragment = new fragment_versement();

                // Commencez la transaction de fragment
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                // Remplacez le fragment existant par le nouveau fragment
                fragmentTransaction.replace(R.id.container1, fragment);

                // Ajoutez la transaction au backstack
                fragmentTransaction.addToBackStack(null);

                // Terminez la transaction
                fragmentTransaction.commit();
            }
        });

        consulter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        creer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        supprimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        return v;
    }


}
