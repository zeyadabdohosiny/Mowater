package com.example.mowater.ui.fragment.Mwatery.MyCars;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import com.example.mowater.R;


public class MyCarsFragment extends Fragment implements MyCarsFragmentContract {
    public static final String TAG = "My_Cars_Fragment";
    //Views
    TextView tvAddCar;

    // Variables
    NavController navController;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_cars, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initUi();
        handleClicks();
    }

    @Override
    public void initUi() {
        tvAddCar = getView().findViewById(R.id.tv_add_car);
    }

    @Override
    public void handleClicks() {
        tvAddCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment();
            }
        });
    }

    public void replaceFragment() {
        navController = Navigation.findNavController(getView());
        NavDirections directions = MyCarsFragmentDirections.actionMyCarsFragmentToAddCarFragment();
        navController.navigate(directions);
    }
}