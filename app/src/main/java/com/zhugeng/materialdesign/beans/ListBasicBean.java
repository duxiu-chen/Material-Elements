package com.zhugeng.materialdesign.beans;

public class ListBasicBean {
    private String name;
    private int resId;
    private String des;

    public ListBasicBean(String name, int resId, String des) {
        this.name = name;
        this.resId = resId;
        this.des = des;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
