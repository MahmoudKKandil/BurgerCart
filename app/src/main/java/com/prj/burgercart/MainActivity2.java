package com.prj.burgercart;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        final EditText status=(EditText) findViewById(R.id.status);
        status.setText("notcompleted");
        status.setEnabled(false);
        final OrdersDB neworder =new OrdersDB(this);

       final EditText id=(EditText) findViewById(R.id.id);
        id.setText(String.valueOf(neworder.getorderid()));
        id.setEnabled(false);
        Button b=(Button)findViewById(R.id.button);
        final EditText description=(EditText) findViewById(R.id.description);
        final EditText details=(EditText) findViewById(R.id.details);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar c = Calendar.getInstance();
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                final String formattedDate = df.format(c.getTime());
                neworder.createneworder(Integer.parseInt(id.getText().toString()),formattedDate,description.getText().toString(),details.getText().toString());
                Intent inn = new Intent(MainActivity2.this, MainActivity2.class);
                finish();
                startActivity(inn);
            }
        });
    }
}