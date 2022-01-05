package com.example.mowater.ui.fragment.SpecialNumbers;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mowater.data.api.ApiClient;
import com.example.mowater.data.models.SpecialNumbers.Datum;
import com.example.mowater.data.models.SpecialNumbers.SpecialNumbers;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SpecialNumberViewModel extends ViewModel {
    MutableLiveData<List<Datum>> specialNumbersList = new MutableLiveData<>();
    SpecialNumberContract.View view;

    public void setViewContract(SpecialNumberContract.View view) {
        this.view = view;
    }

    public void Start() {
        view.initUi();
        view.initRvSpecialNumbers(specialNumbersList);
    }

    public MutableLiveData<List<Datum>> getSpecialNumber(Integer specialNumberCategorieId) {
        view.showProgressBar();
        ApiClient.getInstance().getSpecialNumbers(specialNumberCategorieId).enqueue(new Callback<SpecialNumbers>() {
            @Override
            public void onResponse(Call<SpecialNumbers> call, Response<SpecialNumbers> response) {
                if (response.isSuccessful()) {
                    specialNumbersList.setValue(response.body().getData().getData());

                    if (view != null) {

                        view.hideProgressBar();
                    }
                } else {
                    if (view != null) {
                        view.hideProgressBar();
                        view.showMessage("ServerError");
                    }

                }

            }

            @Override
            public void onFailure(Call<SpecialNumbers> call, Throwable t) {
                if (view != null) {
                    view.hideProgressBar();
                    view.showMessage(t.getMessage());
                }
            }
        });
        return specialNumbersList;
    }

}
