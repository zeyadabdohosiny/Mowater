package com.example.mowater.ui.activities.Vehicle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mowater.R;
import com.example.mowater.adapters.VehicalefeaturesAdapter;
import com.example.mowater.data.models.vehicles.Datum;
import com.example.mowater.ui.activities.TestDrive.TestDriveActivity;
import com.example.mowater.ui.activities.VehicleReservation.VehicleReservation;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.HashMap;

public class VehicleActivity extends AppCompatActivity implements VehicleContract.View {
    HashMap<String, String> map = new HashMap<>();
    int vehicleId, agencyId;
    RecyclerView rvVehecileFeatures;
    VehicleViewModel viewModel;
    VehicalefeaturesAdapter adapter;
    ProgressBar progressBar;
    AppCompatButton btnVehicleReservation, btnTestDrive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicles);
        viewModel = ViewModelProviders.of(this).get(VehicleViewModel.class);
        viewModel.setContract(this);
        viewModel.start();
        viewModel.getVehicleFeatures(vehicleId);

    }

    @Override
    public void initUi() {
        rvVehecileFeatures = findViewById(R.id.rv_vehicle_features);
        btnVehicleReservation = findViewById(R.id.btn_vehicle_reservation);
        btnTestDrive = findViewById(R.id.btn_vehicle_test_drive);
        progressBar = findViewById(R.id.progress_bar);
    }

    @Override
    public void handleClicks() {
        btnVehicleReservation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), VehicleReservation.class).putExtra("vehicle_id", vehicleId));
            }
        });
        btnTestDrive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), TestDriveActivity.class);
                intent.putExtra("agency_id", agencyId);
                intent.putExtra("vehicle_id", vehicleId);
                startActivity(intent);
            }
        });

    }

    @Override
    public void getDataFromIntent() {
        if (getIntent().getStringExtra("flag").matches("show_room")) {
            vehicleId = getIntent().getIntExtra("vehicle_id", -1);
            agencyId = getIntent().getIntExtra("car_show_room_id", -1);
        } else {
            String vehicleObject = getIntent().getStringExtra("vehicle_object");
            Gson gson = new GsonBuilder().create();
            Datum datum = gson.fromJson(vehicleObject, Datum.class);
            vehicleId = datum.getId();
            agencyId = getIntent().getIntExtra("agency_id", 0);
        }
    }

    @Override
    public void initRvVehicleFeatures(MutableLiveData<HashMap<String, String>> vehicleLiveData) {
        rvVehecileFeatures.setLayoutManager(new LinearLayoutManager(this));
        vehicleLiveData.observe(this, new Observer<HashMap<String, String>>() {
            @Override
            public void onChanged(HashMap<String, String> map) {
                adapter = new VehicalefeaturesAdapter(map);
                rvVehecileFeatures.setAdapter(adapter);
            }
        });


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
        Snackbar snackbar = Snackbar.make(rvVehecileFeatures, message, BaseTransientBottomBar.LENGTH_INDEFINITE);
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
}