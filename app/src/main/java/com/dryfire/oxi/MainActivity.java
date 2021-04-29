package com.dryfire.oxi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private HomeRecyclerViewAdapter adapter;
    private List<Distributer> distributerList;
    private ExtendedFloatingActionButton distributorButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        distributerList = new ArrayList<>();

        recyclerView = findViewById(R.id.oxi_home_recyclerView);
        adapter = new HomeRecyclerViewAdapter(this,distributerList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        distributorButton = findViewById(R.id.distributorButton);
        distributerList.add(new Distributer.Builder().setShopName("Oxi Cylinders").build());
        distributerList.add(new Distributer.Builder().setShopName("Oxi Cylinders").build());
        distributerList.add(new Distributer.Builder().setShopName("Oxi Cylinders").build());
        distributerList.add(new Distributer.Builder().setShopName("Oxi Cylinders").build());
        recyclerView.setAdapter(adapter);

        RecyclerView.OnScrollListener onScrollListener = new RecyclerView.OnScrollListener() {

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                if(dy > 0){
                    distributorButton.shrink();
                }else{
                    distributorButton.extend();
                }
            }
        };

        recyclerView.addOnScrollListener(onScrollListener);


        distributorButton.setOnClickListener((View v) -> startActivity(new Intent(this,RegistrationActivity.class)));



    }
}