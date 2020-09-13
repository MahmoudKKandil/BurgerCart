package com.prj.burgercart;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView mylist = (ListView)findViewById(R.id.listo);
        String[] myarr = getResources().getStringArray(R.array.list);
        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,myarr);
         mylist.setAdapter(adapter);
       mylist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
               TextView v=(TextView) view;
               if(((TextView) view).getText().toString().equals("samer")) {
                   Intent inn = new Intent(MainActivity.this, MainActivity2.class);
                   startActivity(inn);
               }
               if(((TextView) view).getText().toString().equals("farah")) {
                   Intent inn = new Intent(MainActivity.this, MainActivity3.class);
                   startActivity(inn);
               }
               if(((TextView) view).getText().toString().equals("yong")) {
                   Intent inn = new Intent(MainActivity.this, MainActivity4.class);
                   startActivity(inn);
               }
           }
       }
       );
    }
}