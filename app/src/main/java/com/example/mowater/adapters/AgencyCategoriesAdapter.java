package com.example.mowater.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mowater.R;
import com.example.mowater.data.models.agencyCategories.Datum;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class AgencyCategoriesAdapter extends RecyclerView.Adapter<AgencyCategoriesAdapter.AgencyCategoriesViewHolder> {
    List<Datum> agencyCategoriesList = new ArrayList<>();
    OnItemClickListner listner;

    public AgencyCategoriesAdapter(List<Datum> agencyCategoriesList) {
        this.agencyCategoriesList = agencyCategoriesList;
    }

    public void onItemClickListner(OnItemClickListner mListner) {
        this.listner = mListner;
    }

    public class AgencyCategoriesViewHolder extends RecyclerView.ViewHolder {
        TextView tvCategoryName;
        ImageView ivCategoryImage;

        public AgencyCategoriesViewHolder(@NonNull View itemView, OnItemClickListner mListner) {
            super(itemView);
            tvCategoryName = itemView.findViewById(R.id.tv_section_category_name_item);
            ivCategoryImage = itemView.findViewById(R.id.iv_section_category_item);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mListner.getItemPosition(getAdapterPosition());
                }
            });

        }
    }

    @NonNull
    @Override
    public AgencyCategoriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.section_categories_item, parent, false);
        AgencyCategoriesViewHolder viewHolder = new AgencyCategoriesViewHolder(view, listner);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AgencyCategoriesViewHolder holder, int position) {
        Datum data = agencyCategoriesList.get(position);
        holder.tvCategoryName.setText(data.getName().toString());
        Picasso.get().load(R.drawable.car_logo).into(holder.ivCategoryImage);

    }

    @Override
    public int getItemCount() {
        return agencyCategoriesList.size();
    }

     public interface OnItemClickListner {
      void getItemPosition(int position);

    }
}
