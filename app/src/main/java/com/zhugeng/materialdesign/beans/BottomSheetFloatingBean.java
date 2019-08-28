package com.zhugeng.materialdesign.beans;

public class BottomSheetFloatingBean {
    private int resId;
    private String title;
    private String time;

    public BottomSheetFloatingBean(int resId, String title, String time) {
        this.resId = resId;
        this.title = title;
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }
}
