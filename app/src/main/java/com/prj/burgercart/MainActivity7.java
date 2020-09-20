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
        ArrayAdapter<String> listadapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        list.setAdapter(listadapter);
OrdersDB h=new OrdersDB(this);

Cursor cursor=h.showhistoryorders(data.username);

        if (cursor != null && cursor.getCount()>0){
            cursor.moveToFirst();

            do{
                for(int i = 0; i < cursor.getCount(); i++){
                  listadapter.add(cursor.getString(i).toString());
                }
            }while(cursor.moveToNext());




        }
        else{ listadapter.add("NO PAST ORDERS");

        }



    }
}