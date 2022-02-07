package com.example.mowater.adapters;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mowater.R;
import com.example.mowater.data.models.vehicles.Datum;

import java.util.ArrayList;
import java.util.List;

public class AgencyVehiclesAdapter extends RecyclerView.Adapter<AgencyVehiclesAdapter.AgencyVehiclesViewHolder> {
    List<Datum> agencyVehiclesList = new ArrayList<>();
    OnItemClickListner listner;


    public AgencyVehiclesAdapter(List<Datum> agencyVehiclesList) {
        this.agencyVehiclesList = agencyVehiclesList;
    }

    public void setOnItemClickListner(OnItemClickListner mListner) {
        this.listner = mListner;
    }

    public class AgencyVehiclesViewHolder extends RecyclerView.ViewHolder {
        TextView tvVehicleName, tvVehiclesModel, tvVehiclePrice, tvVehiclePrice2;
        ImageView ivVehiclesImage;

        public AgencyVehiclesViewHolder(@NonNull View itemView, OnItemClickListner listner) {
            super(itemView);
            tvVehicleName = itemView.findViewById(R.id.tv_vehicle_name_item);
            tvVehiclesModel = itemView.findViewById(R.id.tv_vehicle_model_item);
            tvVehiclePrice = itemView.findViewById(R.id.tv_vehicle_price_item);
            tvVehiclePrice2 = itemView.findViewById(R.id.tv_vehicle_price1_item);
            ivVehiclesImage = itemView.findViewById(R.id.iv_vehicle_image);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listner.onItemClickListner(getAdapterPosition());
                }
            });
        }
    }

    @NonNull
    @Override
    public AgencyVehiclesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.vehicle_item, parent, false);
        AgencyVehiclesViewHolder viewHolder = new AgencyVehiclesViewHolder(view, listner);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final AgencyVehiclesViewHolder holder, int position) {
        Datum object = agencyVehiclesList.get(position);
        holder.tvVehicleName.setText("Bmw");
        holder.tvVehiclesModel.setText(object.getMainVehicle().getManufacturingYear());
        holder.tvVehiclePrice.setText("100"+ "EG");
        holder.tvVehiclePrice2.setText("100"+ "EG");
    }

    @Override
    public int getItemCount() {
        return agencyVehiclesList.size();
    }

    public interface OnItemClickListner {
        void onItemClickListner(int position);
    }
}
