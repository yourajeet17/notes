package com.example.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        ButterKnife.bind(this);

        Intent intent=getIntent();
        if(intent!=null)
        {
            Toast.makeText(LoginActivity.this,intent.getStringExtra("success"),Toast.LENGTH_SHORT).show();
        }
    }

    @OnClick(R.id.login_forget) void submit()
    {
        Intent i1 = new Intent(LoginActivity.this,ForgetActivity.class);
        startActivity(i1);
    }

    @OnClick(R.id.btn_login) void login()
    {
        Intent i3=new Intent(LoginActivity.this,ForgetActivity.class);
        startActivity(i3);
    }

    @OnClick(R.id.login_notregistered) void register(){
        Intent i2 = new Intent(LoginActivity.this,RegisterActivity.class);
        startActivity(i2);
    }

}




