package com.example.mowater.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mowater.R;

import java.util.ArrayList;
import java.util.List;

public class AvailableTimesAdapter extends RecyclerView.Adapter<AvailableTimesAdapter.AvailableTimeViewHolder> {
    public static final String TAG = "Available_time_adapter";
    List<String> availableTimesListResponse = new ArrayList<String>();
    int selectedItemPosition = -1;
    int previousItem = -1;

    public AvailableTimesAdapter(List<String> availableTimesListResponse) {
        this.availableTimesListResponse = availableTimesListResponse;
    }

    class AvailableTimeViewHolder extends RecyclerView.ViewHolder {
        TextView tvAvailableTimes;
        ImageView ivTimeChecked;

        public AvailableTimeViewHolder(@NonNull View itemView) {
            super(itemView);
            tvAvailableTimes = itemView.findViewById(R.id.tv_available_time_item);
            ivTimeChecked = itemView.findViewById(R.id.iv_time_checked_item);
            tvAvailableTimes.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (selectedItemPosition == getAdapterPosition()) {
                        selectedItemPosition = -1;

                    } else {
                        selectedItemPosition = getAdapterPosition();
                    }
                    notifyDataSetChanged();
                }
            });


        }


    }

    @NonNull
    @Override
    public AvailableTimeViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.available_time_item, viewGroup, false);
        AvailableTimeViewHolder viewHolder = new AvailableTimeViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AvailableTimeViewHolder holder, int position) {
        String time = availableTimesListResponse.get(position);
        holder.tvAvailableTimes.setText(time);
        if (selectedItemPosition == position) {
            holder.ivTimeChecked.setVisibility(View.VISIBLE);
        } else {
            holder.ivTimeChecked.setVisibility(View.GONE);
        }


    }

    @Override
    public int getItemCount() {
        return availableTimesListResponse.size();
    }


    public int getItemChecked() {
        return selectedItemPosition;
    }
}
