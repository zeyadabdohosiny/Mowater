package com.example.mowater.ui.activities.TestDrive;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mowater.data.api.ApiClient;
import com.example.mowater.data.models.Time.AvailableTimeResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TestDriveViewModel extends ViewModel {
    public static final String TAG="Test_Drive_View_Model";

    MutableLiveData<List<String>> availableTimeList = new MutableLiveData<>();
    TestDriveContract.View view;

    void setContract(TestDriveContract.View mView) {
        this.view = mView;
    }

    void start() {
        view.initUi();
        view.getDataFromIntent();
        view.handleClicks();
        view.initRvAvailableTimes(availableTimeList);
    }

    void getAvailableTimes(int vehicaleId, String date) {
        view.showAvailableTimesProgressBar();
        ApiClient.getInstance().getVehicleAvailableTime(vehicaleId, date).enqueue(new Callback<AvailableTimeResponse>() {
            @Override
            public void onResponse(Call<AvailableTimeResponse> call, Response<AvailableTimeResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body().getStatus() == 1) {
                        availableTimeList.postValue(response.body().getData());
                        view.hideAvailableTimesProgressBar();

                    } else if (response.body().getStatus() == 0) {
                        view.showMessage(response.body().getMsg());
                        view.hideAvailableTimesProgressBar();
                        Log.d(TAG, "onResponse: "+response.body().getMsg());
                    }


                } else {  // is response Not success
                    view.showMessage(response.message());
                    view.hideAvailableTimesProgressBar();
                    Log.d(TAG, "onResponseNotSuccess: "+response.message());
                }

            }

            @Override
            public void onFailure(Call<AvailableTimeResponse> call, Throwable throwable) {
                Log.d(TAG, "onFailure: "+throwable.getMessage());
                view.hideAvailableTimesProgressBar();
                view.showMessage(throwable.getMessage());
            }
        });
    }

}
