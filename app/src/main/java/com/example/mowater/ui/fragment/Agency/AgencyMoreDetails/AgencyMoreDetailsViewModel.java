package com.example.mowater.ui.fragment.Agency.AgencyMoreDetails;

import androidx.lifecycle.ViewModel;

public class AgencyMoreDetailsViewModel extends ViewModel {
    AgencyMoreDetailsContract.View view;

    void setContract(AgencyMoreDetailsContract.View mView) {
        this.view = mView;
    }
    public void start(){
        view.initUi();
        view.initrvCalModel();
    }
}
