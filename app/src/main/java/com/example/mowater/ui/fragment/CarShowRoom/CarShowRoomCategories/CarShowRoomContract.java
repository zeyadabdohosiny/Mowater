package com.example.mowater.ui.fragment.CarShowRoom.CarShowRoomCategories;

import androidx.lifecycle.MutableLiveData;

import com.example.mowater.data.models.CarShowRoom.Data;


public class CarShowRoomContract {
    public interface View{
        void initUi();
        void initRvCarShowRoomCategories(MutableLiveData<Data> carShowRoomCategoriesList);
        void replaceFragment(int id);
        void showProgressBar();
        void hideProgressBar();
        void showMessage(String message);
    }
}
