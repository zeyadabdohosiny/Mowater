package com.example.mowater.ui.fragment.Agency.AgencyMoreDetails;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mowater.R;
import com.example.mowater.adapters.AgencyMoredetailsAdapter;
import com.example.mowater.data.models.agencyDetails.CarModel;
import com.example.mowater.data.models.agencyDetails.Data;


public class AgencyMoreDetailsFragment extends Fragment implements AgencyMoreDetailsContract.View {
    //Variables
    int agencyId;
    Data agencyObject;
    AgencyMoreDetailsViewModel viewModel;
    NavController navController;
    // RecyclerView && Adapter
    AgencyMoredetailsAdapter adapter;
    RecyclerView rvCarModels;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_agency_more_details, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        agencyId=AgencyMoreDetailsFragmentArgs.fromBundle(getArguments()).getAgencyId();
        agencyObject = AgencyMoreDetailsFragmentArgs.fromBundle(getArguments()).getAgencyObject();
        viewModel = ViewModelProviders.of(this).get(AgencyMoreDetailsViewModel.class);
        viewModel.setContract(this);
        viewModel.start();
    }

    public void initUi() {
        rvCarModels = getView().findViewById(R.id.rv_car_model_and_car_classes);
    }


    public void initrvCalModel() {
        rvCarModels.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new AgencyMoredetailsAdapter(agencyObject.getCarModels());
        rvCarModels.setAdapter(adapter);
        adapter.onItemClickListner(new AgencyMoredetailsAdapter.OnItemClickListner() {
            @Override
            public void onClickListner(int position) {
                replaceFragment(agencyObject.getCarModels().get(position));
            }
        });
    }

    @Override
    public void replaceFragment(CarModel carModel) {
        navController = Navigation.findNavController(getView());
        NavDirections directions = AgencyMoreDetailsFragmentDirections.actionAgencyMoreDetailsFragmentToCarClassesFragment(carModel,agencyId);
        navController.navigate(directions);
    }


}