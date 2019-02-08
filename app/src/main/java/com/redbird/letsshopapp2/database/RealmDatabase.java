package com.redbird.letsshopapp2.database;

import android.content.Context;

import com.redbird.letsshopapp2.Util;
import com.redbird.letsshopapp2.model.ShoppingItem;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;

public class RealmDatabase {

    private Realm mRealm;
    private static RealmDatabase mRealmDatabase;

    public static RealmDatabase getInstance(Context context) {
        if (mRealmDatabase == null) {
            Realm.init(context);
            mRealmDatabase = new RealmDatabase();
        }
        return mRealmDatabase;
    }


    private RealmDatabase() {
        mRealm = Realm.getDefaultInstance();
    }

    public void addShoppingItem(ShoppingItem shoppingItem) {
        final ShoppingItem fShoppingItem = shoppingItem;
        mRealm.executeTransaction(realm -> {
            mRealm.copyToRealm(fShoppingItem);
        });
    }

    public void removeShoppingItem(ShoppingItem shoppingItem) {

    }

    public List<ShoppingItem> getShoppingItemList() {
        return mRealm.where(ShoppingItem.class).findAll();
    }



}
