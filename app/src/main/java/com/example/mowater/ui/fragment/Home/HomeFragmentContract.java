package com.example.mowater.ui.fragment.Home;

import androidx.lifecycle.MutableLiveData;

import com.example.mowater.data.models.Sections.Datum;
import com.example.mowater.data.models.Sections.Sections;

import java.util.List;

public interface HomeFragmentContract {
    interface View {
        void initUi();
        void initrvSections(MutableLiveData< List<Datum>> data);
        void showMessage(String name);
        void showProgressBar();
        void hideProgressBar();
    }


}
