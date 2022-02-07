package com.example.mowater.ui.activities.Register;

import com.example.mowater.data.models.register.Data;

public class RegisterContract {
    interface View {
        void initUi();
        void handleClicks();
        void initSharedPreferences(Data data,String token);
        void register();
        void getDataFromViews();
        void goIntent();
        void showProgressBar();
        void hideProgressBar();
        void showMessage(String message);

    }
}
