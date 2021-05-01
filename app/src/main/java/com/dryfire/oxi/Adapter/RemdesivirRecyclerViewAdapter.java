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

public class RemdesivirRecyclerViewAdapter extends RecyclerView.Adapter<RemdesivirRecyclerViewAdapter.MyViewHolder> {

    private Context context;
    private List<Distributor> distributorList;

    public RemdesivirRecyclerViewAdapter(Context context, List<Distributor> distributorList) {
        this.context = context;
        this.distributorList = distributorList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.remdesivir_recyclerview_card,parent,false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.shopName.setText(distributorList.get(position).getShopName());
        holder.price.setText("\u20b9 "+distributorList.get(position).getPricePerUnit());
        if(distributorList.get(position).getAddress() != null){
            holder.direction.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return distributorList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView shopName,price;
        MaterialButton mobile,direction;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            shopName = itemView.findViewById(R.id.oxi_cardremdesivir_shopName);
            price = itemView.findViewById(R.id.oxi_cardremdesivir_pricePerUnit);
            mobile = itemView.findViewById(R.id.oxi_cardremdesivir_mobile);
            direction = itemView.findViewById(R.id.oxi_cardremdesivir_direction);
        }
    }
}
