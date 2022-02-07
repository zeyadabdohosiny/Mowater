package com.example.mowater.ui.activities.VehicleReservation;

import android.net.Uri;
import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.ViewModel;

import com.example.mowater.data.api.ApiClient;
import com.example.mowater.data.models.resrveVhicle.ReserveVehicle;
import com.example.mowater.hepers.FileUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VehicleReservationViewModel extends ViewModel {
    VehicleReservationContract.View view;

    void setContrat(VehicleReservationContract.View mView) {
        view = mView;
    }

    void start() {
        view.initUi();
    }

    public void bookingVehicle(String vehicleId, String name, String phone, String adress
            , String drivingLicenseFrontUri, Uri uri, String driving_license_back, String personal_ID_front, String personal_ID_back) {
        view.showProgressBar();
        File orignalFile;
        RequestBody vehicleIdRequest, nameRequest, phoneRequest, adressRequest,
                driving_license_backRequest, personal_ID_frontRequest, personal_ID_backRequset, drivingLicenseFrontUriRequset;
        vehicleIdRequest = RequestBody.create(MediaType.parse("text/plain"), vehicleId);
        nameRequest = RequestBody.create(MediaType.parse("text/plain"), name);
        phoneRequest = RequestBody.create(MediaType.parse("text/plain"), phone);
        adressRequest = RequestBody.create(MediaType.parse("text/plain"), adress);




        if (uri != null) {
            orignalFile = FileUtils.getFile(view.getContext(), uri);
            RequestBody filePart=RequestBody.create(MediaType.parse(view.getContext().getContentResolver().getType(uri)),orignalFile);
            List<MultipartBody.Part> mylist=new ArrayList<>();

            MultipartBody.Part part = MultipartBody.Part.createFormData("driving_license_front", orignalFile.getName(), filePart);
            MultipartBody.Part part1 = MultipartBody.Part.createFormData("driving_license_back", orignalFile.getName(), filePart);
            MultipartBody.Part part2= MultipartBody.Part.createFormData("personal_ID_front", orignalFile.getName(), filePart);
            MultipartBody.Part part3= MultipartBody.Part.createFormData("personal_ID_back", orignalFile.getName(), filePart);
            mylist.add(part);
            mylist.add(part1);
            mylist.add(part2);
            mylist.add(part3);


            ApiClient.getInstance().reserveVehicle(vehicleIdRequest, nameRequest, phoneRequest, adressRequest,mylist).enqueue(new Callback<ReserveVehicle>() {
                @RequiresApi(api = Build.VERSION_CODES.M)
                @Override
                public void onResponse(Call<ReserveVehicle> call, Response<ReserveVehicle> response) {
                    if (response.isSuccessful()) {
                        view.showMessage(response.body().getStatus().toString());
                    }
                    else {
                        view.showMessage(response.body().getMsg().toString());
                        Log.d("Zoksh", "Zeyad" + response.body().getMsg().toString());
                    }


                }

                @Override
                public void onFailure(Call<ReserveVehicle> call, Throwable throwable) {
                    view.showMessage(throwable.getMessage());
                    Log.d("Zoksh", throwable.getMessage());
                }
            });
        }


    }

}
