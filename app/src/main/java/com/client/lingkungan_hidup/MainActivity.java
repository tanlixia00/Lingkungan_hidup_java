package com.client.lingkungan_hidup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnLoginAdmin, btnLoginVisitor, btnBuatPengaduan, btnLihatLokasi;

//    public static String basic_url = "http://10.0.2.2/LHserver/";
    public static String basic_url = "https://lingkunganhiduptugas.000webhostapp.com/server/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLoginAdmin = (Button)findViewById(R.id.btnLoginAdmin);
        btnLoginVisitor = (Button)findViewById(R.id.buttonLoginPengunjung);


        btnLoginAdmin.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent i=new Intent(getBaseContext(), LoginAdminActivity.class);
                startActivity(i);
            }
        });

        btnLoginVisitor.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent i=new Intent(getBaseContext(), ListSatwaActivity.class);
                startActivity(i);
            }
        });


    }
}