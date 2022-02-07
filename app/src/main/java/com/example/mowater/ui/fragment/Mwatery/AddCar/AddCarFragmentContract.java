package com.example.mowater.ui.fragment.Mwatery.AddCar;

import com.example.mowater.data.models.Brands.Datum;

import java.util.ArrayList;
import java.util.List;

public interface AddCarFragmentContract {
    void initUi();
    void handleCLicks();
    void setStaticViewsData();
    void retriveDataForBrandSpinner(List<Datum> brandsList);
    void showMessage(String message);

}
