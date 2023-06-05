package com.example.projet_android;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static java.security.AccessController.getContext;

public class mainActivity2 extends AppCompatActivity {
    private Button b1 ;
    private ImageView image1,image2,image3;
    private TextView text1,text2;
    private EditText editTextNumber,editTextTextPersonName2;
    private Context context;
    private Persistence persistence;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        b1=findViewById(R.id.conn_button);
        image1=findViewById(R.id.image1);
        image2=findViewById(R.id.image2);
        image3=findViewById(R.id.image3);
        text1=findViewById(R.id.text1);
        text2=findViewById(R.id.text2);
        editTextNumber = findViewById(R.id.editTextNumber);
        editTextTextPersonName2 = findViewById(R.id.editTextTextPersonName2);
        context = this;
        persistence = new Persistence(context);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    String username = editTextNumber.getText().toString();
                    String password = editTextTextPersonName2.getText().toString();
                    persistence.login(username, password, new Persistence.VolleyOnEventListener<Boolean>() {
                        @Override
                        public void onSuccess(Boolean object) {
                            if(object){
                                Intent it = new Intent(mainActivity2.this, MainActivity.class);
                                startActivity(it);
                            }
                            else{
                                Toast.makeText(context, "Verfier les données in mainactivité", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Exception e) {

                        }
                    });

                }
        });


        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri site = Uri.parse("https://www.facebook.com/login/");
                Intent intent=new Intent(Intent.ACTION_VIEW,site);
                startActivity(intent);
            }
        });

        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri site = Uri.parse("https://www.instagram.com/accounts/login/");
                Intent intent=new Intent(Intent.ACTION_VIEW,site);
                startActivity(intent);
            }
        });

        image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri site = Uri.parse("https://twitter.com/i/flow/login");
                Intent intent=new Intent(Intent.ACTION_VIEW,site);
                startActivity(intent);
            }
        });

        text1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(mainActivity2.this,mainActivity3.class);
                startActivity(it);
            }
        });

        text2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(mainActivity2.this,mainActivity4.class);
                startActivity(it);
            }
        });
    }
    private void echec() {
        Toast.makeText(this, "echec", Toast.LENGTH_LONG).show();
    }

}
