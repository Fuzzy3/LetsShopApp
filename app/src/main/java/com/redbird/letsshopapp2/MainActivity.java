package com.redbird.letsshopapp2;

import android.os.Bundle;

import com.github.clans.fab.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.item_recycler_view) RecyclerView mItemRecyclerView;
    private RecyclerView.Adapter mItemAdapter;
    private RecyclerView.LayoutManager mItemLayoutManager;

//    @BindView(R.id.add_item_floating_menu_item) FloatingActionButton mAddItemFloatingActionButton;
//    @BindView(R.id.snap_shopping_list_floating_menu_item) FloatingActionButton mSnapShoppingListFloatingActionButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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

        mItemAdapter = new ItemAdapter(Util.getDummyItems());
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

    @OnClick(R.id.add_item_floating_menu_item)
    public void addItemFloatingActionButtonClicked(View view) {
        Util.showSnackBar(view, "Add item clicked!");
    }

    @OnClick(R.id.snap_shopping_list_floating_menu_item)
    public void cameraFloatingActionButtonClicked(View view) {
        Util.showSnackBar(view, "Camera clicked!");
    }


}
