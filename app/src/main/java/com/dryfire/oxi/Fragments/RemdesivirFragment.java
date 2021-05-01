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
import com.dryfire.oxi.Adapter.RemdesivirRecyclerViewAdapter;
import com.dryfire.oxi.Model.Distributor;
import com.dryfire.oxi.R;

import java.util.ArrayList;
import java.util.List;

public class RemdesivirFragment extends Fragment {

    private RecyclerView recyclerView;
    private RemdesivirRecyclerViewAdapter adapter;
    private List<Distributor> distributorList;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_remdesivir,container,false);
        recyclerView = v.findViewById(R.id.oxi_remdesivir_recyclerView);
        adapter = new RemdesivirRecyclerViewAdapter(getContext(), distributorList);
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
        distributorList.add(new Distributor.Builder().setShopName("Oxi Cylinders").setCity("Varanasi").setAddress("Lig 78").build());
        distributorList.add(new Distributor.Builder().setShopName("Oxi Cylinders").setCity("ABC").build());

    }
}
