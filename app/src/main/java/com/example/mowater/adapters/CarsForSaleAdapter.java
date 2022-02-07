package com.example.mowater.adapters;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mowater.R;
import com.example.mowater.data.models.CarsForSale.Datum;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class CarsForSaleAdapter extends RecyclerView.Adapter<CarsForSaleAdapter.CarsForSaleViewHolder> {
    List<Datum> carsForSaleList = new ArrayList<>();


    public CarsForSaleAdapter(List<Datum> tvlist) {
        this.carsForSaleList = tvlist;

    }

    public class CarsForSaleViewHolder extends RecyclerView.ViewHolder {

        TextView tvName, tvDescription;
        ImageView carImage;

        public CarsForSaleViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_car_for_sale_name_item);
            tvDescription = itemView.findViewById(R.id.tv_car_for_sale_description_item);
            carImage = itemView.findViewById(R.id.iv_car_for_sale_item);

        }
    }

    @NonNull
    @Override
    public CarsForSaleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cars_for_sale_item, parent, false);
        CarsForSaleViewHolder viewholder = new CarsForSaleViewHolder(view);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull final CarsForSaleViewHolder holder, int position) {

        Datum datum = carsForSaleList.get(position);
        holder.tvName.setText(datum.getMainVehicle().getBrand().getName().toString());
        holder.tvDescription.setText(datum.getMainVehicle().getBodyShape().toString());
   //    Picasso.get().load(datum.getOneImage()).into(holder.carImage);
        holder.carImage.setImageResource(R.drawable.bmw3);


    }

    @Override
    public int getItemCount() {
        return carsForSaleList.size();
    }


}
