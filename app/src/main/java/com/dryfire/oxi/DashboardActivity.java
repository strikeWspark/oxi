package com.dryfire.oxi;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;

public class DashboardActivity extends AppCompatActivity {

    private BottomSheetBehavior mBottomSheetBehavior;
    private MaterialButton addOption;
    private MaterialButton uploadButton;
    private TextInputEditText edit;
    private RecyclerView recyclerView;
    private DistributorRecyclerViewAdapter adapter;
    private List<Distributer> distributerList;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        View bottomSheet = findViewById(R.id.oxi_add_option_bottomSheet);

        distributerList = new ArrayList<>();
        mBottomSheetBehavior = BottomSheetBehavior.from(bottomSheet);

        addOption = findViewById(R.id.oxi_addOption);
        uploadButton = findViewById(R.id.uploadButton);
        edit = findViewById(R.id.oxi_shopNamEdit);
        recyclerView = findViewById(R.id.oxi_add_shops);
        adapter = new DistributorRecyclerViewAdapter(this,distributerList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        addOption.setOnClickListener((View v) ->{

            mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        });

        uploadButton.setOnClickListener((View v) -> {

            String name = edit.getText().toString().trim();
            distributerList.add(new Distributer.Builder().setShopName(name).build());
            mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);

            Toast.makeText(DashboardActivity.this, ""+ distributerList.get(0).getShopName(), Toast.LENGTH_SHORT).show();
            recyclerView.setAdapter(adapter);


        });
    }
}
