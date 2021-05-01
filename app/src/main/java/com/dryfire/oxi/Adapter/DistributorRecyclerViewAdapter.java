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

import java.util.List;

public class DistributorRecyclerViewAdapter extends RecyclerView.Adapter<DistributorRecyclerViewAdapter.MyViewHolder> {
    private Context context;
    final private List<Distributor> distributorList;

    public DistributorRecyclerViewAdapter(Context context, List<Distributor> distributorList) {
        this.context = context;
        this.distributorList = distributorList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.distributer_card,parent,false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.shopName.setText(distributorList.get(position).getShopName());

    }

    @Override
    public int getItemCount() {
        return distributorList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView shopName,avail,capacity,price,mobile;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            shopName = itemView.findViewById(R.id.oxi_card_shopName);
            avail = itemView.findViewById(R.id.oxi_card_available);
            capacity = itemView.findViewById(R.id.oxi_card_capacity);
            price = itemView.findViewById(R.id.oxi_card_pricePerUnit);
            mobile = itemView.findViewById(R.id.oxi_card_mobile);
        }
    }
}
