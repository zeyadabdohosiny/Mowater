package com.example.mowater.ui.fragment.SpecialNumbersReservation;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.mowater.R;
import com.example.mowater.data.api.ApiClient;
import com.example.mowater.data.models.SpecialNumberReservation.SpecialNumberReservation;
import com.example.mowater.data.models.SpecialNumbers.Datum;
import com.google.android.material.textfield.TextInputEditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SpecialNumbersReservationFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SpecialNumbersReservationFragment extends Fragment implements SpecialNumbersReservationContract.View {
    //Views
    TextView tvNumber, tvTransferType, tvIncludeInsurance, tvsize, tvPrice;
    TextInputEditText etName, etIdCardNumber, etPhone, etAdress;
    AppCompatButton btnReservation, btnVerification;
    ProgressBar progressBar,reserveProgressBar;
    // Variables
    private static final String ARG_PARAM2 = "param2";
    String name,idCardNumber,phone,adress;


    private Datum specialNumberObject;

    SpecialNumberReservationViewmodel viewmodel;

    public SpecialNumbersReservationFragment() {
        // Required empty public constructor
    }

    public static SpecialNumbersReservationFragment newInstance(Datum datum) {
        SpecialNumbersReservationFragment fragment = new SpecialNumbersReservationFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM2, datum);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            specialNumberObject = (Datum) getArguments().getSerializable(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_special_numbers_reservation, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewmodel= ViewModelProviders.of(getActivity()).get(SpecialNumberReservationViewmodel.class);
        viewmodel.setContract(this);
        viewmodel.start();

    }

    @Override
    public void initUi() {
        tvNumber = getView().findViewById(R.id.tv_special_number_number);
        tvTransferType = getView().findViewById(R.id.tv_special_number_transfer_type);
        tvIncludeInsurance = getView().findViewById(R.id.tv_special_number_include_insurance);
        tvsize = getView().findViewById(R.id.tv_special_number_size);
        tvPrice = getView().findViewById(R.id.tv_special_number_price);
        etName = getView().findViewById(R.id.et_special_number_reservation_name);
        etIdCardNumber = getView().findViewById(R.id.et_special_number_reservation_id_card_number);
        etPhone = getView().findViewById(R.id.et_special_number_reservation_phone);
        etAdress = getView().findViewById(R.id.et_special_number_reservation_adress);
        btnVerification = getView().findViewById(R.id.btn_special_number_Verification);
        btnReservation = getView().findViewById(R.id.btn_special_number_reserve);
        progressBar=getView().findViewById(R.id.progress_bar);
        reserveProgressBar=getView().findViewById(R.id.progess_bar_reservation);

    }

    @Override
    public void setData() {
        tvNumber.setText(specialNumberObject.getNumber().toString());
        tvTransferType.setText(specialNumberObject.getTransferType().toString());
        if (specialNumberObject.getIncludeInsurance() == 1)
            tvIncludeInsurance.setText("شامل");
        else
            tvIncludeInsurance.setText("غير شامل");

        tvsize.setText(specialNumberObject.getSize().toString());
        tvPrice.setText(specialNumberObject.getPrice().toString());

    }

    @Override
    public void getReservationData() {
        name=etName.getText().toString();
        idCardNumber=etIdCardNumber.getText().toString();
        phone=etPhone.getText().toString();
        adress=etAdress.getText().toString();
    }

    @Override
    public void HandleClick() {
        btnVerification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });
        btnReservation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name=etName.getText().toString();
                idCardNumber=etIdCardNumber.getText().toString();
                phone=etPhone.getText().toString();
                adress=etAdress.getText().toString();
                viewmodel.reserveSpecialNumber(specialNumberObject.getId().toString(),name,phone,adress
                        ,"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwczpcL1wvbWF3YXRlcnkuc2NoZW1lY29kZS5jb21cL2FwaVwvbG9naW4iLCJpYXQiOjE2NDE4MTIwNTQsIm5iZiI6MTY0MTgxMjA1NCwianRpIjoieXZQOEo0UzY0cWdzODB0SSIsInN1YiI6MTIsInBydiI6IjIzYmQ1Yzg5NDlmNjAwYWRiMzllNzAxYzQwMDg3MmRiN2E1OTc2ZjcifQ.tyGL8EG2L22-I-aPIRg31Jc-HbqmMwooCkcPmU-OBwE").observe(getViewLifecycleOwner(), new Observer<SpecialNumberReservation>() {
                    @Override
                    public void onChanged(SpecialNumberReservation specialNumberReservation) {
                     //   Toast.makeText(getContext(), ""+specialNumberReservation.getMsg(), Toast.LENGTH_SHORT).show();
                    }
                });


            }
        });

    }
    @Override
    public void showMessage(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
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