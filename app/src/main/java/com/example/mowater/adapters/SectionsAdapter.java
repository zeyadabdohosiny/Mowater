package com.example.mowater.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mowater.R;
import com.example.mowater.data.models.Sections.Datum;

import java.util.ArrayList;
import java.util.List;

public class SectionsAdapter extends RecyclerView.Adapter<SectionsAdapter.SectionsViewHolder> {

    List<Datum> sectionsList = new ArrayList<>();
    OnItemClickListner listner;

    public SectionsAdapter(List<Datum> sectionsList) {
        this.sectionsList = sectionsList;
    }

    public void onClickListner(OnItemClickListner listner) {
        this.listner = listner;
    }

    public class SectionsViewHolder extends RecyclerView.ViewHolder {

        TextView tvSectionName;

        public SectionsViewHolder(@NonNull View itemView, OnItemClickListner listner) {
            super(itemView);
            tvSectionName = itemView.findViewById(R.id.tvSectionName);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listner.clickListner(getAdapterPosition());
                }
            });
        }
    }

    @NonNull
    @Override
    public SectionsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sections_item, parent, false);
        SectionsViewHolder viewHolder = new SectionsViewHolder(view, listner);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SectionsViewHolder holder, int position) {
        Datum datum = sectionsList.get(position);
        holder.tvSectionName.setText(datum.getName());
    }

    @Override
    public int getItemCount() {
        return sectionsList.size();
    }


    public interface OnItemClickListner {
        void clickListner(int position);
    }
}
