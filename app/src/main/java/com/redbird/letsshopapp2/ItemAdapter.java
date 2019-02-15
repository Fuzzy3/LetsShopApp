package com.redbird.letsshopapp2;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.redbird.letsshopapp2.model.ShoppingItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {

    private List<ShoppingItem> mDataset;
    private ItemAdapterPresenter mItemAdapterPresenter;

    public ItemAdapter(List<ShoppingItem> mDataset, Context context) {
        this.mDataset = mDataset;
        mItemAdapterPresenter = new ItemAdapterPresenterImpl(context);
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_cell, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        holder.onBind(mDataset.get(position));
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public void setItemList(List<ShoppingItem> itemList) {
        mDataset = itemList;
    }


    public class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ShoppingItem mShoppingItem;
        @BindView(R.id.list_cell_item_title) TextView mItemTitle;
        @BindView(R.id.finished_check_box) CheckBox mItemFinishedCheckBox;

        public ItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        public void onBind(ShoppingItem shoppingItem) {
            mShoppingItem = shoppingItem;
            mItemTitle.setText(shoppingItem.getTitle());
            mItemFinishedCheckBox.setChecked(shoppingItem.isChecked());
            setStrikeThrough(shoppingItem.isChecked());
        }

        @OnCheckedChanged(R.id.finished_check_box)
        public void onCheckChangedFinishedCheckBox(CompoundButton button, boolean checked) {
            if(mShoppingItem.isChecked() != checked) {
                checkItem(checked);
            }
        }

        private void checkItem(boolean checked) {
            mItemAdapterPresenter.setCheckedShoppingItem(mShoppingItem, checked);
            setStrikeThrough(checked);
            notifyDataSetChanged();
        }


        private void setStrikeThrough(boolean strikeThrough) {
            try {
                if(strikeThrough) {
                    mItemTitle.setPaintFlags(mItemTitle.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                } else {
                    mItemTitle.setPaintFlags(mItemTitle.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onClick(View view) {
            checkItem(!mItemFinishedCheckBox.isChecked());
        }
    }
}
