package com.example.mowater.ui.fragment.Agency.AgencyDetails;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import com.example.mowater.R;
import com.example.mowater.data.models.agencyDetails.Data;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class AgencyDetailsFragment extends Fragment implements AgencyDetailsContract.View {
    //Views
    TextView tvName, tvDescription, tvSupport, tvRecordNumber, tvMoreDetails;
    RatingBar ratingBar;
    ProgressBar progressBar;
    // Variables
    int agencyId;
    NavController navController;
    Data agencyObjcet;
    //ViewModel
    AgencyDetailsViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_agency_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Get this id From AgencyCategoriesFragment
        agencyId = AgencyDetailsFragmentArgs.fromBundle(getArguments()).getAgencyId();
        viewModel = ViewModelProviders.of(getActivity()).get(AgencyDetailsViewModel.class);
        viewModel.setContract(this);
        viewModel.start();
        viewModel.getAgencyDetails(agencyId);
    }

    @Override
    public void initUi() {
        tvName = getView().findViewById(R.id.tv_agency_name);
        tvDescription = getView().findViewById(R.id.tv_agency_description);
        tvMoreDetails = getView().findViewById(R.id.tv_agency_more_details);
        ratingBar = getView().findViewById(R.id.tv_agency_rating);
        progressBar = getView().findViewById(R.id.progress_bar);
    }

    @Override
    public void setData(Data data) {
        tvName.setText(data.getName().toString());
        tvDescription.setText(data.getDescription().toString());
        ratingBar.setRating(2);
        agencyObjcet = data;
    }

    @Override
    public void handleClicks() {
        tvMoreDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(agencyId, agencyObjcet);
            }
        });

    }

    @Override
    public void replaceFragment(int agencyId, Data agencyObjcet) {
        navController = Navigation.findNavController(getView());
        NavDirections directions = AgencyDetailsFragmentDirections.actionAgencyDetailsFragmentToAgencyMoreDetailsFragment(agencyId, agencyObjcet);
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