package com.redbird.letsshopapp2;

import android.content.Context;

import com.redbird.letsshopapp2.database.RealmDatabase;
import com.redbird.letsshopapp2.model.ShoppingItem;

public class ItemAdapterPresenterImpl implements ItemAdapterPresenter {


    private RealmDatabase mDatabase;

    public ItemAdapterPresenterImpl(Context context) {
        mDatabase = RealmDatabase.getInstance(context);
    }

    @Override
    public void setCheckedShoppingItem(ShoppingItem shoppingItem, boolean checked) {
        mDatabase.setCheckedOnItem(shoppingItem, checked);
    }
}
