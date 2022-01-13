package com.example.mowater.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mowater.R;
import com.example.mowater.data.models.RentalOffices.RentalOfficeCar;

import java.util.ArrayList;
import java.util.List;

public class RentalOfficeCarsAdapter extends RecyclerView.Adapter<RentalOfficeCarsAdapter.RentalOfficesViewHolder> {
    List<RentalOfficeCar> rentalOfficeCarList = new ArrayList<>();
    OnUserClickListner listner;

    public RentalOfficeCarsAdapter(List<RentalOfficeCar> rentalOfficeCarList) {
        this.rentalOfficeCarList = rentalOfficeCarList;
    }

    public void onUserClickListner(OnUserClickListner mlistner) {
        this.listner = mlistner;
    }

    public class RentalOfficesViewHolder extends RecyclerView.ViewHolder {
        TextView tvDynamicYearlyprice, tvYearlyPrice, tvDynamicMonthlyPrice, tvMonthlyprice, tvDynamicWeeklyPrice,
                tvWeeklyPrice, tvDynamicDailyPrice, tvDailyPrice, tvDynamicName, tvName;
        ImageView ivCarLogo;

        public RentalOfficesViewHolder(@NonNull View itemView, OnUserClickListner listner) {
            super(itemView);
            tvDynamicYearlyprice = itemView.findViewById(R.id.tv_dynamic_rental_office_yearly_price_item);
            tvYearlyPrice = itemView.findViewById(R.id.tv_rental_office_yearly_price_item);
            tvDynamicMonthlyPrice = itemView.findViewById(R.id.tv_dynamic_rental_office_monthly_price_item);
            tvMonthlyprice = itemView.findViewById(R.id.tv_rental_office_monthly_price_item);
            tvDynamicWeeklyPrice = itemView.findViewById(R.id.tv_dynamic_rental_office_weekly_price_item);
            tvWeeklyPrice = itemView.findViewById(R.id.tv_rental_office_weekly_price_item);
            tvDynamicDailyPrice = itemView.findViewById(R.id.tv_dynamic_rental_office_daily_price_item);
            tvDailyPrice = itemView.findViewById(R.id.tv_rental_office_daily_price_item);
            tvDynamicName = itemView.findViewById(R.id.tv_dynamic_rental_office_name_item);
            tvName = itemView.findViewById(R.id.tv_rental_office_name_item);
            ivCarLogo = itemView.findViewById(R.id.iv_rental_office_item);
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
    public RentalOfficesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rental_offices_item, parent, false);
        RentalOfficesViewHolder viewHolder = new RentalOfficesViewHolder(view, listner);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RentalOfficesViewHolder holder, int position) {
        RentalOfficeCar object = rentalOfficeCarList.get(position);
        holder.tvDynamicYearlyprice.setText("سنوي");
        holder.tvYearlyPrice.setText(object.getYearlyRentalPrice().toString() + "EG");
        holder.tvDynamicMonthlyPrice.setText("شهري");
        holder.tvMonthlyprice.setText(object.getMonthlyRentalPrice().toString() + "EG");
        holder.tvDynamicWeeklyPrice.setText("اسبوعي");
        holder.tvWeeklyPrice.setText(object.getWeeklyRentalPrice().toString() + "EG");
        holder.tvDynamicDailyPrice.setText("يومي");
        holder.tvDailyPrice.setText(object.getDailyRentalPrice() + "EG");
        holder.tvDynamicName.setText("الاسم");
        holder.tvName.setText(object.getCarClass().getName());

    }

    @Override
    public int getItemCount() {
        return rentalOfficeCarList.size();
    }

    public interface OnUserClickListner {

        void onClickListner(int id);

    }


}
