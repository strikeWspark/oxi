package com.dryfire.oxi;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;
import com.razerdp.widget.animatedpieview.AnimatedPieView;
import com.razerdp.widget.animatedpieview.AnimatedPieViewConfig;
import com.razerdp.widget.animatedpieview.data.SimplePieInfo;

import java.util.List;

public class HomeRecyclerViewAdapter extends RecyclerView.Adapter<HomeRecyclerViewAdapter.MyViewHolder> {

    private Context context;
    private List<Distributer> distributerList;

    public HomeRecyclerViewAdapter(Context context, List<Distributer> distributerList) {
        this.context = context;
        this.distributerList = distributerList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.home_recyclerview_card,parent,false);
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
        holder.shopName.setText(distributerList.get(position).getShopName());
    }

    @Override
    public int getItemCount() {
        return distributerList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView shopName,avail,price;
        MaterialButton callButton;
        AnimatedPieView animatedPieViewProbability;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            shopName = itemView.findViewById(R.id.oxi_cardHome_shopName);
            avail = itemView.findViewById(R.id.oxi_cardHome_available);
            price = itemView.findViewById(R.id.oxi_cardHome_pricePerUnit);
            callButton = itemView.findViewById(R.id.oxi_cardHome_mobile);
            animatedPieViewProbability = itemView.findViewById(R.id.oxu_probability_piechart);
        }
    }
}
