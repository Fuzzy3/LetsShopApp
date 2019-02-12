package com.redbird.letsshopapp2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.redbird.letsshopapp2.model.ShoppingItem;

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


    public class ItemViewHolder extends RecyclerView.ViewHolder {
        private ShoppingItem mShoppingItem;
        @BindView(R.id.list_cell_item_title) TextView mItemTitle;
        @BindView(R.id.finished_check_box) CheckBox mItemFinishedCheckBox;

        public ItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void onBind(ShoppingItem shoppingItem) {
            mShoppingItem = shoppingItem;
            mItemTitle.setText(shoppingItem.getTitle());
            mItemFinishedCheckBox.setChecked(shoppingItem.isChecked());
        }

        @OnCheckedChanged(R.id.finished_check_box)
        public void onCheckChangedFinishedCheckBox(CompoundButton button, boolean checked) {
            mItemAdapterPresenter.setCheckedShoppingItem(mShoppingItem, checked);
        }
    }
}
