package com.prj.burgercart;

public class MenuItem {
    public int ID,Price,Quantity;
    public String Title,Description;

    public MenuItem(int ID,String title, String description, int price) {
        this.ID = ID;
        Price = price;
        Title = title;
        Description = description;
        Quantity=1;
    }
}
