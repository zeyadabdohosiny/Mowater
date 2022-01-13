package com.example.mowater.ui.fragment.Agency.AgencyVehicles;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mowater.R;
import com.example.mowater.adapters.AgencyVehiclesAdapter;
import com.example.mowater.data.api.ApiClient;
import com.example.mowater.data.models.vehicles.Vehicles;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class AgencyVehiclesFragment extends Fragment implements AgencyVehiclesContract.View{

    //Views
    ProgressBar progressBar;
    //Variables
    int agencyId, carModelId, carClassId;
    String modelType;
    AgencyVehiclesViewModel viewModel;
    NavController navController;
    //Rv && Adapter
    RecyclerView rvVehicles;
    AgencyVehiclesAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_agency_vehicles, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel= ViewModelProviders.of(this).get(AgencyVehiclesViewModel.class);
        viewModel.setContract(this);
        viewModel.start();
        viewModel.getVehicles(agencyId,modelType,carModelId,carClassId);
 
     
    }

    @Override
    public void initUi() {
        rvVehicles=getView().findViewById(R.id.rv_agency_vehicles);

        
    }

    @Override
    public void getData() {
        agencyId = AgencyVehiclesFragmentArgs.fromBundle(getArguments()).getAgencyId();
        modelType = AgencyVehiclesFragmentArgs.fromBundle(getArguments()).getModelType();
        carModelId = AgencyVehiclesFragmentArgs.fromBundle(getArguments()).getCarModelId();
        carClassId = AgencyVehiclesFragmentArgs.fromBundle(getArguments()).getCarClassId();
    }

    @Override
    public void initRvVehicles(MutableLiveData<Vehicles> vehicles ) {
        if (getView()!=null) {
            rvVehicles.setLayoutManager(new LinearLayoutManager(getContext()));
            vehicles.observe(getViewLifecycleOwner(), new Observer<Vehicles>() {
                @Override
                public void onChanged(Vehicles vehicles) {
                    adapter=new AgencyVehiclesAdapter(vehicles.getData());
                    rvVehicles.setAdapter(adapter);
                }
            });
        }
    }

    @Override
    public void replaceFragment(int id) {

    }

    @Override
    public void showProgressBar() {

    }

    @Override
    public void hideProgressBar() {

    }

    @Override
    public void showMessage(String message) {

    }
}