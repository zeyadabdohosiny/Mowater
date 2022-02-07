package com.example.mowater.ui.fragment.CarShowRoom.CarShowRoomDetails;

import androidx.lifecycle.MutableLiveData;

import com.example.mowater.data.models.CarShowRoomDetails.Data;
import com.example.mowater.data.models.vehicles.Vehicles;

public class CarShowRoomDetailsContract {
    interface View {
        void initUi();

        void setData(com.example.mowater.data.models.CarShowRoomDetails.Data data);

        void handleClicks();

        void replaceFragment(int agencyId, Data agencyObjcet);

        void showProgressBar();

        void hideProgressBar();

        void showMessage(String message);

    }
}
