package com.example.projet_android;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class mainActivity3  extends AppCompatActivity {
private Button md_valider;
private EditText edit_identifiant, edit_telephone;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mdp);
        md_valider=findViewById(R.id.md_valider);
        edit_identifiant=findViewById(R.id.edit_identifiant);
        edit_telephone=findViewById(R.id.edit_telephone);

        md_valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edit_identifiant.getText().toString().trim().length()>0  &&
                        edit_telephone.getText().toString().trim().length()>0 ) { // plus une verification de l'existance de l'identifiant
                   validation();
                }
                else echec();

            }
        });

    }
    private void validation() {
        Toast.makeText(this, "Neuveau identifiant est envoye au votre numero de telephone", Toast.LENGTH_LONG).show();
    }

    private void echec() {
        Toast.makeText(this, "echec", Toast.LENGTH_LONG).show();
    }
}
