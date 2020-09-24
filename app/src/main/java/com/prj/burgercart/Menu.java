package com.prj.burgercart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuAdapter;

import android.os.Bundle;
import android.widget.GridView;

import com.example.myapplication.R;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        GridView grid_menu = (GridView)findViewById(R.id.grd_menu);
        menuadapter menuAdapter = new menuadapter(getApplicationContext(),R.layout.menuitem);
        menuAdapter.add("juicy lucy");
        menuAdapter.add("world war");
        menuAdapter.add("juicy lucy");

        grid_menu.setAdapter(menuAdapter);

        registerForContextMenu(grid_menu);
    }
}