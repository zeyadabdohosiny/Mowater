package com.example.mowater.ui.activities.Register;

import androidx.lifecycle.ViewModel;

import com.example.mowater.data.api.ApiClient;
import com.example.mowater.data.models.register.Register;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterViewModel extends ViewModel {

    RegisterContract.View view;

    void setContract(RegisterContract.View mView) {
        this.view = mView;
    }

    void start() {
        view.initUi();
        view.handleClicks();
    }

    public void registerbyEmailAndPassword(String name, String password, String mail,
                                           String phone, String dateOfbirth, String gender) {
        view.showProgressBar();
        ApiClient.getInstance().registerByMailAndPassword(name, password, mail, phone, dateOfbirth, gender).enqueue(new Callback<Register>() {
            @Override
            public void onResponse(Call<Register> call, Response<Register> response) {

                if (response.isSuccessful()){
                    view.hideProgressBar();
                    view.showMessage(response.body().getMsg());
                    view.initSharedPreferences(response.body().getData(),response.body().getData().getToken());
                    view.goIntent();

                }else {
                    view.hideProgressBar();
                    view.showMessage(response.message());
                }

            }

            @Override
            public void onFailure(Call<Register> call, Throwable throwable) {
                view.hideProgressBar();
                view.showMessage("هذا الحساب مسجل من قبل");
            }
        });


    }
}
