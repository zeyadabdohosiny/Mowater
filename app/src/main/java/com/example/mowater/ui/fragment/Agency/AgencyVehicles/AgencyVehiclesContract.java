package com.example.mowater.ui.fragment.Agency.AgencyVehicles;

import androidx.lifecycle.MutableLiveData;

import com.example.mowater.data.models.vehicles.Vehicles;

public interface AgencyVehiclesContract {
    interface View{
        void initUi();
        void getData();
        void initRvVehicles( MutableLiveData<Vehicles> vehicles);
        void replaceFragment(int id);
        void showProgressBar();
        void hideProgressBar();
        void showMessage(String message);

    }
}
