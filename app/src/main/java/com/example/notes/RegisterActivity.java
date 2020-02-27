package com.example.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import es.dmoral.toasty.Toasty;

public class RegisterActivity extends AppCompatActivity {
    private EditText name,email,mobile,password,cpassword;
    private String username,useremail,userpassword,usermobile,usercpassword;
    private TextView registered;
    private Button register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        registered=findViewById(R.id.reg_textview);
        name=findViewById(R.id.reg_name);
        email=findViewById(R.id.reg_email);
        mobile=findViewById(R.id.reg_mobile);
        password=findViewById(R.id.reg_password);
        cpassword=findViewById(R.id.reg_confirmpassword);
        register=findViewById(R.id.btn_register);


        registered.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(i);
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                username=name.getText().toString().trim();
                useremail=email.getText().toString().trim();
                usermobile=mobile.getText().toString().trim();
                userpassword=password.getText().toString();
                usercpassword=cpassword.getText().toString();

                if (TextUtils.isEmpty(username)){
                    /*Toast.makeText(RegisterActivity.this,"please enter your name",Toast.LENGTH_SHORT).show();*/
                    Toasty.error(RegisterActivity.this,"pls enter your name",Toasty.LENGTH_SHORT).show();
                }
                else if (TextUtils.isEmpty(useremail)){
                    Toast.makeText(RegisterActivity.this,"please enter your Email",Toast.LENGTH_SHORT).show();
                }
                else if (TextUtils.isEmpty(usermobile)){
                    Toast.makeText(RegisterActivity.this,"Please enter your Mobile no",Toast.LENGTH_SHORT).show();
                }
                else if (usermobile.length()!=10){
                    Toast.makeText(RegisterActivity.this,"Please enter Valid 10 digit mobile number",Toast.LENGTH_SHORT).show();
                }
                else if (TextUtils.isEmpty(userpassword)){
                    Toast.makeText(RegisterActivity.this,"Please Enter your password",Toast.LENGTH_SHORT).show();
                }
                else if (TextUtils.isEmpty(usercpassword)){
                    Toast.makeText(RegisterActivity.this,"Input your password again",Toast.LENGTH_SHORT).show();
                }
                else if (userpassword.length()<5){
                    Toast.makeText(RegisterActivity.this,"input password of more than 5 character",Toast.LENGTH_SHORT).show();
                }
                else if(userpassword.length()>5) {

                    if (!usercpassword.equals(userpassword)) {
                        Toast.makeText(RegisterActivity.this, "password is not matching with confirm password", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Intent intent=new Intent(RegisterActivity.this,LoginActivity.class);
                        intent.putExtra("success","You have successfully registered");
                        startActivity(intent);
                    }
                }
            }
        });
    }
}
