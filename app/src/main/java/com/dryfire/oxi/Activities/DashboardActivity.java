package com.dryfire.oxi.Activities;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dryfire.oxi.Adapter.DistributorRecyclerViewAdapter;
import com.dryfire.oxi.Model.Distributor;
import com.dryfire.oxi.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;

public class DashboardActivity extends AppCompatActivity {

    private BottomSheetBehavior mBottomSheetBehavior;
    private MaterialButton addOption;
    private MaterialButton uploadButton;
    private TextInputEditText edit;
    TextInputLayout availableInput,capacityInput;
    private RecyclerView recyclerView;
    private DistributorRecyclerViewAdapter adapter;
    private List<Distributor> distributorList;
    private AppCompatSpinner spinner;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        View bottomSheet = findViewById(R.id.oxi_add_option_bottomSheet);

        distributorList = new ArrayList<>();
        mBottomSheetBehavior = BottomSheetBehavior.from(bottomSheet);

        addOption = findViewById(R.id.oxi_addOption);
        spinner = findViewById(R.id.oxi_add_option_spinner);
        uploadButton = findViewById(R.id.uploadButton);
        edit = findViewById(R.id.oxi_shopNamEdit);
        availableInput = findViewById(R.id.oxi_availInput);
        capacityInput = findViewById(R.id.oxi_capacityInput);
        recyclerView = findViewById(R.id.oxi_add_shops);
        adapter = new DistributorRecyclerViewAdapter(this, distributorList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        addOption.setOnClickListener((View v) ->{

            mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        });

        String [] spinnerElementsArray = {"Oxygen","Remdesivir","Fabiflu","Plasma"};
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(this,R.layout.type_spinner_text,spinnerElementsArray);
        spinner.setAdapter(spinnerAdapter);

        uploadButton.setOnClickListener((View v) -> {

            String name = edit.getText().toString().trim();
            distributorList.add(new Distributor.Builder().setShopName(name).build());
            mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);

            Toast.makeText(DashboardActivity.this, ""+ distributorList.get(0).getShopName(), Toast.LENGTH_SHORT).show();
            recyclerView.setAdapter(adapter);


        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String selected = adapterView.getItemAtPosition(i).toString();
                if(selected.equals("Oxygen")){

                    availableInput.setVisibility(View.INVISIBLE);
                    capacityInput.setVisibility((View.INVISIBLE));
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            availableInput.setVisibility(View.VISIBLE);
                            capacityInput.setVisibility(View.VISIBLE);
                        }
                    },700);
                }else{

                    availableInput.setVisibility(View.INVISIBLE);
                    capacityInput.setVisibility((View.INVISIBLE));
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            availableInput.setVisibility(View.GONE);
                            capacityInput.setVisibility(View.GONE);
                        }
                    },700);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
