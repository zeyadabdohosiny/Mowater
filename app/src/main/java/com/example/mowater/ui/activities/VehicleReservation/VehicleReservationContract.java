package com.example.mowater.ui.activities.VehicleReservation;

import android.content.Context;

public interface VehicleReservationContract {
    public interface View{
        void initUi();
        void showMessage(String name);
        void showProgressBar();
        void hideProgressBar();
        Context getContext();
    }
}
