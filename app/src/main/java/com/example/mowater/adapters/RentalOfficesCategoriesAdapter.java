package com.example.mowater.adapters;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mowater.R;
import com.example.mowater.data.models.RentalOffiecesCategories.Datum;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class RentalOfficesCategoriesAdapter extends RecyclerView.Adapter<RentalOfficesCategoriesAdapter.RentalOfficesCategoriesViewHolder> {
    List<Datum> rentalofficescategoriesList = new ArrayList<>();
    onItemClickListner listner;

    public void setOnItemClickListner(onItemClickListner mlistner) {
        this.listner = mlistner;
    }

    public RentalOfficesCategoriesAdapter(List<Datum> rentalofficescategoriesList) {
        this.rentalofficescategoriesList = rentalofficescategoriesList;
    }

    public class RentalOfficesCategoriesViewHolder extends RecyclerView.ViewHolder {

        TextView tvRentalOfficesName;
        ImageView ivRentalOffices;

        public RentalOfficesCategoriesViewHolder(@NonNull View itemView, onItemClickListner listner) {
            super(itemView);
            tvRentalOfficesName = itemView.findViewById(R.id.tv_section_category_name_item);
            ivRentalOffices = itemView.findViewById(R.id.iv_section_category_item);
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
    public RentalOfficesCategoriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.section_categories_item, parent, false);
        RentalOfficesCategoriesViewHolder viewHolder = new RentalOfficesCategoriesViewHolder(view, listner);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RentalOfficesCategoriesViewHolder holder, int position) {
        Datum datum = rentalofficescategoriesList.get(position);
        holder.tvRentalOfficesName.setText(datum.getName());
        Picasso.get().load(R.drawable.applogo).into(holder.ivRentalOffices);
    }

    @Override
    public int getItemCount() {
        return rentalofficescategoriesList.size();
    }

    public interface onItemClickListner {
        void onClickListner(int position);
    }
}
