package com.example.mowater.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mowater.R;
import com.example.mowater.data.models.CarShowRoomDetails.CarModel;
import com.example.mowater.data.models.CarShowRoomDetails.MainVehicle;
import com.example.mowater.data.models.CarShowRoomDetails.Model;
import com.example.mowater.data.models.CarShowRoomDetails.Vehicle;
import java.util.ArrayList;
import java.util.List;

public class CarShowRoomMoreDetailsAdapter extends RecyclerView.Adapter<CarShowRoomMoreDetailsAdapter.CustomViewHolder> {
    List<Vehicle> carShowRoomVehicles= new ArrayList<>();
    String carClasses = "";
    CarShowRoomMoreDetailsAdapter.OnItemClickListner listner;

    public CarShowRoomMoreDetailsAdapter(List<Vehicle> carModelList) {
        this.carShowRoomVehicles = carModelList;
    }

    public void onItemClickListner(CarShowRoomMoreDetailsAdapter.OnItemClickListner mListner) {
        this.listner = mListner;
    }
    class CustomViewHolder extends RecyclerView.ViewHolder {
        TextView tvVehicleName, tvVehiclesModel, tvVehiclePrice, tvVehiclePrice2;
        ImageView ivVehiclesImage;
        public CustomViewHolder(@NonNull View itemView, OnItemClickListner listner) {
            super(itemView);
            tvVehicleName = itemView.findViewById(R.id.tv_vehicle_name_item);
            tvVehiclesModel = itemView.findViewById(R.id.tv_vehicle_model_item);
            tvVehiclePrice = itemView.findViewById(R.id.tv_vehicle_price_item);
            tvVehiclePrice2 = itemView.findViewById(R.id.tv_vehicle_price1_item);
            ivVehiclesImage = itemView.findViewById(R.id.iv_vehicle_image);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listner.onClickListner(getAdapterPosition());
                }
            });
        }
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.vehicle_item, parent, false);
        CustomViewHolder viewHolder=new CustomViewHolder(view,listner);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        Vehicle vehicle = carShowRoomVehicles.get(position);
        holder.tvVehicleName.setText("Bmw");
        holder.tvVehiclesModel.setText(vehicle.getMainVehicle().getManufacturingYear());
        holder.tvVehiclePrice.setText(vehicle.getPrice()+ "EG");
        holder.tvVehiclePrice2.setText(vehicle.getPrice()+ "EG");

    }

    @Override
    public int getItemCount() {
        return carShowRoomVehicles.size();
    }
    public interface OnItemClickListner {
        void onClickListner(int position);
    }
}
