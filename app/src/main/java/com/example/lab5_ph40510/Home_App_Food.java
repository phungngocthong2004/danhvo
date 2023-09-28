package com.example.lab5_ph40510;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.lab5_ph40510.adapter.foodAdapter;
import com.example.lab5_ph40510.model.Student;
import com.example.lab5_ph40510.model.food;

import java.util.ArrayList;

public class Home_App_Food extends AppCompatActivity {
    ListView lvfood;
    private ArrayList<food> listfood = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_app_food);
        lvfood = findViewById(R.id.lvfood);
        TextView txttotal = findViewById(R.id.txttotal);



        listfood.add(new food(R.drawable.img_7,"Bún chả",30000));
        listfood.add(new food(R.drawable.img_8,"Bún Đậu mắm tôm",34000));
        listfood.add(new food(R.drawable.img_9,"Bún riêu",35000));
        listfood.add(new food(R.drawable.img_10,"Phở",45000));
        listfood.add(new food(R.drawable.img_11,"Bánh xòe",25000));
        listfood.add(new food(R.drawable.img_12,"Bánh mì",20000));


        foodAdapter adapter = new foodAdapter(this,listfood);
        lvfood.setAdapter(adapter);
    }

}