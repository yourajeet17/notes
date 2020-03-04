package com.example.notes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.notes.Fragment.HomeFragment;
import com.example.notes.Fragment.NotificationFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        ButterKnife.bind(this);
        bottomNavigationView=findViewById(R.id.bottomNav);
        bottomNavigationView.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {
                Fragment fragment=null;
                switch (item.getItemId()){
                    case R.id.home:
                        fragment=new HomeFragment();
                        break;
                    case R.id.dashboard:
                        fragment=new DashboardFragment();
                        break;
                    case R.id.notification:
                        fragment=new NotificationFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragcontainer,fragment).commit();
                return;

            }

        });

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




