package com.example.mowater.adapters;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mowater.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class VehicalefeaturesAdapter extends RecyclerView.Adapter<VehicalefeaturesAdapter.VehicalefeaturesViewHolder> {
    ArrayList<String> keyList = new ArrayList<>();
    ArrayList<String> valueList = new ArrayList<>();
    HashMap<String, String> mMap = new HashMap<>();


    public VehicalefeaturesAdapter(HashMap<String, String> map) {
        Set keys = map.keySet();
        int k = 0;
        for (Iterator i = keys.iterator(); i.hasNext(); ) {
            keyList.add((String) i.next());
            valueList.add(map.get(keyList.get(k)));
            k++;
        }


    }

    public class VehicalefeaturesViewHolder extends RecyclerView.ViewHolder {
        TextView tvKey, tvValue;

        public VehicalefeaturesViewHolder(@NonNull View itemView) {
            super(itemView);
            tvKey = itemView.findViewById(R.id.tv_feature_key_item);
            tvValue = itemView.findViewById(R.id.tv_feature_value_item);


        }
    }

    @NonNull
    @Override
    public VehicalefeaturesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.vehicle_features_item, parent, false);
        VehicalefeaturesViewHolder viewHolder = new VehicalefeaturesViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final VehicalefeaturesViewHolder holder, int position) {

        holder.tvKey.setText(keyList.get(position));
        holder.tvValue.setText(valueList.get(position));


    }

    @Override
    public int getItemCount() {
        return valueList.size();
    }


}
