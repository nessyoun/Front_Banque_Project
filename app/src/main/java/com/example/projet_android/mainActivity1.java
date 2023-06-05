package com.example.projet_android;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.projet_android.fragmentMenu.fragment_creation;

public class mainActivity1 extends AppCompatActivity {
   private Button b1 ;
    private Button b2 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        b1=findViewById(R.id.btn_conn);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(mainActivity1.this,mainActivity2.class);
                startActivity(it);
            }
        });
//        b2=findViewById(R.id.btn_insc);
//
//            // Masquer l'interface de l'activité
//            View decorView = getWindow().getDecorView();
//            int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
//            decorView.setSystemUiVisibility(uiOptions);
//
//            // Charger le fragment
//            setContentView(R.layout.activity_main);
//            getSupportFragmentManager().beginTransaction()
//                    .replace(R.id.container, new fragment_creation())
//                    .commit();




//
//        b2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                    FragmentManager fragmentManager = getSupportFragmentManager();
//                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                    Fragment fragment = new fragment_creation();
//                    fragmentTransaction.replace(R.id.container, fragment);
//                    fragmentTransaction.addToBackStack(null);
//                    fragmentTransaction.commit();
//
//
//            }
//        });
}
//       b2.setOnClickListener(new View.OnClickListener() {
//           @Override
//           public void onClick(View view) {
//               Fragment fragment= new fragment_creation();
//               FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//               fragmentTransaction.replace(R.id.container,fragment).commit();
//           }
//       });

    }

