package com.example.lab5_ph40510;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import android.widget.Toast;

import com.example.lab5_ph40510.adapter.studentAdapter;
import com.example.lab5_ph40510.model.Student;

import java.util.ArrayList;

public class Bai2 extends AppCompatActivity {

    private ArrayList<Student> litsStuden = new ArrayList<>();
    private studentAdapter adapter = new studentAdapter(this, litsStuden);
     private  ActivityResultLauncher<Intent> getadd;
     SearchView searchView;
    ListView lvstuden;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai2);
        //anh xa
        lvstuden = findViewById(R.id.lvstudent);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Home");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //them doi tuong vao list
        litsStuden.add(new Student("Fpoly Hà Nội","Nguyễn Văn A","Hà Nội"));
        litsStuden.add(new Student("Fpoly Hồ Chí Minh","Nguyễn Văn B","Hồ Chí Minh"));
        litsStuden.add(new Student("Fpoly Đà Nẵng","Nguyễn Văn C","Huế"));
        //do du lieu len listview
        adapter = new studentAdapter(this, litsStuden);
        lvstuden.setAdapter(adapter);
        getadd = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == 1) {
                            Intent intent = result.getData();
                            if (intent != null) {
                                Bundle bundle = intent.getExtras();
                                String branch = bundle.getString("branch");
                                String name = bundle.getString("name");
                                String address = bundle.getString("address");
                                litsStuden.add(new Student(branch, name, address));
                                adapter.notifyDataSetChanged();
                            }
                        }
                    }
                }
        );

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mn_home,menu);
        SearchManager searchManager =   (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setMaxWidth(Integer.MAX_VALUE);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.add){
            Intent intent = new Intent(Bai2.this, Bai1.class);
            getadd.launch(intent);
        } else if (item.getItemId()==R.id.search) {
            Toast.makeText(this, "Tìm kiếm", Toast.LENGTH_SHORT).show();
        } else if (item.getItemId()==R.id.lichhoc) {
            Toast.makeText(this, "Lịch Học", Toast.LENGTH_SHORT).show();
        } else if (item.getItemId()==R.id.bangdiem) {
            Toast.makeText(this, "Bảng Điểm", Toast.LENGTH_SHORT).show();
        } else if (item.getItemId()==R.id.diemdanh) {
            Toast.makeText(this, "Điểm danh", Toast.LENGTH_SHORT).show();
        } else{
            startActivity(new Intent(Bai2.this, Sign_in.class));
        }
        return super.onOptionsItemSelected(item);
    }

}