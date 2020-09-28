package com.prj.burgercart;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

import com.example.myapplication.R;

import java.util.HashMap;

public class OrdersCart extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders_cart);
        GridView grid=(GridView) findViewById(R.id.GV);
   Cart c= new Cart();
   c.AllOrderItems= (HashMap<Integer, MenuItem>) getIntent().getSerializableExtra("AllOrderItems");
        OrderItemAdapter Item = new OrderItemAdapter(getApplicationContext(), R.layout.activity_orders_cart);
        for (MenuItem item : c.AllOrderItems.values()) {
            Item.AddItem(item);
        }

        grid.setAdapter(Item);

    }
}