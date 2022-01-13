package com.example.mowater.ui.fragment.Agency.AgencyCategories;

import androidx.lifecycle.MutableLiveData;

import com.example.mowater.data.models.agencyCategories.Data;

public interface AgencyCategoriesContract {
    public interface View{
        void initUi();
        void initRvAgentCategories(MutableLiveData<Data> AgentCategoriesList);
        void replaceFragment(int id);
        void showProgressBar();
        void hideProgressBar();
        void showMessage(String message);
    }
}
