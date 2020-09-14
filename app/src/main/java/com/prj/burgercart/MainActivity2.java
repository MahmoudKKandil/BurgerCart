package com.prj.burgercart;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        EditText time=(EditText) findViewById(R.id.time);
        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        final String formattedDate = df.format(c.getTime());
        time.setText(formattedDate);
        time.setEnabled(false);
        final EditText status=(EditText) findViewById(R.id.status);
        status.setText("notcompleted");
        status.setEnabled(false);
        final OrdersDB neworder =new OrdersDB(this);
        final EditText id=(EditText) findViewById(R.id.id);
        id.setText(neworder.getorderid());
        id.setEnabled(false);
        Button b=(Button)findViewById(R.id.button);
        final EditText describtion=(EditText) findViewById(R.id.description);
        final EditText details=(EditText) findViewById(R.id.details);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                neworder.createneworder(neworder.getorderid(),formattedDate,describtion.getText().toString(),details.getText().toString());

            }
        });
    }
}