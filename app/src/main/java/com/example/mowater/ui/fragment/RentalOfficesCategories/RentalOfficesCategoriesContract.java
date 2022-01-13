package com.example.mowater.ui.fragment.RentalOfficesCategories;

import androidx.lifecycle.MutableLiveData;

import com.example.mowater.data.models.RentalOffiecesCategories.Data;
import com.example.mowater.data.models.RentalOffiecesCategories.Datum;

public interface RentalOfficesCategoriesContract {
    interface View{
        void initUi();
        void initRvRentalOfficesCategories(MutableLiveData<Data> rentalOfficesCategoriesList);
        void ReplaceFragment(int id);
        void showProgressBar();
        void hideProgressBar();
        void showMessage(String message);
    }
}
