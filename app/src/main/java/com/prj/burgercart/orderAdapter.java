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

public class orderAdapter extends ArrayAdapter {
  ArrayList list=new ArrayList();
    public orderAdapter(Context con,int resource)
    {
        super(con,resource);
    }
static class layoutHandler
{
    TextView id,date,info,des;
}

    public void add(order or) {
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
        layoutHandler lh;
        if(row==null)
        {
            LayoutInflater lf=(LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row=lf.inflate(R.layout.row_layout,parent,false);
            lh=new layoutHandler();
            lh.id=(TextView)row.findViewById(R.id.orderId);
            lh.date=(TextView)row.findViewById(R.id.orderdate);
            lh.des=(TextView)row.findViewById(R.id.ordedesc);
            lh.info=(TextView)row.findViewById(R.id.orderinfo);
            row.setTag(lh);
        }
        else
            {
                lh=(layoutHandler)row.getTag();
            }
        order ORDER=(order) this.getItem((position));
        lh.id.setText(ORDER.getId().toString());

        lh.date.setText(ORDER.getDate().toString());
        lh.info.setText(ORDER.getInfo().toString());
        lh.des.setText(ORDER.getDesc());
    return row;
    }
}
