package com.example.lab5_ph40510;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Sign_in extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        EditText txtusername = findViewById(R.id.txtusername);
        EditText txtpassword=findViewById(R.id.txtpassword);
        Button btndangky = findViewById(R.id.btn_sign_up);
        Button btndangnhap = findViewById(R.id.btn_sign_in);
        CheckBox chkremember = findViewById(R.id.chkremember);
        btndangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Sign_in.this,Sign_up.class);
                startActivity(intent);
            }
        });
        btndangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= getIntent();
                Bundle bundle=i.getExtras();
                if (bundle != null) {
                    String username = bundle.getString("username");
                    String password = bundle.getString("password");
                    Boolean u = username.equals(txtusername.getText().toString());
                    Boolean p= password.equals(txtpassword.getText().toString());
                    if(u&&p){
                        if(chkremember.isChecked()){
                            Toast.makeText(Sign_in.this, "Đăng nhập thành công. Đã ghi nhớ đăng nhập", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(Sign_in.this,Bai2.class));
                        }else{
                            Toast.makeText(Sign_in.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(Sign_in.this,Bai2.class));
                        }
                    }else{
                        Toast.makeText(Sign_in.this, "Sai tài khoản mật khẩu", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(Sign_in.this, "Bạn chưa đăng kí", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}