package com.example.mowater.ui.fragment.CarShowRoom.CarShowRoomMoreDetails;

import com.example.mowater.data.models.CarShowRoomDetails.MainVehicle;
import com.example.mowater.data.models.agencyDetails.CarModel;

public class CarShowRoomMoreDetailsContract {
    public interface View {
        void initUi();

        void initrvCalModel();

        void replaceFragment(MainVehicle carModel);
    }

}
