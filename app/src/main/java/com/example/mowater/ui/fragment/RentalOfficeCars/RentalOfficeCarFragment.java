package com.example.mowater.ui.fragment.RentalOfficeCars;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mowater.R;
import com.example.mowater.adapters.RentalOfficeCarsAdapter;
import com.example.mowater.data.models.RentalOffices.RentalOffices;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;


public class RentalOfficeCarFragment extends Fragment implements RentalOfficeCarsContract.View {
    // variables
    int rentalOfficeCarId;
    //Rv
    RecyclerView rvRentalOfficesCars;
    RentalOfficeCarsAdapter adapter;
    // ViewModel
    RentalOfficeCarsViewModel viewModel;
    //Views
    ProgressBar progressBar;
    // Navigation
    NavController navController;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_rental_offices, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rentalOfficeCarId = RentalOfficeCarFragmentArgs.fromBundle(getArguments()).getRentalofficesId();
        viewModel = ViewModelProviders.of(this).get(RentalOfficeCarsViewModel.class);
        viewModel.setContract(this);
        viewModel.start();
        viewModel.getRentalOfficeCars(rentalOfficeCarId);

    }

    @Override
    public void initUi() {
        rvRentalOfficesCars = getView().findViewById(R.id.rv_rental_offces);
        progressBar = getView().findViewById(R.id.progress_bar);

    }

    @Override
    public void initRvRentalOffice(MutableLiveData<RentalOffices> rentalOfficeCarsLiveData) {
        if (getView() != null) {
            rvRentalOfficesCars.setLayoutManager(new LinearLayoutManager(getContext()));
            rentalOfficeCarsLiveData.observe(getViewLifecycleOwner(), new Observer<RentalOffices>() {
                @Override
                public void onChanged(RentalOffices rentalOffices) {
                    adapter = new RentalOfficeCarsAdapter(rentalOffices.getData().getRentalOfficeCars());
                    rvRentalOfficesCars.setAdapter(adapter);
                    adapter.onUserClickListner(new RentalOfficeCarsAdapter.OnUserClickListner() {
                        @Override
                        public void onClickListner(int id) {

                            ReplaceFragment(rentalOffices);

                        }
                    });

                }
            });
        }


    }

    @Override
    public void ReplaceFragment(com.example.mowater.data.models.RentalOffices.RentalOffices rentalOffices) {
        navController = Navigation.findNavController(getView());
        NavDirections directions = RentalOfficeCarFragmentDirections.actionRentalOfficesFragmentToRentalOfficesReservationFragment(rentalOffices);
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
        Snackbar snackbar = Snackbar.make(rvRentalOfficesCars, message, BaseTransientBottomBar.LENGTH_INDEFINITE);
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