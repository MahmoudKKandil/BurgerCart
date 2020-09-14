package com.prj.burgercart;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class OrdersDB extends SQLiteOpenHelper {

    private static String databaseName = "ordersDatabase";
    SQLiteDatabase ordersDatabase;

    public OrdersDB(Context context) {
        super(context,databaseName,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table orders(id integer primary key,"+
                "name text not null, description text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists orders");
        onCreate(db);
    }

    public Cursor fetchAllOrders()
    {
        ordersDatabase = getReadableDatabase();
        String [] rowDetails = {"name","description","id"};
        Cursor cursor = ordersDatabase.query("orders",rowDetails,null,null,null,null,null);
        if(cursor != null)
            cursor.moveToFirst();
        ordersDatabase.close();
        return cursor;
    }
}
