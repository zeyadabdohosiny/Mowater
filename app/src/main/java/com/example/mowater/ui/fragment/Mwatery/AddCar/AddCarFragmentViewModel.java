package com.example.mowater.ui.fragment.Mwatery.AddCar;

import androidx.lifecycle.ViewModel;

import com.example.mowater.data.api.ApiClient;
import com.example.mowater.data.models.Brands.BrandsResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddCarFragmentViewModel extends ViewModel {

    AddCarFragmentContract view;

    void setContract(AddCarFragmentContract mview) {
        view = mview;
    }

    void start() {
        view.initUi();
        view.setStaticViewsData();
        view.handleCLicks();
        getAllCarsBrands();
    }

    void getAllCarsBrands() {
        ApiClient.getInstance().getCarsBrands().enqueue(new Callback<BrandsResponse>() {
            @Override
            public void onResponse(Call<BrandsResponse> call, Response<BrandsResponse> response) {
                if (response.isSuccessful()) {
                    view.retriveDataForBrandSpinner(response.body().getData().getData());
                    view.showMessage("succes");
                } else {
                    view.showMessage(response.body().getMsg());
                }
            }

            @Override
            public void onFailure(Call<BrandsResponse> call, Throwable throwable) {
                view.showMessage(throwable.getMessage());
            }
        });
    }


}
