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
        menuAdapter.AddItem(new MenuItem(10,50,"jucylucy","210 gram burger - tomatos"));
        menuAdapter.AddItem(new MenuItem(10,50,"World war","210 gram burger - tomatos -mozarilla sticks -  beacon - ay 7aga w bta3 "));
        menuAdapter.AddItem(new MenuItem(10,50,"jucylucy"," "));

        grid_menu.setAdapter(menuAdapter);

        registerForContextMenu(grid_menu);
    }
}