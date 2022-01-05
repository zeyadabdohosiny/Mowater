package com.example.mowater.ui.fragment.SpecialNumbersReservation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.mowater.R;
import com.example.mowater.data.models.SpecialNumbers.Datum;
import com.google.android.material.textfield.TextInputEditText;

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
                Toast.makeText(getContext(), "recervation", Toast.LENGTH_SHORT).show();
            }
        });

    }
}