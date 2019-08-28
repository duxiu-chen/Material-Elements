package com.zhugeng.materialdesign.beans;

import android.graphics.drawable.Drawable;
import android.net.Uri;

import com.pchmn.materialchips.model.ChipInterface;

public class ContactChip implements ChipInterface {

    private String label;
    private String info;
    private Drawable drawable;
    private int id;

    public ContactChip(String label, String info, Drawable drawable, int id) {
        this.label = label;
        this.info = info;
        this.drawable = drawable;
        this.id = id;
    }

    @Override
    public Object getId() {
        return id;
    }

    @Override
    public Uri getAvatarUri() {
        return null;
    }

    @Override
    public Drawable getAvatarDrawable() {
        return drawable;
    }

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public String getInfo() {
        return info;
    }
}
