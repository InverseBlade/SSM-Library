package com.zzw.entity.custom;

import com.zzw.entity.Item;
import com.zzw.entity.Title;

public class ItemCustom extends Item {

    private Title title;

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return super.toString() +
                "ItemCustom{" +
                "title=" + title +
                '}' +
                '\n';
    }
}
