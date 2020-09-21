package com.prj.burgercart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;

public class UserPanel extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userpanel);
        Button showorders=(Button)findViewById(R.id.userordersbutton);
        Button add=(Button)findViewById(R.id.addneworderbutton);
        showorders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inn = new Intent(UserPanel.this, AllOrders.class);
                String username=getIntent().getStringExtra("username");
                inn.putExtra("username",username);
                startActivity(inn);
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inn = new Intent(UserPanel.this, AddOrder.class);
                String username=getIntent().getStringExtra("username");
                inn.putExtra("username",username);
                startActivity(inn);
            }
        });
    }
}