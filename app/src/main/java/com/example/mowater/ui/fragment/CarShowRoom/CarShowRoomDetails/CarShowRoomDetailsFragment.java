package com.example.mowater.ui.fragment.CarShowRoom.CarShowRoomDetails;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.mowater.R;
import com.example.mowater.data.models.CarShowRoomDetails.Data;
import com.example.mowater.data.models.vehicles.Vehicles;
import com.example.mowater.ui.fragment.Agency.AgencyDetails.AgencyDetailsFragmentDirections;
import com.example.mowater.ui.fragment.Agency.AgencyDetails.AgencyDetailsViewModel;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;


public class CarShowRoomDetailsFragment extends Fragment implements CarShowRoomDetailsContract.View{
    //Views
    TextView tvName, tvDescription, tvSupport, tvRecordNumber, tvMoreDetails;
    RatingBar ratingBar;
    ProgressBar progressBar;
    // Variables
    NavController navController;
    int carShowRoomId;
    com.example.mowater.data.models.CarShowRoomDetails.Data carShowRoomObjcet;
    //ViewModel
    CarShowRoomDetailsVIewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_car_show_room_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        carShowRoomId=CarShowRoomDetailsFragmentArgs.fromBundle(getArguments()).getCarShowRoomId();
        viewModel= ViewModelProviders.of(getActivity()).get(CarShowRoomDetailsVIewModel.class);
        viewModel.setContract(this);
        viewModel.start();
        viewModel.getAgencyDetails(carShowRoomId);
    }

    @Override
    public void initUi() {
        tvName = getView().findViewById(R.id.tv_car_show_room_name);
        tvDescription = getView().findViewById(R.id.tv_car_show_room_description);
        tvMoreDetails = getView().findViewById(R.id.tv_car_show_room_more_details);
        ratingBar = getView().findViewById(R.id.car_show_room_rating);
        progressBar = getView().findViewById(R.id.progress_bar);
    }

    @Override
    public void setData(com.example.mowater.data.models.CarShowRoomDetails.Data data) {
        tvName.setText(data.getName().toString());
        tvDescription.setText(data.getDescription().toString());
        ratingBar.setRating(data.getRating());
        carShowRoomObjcet = data;
    }

    @Override
    public void handleClicks() {
        tvMoreDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(carShowRoomId, carShowRoomObjcet);
            }
        });
    }

    @Override
    public void replaceFragment(int agencyId, Data carShowRoomObjcet) {
        navController = Navigation.findNavController(getView());
        NavDirections directions = CarShowRoomDetailsFragmentDirections.actionCarShowRoomDetailsToCarShowRoomMoreDetailsFragment(carShowRoomId,carShowRoomObjcet);
        navController.navigate(directions);
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
        Snackbar snackbar = Snackbar.make(tvMoreDetails, message, BaseTransientBottomBar.LENGTH_INDEFINITE);
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