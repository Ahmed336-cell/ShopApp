package com.elm.shop.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.elm.shop.R;
import com.elm.shop.adapter.StoreListAdapter;
import com.elm.shop.model.StoreModel;
import com.elm.shop.viewModel.MainAcViewModel;

public class MainActivity extends AppCompatActivity {

    MainAcViewModel mainAcViewModel;
    RecyclerView rv;
    StoreListAdapter storeListAdapter;
    LinearLayoutManager linearLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainAcViewModel = new ViewModelProvider(this).get(MainAcViewModel.class);
        rv = findViewById(R.id.item_rv);
        linearLayoutManager = new LinearLayoutManager(this);
        rv.setLayoutManager(linearLayoutManager);


        mainAcViewModel.getStoreItems().observe(this, storeModels ->{
            Log.e("MainAc","MovieList: "+storeModels.get(0).getTitle());
            if (storeModels !=null){
                storeListAdapter = new StoreListAdapter(this,storeModels);
                storeListAdapter.notifyDataSetChanged();
                rv.setAdapter(storeListAdapter);
            }
        });
    }
}