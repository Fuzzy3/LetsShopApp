package com.redbird.letsshopapp2;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.nfc.Tag;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;
import com.redbird.letsshopapp2.model.ShoppingItem;

import java.util.ArrayList;
import java.util.List;

import static android.content.ClipDescription.MIMETYPE_TEXT_PLAIN;

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

    public static String getListAsString(List<ShoppingItem> shoppingItemList) {
        String stringlist = "";
        for (ShoppingItem item : shoppingItemList) {
            if(shoppingItemList.get(shoppingItemList.size()-1).equals(item)) {
                stringlist = stringlist.concat("- " + item.getTitle() + "");
            } else {
                stringlist = stringlist.concat("- " + item.getTitle() + "\n");
            }
        }
        return stringlist;
    }

    public static List<ShoppingItem> getUncheckedList(List<ShoppingItem> shoppingItems) {
        List<ShoppingItem> uncheckedList = new ArrayList<>();
        for (ShoppingItem item : shoppingItems) {
            if(!item.isChecked()) {
                uncheckedList.add(item);
            }
        }
        return uncheckedList;
    }

    public static List<ShoppingItem> getShoppingItemListFromString(String list) {
        List<ShoppingItem> shoppingItems = new ArrayList<>();
        String[] stringShoppingItems;
        if(list.contains("-")) {
            stringShoppingItems = list.split("-");
        } else {
            stringShoppingItems = list.split("\n");
        }
        for (String item : stringShoppingItems) {
            String trimmedItem = item.trim().replace("\n", "");
            if(!trimmedItem.equals("")){
                shoppingItems.add(new ShoppingItem(trimmedItem, 1));
            }
        }
        return shoppingItems;
    }

    public static String getTextFromClipBoard(Activity activity) {
        ClipboardManager clipboard = (ClipboardManager) activity.getSystemService(Context.CLIPBOARD_SERVICE);
        if (!(clipboard.hasPrimaryClip()) || !(clipboard.getPrimaryClipDescription().hasMimeType(MIMETYPE_TEXT_PLAIN))) {
            return "";
        }
        ClipData.Item item = clipboard.getPrimaryClip().getItemAt(0);
        return item.getText().toString();
    }

    public static void copyTextToClipBoard(String text, String label, Activity activity) {
        ClipboardManager clipboard = (ClipboardManager) activity.getSystemService(Context.CLIPBOARD_SERVICE);

        ClipData clip = ClipData.newPlainText(label, text);
        clipboard.setPrimaryClip(clip);
    }

}
