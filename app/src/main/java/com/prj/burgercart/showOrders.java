package com.prj.burgercart;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class showOrders extends AppCompatActivity {
    ListView ordersList;
    ArrayAdapter<String> ordersAdapter;
    OrdersDB orders;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_orders);

        ordersList = (ListView)findViewById(R.id.ListView1);
        ordersAdapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1);
        ordersList.setAdapter(ordersAdapter);

        orders = new OrdersDB(getApplicationContext());
        Cursor cursor = orders.fetchAllOrders();
        while (!cursor.isAfterLast())
        {
            ordersAdapter.add(cursor.getString(0));
            cursor.moveToNext();
        }
    }


}
