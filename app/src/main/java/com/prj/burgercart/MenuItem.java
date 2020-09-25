package com.prj.burgercart;

public class MenuItem {
    public int ID,Price;
    public String Title,Description;

    public MenuItem(int ID, int price, String title, String description) {
        this.ID = ID;
        Price = price;
        Title = title;
        Description = description;
    }
}
