package com.redbird.letsshopapp2;

import android.os.Bundle;

import com.github.clans.fab.FloatingActionMenu;
import com.redbird.letsshopapp2.model.ShoppingItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

public class MainActivity extends AppCompatActivity implements AddItemDialogFragment.AddItemDialogListener, MainView {

    @BindView(R.id.main_floating_action_menu) FloatingActionMenu mFloatingActionMenu;
    @BindView(R.id.item_recycler_view) RecyclerView mItemRecyclerView;
    private ItemAdapter mItemAdapter;
    private RecyclerView.LayoutManager mItemLayoutManager;
    private MainPresenter mMainPresenter;
//    @BindView(R.id.add_item_floating_menu_item) FloatingActionButton mAddItemFloatingActionButton;
//    @BindView(R.id.snap_shopping_list_floating_menu_item) FloatingActionButton mSnapShoppingListFloatingActionButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMainPresenter = new MainPresenterImpl(this, this);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        setupRecyclerView();
    }

    private void setupRecyclerView() {
        mItemRecyclerView.setHasFixedSize(true);
        mItemLayoutManager = new LinearLayoutManager(this);
        mItemRecyclerView.setLayoutManager(mItemLayoutManager);

        mItemAdapter = new ItemAdapter(mMainPresenter.getShoppingItemList());
        mItemRecyclerView.setAdapter(mItemAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void showAddItemDialog() {
        // Create an instance of the dialog fragment and show it
        DialogFragment dialog = new AddItemDialogFragment();
        dialog.show(getSupportFragmentManager(), "AddItemDialog");
    }

    @OnClick(R.id.add_item_floating_menu_item)
    public void addItemFloatingActionButtonClicked(View view) {
        mFloatingActionMenu.close(false);
        showAddItemDialog();
    }

    @OnClick(R.id.snap_shopping_list_floating_menu_item)
    public void cameraFloatingActionButtonClicked(View view) {
        mFloatingActionMenu.close(false);
    }

    @Override
    public void onAddItemDialogAddClick(String newItem) {
        mMainPresenter.itemAdded(new ShoppingItem(newItem, 1));
    }

    @Override
    public void onAddItemDialogCancelClick() {

    }

    @Override
    public void setShoppingItemList(List<ShoppingItem> itemList) {
        mItemAdapter.setItemList(itemList);
        mItemAdapter.notifyDataSetChanged();
    }
}
