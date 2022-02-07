package com.example.mowater.ui.activities.VehicleReservation;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModelProviders;

import com.example.mowater.R;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class VehicleReservation extends AppCompatActivity implements VehicleReservationContract.View {
    Button btn;
    TextView tvFrontLicense, tvBackLicense;
    ProgressBar progressBar;
    Uri selectedImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicale_reservation);
        int x = getIntent().getIntExtra("vehicle_id", 0);
        String name = "" + x;
        VehicleReservationViewModel viewModel = ViewModelProviders.of(this).get(VehicleReservationViewModel.class);
        viewModel.setContrat(this);
        viewModel.start();

        progressBar.setVisibility(View.VISIBLE);
        tvFrontLicense.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                permisiion();
                Log.d("Zeyad", "onClick: " + selectedImage);
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                Log.d("Zoksh", "" + selectedImage);
                viewModel.bookingVehicle(name.trim(), "ZeyadAbdoHosiny", "01222419149", "maady", "hello", selectedImage, "sdf", "sdf", "sadasd");

            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private boolean permisiion() {
        if (checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED
                && checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
            Log.e("Permission error", "You have permission");
            Intent intent = new Intent();
            intent.setType("image/*");
            intent.setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(Intent.createChooser(intent, "Select Picture"), 5);
            return true;
        } else {
            Log.e("Permission error", "You have asked for permission");
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE}, 2);
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
            Log.e("uri", selectedImage.toString());
            String[] filePathColumn = {MediaStore.Images.Media.DATA};
            Cursor cursor = getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();
        }
    }

    @Override
    public void initUi() {
        tvFrontLicense = findViewById(R.id.tv_reservation_front_driving_license);
        tvBackLicense = findViewById(R.id.tv_reservation_back_driving_license);
        progressBar = findViewById(R.id.progess_bar_reservation);
        btn = findViewById(R.id.btn_vehicle_reserve);
    }

    @Override
    public void showMessage(String name) {
        Snackbar snackbar = Snackbar.make(btn, name, BaseTransientBottomBar.LENGTH_INDEFINITE);
        snackbar.setDuration(8000);
        snackbar.setBackgroundTint(ContextCompat.getColor(this, R.color.snack_bar_color));
        snackbar.setAction("تجاهل", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                snackbar.dismiss();
            }
        });
        snackbar.show();
    }


    @Override
    public void showProgressBar() {

    }

    @Override
    public void hideProgressBar() {

    }

    @Override
    public Context getContext() {
        return VehicleReservation.this;
    }
}