package com.example.mowater.ui.fragment.RentalOfficeCars;

import androidx.lifecycle.MutableLiveData;

import com.example.mowater.data.models.RentalOffices.RentalOffices;

public interface RentalOfficeCarsContract {
    public interface View {
        void initUi();

        void initRvRentalOffice(MutableLiveData<RentalOffices> rentalOfficeCarsLiveData);

        void ReplaceFragment(com.example.mowater.data.models.RentalOffices.RentalOffices rentalOffices);

        void showProgressBar();

        void hideProgressBar();

        void showMessage(String message);
    }
}
