package com.prj.burgercart;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;

public class OrdersDB extends SQLiteOpenHelper {
    private static String databaseName = "ordersDatabase";
    SQLiteDatabase ordersdatabase;
   static int usedbefore=0;
    public OrdersDB(Context context) {


        super(context,databaseName,null,1);  }
    public void createneworder(int id, String time, String description, String details) {
        usedbefore++;
        ContentValues row = new ContentValues();
        row.put("id", id);
        row.put("time", time);
        row.put("description", description);
        row.put("details", details);
        row.put("status", "noncompleted");
        ordersdatabase = getWritableDatabase();
        ordersdatabase.insert("orders", null, row);
        ordersdatabase.close();
    }

    public int getorderid() {

ordersdatabase=getReadableDatabase();
        Cursor cursor= ordersdatabase.rawQuery("SELECT *  FROM orders", null);
        cursor.moveToFirst();
       int count = cursor.getCount()+1;
        cursor.close();
        return count;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table orders(id integer primary key autoincrement,"+
                "time text not null, description text not null,details,status text not null )");

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists orders");
        onCreate(db);
    }

    public Cursor fetchAllOrders() {
        ordersdatabase = getReadableDatabase();
        String [] rowDetails = {"id","time","description","details","status"};
        Cursor cursor = ordersdatabase.query("orders",rowDetails,null,null,null,null,null);
        if(cursor != null)
            cursor.moveToFirst();
        ordersdatabase.close();
        return cursor;
    }
}