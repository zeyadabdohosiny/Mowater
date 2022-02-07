package com.example.mowater.ui.fragment.CarShowRoom.CarShowRoomMoreDetails;

import androidx.lifecycle.ViewModel;

public class CarShowRoomsMoreDetailsViewModel extends ViewModel {
    CarShowRoomMoreDetailsContract.View view;
    void setContract(CarShowRoomMoreDetailsContract.View mView) {
        this.view = mView;
    }

    public void start() {
        view.initUi();
        view.initrvCalModel();
    }
}
