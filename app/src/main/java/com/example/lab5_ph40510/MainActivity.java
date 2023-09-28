package com.example.lab5_ph40510;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class    MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnlab5=findViewById(R.id.btnlab5);
        Button btnbtt = findViewById(R.id.btnbtt);
        Button btnvdsp =findViewById(R.id.btnvdsp);
        //xử ly sự kiện khi click

        btnvdsp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,vdsp.class);
                startActivity(intent);
            }
        });
        btnlab5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Sign_in.class);
                startActivity(intent);
            }
        });
        btnbtt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Home_App_Food.class);
                startActivity(intent);
            }
        });
    }
}