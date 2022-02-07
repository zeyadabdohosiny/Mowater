package com.example.mowater.ui.activities.TestDrive;

import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface TestDriveContract {
    interface View {
        void initUi();

        void handleClicks();

        void getDataFromIntent();

        void initRvAvailableTimes(MutableLiveData<List<String>> availableTimeList);

        void showMessage(String name);

        void showAvailableTimesProgressBar();

        void hideAvailableTimesProgressBar();
    }
}
