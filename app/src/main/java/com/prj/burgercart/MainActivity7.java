package com.prj.burgercart;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.text.Layout;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.myapplication.R;

public class MainActivity7 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        ListView list=(ListView)findViewById(R.id.historyorders);

OrdersDB h=new OrdersDB(this);

Cursor cursor=h.showhistoryorders(data.username);

String []arr ;
        if (cursor != null && cursor.getCount()>0){
            cursor.moveToFirst();
           arr = new String[cursor.getCount()];
            do{
                for(int i = 0; i < cursor.getCount(); i++){
                   arr[i]=(cursor.getString(i));
                }
            }while(cursor.moveToNext());
        }
        else{ arr = new String[1];arr[0]="NO PAST ORDERS";}
        ArrayAdapter<String> listadapter=new ArrayAdapter<>(this, R.layout.activity_main7,arr);
        list.setAdapter(listadapter);
    }
}