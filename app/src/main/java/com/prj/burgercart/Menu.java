package com.prj.burgercart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuAdapter;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.GridView;

import com.example.myapplication.R;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        GridView grid_menu = (GridView)findViewById(R.id.grd_menu);
        OrdersDB db = new OrdersDB(this);
        Cart cart = new Cart();
        menuadapter menuAdapter = new menuadapter(getApplicationContext(),R.layout.menuitem,cart);
        Cursor cursor =db.getMenu();
        do {
            menuAdapter.AddItem(new MenuItem(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getInt(3)));

        }while(cursor.moveToNext());


        grid_menu.setAdapter(menuAdapter);

        registerForContextMenu(grid_menu);
    }
}