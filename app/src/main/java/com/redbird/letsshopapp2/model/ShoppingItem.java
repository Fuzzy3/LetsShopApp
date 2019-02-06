package com.redbird.letsshopapp2.model;

public class ShoppingItem {

    private String title;
    private int amount;

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
        this.title = title;
        this.amount = amount;
    }

}
