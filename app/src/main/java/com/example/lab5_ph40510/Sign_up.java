package com.example.lab5_ph40510;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Sign_up extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        EditText txtuser=findViewById(R.id.txtuser);
        EditText txtpass=findViewById(R.id.txtpass);
        EditText txtcomfirm=findViewById(R.id.txtconfirm);
        Button btndk = findViewById(R.id.btndk);

        btndk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = txtuser.getText().toString();
                String pass = txtpass.getText().toString();
                String confirm = txtcomfirm.getText().toString();

                if(TextUtils.isEmpty(user)||TextUtils.isEmpty(pass)||TextUtils.isEmpty(confirm)){
                    Toast.makeText(Sign_up.this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                }else {
                    if (pass.equals(confirm)){
                        Toast.makeText(Sign_up.this, "Đăng kí thành công", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Sign_up.this,Sign_in.class);
                        Bundle bundle = new Bundle();
                        bundle.putString("username",user);
                        bundle.putString("password",pass);
                        intent.putExtras(bundle);
                        startActivity(intent);
                    }else{
                        Toast.makeText(Sign_up.this, "Đăng kí thất bại", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}