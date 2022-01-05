package com.example.mowater.ui.fragment.SpecialNumbersReservation;

import androidx.lifecycle.ViewModel;

public class SpecialNumberReservationViewmodel extends ViewModel {

    SpecialNumbersReservationContract.View view;

    public void setContract(SpecialNumbersReservationContract.View mviw) {
        this.view = mviw;
    }

    public void start() {
        view.initUi();
        view.setData();
        view.HandleClick();
    }
}
