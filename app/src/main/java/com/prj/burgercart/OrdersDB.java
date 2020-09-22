package com.prj.burgercart;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class OrdersDB extends SQLiteOpenHelper {
    private static String databaseName = "ordersDatabase";
    SQLiteDatabase ordersdatabase;

    static int usedbefore = 0;
    Context C;

    public OrdersDB(Context context) {
        super(context, databaseName, null, 1);
    }

    public void CreateNewOrder(int id, String time, String description, String details, int UserID) {

        ContentValues row = new ContentValues();
        row.put("id", id);
        row.put("time", time);
        row.put("description", description);
        row.put("details", details);
        row.put("status", "notcompleted");
        row.put("User_ID", UserID);
        ordersdatabase = getWritableDatabase();
        ordersdatabase.insert("orders", null, row);
        ordersdatabase.close();

    }

    public int getorderid() {


ordersdatabase=getReadableDatabase();
        Cursor cursor= ordersdatabase.rawQuery("SELECT count(*)  FROM orders", null);
        cursor.moveToFirst();
        int count = cursor.getInt(0);
        ordersdatabase.close();
        return count;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table orders(id integer primary key autoincrement," +
                "time text not null, description text not null,details,status text not null, User_ID integer, FOREIGN KEY(User_ID) REFERENCES orders (UserID) )");
        db.execSQL("create table user" + "(UserID integer primary key autoincrement, UserName text UNIQUE not null, Password text not null, Phone text UNIQUE not null, Email text UNIQUE not null, Address text not null,UserType text default 'NU') ");


    }

    public void createNewUser(String Name, String pass, String phone, String Email, String Address) {
        ContentValues row = new ContentValues();
        row.put("UserName", Name);
        row.put("Password", pass);
        row.put("Phone", phone);
        row.put("Email", Email);
        row.put("Address", Address);
        ordersdatabase = getWritableDatabase();
        ordersdatabase.insert("user", null, row);
        ordersdatabase.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists orders");
        db.execSQL("drop table if exists user");
        onCreate(db);
    }

    public Cursor fetchAllOrders() {
        ordersdatabase = getReadableDatabase();
        String[] rowDetails = {"id", "time", "description", "details"};
        Cursor cursor = ordersdatabase.rawQuery("select * from orders where status like?", new String[]{"Notcompleted"});
        if (cursor != null)
            cursor.moveToFirst();
        ordersdatabase.close();
        return cursor;
    }


    public boolean CheckingEmail(String Email) {
        ordersdatabase = getReadableDatabase();
        Cursor cursor = ordersdatabase.rawQuery("select count(*) from user where Email like?", new String[]{Email});
        cursor.moveToFirst();
        int count = cursor.getInt(0);
        ordersdatabase.close();
        return count > 0;
    }

    public boolean CheckingUserName(String UserName) {
        ordersdatabase = getReadableDatabase();
        Cursor cursor = ordersdatabase.rawQuery("select count(*) from user where UserName like?", new String[]{UserName});
        cursor.moveToFirst();
        int count = cursor.getInt(0);
        ordersdatabase.close();
        return count > 0;
    }

    public String GetPassword(String UserName) {
        String pass = "";
        ordersdatabase = getReadableDatabase();
        Cursor cursor = ordersdatabase.rawQuery("select * from user where UserName like?", new String[]{UserName});
        cursor.moveToFirst();
        if (cursor != null && cursor.moveToFirst()) {

            pass = cursor.getString(cursor.getColumnIndex("Password"));
        }

        ordersdatabase.close();

        return pass;
    }

    public String GetUserType(String UserName) {
        ordersdatabase = getReadableDatabase();
        Cursor cursor = ordersdatabase.rawQuery("select UserType from user where UserName like?", new String[]{UserName});
        if (cursor.moveToFirst()) {
            ordersdatabase.close();
            return cursor.getString(cursor.getColumnIndex("UserType"));
        }
        ordersdatabase.close();

        return null;
    }

    public boolean CheckingPhone(String Phone) {
        ordersdatabase = getReadableDatabase();
        Cursor cursor = ordersdatabase.rawQuery("select count(*) from user where Phone like?", new String[]{Phone});
        cursor.moveToFirst();
        int count = cursor.getInt(0);
        ordersdatabase.close();
        return count > 0;
    }

    public int getUserId(String UserName) {
        int id = -1;
        ordersdatabase = getReadableDatabase();
        Cursor cursor = ordersdatabase.rawQuery("select UserID from user where UserName like?", new String[]{UserName});
        cursor.moveToFirst();
        if (cursor != null && cursor.moveToFirst())
            id = Integer.parseInt(cursor.getString(0));

        ordersdatabase.close();
        return id;
    }

    public void Searching(String pos) {
        ordersdatabase = getWritableDatabase();
        ContentValues newValues = new ContentValues();
        newValues.put("status", "completed");
        int p = Integer.parseInt(pos);
        ordersdatabase.update("orders", newValues, "id" + "=" + p, null);
        ordersdatabase.close();

    }

    public void UpdatingUser(int pos) {
        ordersdatabase = getWritableDatabase();
        ContentValues newValues = new ContentValues();
        newValues.put("UserType", "AD");
        ordersdatabase.update("user", newValues, "UserID" + "=" + pos, null);
        ordersdatabase.close();

    }

    public Cursor ShowHistoryOrders(String username) {
        int id = getUserId(username);
        String type = GetUserType(username);
        ordersdatabase = getReadableDatabase();
        Cursor cursor;
        if (type.equals("AD"))
            cursor = ordersdatabase.rawQuery("select * from orders", null);
        else
            cursor = ordersdatabase.rawQuery("select * from orders where User_ID like ?", new String[]{String.valueOf(id)});
        if (cursor != null)
            cursor.moveToFirst();
        ordersdatabase.close();
        return cursor;
    }



    public Cursor ShowAllUsers()
    {
        ordersdatabase = getReadableDatabase();
        Cursor cursor=ordersdatabase.rawQuery("select UserName from user", new String[]{});
        if (cursor != null)
            cursor.moveToFirst();
        ordersdatabase.close();
        return cursor;
    }

    public String GetEmail(String UserName) {
        String email = "";
        ordersdatabase = getReadableDatabase();
        Cursor cursor = ordersdatabase.rawQuery("select * from user where UserName like?", new String[]{UserName});
        cursor.moveToFirst();
        if (cursor != null && cursor.moveToFirst()) {

            email = cursor.getString(cursor.getColumnIndex("Email"));
        }

        ordersdatabase.close();

        return email;
    }
    public String GetAdress(String UserName) {
        String address= "";
        ordersdatabase = getReadableDatabase();
        Cursor cursor = ordersdatabase.rawQuery("select * from user where UserName like?", new String[]{UserName});
        cursor.moveToFirst();
        if (cursor != null && cursor.moveToFirst()) {

            address = cursor.getString(cursor.getColumnIndex("Address"));
        }

        ordersdatabase.close();

        return address;
    }
    public void Updateuseremail(String newemail,String username){
        ordersdatabase=getWritableDatabase();
        ContentValues row = new ContentValues();
        row.put("Email",newemail);
        ordersdatabase.update("user",row,"UserName like?",new String[]{username});
        ordersdatabase.close();

    }
    public void Updateuseraddress(String newaddress,String username){
        ordersdatabase=getWritableDatabase();
        ContentValues row = new ContentValues();
        row.put("Address",newaddress);
        ordersdatabase.update("user",row,"UserName like?",new String[]{username});
        ordersdatabase.close();

    }
    public void Updateuserpassword(String newpassword,String username){
        ordersdatabase=getWritableDatabase();
        ContentValues row = new ContentValues();
        row.put("Password",newpassword);
        ordersdatabase.update("user",row,"UserName like?",new String[]{username});
        ordersdatabase.close();

    }
    public void DeleteUser(String UserName)
    {
        ordersdatabase = getReadableDatabase();
        ordersdatabase .delete("user", "UserName='" + UserName + "'", null);
        ordersdatabase.close();
    }
}