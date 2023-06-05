package com.example.projet_android;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class mainActivity4  extends AppCompatActivity {
    private Button md_valider;
    private EditText edit_mail, edit_telephone;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_identifiant);
        md_valider=findViewById(R.id.id_valider);
        edit_mail=findViewById(R.id.edit_mail);
        edit_telephone=findViewById(R.id.edit_tele);

        md_valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edit_mail.getText().toString().trim().length()>0  ||
                        edit_telephone.getText().toString().trim().length()>0 ) { // plus une verification de l'existance de l'identifiant
                    validation();

                }
                else echec();

            }
        });

    }
    private void validation() {
        Toast.makeText(this, "Neuveau mot de passe est envoye ", Toast.LENGTH_SHORT).show();
    }

    private void echec() {
        Toast.makeText(this, "echec", Toast.LENGTH_SHORT).show();
    }
}

