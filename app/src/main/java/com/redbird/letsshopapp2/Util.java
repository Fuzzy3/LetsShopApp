package com.redbird.letsshopapp2;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.redbird.letsshopapp2.model.ShoppingItem;

import java.util.ArrayList;
import java.util.List;

public class Util {

    public static List<ShoppingItem> getDummyItems() {
        List<ShoppingItem> dummyItems = new ArrayList<>();

        dummyItems.add(new ShoppingItem("Agurk", 1));
        dummyItems.add(new ShoppingItem("Peberfrugt", 2));
        dummyItems.add(new ShoppingItem("Løg", 1));
        dummyItems.add(new ShoppingItem("Hakkekød", 2));
        dummyItems.add(new ShoppingItem("Chips", 5));
        dummyItems.add(new ShoppingItem("Skummet Mælk", 4));
        dummyItems.add(new ShoppingItem("Rugbrød", 1));
        dummyItems.add(new ShoppingItem("Danskvand, 6stk", 1));
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

    public static void showSnackBar(View view, String input) {
        Snackbar.make(view, input, Snackbar.LENGTH_LONG).setAction("Action", null).show();
    }

    public static void showShortToast(Context context, String input) {
        Toast.makeText(context, input, Toast.LENGTH_SHORT).show();
    }
}
