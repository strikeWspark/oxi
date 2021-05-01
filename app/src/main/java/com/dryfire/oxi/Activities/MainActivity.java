package com.dryfire.oxi.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.dryfire.oxi.Adapter.OxygenRecyclerViewAdapter;
import com.dryfire.oxi.Adapter.HomeViewPagerAdapter;
import com.dryfire.oxi.Fragments.FabifluFragment;
import com.dryfire.oxi.Fragments.OxygenFragment;
import com.dryfire.oxi.Fragments.RemdesivirFragment;
import com.dryfire.oxi.Model.Distributor;
import com.dryfire.oxi.R;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private HomeViewPagerAdapter homeViewPagerAdapter;
    private RecyclerView recyclerView;
    private OxygenRecyclerViewAdapter adapter;
    private List<Distributor> distributorList;
    private ExtendedFloatingActionButton distributorButton;
    private FirebaseAuth mAuth;
    private FirebaseUser mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();
        distributorList = new ArrayList<>();

        tabLayout = findViewById(R.id.oxi_home_tabLayout);
        viewPager = findViewById(R.id.oxi_homeViewpager);
        homeViewPagerAdapter = new HomeViewPagerAdapter(getSupportFragmentManager());
        //recyclerView = findViewById(R.id.oxi_home_recyclerView);
        adapter = new OxygenRecyclerViewAdapter(this, distributorList);
        distributorButton = findViewById(R.id.distributorButton);
      /*  recyclerView.setLayoutManager(new LinearLayoutManager(this));

        distributorList.add(new Distributor.Builder().setShopName("Oxi Cylinders").setAddress("Lig 78").build());
        distributorList.add(new Distributor.Builder().setShopName("Oxi Cylinders").build());
        distributorList.add(new Distributor.Builder().setShopName("Oxi Cylinders").build());
        distributorList.add(new Distributor.Builder().setShopName("Oxi Cylinders").build());
        recyclerView.setAdapter(adapter);

*/
        homeViewPagerAdapter.addFragment(new OxygenFragment(),"Oxygen");
        homeViewPagerAdapter.addFragment(new RemdesivirFragment(),"Remdesivir");
        homeViewPagerAdapter.addFragment(new FabifluFragment(),"Fabiflu");
        viewPager.setAdapter(homeViewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

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

       // recyclerView.addOnScrollListener(onScrollListener);


        distributorButton.setOnClickListener((View v) -> {

            if(mUser != null){
                Intent intent = new Intent(getApplicationContext(), DashboardActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);

            }else{
                Intent intent = new Intent(getApplicationContext(), RegistrationActivity.class);


            }

        });



    }
}