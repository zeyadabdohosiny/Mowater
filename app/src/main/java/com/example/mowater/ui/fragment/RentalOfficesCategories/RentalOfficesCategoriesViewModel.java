package com.example.mowater.ui.fragment.RentalOfficesCategories;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mowater.data.api.ApiClient;
import com.example.mowater.data.models.RentalOffiecesCategories.Data;
import com.example.mowater.data.models.RentalOffiecesCategories.RentalOfficesCategories;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RentalOfficesCategoriesViewModel extends ViewModel {
    MutableLiveData<Data> rentalOfficesCategoriesList = new MutableLiveData<>();
    RentalOfficesCategoriesContract.View view;

    public void setContract(RentalOfficesCategoriesContract.View mview) {
        view = mview;
    }

    public void start() {
        view.initUi();
        view.initRvRentalOfficesCategories(rentalOfficesCategoriesList);
    }

    public MutableLiveData<Data> getRentalOfficesCategoriesList() {
        view.showProgressBar();
        ApiClient.getInstance().getRentalOfficesCategories().enqueue(new Callback<RentalOfficesCategories>() {
            @Override
            public void onResponse(Call<RentalOfficesCategories> call, Response<RentalOfficesCategories> response) {
                if (response.isSuccessful()) {
                    if (view != null) {
                        view.hideProgressBar();
                        rentalOfficesCategoriesList.postValue(response.body().getData());
                    }

                } else {
                    if (view != null) {
                        view.hideProgressBar();
                    }
                }

            }

            @Override
            public void onFailure(Call<RentalOfficesCategories> call, Throwable t) {
                if (view != null) {
                    view.hideProgressBar();
                    view.showMessage(t.getMessage());
                }
            }
        });
        return rentalOfficesCategoriesList;
    }

}
