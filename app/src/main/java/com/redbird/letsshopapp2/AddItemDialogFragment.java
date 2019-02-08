package com.redbird.letsshopapp2;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class AddItemDialogFragment extends DialogFragment {

    private AddItemDialogListener mListener;
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

        builder.setView(view)
                .setPositiveButton(R.string.add, (dialogInterface, i) -> {
                    mListener.onAddItemDialogAddClick(mAddItemEditText.getText().toString());
                })
                .setNegativeButton(R.string.cancel, (dialogInterface, i) -> {
                    mListener.onAddItemDialogCancelClick();
                });
        return builder.create();
    }

    public interface AddItemDialogListener {
        void onAddItemDialogAddClick(String newItem);
        void onAddItemDialogCancelClick();
    }
}
