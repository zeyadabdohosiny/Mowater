package com.example.mowater.ui.fragment.CarShowRoom.CarShowRoomDetails;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mowater.data.api.ApiClient;
import com.example.mowater.data.models.CarShowRoomDetails.CarShowRoomDetailsResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CarShowRoomDetailsVIewModel extends ViewModel {
    MutableLiveData<CarShowRoomDetailsResponse> CarShowRoomLiveData = new MutableLiveData<>();
    CarShowRoomDetailsContract.View view;

    void setContract(CarShowRoomDetailsContract.View mView) {
        view = mView;
    }

    void start() {
        view.initUi();
        view.handleClicks();
    }

    public MutableLiveData<CarShowRoomDetailsResponse> getAgencyDetails(int carShowRoomId) {
        if (view != null) {
            view.showProgressBar();
        }
        ApiClient.getInstance().getCarShowRoom(carShowRoomId).enqueue(new Callback<CarShowRoomDetailsResponse>() {
            @Override
            public void onResponse(Call<CarShowRoomDetailsResponse> call, Response<CarShowRoomDetailsResponse> response) {
                if (response.isSuccessful()) {
                    if (view != null)
                        view.hideProgressBar();
                        view.setData(response.body().getData());
                } else {
                    if (view != null)
                        view.hideProgressBar();
                }
            }

            @Override
            public void onFailure(Call<CarShowRoomDetailsResponse> call, Throwable throwable) {
                if (view != null) {
                    view.hideProgressBar();
                    view.showMessage(throwable.getMessage());
                }
            }
        });
        return CarShowRoomLiveData;
    }
}
