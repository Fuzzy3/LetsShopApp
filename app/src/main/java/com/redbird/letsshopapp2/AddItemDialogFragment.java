package com.redbird.letsshopapp2;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.tabs.TabLayout;
import com.redbird.letsshopapp2.model.ShoppingItem;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import butterknife.BindView;
import butterknife.ButterKnife;

public class AddItemDialogFragment extends DialogFragment {

    public static final String TAG = AddItemDialogFragment.class.getSimpleName();

    private AddItemDialogListener mListener;
    private List<ShoppingItem> mShoppingItemsList;
    @BindView(R.id.add_item_edittext) EditText mAddItemEditText;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        // Verify that the host activity implements the callback interface
        try {
            // Instantiate the NoticeDialogListener so we can send events to the host
            mListener = (AddItemDialogListener) context;
        } catch (ClassCastException e) {
            // The activity doesn't implement the interface, throw exception
            Log.e(e.getMessage(), "Activity showing AddItemDialogFragment must implement AddItemDialogListener");
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
//        LayoutInflater layoutInflater = getActivity().getLayoutInflater();

        View view = View.inflate(getContext(), R.layout.dialog_additem, null);
        ButterKnife.bind(this, view);
        mAddItemEditText.requestFocus();
        mShoppingItemsList = new ArrayList<>();

        builder.setView(view)
                .setNegativeButton(R.string.close, (dialogInterface, i) -> mListener.onDialogClosed(mShoppingItemsList))
                .setNeutralButton(R.string.AddAnother, null)
                .setPositiveButton(R.string.add, (dialogInterface, i) -> {
                    mShoppingItemsList.add(new ShoppingItem(mAddItemEditText.getText().toString(), 1));
                    mListener.onDialogClosed(mShoppingItemsList);
                });

        return builder.create();
    }

    @Override
    public void onResume()
    {
        super.onResume();
        AlertDialog alertDialog = (AlertDialog) getDialog();
        Button okButton = alertDialog.getButton(AlertDialog.BUTTON_NEUTRAL);
        okButton.setOnClickListener(v -> {
            addAnotherItem();
        });
    }

    private void addAnotherItem() {
        String input = mAddItemEditText.getText().toString();
        Util.showShortToast(getContext(), input + " added to your shopping list");
        mShoppingItemsList.add(new ShoppingItem(input, 1));
        mAddItemEditText.getText().clear();
    }

    public interface AddItemDialogListener {
        void onDialogClosed(List<ShoppingItem> shoppingItems);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getDialog().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
    }
}
