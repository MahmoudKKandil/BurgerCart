package com.prj.burgercart;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import com.example.myapplication.R;

import java.util.HashMap;

public class OrdersCart extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders_cart);
        GridView grid=(GridView) findViewById(R.id.GV);
        Button makeorder=(Button) findViewById(R.id.addneworderbutton);
        final TextView details=(TextView)findViewById(R.id.orderdetailstexxt);
        final String username = getIntent().getStringExtra("username");
   Cart c= (Cart)getIntent().getSerializableExtra("cart");
   c.AllOrderItems= (HashMap<Integer, MenuItem>) getIntent().getSerializableExtra("AllOrderItems");
        OrderItemAdapter Item = new OrderItemAdapter(getApplicationContext(), R.layout.activity_orders_cart);
        for (MenuItem item : c.AllOrderItems.values()) {
            Item.AddItem(item);
        }

        grid.setAdapter(Item);
makeorder.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        c.EndAddingToCart(details.getText().toString(),username,this);
    }
});
    }
}