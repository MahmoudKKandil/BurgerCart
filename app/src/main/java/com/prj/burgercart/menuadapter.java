package com.prj.burgercart;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class menuadapter extends ArrayAdapter {
    ArrayList list=new ArrayList();
    public menuadapter(Context con,int resource)
    {
        super(con,resource);
    }

    public void add(String or) {
        list.add(or);
        super.add(or);

    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row=convertView;
            LayoutInflater lf=(LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row=lf.inflate(R.layout.menuitem,parent,false);
            TextView title =(TextView)row.findViewById(R.id.title);


        String ORDER= (String)this.getItem((position));
        title.setText(ORDER.toString());
        return row;
    }
}
