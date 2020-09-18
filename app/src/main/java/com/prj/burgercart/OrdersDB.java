package com.prj.burgercart;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

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
        row.put("status", "notcompleted");
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
        String [] rowDetails = {"id","time","description","details"};
        Cursor cursor = ordersdatabase.rawQuery("select * from orders where status like?",new String[]{"Notcompleted"});
        if(cursor != null)
            cursor.moveToFirst();
        ordersdatabase.close();
        return cursor;
    }
    public Cursor fetchAllOrders2() {
        ordersdatabase = getReadableDatabase();
        String [] rowDetails = {"id","time","description","details"};
        Cursor cursor = ordersdatabase.rawQuery("select * from orders where status like?",new String[]{"completed"});
        if(cursor != null)
            cursor.moveToFirst();
        ordersdatabase.close();
        return cursor;
    }
    public void Searching(String pos)
    {
        ordersdatabase = getWritableDatabase();
        ContentValues newValues = new ContentValues();
        newValues.put("status", "completed");
int p=Integer.parseInt(pos);

        ordersdatabase.update("orders", newValues, "id"+"="+p, null);

        ordersdatabase.close();

    }
}