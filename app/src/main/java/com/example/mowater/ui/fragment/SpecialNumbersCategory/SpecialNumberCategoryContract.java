package com.example.mowater.ui.fragment.SpecialNumbersCategory;

import androidx.lifecycle.MutableLiveData;

import com.example.mowater.data.models.SpecialNumbersCategories.Data;

public interface SpecialNumberCategoryContract {
    interface View {
        void initUi();
        void initRvSpecialNumbersCategories(MutableLiveData<Data> specialNumberList);
        void showProgressBar();
        void hideProgressBar();
        void showMessage(String message);

    }

}
