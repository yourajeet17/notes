package com.example.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {


    private TextView forget,notregistered;
    private Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        forget=findViewById(R.id.login_forget);
        notregistered=findViewById(R.id.login_notregistered);
        login=findViewById(R.id.btn_login);


        Intent intent=getIntent();
        if(intent!=null)
        {
            Toast.makeText(LoginActivity.this,intent.getStringExtra("success"),Toast.LENGTH_SHORT).show();
        }

        forget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(getApplicationContext(),ForgetActivity.class);
                startActivity(i1);
            }
        });

        notregistered.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(getApplicationContext(),RegisterActivity.class);
                startActivity(i2);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i3=new Intent(getApplicationContext(),ForgetActivity.class);
                startActivity(i3);
            }
        });
    }
}




