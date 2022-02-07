package com.example.mowater.ui.fragment.RentalOfficesReservation;

public interface RentalOfficeReservationContract {
    interface View {
        void initUi();

        void setData();


        void handleClick();

        void showProgressBar();

        void hideProgressBar();

        void showMessage(String message);

        void showReserveProgress();

        void hideReserveProgress();

        void choseImageFromGallery();

    }
}
