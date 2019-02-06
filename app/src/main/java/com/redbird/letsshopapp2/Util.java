package com.redbird.letsshopapp2;

import com.redbird.letsshopapp2.model.ShoppingItem;

import java.util.ArrayList;
import java.util.List;

public class Util {

    List<ShoppingItem> getDummyItems() {
        List<ShoppingItem> dummyItems = new ArrayList<>();

        dummyItems.add(new ShoppingItem("Agurk", 1));
        dummyItems.add(new ShoppingItem("Peberfrugt", 2));
        dummyItems.add(new ShoppingItem("Løg", 1));
        dummyItems.add(new ShoppingItem("Hakkekød", 2));
        dummyItems.add(new ShoppingItem("Chips", 5));
        dummyItems.add(new ShoppingItem("Skummet Mælk", 4));
        dummyItems.add(new ShoppingItem("Rugbrød", 1));
        dummyItems.add(new ShoppingItem("Danskvand, 6stk", 1));

        return dummyItems;
    }
}
