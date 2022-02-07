package com.example.mowater.ui.fragment.Agency.AgencyCategories;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mowater.data.api.ApiClient;
import com.example.mowater.data.models.agencyCategories.AgencyCategories;
import com.example.mowater.data.models.agencyCategories.Data;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AgencyCategoriesVIewModel extends ViewModel{
    MutableLiveData<Data> agentCategoriesList = new MutableLiveData<>();
    AgencyCategoriesContract.View view;

    void setContract(AgencyCategoriesContract.View mView) {
        this.view = mView;
    }

    public void start() {
        view.initUi();
    }

    public MutableLiveData<Data> getAgentCategories() {
        if (view != null) {
            view.showProgressBar();
        }
        ApiClient.getInstance().getAgentCategories().enqueue(new Callback<AgencyCategories>() {
            @Override
            public void onResponse(Call<AgencyCategories> call, Response<AgencyCategories> response) {
                if (response.isSuccessful()) {
                    if (view != null) {
                        view.hideProgressBar();
                        agentCategoriesList.setValue(response.body().getData());
                        view.initRvAgentCategories(agentCategoriesList);
                    }

                } else {
                    if (view != null)
                        view.hideProgressBar();
                        view.showMessage(response.message());
                }
            }

            @Override
            public void onFailure(Call<AgencyCategories> call, Throwable t) {
                if (view != null) {
                    view.hideProgressBar();
                    view.showMessage(t.getMessage());
                }
            }
        });
        return agentCategoriesList;
    }

}
