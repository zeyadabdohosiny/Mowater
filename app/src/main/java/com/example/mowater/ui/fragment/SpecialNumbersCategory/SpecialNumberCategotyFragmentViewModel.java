package com.example.mowater.ui.fragment.SpecialNumbersCategory;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mowater.data.api.ApiClient;
import com.example.mowater.data.models.SpecialNumbersCategories.Data;
import com.example.mowater.data.models.SpecialNumbersCategories.SpecialNumbersCategories;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SpecialNumberCategotyFragmentViewModel extends ViewModel {
    public static final String TAG="SpecialcatNumModel";
    MutableLiveData<Data> specialNumberList = new MutableLiveData<>();
    SpecialNumberCategoryContract.View view;

    public void contract(SpecialNumberCategoryContract.View mview){
        this.view=mview;
    }

    public void start() {
        view.initUi();
        view.initRvSpecialNumbersCategories(specialNumberList);
    }

    public MutableLiveData<Data> getSpecialNumbers() {
        view.showProgressBar();
        ApiClient.getInstance().getSpecialNumbersCategories().enqueue(new Callback<SpecialNumbersCategories>() {
            @Override
            public void onResponse(Call<SpecialNumbersCategories> call, Response<SpecialNumbersCategories> response) {
                if (response.isSuccessful()) {
                    specialNumberList.setValue(response.body().getData());
                    if (view != null) {
                        view.hideProgressBar();
                    }

                } else {
                    if (view != null) {
                        view.hideProgressBar();
                    }
                }

            }

            @Override
            public void onFailure(Call<SpecialNumbersCategories> call, Throwable t) {
                if (view != null) {
                    view.hideProgressBar();
                }

            }
        });

        return specialNumberList;
    }


}
