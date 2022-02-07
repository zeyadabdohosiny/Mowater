package com.example.mowater.ui.activities.Vehicle;

import androidx.lifecycle.MutableLiveData;

import com.example.mowater.data.models.Sections.Datum;
import com.example.mowater.data.models.vehicle.Vehicle;

import java.util.HashMap;
import java.util.List;

public interface VehicleContract {
    interface View {
        void initUi();
        void handleClicks();
        void getDataFromIntent();
        void initRvVehicleFeatures(MutableLiveData<HashMap<String,String>> vehicleLiveData);
        void showMessage(String name);
        void showProgressBar();
        void hideProgressBar();
    }
}
