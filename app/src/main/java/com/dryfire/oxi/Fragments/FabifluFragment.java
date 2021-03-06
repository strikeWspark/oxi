package com.dryfire.oxi.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dryfire.oxi.Adapter.FabifluRecyclerViewAdapter;
import com.dryfire.oxi.Adapter.OxygenRecyclerViewAdapter;
import com.dryfire.oxi.Model.Distributor;
import com.dryfire.oxi.R;

import java.util.ArrayList;
import java.util.List;

public class FabifluFragment extends Fragment {


    private RecyclerView recyclerView;
    private FabifluRecyclerViewAdapter adapter;
    private List<Distributor> distributorList;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_fabiflu,container,false);
        recyclerView = v.findViewById(R.id.oxi_fabiflu_recyclerView);
        adapter = new FabifluRecyclerViewAdapter(getContext(), distributorList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
        return v;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        distributorList = new ArrayList<>();
        distributorList.add(new Distributor.Builder().setShopName("Oxi Cylinders").setCity("Delhi").build());
        distributorList.add(new Distributor.Builder().setShopName("Oxi Cylinders").setCity("Noida").build());
        distributorList.add(new Distributor.Builder().setShopName("Oxi Cylinders").setCity("Varanasi").build());
        distributorList.add(new Distributor.Builder().setShopName("Oxi Cylinders").setCity("ABC").build());

    }
}
