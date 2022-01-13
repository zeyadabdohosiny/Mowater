package com.example.mowater.ui.fragment.RentalOfficesReservation;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mowater.data.api.ApiClient;
import com.example.mowater.data.models.BookRentalCar.BookRentalCar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RentalOfficeReservationViewModel extends ViewModel {
    MutableLiveData<BookRentalCar> bookRentalCarMutableLiveData = new MutableLiveData<>();
    RentalOfficeReservationContract.View view;

    public void setContract(RentalOfficeReservationContract.View mview) {
        this.view = mview;
    }

    void start() {
        view.initUi();
        view.handleClick();
    }

    public void bookRentalCar() {
        if (view != null) {
            view.showReserveProgress();
        }
        ApiClient.getInstance().bookRentalCar("1", "zeyad", "01222419149",
                "sfad", "2021-12-10", "daily", "1", "bearer" + "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwczpcL1wvbWF3YXRlcnkuc2NoZW1lY29kZS5jb21cL2FwaVwvbG9naW4iLCJpYXQiOjE2NDE4MTIwNTQsIm5iZiI6MTY0MTgxMjA1NCwianRpIjoieXZQOEo0UzY0cWdzODB0SSIsInN1YiI6MTIsInBydiI6IjIzYmQ1Yzg5NDlmNjAwYWRiMzllNzAxYzQwMDg3MmRiN2E1OTc2ZjcifQ.tyGL8EG2L22-I-aPIRg31Jc-HbqmMwooCkcPmU-OBwE").enqueue(new Callback<BookRentalCar>() {
            @Override
            public void onResponse(Call<BookRentalCar> call, Response<BookRentalCar> response) {
                if (response.isSuccessful()) {
                    bookRentalCarMutableLiveData.setValue(response.body());
                    view.showMessage(response.body().getMsg());
                    view.hideReserveProgress();
                } else
                    view.showMessage("not Succes");
                view.hideReserveProgress();
            }

            @Override
            public void onFailure(Call<BookRentalCar> call, Throwable t) {
                if (view != null) {
                    view.showMessage(" not Done" + t);
                    Log.d("ZOksh", "" + t);
                    view.hideReserveProgress();
                }
            }
        });

    }
}
