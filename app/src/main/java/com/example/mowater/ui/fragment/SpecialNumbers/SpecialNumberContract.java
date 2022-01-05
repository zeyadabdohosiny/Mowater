package com.example.mowater.ui.fragment.SpecialNumbers;

import androidx.lifecycle.MutableLiveData;

import com.example.mowater.data.models.SpecialNumbers.Datum;

import java.util.List;

public interface SpecialNumberContract {
    interface View{
      void  initUi ();
      void  initRvSpecialNumbers(MutableLiveData<List<Datum>> specialNumberList);
        void showMessage(String name);
        void showProgressBar();
        void hideProgressBar();
    }
}
