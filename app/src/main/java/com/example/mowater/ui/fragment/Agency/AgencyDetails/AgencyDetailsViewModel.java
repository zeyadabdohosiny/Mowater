package com.example.mowater.ui.fragment.Agency.AgencyDetails;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mowater.data.api.ApiClient;
import com.example.mowater.data.models.agencyDetails.AgencyDetails;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AgencyDetailsViewModel extends ViewModel {
    MutableLiveData<AgencyDetails> agencyDetailsLiveData = new MutableLiveData<>();
    AgencyDetailsContract.View view;

    void setContract(AgencyDetailsContract.View mView) {
        view = mView;
    }

    void start() {
        view.initUi();
        view.handleClicks();
    }

    public MutableLiveData<AgencyDetails> getAgencyDetails(int agencyId) {
        if (view != null) {
            view.showProgressBar();
        }
        ApiClient.getInstance().getAgencyDetails(agencyId).enqueue(new Callback<AgencyDetails>() {
            @Override
            public void onResponse(Call<AgencyDetails> call, Response<AgencyDetails> response) {
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
            public void onFailure(Call<AgencyDetails> call, Throwable t) {
                if (view != null) {
                    view.hideProgressBar();
                    view.showMessage(t.getMessage());
                }
            }
        });
        return agencyDetailsLiveData;
    }
}
