package com.example.mowater.ui.fragment.RentalOfficeCars;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mowater.data.api.ApiClient;
import com.example.mowater.data.models.RentalOffices.RentalOffices;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RentalOfficeCarsViewModel extends ViewModel {
    MutableLiveData<RentalOffices> rentalOfficeCarsLiveData = new MutableLiveData<RentalOffices>();
    RentalOfficeCarsContract.View view;

    public void setContract(RentalOfficeCarsContract.View mView) {
        this.view = mView;
    }

    public void start() {
        view.initUi();
        view.initRvRentalOffice(rentalOfficeCarsLiveData);
    }

    public MutableLiveData<RentalOffices> getRentalOfficeCars(int rentalOfficeId) {
        if (view != null) {
            view.showProgressBar();
        }
        ApiClient.getInstance().getRentalOffice(rentalOfficeId).enqueue(new Callback<RentalOffices>() {
            @Override
            public void onResponse(Call<RentalOffices> call, Response<RentalOffices> response) {
                if (response.isSuccessful()) {
                    if (view != null) {
                        view.hideProgressBar();
                        rentalOfficeCarsLiveData.setValue(response.body());
                    }
                } else {
                    view.hideProgressBar();
                    view.showMessage(response.message());
                }

            }

            @Override
            public void onFailure(Call<RentalOffices> call, Throwable t) {
                if (view != null) {
                    view.hideProgressBar();
                    view.showMessage(t.getMessage());
                }
            }
        });
        return rentalOfficeCarsLiveData;
    }

}
