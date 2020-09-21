package com.prj.burgercart;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.text.Layout;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.myapplication.R;

public class AllOrders extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        ListView list=(ListView)findViewById(R.id.historyorders);
        ArrayAdapter<String> listadapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        list.setAdapter(listadapter);
OrdersDB h=new OrdersDB(this);
String username=getIntent().getStringExtra("username");
Cursor cursor=h.showhistoryorders(username);

        if (cursor != null && cursor.getCount()>0){
            cursor.moveToFirst();


                for(int i = 0; i < cursor.getCount(); i++){
                    String str=cursor.getString(1)+" "+cursor.getString(2).toString()+" "+cursor.getString(3).toString()+" "+ cursor.getString(5).toString();
                  listadapter.add(str);
                  cursor.moveToNext();
                }





        }
        else{ listadapter.add("NO PAST ORDERS");

        }



    }
}