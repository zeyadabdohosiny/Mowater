package com.example.mowater.ui.fragment.Home;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mowater.data.api.ApiClient;
import com.example.mowater.data.models.Sections.Datum;
import com.example.mowater.data.models.Sections.Sections;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragmentViewModel extends ViewModel {
    private MutableLiveData<List<Datum>> sectionsList = new MutableLiveData<>();
    HomeFragmentContract.View view;

    public void HomeFragmentViewModell(HomeFragmentContract.View contract) {
        this.view = contract;
    }

    void start() {
        view.initUi();
        view.initrvSections(sectionsList);
    }

    public MutableLiveData<List<Datum>> getSections() {
        view.showProgressBar();
        ApiClient.getInstance().getSections().enqueue(new Callback<Sections>() {
            @Override
            public void onResponse(Call<Sections> call, Response<Sections> response) {
                if (response.isSuccessful()) {
                    sectionsList.setValue(response.body().getData());
                    if (view != null) {
                        view.hideProgressBar();
                    }
                } else {
                    if (view != null) {
                        view.hideProgressBar();
                        view.showMessage(response.message());
                    }
                }
            }

            @Override
            public void onFailure(Call<Sections> call, Throwable t) {
                view.hideProgressBar();
                view.showMessage(t.getMessage());
            }
        });
        return sectionsList;
    }


}
