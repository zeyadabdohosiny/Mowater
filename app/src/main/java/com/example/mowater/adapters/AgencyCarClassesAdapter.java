package com.example.mowater.adapters;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mowater.R;
import com.example.mowater.data.models.agencyDetails.CarClass;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

;

public class AgencyCarClassesAdapter extends RecyclerView.Adapter<AgencyCarClassesAdapter.CarClassesViewHolder> {
    List<CarClass> carClassesList = new ArrayList<>();
    AgencyCarClassesAdapter.OnItemClickListner listner;

    public AgencyCarClassesAdapter(List<CarClass> carClassesList) {
        this.carClassesList = carClassesList;

    }

    public void onItemClickListner(AgencyCarClassesAdapter.OnItemClickListner mListner) {
        this.listner = mListner;
    }

    public class CarClassesViewHolder extends RecyclerView.ViewHolder {

        TextView tvCarClassName;
        ImageView ivCarClassImage;

        public CarClassesViewHolder(@NonNull View itemView, OnItemClickListner mListner) {
            super(itemView);
            tvCarClassName = itemView.findViewById(R.id.tv_section_category_name_item);
            ivCarClassImage = itemView.findViewById(R.id.iv_section_category_item);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mListner.onClickListner(getAdapterPosition());
                }
            });

        }
    }

    @NonNull
    @Override
    public CarClassesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.section_categories_item, parent, false);
        CarClassesViewHolder tv = new CarClassesViewHolder(view, listner);
        return tv;
    }

    @Override
    public void onBindViewHolder(@NonNull final CarClassesViewHolder holder, int position) {
        CarClass object = carClassesList.get(position);
        holder.tvCarClassName.setText(object.getName());
        Picasso.get().load(R.drawable.bmw5).into(holder.ivCarClassImage);
    }

    @Override
    public int getItemCount() {
        return carClassesList.size();
    }

    public interface OnItemClickListner {
        void onClickListner(int position);

    }

}
