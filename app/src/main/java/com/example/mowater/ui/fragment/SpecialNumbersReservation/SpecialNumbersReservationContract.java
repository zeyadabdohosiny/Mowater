package com.example.mowater.ui.fragment.SpecialNumbersReservation;

public interface SpecialNumbersReservationContract {
    interface View{
        void initUi();
        void setData();
        void getReservationData();
        void HandleClick();
        void showProgressBar();
        void hideProgressBar();
        void showMessage(String message);
        void showReserveProgress();
        void hideReserveProgress();

    }
}
