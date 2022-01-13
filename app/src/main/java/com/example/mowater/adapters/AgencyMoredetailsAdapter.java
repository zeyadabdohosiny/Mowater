package com.example.mowater.adapters;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mowater.R;
import com.example.mowater.data.models.agencyDetails.CarModel;

import java.util.ArrayList;
import java.util.List;

public class AgencyMoredetailsAdapter extends RecyclerView.Adapter<AgencyMoredetailsAdapter.AgencyMoredetailsViewHolder> {
    List<CarModel> carModelList = new ArrayList<>();
    String carClasses = "";
    OnItemClickListner listner;

    public AgencyMoredetailsAdapter(List<CarModel> carModelList) {
        this.carModelList = carModelList;

    }

    public void onItemClickListner(OnItemClickListner mListner) {
        this.listner = mListner;
    }


    public class AgencyMoredetailsViewHolder extends RecyclerView.ViewHolder {
        TextView tvCarModleName, tvCarClassesName;

        public AgencyMoredetailsViewHolder(@NonNull View itemView, OnItemClickListner listner) {
            super(itemView);
            tvCarModleName = itemView.findViewById(R.id.tv_car_model_name_item);
            tvCarClassesName = itemView.findViewById(R.id.tv_car_classes_name_item);
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
    public AgencyMoredetailsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.agency_more_details_item, parent, false);
        AgencyMoredetailsViewHolder viewHolder = new AgencyMoredetailsViewHolder(view, listner);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final AgencyMoredetailsViewHolder holder, int position) {
        CarModel carModel = carModelList.get(position);
        holder.tvCarModleName.setText(carModel.getName());
        // get All Car Classes At this Car Model and Make it on one String Variable
        for (int i = 0; i < carModel.getCarClasses().size(); i++) {
            carClasses = carClasses + " , " + carModel.getCarClasses().get(i).getName();
        }
        holder.tvCarClassesName.setText(carClasses);
    }

    @Override
    public int getItemCount() {
        return carModelList.size();
    }

    public interface OnItemClickListner {
        void onClickListner(int position);
    }

}
