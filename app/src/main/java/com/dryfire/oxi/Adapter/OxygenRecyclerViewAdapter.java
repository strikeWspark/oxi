package com.dryfire.oxi.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dryfire.oxi.Model.Distributor;
import com.dryfire.oxi.R;
import com.google.android.material.button.MaterialButton;
import com.razerdp.widget.animatedpieview.AnimatedPieView;
import com.razerdp.widget.animatedpieview.AnimatedPieViewConfig;
import com.razerdp.widget.animatedpieview.data.SimplePieInfo;

import java.util.List;

public class OxygenRecyclerViewAdapter extends RecyclerView.Adapter<OxygenRecyclerViewAdapter.MyViewHolder> {

    private Context context;
    private List<Distributor> distributorList;

    public OxygenRecyclerViewAdapter(Context context, List<Distributor> distributorList) {
        this.context = context;
        this.distributorList = distributorList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.oxygen_recyclerview_card,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        AnimatedPieViewConfig config = new AnimatedPieViewConfig();
        config.addData(new SimplePieInfo(2500, Color.parseColor("#aafb0000"),"A"));
        config.addData(new SimplePieInfo(3200, Color.parseColor("#aa00ff00"),"B"));
        config.addData(new SimplePieInfo(4500, Color.parseColor("#aa0000ff"),"C"));

        config.duration(1000);
        config.drawText(true);
        config.strokeMode(true);
        config.textSize(52);
        config.focusAlphaType(AnimatedPieViewConfig.FOCUS_WITH_ALPHA_REV);
        holder.animatedPieViewProbability.applyConfig(config).start();
        holder.shopName.setText(distributorList.get(position).getShopName());
        if(distributorList.get(position).getAddress() != null){
            holder.directionButton.setVisibility(View.VISIBLE);

        }
    }

    @Override
    public int getItemCount() {
        return distributorList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView shopName,avail,price;
        MaterialButton callButton,directionButton;
        AnimatedPieView animatedPieViewProbability;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            shopName = itemView.findViewById(R.id.oxi_cardOxygen_shopName);
            avail = itemView.findViewById(R.id.oxi_cardOxygen_available);
            price = itemView.findViewById(R.id.oxi_cardOxygen_pricePerUnit);
            callButton = itemView.findViewById(R.id.oxi_cardOxygen_mobile);
            directionButton = itemView.findViewById(R.id.oxi_cardOxygen_direction);
            animatedPieViewProbability = itemView.findViewById(R.id.oxi_probability_piechart);
        }
    }
}
