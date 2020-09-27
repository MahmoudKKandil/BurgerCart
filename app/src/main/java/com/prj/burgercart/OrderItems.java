package com.prj.burgercart;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import com.example.myapplication.R;

public class OrderItems extends AppCompatActivity {
    OrdersDB orders;
    String id,name,descrp,Price;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_items);
        GridView grid = (GridView) findViewById(R.id.GV);
        OrderItemAdapter orderItem = new OrderItemAdapter(getApplicationContext(), R.layout.activity_order_items);
        grid.setAdapter(orderItem);
        TextView price=(TextView) findViewById(R.id.textView9);
        int OrderID=Integer.valueOf( getIntent().getStringExtra("OrderID")) ;
      /*  */
        Cursor cursor = orders.LoadOrderItems(OrderID);
        if(cursor.moveToFirst()){
            do {
                id = cursor.getString(0);
                name = cursor.getString(1);
                descrp = cursor.getString(2);
              Price = cursor.getString(3);
                MenuItem orr = new MenuItem(Integer.valueOf(id), Integer.valueOf(Price),name,descrp);
                orderItem.add(orr);

            }while(cursor.moveToNext());
        }

        int p=0 ;
        for(int i=0;i<orderItem.getCount();i++)
        {
         MenuItem m=   (MenuItem) orderItem.getItem(i);
          p+=  m.Price;
        }
        price.setText("Total pice "+"\n"+p+" LE");

    }
}