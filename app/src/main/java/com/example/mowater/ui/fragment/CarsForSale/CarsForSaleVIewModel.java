package com.example.mowater.ui.fragment.CarsForSale;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mowater.data.api.ApiClient;
import com.example.mowater.data.models.CarsForSale.CarsForSaleResponse;
import com.example.mowater.data.models.CarsForSale.Datum;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CarsForSaleVIewModel extends ViewModel {
    MutableLiveData<List<Datum>> getCarForSaleList = new MutableLiveData<>();
    CarsForSaleContract view;

    public void setContract(CarsForSaleContract contract) {
        this.view = contract;
    }

    public void start() {
        view.initUi();
        view.initRvCarsForSale(getCarForSaleList);
    }

    public MutableLiveData<List<Datum>> getCarsForSale() {
        if (view != null) {
            view.showProgressBar();
            ApiClient.getInstance().getCarsForSale().enqueue(new Callback<CarsForSaleResponse>() {
                @Override
                public void onResponse(Call<CarsForSaleResponse> call, Response<CarsForSaleResponse> response) {
                    if (response.isSuccessful()) {
                        if (response.body().getData() != null) {
                            view.hideProgressBar();
                            getCarForSaleList.setValue(response.body().getData().getData());
                            view.initRvCarsForSale(getCarForSaleList);


                        } else { // no data to show
                            view.hideProgressBar();
                            view.showMessage("no data to show");

                        }

                    } else { // response not Success
                        view.hideProgressBar();
                        view.showMessage(response.message());
                    }


                }

                @Override
                public void onFailure(Call<CarsForSaleResponse> call, Throwable throwable) {
                    view.hideProgressBar();
                    view.showMessage(throwable.getMessage());
                }
            });
        }
        return getCarForSaleList;

    }
}
