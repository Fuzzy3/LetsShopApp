package com.redbird.letsshopapp2;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
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

    @BindView(R.id.item_recycler_view)
    private RecyclerView mItemRecyclerView;
    private RecyclerView.Adapter mItemAdapter;
    private RecyclerView.LayoutManager mItemLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
    }

    private void setupRecyclerView() {
        mItemRecyclerView.setHasFixedSize(true);
        mItemLayoutManager = new LinearLayoutManager(this);
        mItemRecyclerView.setLayoutManager(mItemLayoutManager);

        mItemAdapter = new

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

    @OnClick(R.id.camera_fab)
    public void cameraFloatingActionButtonClicked(View view) {
        Snackbar.make(view, "Here be dragons", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }
}
