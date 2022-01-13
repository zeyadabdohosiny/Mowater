package com.example.mowater.ui.fragment.Agency.AgencyMoreDetails;

import com.example.mowater.data.models.agencyDetails.CarModel;

public interface AgencyMoreDetailsContract {
    public interface View {
        void initUi();

        void initrvCalModel();

       void replaceFragment(CarModel carModel);
    }
}
