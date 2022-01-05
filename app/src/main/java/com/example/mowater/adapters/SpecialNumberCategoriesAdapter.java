package com.example.mowater.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mowater.R;
import com.example.mowater.data.models.SpecialNumbersCategories.Datum;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class SpecialNumberCategoriesAdapter extends RecyclerView.Adapter<SpecialNumberCategoriesAdapter.SpecialNumbersCategoriesViewHolder> {
    List<Datum> specialNumberList = new ArrayList<>();
    onItemClickListner onItemClickListner;

    public SpecialNumberCategoriesAdapter(List<Datum> specialNumberList) {
        this.specialNumberList = specialNumberList;
    }

    public void setOnItemClickListner(onItemClickListner listner) {
        this.onItemClickListner = listner;
    }

    public class SpecialNumbersCategoriesViewHolder extends RecyclerView.ViewHolder {
        TextView tvSpecialNumberName;
        CircleImageView ivSpecialNumber;

        public SpecialNumbersCategoriesViewHolder(@NonNull View itemView, onItemClickListner listner) {
            super(itemView);
            tvSpecialNumberName = itemView.findViewById(R.id.tv_special_number_name_item);
            ivSpecialNumber = itemView.findViewById(R.id.iv_special_number_item);
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
    public SpecialNumbersCategoriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.special_number_category_item, parent, false);
        SpecialNumbersCategoriesViewHolder viewHolder = new SpecialNumbersCategoriesViewHolder(view, onItemClickListner);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SpecialNumbersCategoriesViewHolder holder, int position) {
        Datum data = specialNumberList.get(position);
        holder.tvSpecialNumberName.setText(data.getName().toString());
        Picasso.get().load(R.drawable.applogo).into(holder.ivSpecialNumber);
    }

    @Override
    public int getItemCount() {
        return specialNumberList.size();
    }

    public interface onItemClickListner {
        void onClickListner(int position);
    }


}
