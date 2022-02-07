package com.example.mowater.ui.fragment.Mwatery.AddCar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.mowater.R;
import com.example.mowater.data.models.Brands.Datum;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;


public class AddCarFragment extends Fragment implements AddCarFragmentContract {
    public static final String TAG = "Add_car_Fragment";
    // Views
    AutoCompleteTextView spVehicleType, spVehicleBrands;

    //Variables
    String vehicleType, vehicleBrand;
    AddCarFragmentViewModel viewModel;
    ArrayAdapter<CharSequence> vehicleTypeArrayAdapter;
    ArrayAdapter<CharSequence> vehicleBrandsAdapter;
    ArrayList<CharSequence> vehicleBrandsList=new ArrayList<>();



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_car, container, false);


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = ViewModelProviders.of(getActivity()).get(AddCarFragmentViewModel.class);
        viewModel.setContract(this);
        viewModel.start();

    }

    @Override
    public void initUi() {
        spVehicleType = getView().findViewById(R.id.sp_vehicle_type);
        spVehicleBrands=getView().findViewById(R.id.sp_vehicle_brand);
    }

    @Override
    public void handleCLicks() {
        spVehicleType.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        vehicleType = "trucks";
                        Toast.makeText(getContext(), "" + vehicleType, Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        vehicleType = "cars";
                        Toast.makeText(getContext(), "" + vehicleType, Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });

    }

    @Override
    public void setStaticViewsData() {
        // set data on spVehicleTpye
        vehicleTypeArrayAdapter = new ArrayAdapter<CharSequence>(getContext(), R.layout.support_simple_spinner_dropdown_item, getResources().getStringArray(R.array.vehicale_types));
        spVehicleType.setAdapter(vehicleTypeArrayAdapter);
    }

    @Override
    public void retriveDataForBrandSpinner(List<Datum> brandsList) {
        for (int i=0;i<brandsList.size();i++){
          vehicleBrandsList.add(brandsList.get(i).getName());
        }
        vehicleBrandsAdapter=new ArrayAdapter<CharSequence>(getContext(), R.layout.support_simple_spinner_dropdown_item,vehicleBrandsList);
        spVehicleBrands.setAdapter(vehicleBrandsAdapter);

    }

    @Override
    public void showMessage(String message) {
        Snackbar snackbar = Snackbar.make(spVehicleBrands, message, BaseTransientBottomBar.LENGTH_INDEFINITE);
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