package com.example.mowater.ui.fragment.Agency.AgencyVehicles;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mowater.data.api.ApiClient;
import com.example.mowater.data.models.vehicles.Vehicles;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AgencyVehiclesViewModel extends ViewModel {
    MutableLiveData<Vehicles> vehiclesLiveData = new MutableLiveData<>();
    AgencyVehiclesContract.View view;

    void setContract(AgencyVehiclesContract.View mview) {
        this.view = mview;
    }

    void start() {
        view.initUi();
        view.getData();
    }

    public MutableLiveData<Vehicles> getVehicles(int agencyId, String modelType, int carModelId, int carClassId) {
        if (view != null) {
            view.showProgressBar();
        }
        ApiClient.getInstance().getVehicles(agencyId, modelType, carModelId, carClassId).enqueue(new Callback<Vehicles>() {
            @Override
            public void onResponse(Call<Vehicles> call, Response<Vehicles> response) {

                if (response.isSuccessful()) {
                    if (view != null) {
                        view.hideProgressBar();
                        vehiclesLiveData.setValue(response.body());
                        view.initRvVehicles(vehiclesLiveData);
                    }
                } else {
                    if (view != null) {
                        view.hideProgressBar();
                        view.showMessage(response.message());
                    }
                }
            }

            @Override
            public void onFailure(Call<Vehicles> call, Throwable throwable) {
                if (view != null) {
                    view.hideProgressBar();
                    view.showMessage(throwable.getMessage());
                }
            }
        });
        return vehiclesLiveData;
    }
}
