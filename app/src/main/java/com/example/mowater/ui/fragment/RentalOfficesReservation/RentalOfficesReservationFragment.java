package com.example.mowater.ui.fragment.RentalOfficesReservation;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.mowater.R;
import com.example.mowater.data.models.BookRentalCar.BookRentalCar;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;


public class RentalOfficesReservationFragment extends Fragment implements RentalOfficeReservationContract.View{
    // Views
    TextInputEditText etName, etIdCardNumber, etPhone, etAdress;
    AppCompatButton btnReservation;
    ProgressBar progressBar,reserveProgressBar;

    //Variables
    String name,idCardNumber,phone,adress;


    // ViewModel
    RentalOfficeReservationViewModel viewModel;
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
        btnReservation = getView().findViewById(R.id.btn_rental_office_reserve);
        progressBar=getView().findViewById(R.id.progress_bar);
        reserveProgressBar=getView().findViewById(R.id.progess_bar_reservation);

    }

    @Override
    public void setData() {

    }


    @Override
    public void handleClick() {
        btnReservation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             viewModel.bookRentalCar();
            }
        });

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
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
    }
}