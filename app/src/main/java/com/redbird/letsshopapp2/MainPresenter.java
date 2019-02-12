package com.redbird.letsshopapp2;

import com.redbird.letsshopapp2.model.ShoppingItem;

import java.util.List;

public interface MainPresenter {
    void itemAdded(ShoppingItem shoppingItem);
    void itemUpdated(ShoppingItem shoppingItem);
    List<ShoppingItem> getShoppingItemList();
    void itemListAdded(List<ShoppingItem> shoppingItems);
    void deleteAllTasks();
    void deleteAllCheckedItems();
}
