package com.dryfire.oxi.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dryfire.oxi.Model.Distributor;
import com.dryfire.oxi.R;
import com.google.android.material.button.MaterialButton;

import java.util.List;

public class PlasmaRecyclerViewAdapter extends RecyclerView.Adapter<PlasmaRecyclerViewAdapter.MyViewHolder> {

    private Context context;
    private List<Distributor> distributorList;

    public PlasmaRecyclerViewAdapter(Context context, List<Distributor> distributorList) {
        this.context = context;
        this.distributorList = distributorList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.plasma_recyclerview_card,parent,false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.name.setText(distributorList.get(position).getDonorName());
        holder.city.setText(distributorList.get(position).getCity());

    }

    @Override
    public int getItemCount() {
        return distributorList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView name,city;
        private MaterialButton mobile;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.oxi_cardplasma_donorName);
            city = itemView.findViewById(R.id.oxi_cardplasma_city);
            mobile = itemView.findViewById(R.id.oxi_cardplasma_mobile);
        }
    }
}
