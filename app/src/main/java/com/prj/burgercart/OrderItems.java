package com.prj.burgercart;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import com.example.myapplication.R;

public class OrderItems extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_items);
        GridView grid = (GridView) findViewById(R.id.GV);
        OrderItemAdapter orderItem = new OrderItemAdapter(getApplicationContext(), R.layout.activity_order_items);
        orderItem.AddItem(new MenuItem(10, 50, "jucylucy", "210 gram burger - tomatos"));
        orderItem.AddItem(new MenuItem(10, 50, "World war", "210 gram burger - tomatos -mozarilla sticks -  beacon - ay 7aga w bta3 "));
        orderItem.AddItem(new MenuItem(10, 50, "jucylucy", " "));
        grid.setAdapter(orderItem);
        TextView price=(TextView) findViewById(R.id.textView9);
        int p=0 ;
        for(int i=0;i<orderItem.getCount();i++)
        {
         MenuItem m=   (MenuItem) orderItem.getItem(i);
          p+=  m.Price;
        }
        price.setText("Total pice "+"\n"+p+" LE");

    }
}