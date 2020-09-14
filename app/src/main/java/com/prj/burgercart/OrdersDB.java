
package com.prj.burgercart;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
public class OrdersDB extends SQLiteOpenHelper {
    private static String databaseName = "ordersDatabase";
    SQLiteDatabase ordersdatabase;
    public OrdersDB(Context context) {
        super(context,databaseName,null,1);}
    public void createneworder(int id, String time, String description, String details) {
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
        ordersdatabase = getWritableDatabase();
        Cursor cursor = ordersdatabase.rawQuery("SELECT  * FROM ordersdatabase", null);
        int count = cursor.getCount();
        cursor.close();
        return count;

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
    }}