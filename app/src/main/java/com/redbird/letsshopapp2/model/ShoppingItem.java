package com.redbird.letsshopapp2.model;

import java.util.UUID;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class ShoppingItem extends RealmObject {

    @PrimaryKey
    private String mId;
    private String title;
    private int amount;
    private boolean isChecked;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public ShoppingItem(String title, int amount) {
        mId = UUID.randomUUID().toString();
        this.title = title;
        this.amount = amount;
    }

    public ShoppingItem() {

    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }
}
