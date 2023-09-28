package com.example.lab5_ph40510;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.lab5_ph40510.adapter.schooladapter;
import com.example.lab5_ph40510.model.school;

import java.util.ArrayList;

public class Bai1 extends AppCompatActivity {
    private ArrayList<school> list = new ArrayList<>();
    private String branch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai1);
        Spinner spdiachi = findViewById(R.id.spinerdiachi);
        EditText txtdiachi = findViewById(R.id.txtdiachi);
        EditText txtten = findViewById(R.id.txtten);
        Button btnsubmit = findViewById(R.id.btnsubmit);


        list.add(new school(R.drawable.img,"Hà Nội"));
        list.add(new school(R.drawable.img_1,"Huế"));
        list.add(new school(R.drawable.img_2,"Tây Nguyên"));
        list.add(new school(R.drawable.img_3,"Cần Thơ"));
        list.add(new school(R.drawable.img_4,"Đà Nẵng"));
        list.add(new school(R.drawable.img_5,"Hồ Chí Minh"));

        schooladapter schooladapter = new schooladapter(this,list);
        spdiachi.setAdapter(schooladapter);

        spdiachi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
               branch = "Fpoly " + list.get(i).getTencs();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Bai1.this, Bai2.class);
                Bundle bundle = new Bundle();
                bundle.putString("name",txtten.getText().toString());
                bundle.putString("branch",branch);
                bundle.putString("address",txtdiachi.getText().toString());
                intent1.putExtras(bundle);
                setResult(1,intent1);
                finish();
            }
        });

    }
}