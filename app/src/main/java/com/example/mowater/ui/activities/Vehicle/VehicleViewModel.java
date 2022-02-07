package com.example.mowater.ui.activities.Vehicle;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mowater.data.api.ApiClient;
import com.example.mowater.data.models.vehicle.Vehicle;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VehicleViewModel extends ViewModel {
    MutableLiveData<HashMap<String, String>> vehicleFeaturesLiveData = new MutableLiveData<>();
    VehicleContract.View view;

    public void setContract(VehicleContract.View mview) {
        this.view = mview;
    }

    public void start() {
        view.initUi();
        view.handleClicks();
        view.getDataFromIntent();
    }

    public MutableLiveData<HashMap<String, String>> getVehicleFeatures(int vehicleId) {
        if (view != null) {
            view.showProgressBar();
        }
        ApiClient.getInstance().getVehicle(vehicleId).enqueue(new Callback<Vehicle>() {
            @Override
            public void onResponse(Call<Vehicle> call, Response<Vehicle> response) {
                if (response.isSuccessful()) {
                    if (view != null) {
                        view.hideProgressBar();
                        vehicleFeaturesLiveData.setValue(response.body().getData().getFeatures());
                        view.initRvVehicleFeatures(vehicleFeaturesLiveData);
                    }


                } else {
                    if (view != null) {
                        view.hideProgressBar();
                        view.showMessage(response.message());
                    }

                }

            }

            @Override
            public void onFailure(Call<Vehicle> call, Throwable throwable) {
                if (view != null) {
                    view.hideProgressBar();
                    view.showMessage(throwable.getMessage());
                }
            }
        });
        return vehicleFeaturesLiveData;
    }
}
