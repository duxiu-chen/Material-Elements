package com.zhugeng.materialdesign.beans;

public class ProgressBeans {
    private String name;
    private String date;
    private int resId;
    private boolean isTitle;

    public ProgressBeans(String name, boolean isTitle) {
        this.name = name;
        this.isTitle = isTitle;
    }

    public ProgressBeans(String name, String date, int resId, boolean isTitle) {
        this.name = name;
        this.date = date;
        this.resId = resId;
        this.isTitle = isTitle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public boolean isTitle() {
        return isTitle;
    }

    public void setTitle(boolean title) {
        isTitle = title;
    }
}
