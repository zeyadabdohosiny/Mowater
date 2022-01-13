package com.example.mowater.ui.fragment.SpecialNumbersReservation;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mowater.data.api.ApiClient;
import com.example.mowater.data.models.SpecialNumberReservation.SpecialNumberReservation;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SpecialNumberReservationViewmodel extends ViewModel {
    MutableLiveData<SpecialNumberReservation> specialNumberReservationLiveData=new MutableLiveData<>();

    SpecialNumbersReservationContract.View view;

    public void setContract(SpecialNumbersReservationContract.View mviw) {
        this.view = mviw;
    }

    public void start() {
        view.initUi();
        view.setData();
        view.HandleClick();
    }

    public MutableLiveData<SpecialNumberReservation>reserveSpecialNumber(String specialNumberId, String name, String phone, String adress, String token) {
        view.showReserveProgress();
        ApiClient.getInstance().reserveSpecialNumber(specialNumberId, name, phone, adress
                , "bearer" + token).enqueue(new Callback<SpecialNumberReservation>() {
            @Override
            public void onResponse(Call<SpecialNumberReservation> call, Response<SpecialNumberReservation> response) {
                view.showMessage(response.body().getMsg());
                specialNumberReservationLiveData.postValue(response.body());
                view.hideReserveProgress();

            }

            @Override
            public void onFailure(Call<SpecialNumberReservation> call, Throwable t) {
                view.showMessage(t.getMessage());
                view.hideReserveProgress();
            }
        });

         return specialNumberReservationLiveData;
    }
}
