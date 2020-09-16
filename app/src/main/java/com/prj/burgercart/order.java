package com.prj.burgercart;

public class order {
    private String id,info,desc,date;
    public order(String id,String info,String desc,String date)
    {
        this.date=date;
        this.id=id;

        this.info=info;
        this.desc=desc;

    }

    public String getDate() {

        return date;
    }

    public String getDesc() {
        return desc;
    }

    public String getId() {
        return id;
    }

    public String getInfo() {
        return info;
    }
}
