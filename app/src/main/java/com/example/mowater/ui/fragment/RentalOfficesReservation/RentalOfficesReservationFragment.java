package com.example.mowater.ui.fragment.RentalOfficesReservation;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.mowater.R;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

import java.util.HashMap;


public class RentalOfficesReservationFragment extends Fragment implements RentalOfficeReservationContract.View {
    // Views
    TextInputEditText etName, etIdCardNumber, etPhone, etAdress;
    AppCompatButton btnReservation;
    ProgressBar progressBar, reserveProgressBar;
    TextView tvFrontLicense, tvBackLicense;
    //Variables
    String name, idCardNumber, phone, adress;
    HashMap<String, Uri> imageList = new HashMap<>();
    // ViewModel
    RentalOfficeReservationViewModel viewModel;
    Uri selectedImage;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_rental_offices_reservation, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String name=RentalOfficesReservationFragmentArgs.fromBundle(getArguments()).getRentalOfficeObjcet().getData().getName();
        viewModel= ViewModelProviders.of(this).get(RentalOfficeReservationViewModel.class);
        viewModel.setContract(this);
        viewModel.start();

    }
    @Override
    public void initUi() {
        etName = getView().findViewById(R.id.et_rental_office_reservation_name);
        etIdCardNumber = getView().findViewById(R.id.et_rental_office_reservation_id_card_number);
        etPhone = getView().findViewById(R.id.et_rental_office_reservation_phone);
        etAdress = getView().findViewById(R.id.et_rental_office_reservation_adress);
        tvFrontLicense = getView().findViewById(R.id.tv_reservation_front_driving_license);
        tvBackLicense = getView().findViewById(R.id.tv_reservation_back_driving_license);
        btnReservation = getView().findViewById(R.id.btn_rental_office_reserve);
        progressBar = getView().findViewById(R.id.progress_bar);
        reserveProgressBar = getView().findViewById(R.id.progess_bar_reservation);

    }

    @Override
    public void setData() {

    }


    @Override
    public void handleClick() {


        tvFrontLicense.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                permisiion();
            }
        });

        btnReservation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.bookRentalCar();
            }
        });

    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    private boolean permisiion() {
        if (getActivity().checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED
                && getActivity().checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
            Log.e("Permission error", "You have permission");
            Intent intent = new Intent();
            intent.setType("image/*");
            intent.setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(Intent.createChooser(intent, "Select Picture"), 5);
            return true;
        } else {
            Log.e("Permission error", "You have asked for permission");
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE}, 2);
            return false;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1 && grantResults.length > 0
                && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            Intent intent = new Intent();
            intent.setType("image/*");
            intent.setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(Intent.createChooser(intent, "Select Picture"), 5);
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 5 && data != null) {
            selectedImage = data.getData();
            imageList.put("Image",selectedImage);
            Log.e("uri", selectedImage.toString());
            String[] filePathColumn = {MediaStore.Images.Media.DATA};
            Cursor cursor = getActivity().getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex(filePathColumn[0]); 
            String picturePath = cursor.getString(columnIndex);
            cursor.close();
        }
    }


    @Override
    public void showReserveProgress() {
        reserveProgressBar.setVisibility(View.VISIBLE);
        btnReservation.setVisibility(View.GONE);

    }

    @Override
    public void hideReserveProgress() {
        reserveProgressBar.setVisibility(View.GONE);
        btnReservation.setVisibility(View.VISIBLE);
    }

    @Override
    public void choseImageFromGallery() {

    }


    @Override
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showMessage(String message) {
        Snackbar snackbar = Snackbar.make(btnReservation, message, BaseTransientBottomBar.LENGTH_INDEFINITE);
        snackbar.setDuration(4000);
        snackbar.setBackgroundTint(ContextCompat.getColor(getContext(), R.color.snack_bar_color));
        snackbar.setAction("تجاهل", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                snackbar.dismiss();
            }
        });
        snackbar.show();
    }
}