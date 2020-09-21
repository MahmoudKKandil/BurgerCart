package com.prj.burgercart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.R;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
       final  OrdersDB or=new OrdersDB(this);
       or.GetUserType("t");
        final EditText UserName=(EditText) findViewById(R.id.un);
        final EditText Password=(EditText) findViewById(R.id.pt);
        final Button login=(Button)  findViewById(R.id.login);
        Button register =(Button)  findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inn = new Intent(Login.this, Register.class);
                startActivity(inn);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(UserName.getText().toString()))
                    UserName.setError("UserName cant be null ");
                if (TextUtils.isEmpty(Password.getText().toString()))
                    Password.setError("Password cant be null ");
                if(or.CheckingUserName(UserName.getText().toString()))
                {

                    if(Password.getText().toString().equals(or.GetPassword((UserName.getText().toString())))) {
                        if(or.GetUserType(UserName.getText().toString()).equals("AD"))
                        {
                            Intent inn = new Intent(Login.this, MainActivity.class);
                            inn.putExtra("username",UserName.getText().toString());
                            startActivity(inn);
                        }
                        else
                            {
                                Intent inn = new Intent(Login.this, UserPanel.class);
                                inn.putExtra("username",UserName.getText().toString());
                                startActivity(inn);
                            }

                    }
                    else
                        {
                            Password.setError("The Password is wrong");

                        }
                }
                else
                    {
                        UserName.setError("This UserName is not registered");
                    }

            }
        });


    }
}