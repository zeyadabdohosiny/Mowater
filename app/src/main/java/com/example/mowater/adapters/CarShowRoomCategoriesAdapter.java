package com.example.mowater.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mowater.R;
import com.example.mowater.data.models.CarShowRoom.Datum;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class CarShowRoomCategoriesAdapter extends RecyclerView.Adapter<CarShowRoomCategoriesAdapter.CarShowRoomViewHolder> {
    List<Datum> carShowRoomCategoriesList = new ArrayList<>();
    CarShowRoomCategoriesAdapter.OnItemClickListner listner;

    public CarShowRoomCategoriesAdapter(List<Datum> carShowRoomCategoriesList) {
        this.carShowRoomCategoriesList = carShowRoomCategoriesList;
    }
    public void onItemClickListner(CarShowRoomCategoriesAdapter.OnItemClickListner mListner) {
        this.listner = mListner;
    }

    class CarShowRoomViewHolder extends RecyclerView.ViewHolder {
        TextView tvCategoryName;
        ImageView ivCategoryImage;

        public CarShowRoomViewHolder(@NonNull View itemView, OnItemClickListner mListner) {
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
    public CarShowRoomViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.section_categories_item, viewGroup, false);
        CarShowRoomViewHolder viewHolder=new CarShowRoomViewHolder(view,listner);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CarShowRoomViewHolder holder, int position) {
        Datum data = carShowRoomCategoriesList.get(position);
        holder.tvCategoryName.setText(data.getName().toString());
        Picasso.get().load(data.getLogo()).into(holder.ivCategoryImage);
    }

    @Override
    public int getItemCount() {
        return carShowRoomCategoriesList.size();
    }

    public interface OnItemClickListner {
        void getItemPosition(int position);

    }
}
