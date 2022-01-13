package com.example.mowater.ui.fragment.Agency.AgencyDetails;

import com.example.mowater.data.models.agencyDetails.Data;

public interface AgencyDetailsContract {
    interface View {
        void initUi();

        void setData(Data data);

        void handleClicks();

        void replaceFragment(int agencyId, Data agencyObjcet);

        void showProgressBar();

        void hideProgressBar();

        void showMessage(String message);

    }
}
