package com.example.mowater.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mowater.R;
import com.example.mowater.data.models.SpecialNumbers.Datum;

import java.util.ArrayList;
import java.util.List;

public class SpecialNumbersAdapter extends RecyclerView.Adapter<SpecialNumbersAdapter.SpecialNumbersViewHolder> {

    List<Datum> specialNumbersList = new ArrayList<>();
    OnItemClickListner mlistner;

    public SpecialNumbersAdapter(List<Datum> specialNumbersList) {
        this.specialNumbersList = specialNumbersList;
    }

    public void onClickListner(OnItemClickListner listner) {
        this.mlistner = listner;
    }

    public class SpecialNumbersViewHolder extends RecyclerView.ViewHolder {
        TextView tvNumber, tvTransferType, tvIncludeInsurance, tvsize, tvPrice, tvReservation;

        public SpecialNumbersViewHolder(@NonNull View itemView, OnItemClickListner listner) {
            super(itemView);
            tvNumber = itemView.findViewById(R.id.tv_special_number_item);
            tvTransferType = itemView.findViewById(R.id.tv_special_number_transfer_type_item);
            tvIncludeInsurance = itemView.findViewById(R.id.tv_special_number_include_insurance_item);
            tvsize = itemView.findViewById(R.id.tv_special_number_size_item);
            tvPrice = itemView.findViewById(R.id.tv_special_number_price_item);
            tvReservation = itemView.findViewById(R.id.tv_special_number_reservation_item);
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
    public SpecialNumbersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.special_number_item, parent, false);
        SpecialNumbersViewHolder viewHolder = new SpecialNumbersViewHolder(view, mlistner);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SpecialNumbersViewHolder holder, int position) {
        Datum object = specialNumbersList.get(position);
        holder.tvNumber.setText(object.getNumber().toString());
        holder.tvTransferType.setText(object.getTransferType().toString());
        if (object.getIncludeInsurance() == 0) {
            holder.tvIncludeInsurance.setText("غير شامل ");
        } else {
            holder.tvIncludeInsurance.setText(" شامل ");
        }
        holder.tvsize.setText(object.getSize().toString());
        holder.tvPrice.setText( " EG " + object.getPrice().toString());
        holder.tvReservation.setText("حجز");
    }

    @Override
    public int getItemCount() {
        return specialNumbersList.size();
    }

    public interface OnItemClickListner {
        void onClickListner(int position);
    }
}
