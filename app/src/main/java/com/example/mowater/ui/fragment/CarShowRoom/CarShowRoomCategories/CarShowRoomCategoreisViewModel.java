package com.example.mowater.ui.fragment.CarShowRoom.CarShowRoomCategories;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mowater.data.api.ApiClient;
import com.example.mowater.data.models.CarShowRoom.CarShowRoomResponse;
import com.example.mowater.data.models.CarShowRoom.Data;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CarShowRoomCategoreisViewModel extends ViewModel {
    MutableLiveData<com.example.mowater.data.models.CarShowRoom.Data> CarShowRoomCategoriesList = new MutableLiveData<>();
    CarShowRoomContract.View view;

    void setContract(CarShowRoomContract.View mView) {
        this.view = mView;
    }

    public void start() {
        view.initUi();
    }

    public MutableLiveData<Data> getAgentCategories() {
        if (view != null) {
            view.showProgressBar();
        }
        ApiClient.getInstance().getCarShowRoomCategories().enqueue(new Callback<CarShowRoomResponse>() {
            @Override
            public void onResponse(Call<CarShowRoomResponse> call, Response<CarShowRoomResponse> response) {
                if (response.isSuccessful()) {
                    if (view != null) {
                        view.hideProgressBar();
                        CarShowRoomCategoriesList.setValue(response.body().getData());
                        view.initRvCarShowRoomCategories(CarShowRoomCategoriesList);
                    }

                } else {
                    if (view != null)
                        view.hideProgressBar();
                    view.showMessage(response.message());
                }
            }

            @Override
            public void onFailure(Call<CarShowRoomResponse> call, Throwable t) {
                if (view != null) {
                    view.hideProgressBar();
                    view.showMessage(t.getMessage());
                }
            }
        });
        return CarShowRoomCategoriesList;
    }
}
