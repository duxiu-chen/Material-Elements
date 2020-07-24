package com.zhugeng.materialdesign.beans;

import android.support.design.widget.TabLayout;

import java.util.List;

public class MenuBeans {
    private String title;
    private int resId;
    private int type;
    private List<ChildBeans> childBeans;
    private boolean visible;

    public MenuBeans(String title, int resId, int type, List<ChildBeans> childBeans, boolean visible) {
        this.title = title;
        this.resId = resId;
        this.type = type;
        this.visible = visible;
        this.childBeans = childBeans;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public List<ChildBeans> getChildBeans() {
        return childBeans;
    }

    public void setChildBeans(List<ChildBeans> childBeans) {
        this.childBeans = childBeans;

    }

    public static class ChildBeans{
        private String subTitle;
        private boolean hasNew;
        public ChildBeans(String subTitle) {
            this.subTitle = subTitle;
        }

        public ChildBeans(String subTitle, boolean hasNew) {
            this.subTitle = subTitle;
            this.hasNew = hasNew;
        }

        public String getTitle() {
            return subTitle;
        }

        public void setTitle(String subTitle) {
            this.subTitle = subTitle;
        }

        public boolean isHasNew() {
            return hasNew;
        }

        public void setHasNew(boolean hasNew) {
            this.hasNew = hasNew;
        }
    }

}
