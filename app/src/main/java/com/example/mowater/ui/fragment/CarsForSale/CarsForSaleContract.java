package com.example.mowater.ui.fragment.CarsForSale;

import androidx.lifecycle.MutableLiveData;

import com.example.mowater.data.models.CarsForSale.Datum;
import com.example.mowater.data.models.SpecialNumbersCategories.Data;

import java.util.List;

public interface CarsForSaleContract {
    void initUi();
    void initRvCarsForSale(MutableLiveData<List<Datum>> carsForSaleList);
    void showProgressBar();
    void hideProgressBar();
    void showMessage(String message);
}
