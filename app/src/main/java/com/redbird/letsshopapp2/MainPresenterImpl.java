package com.redbird.letsshopapp2;

import android.content.Context;

import com.redbird.letsshopapp2.database.RealmDatabase;
import com.redbird.letsshopapp2.model.ShoppingItem;

import java.util.List;

public class MainPresenterImpl implements MainPresenter {

    private MainView mMainView;
    private RealmDatabase mDatabase;

    public MainPresenterImpl(MainView mainView, Context context) {
        mMainView = mainView;
        mDatabase = RealmDatabase.getInstance(context);
    }

    @Override
    public void itemAdded(ShoppingItem shoppingItem) {
        mDatabase.addShoppingItem(shoppingItem);
        mMainView.setShoppingItemList(getShoppingItemList());
    }

    public List<ShoppingItem> getShoppingItemList() {
        return mDatabase.getShoppingItemList();
    }
}
