package com.example.mowater.ui.fragment.Agency.AgencyCarClasses;

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
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mowater.R;
import com.example.mowater.adapters.AgencyCarClassesAdapter;
import com.example.mowater.data.models.agencyDetails.CarModel;
import com.example.mowater.ui.fragment.Agency.AgencyCategories.AgencyCategoriesFragmentDirections;


public class AgencyCarClassesFragment extends Fragment implements AgencyCarClassesContract.View {
    // Views

    //Variables
    int agencyId, carModelId, carclasseId;
    CarModel carClassObjcet;
    AgencyCarClassesViewModel viewModel;
    NavController navController;
    // RecyclerView && Adapter
    RecyclerView rvCarclasses;
    AgencyCarClassesAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_agency_car_classes, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        agencyId = AgencyCarClassesFragmentArgs.fromBundle(getArguments()).getAgencyId();
        carClassObjcet = AgencyCarClassesFragmentArgs.fromBundle(getArguments()).getCarClasses();
        viewModel = ViewModelProviders.of(this).get(AgencyCarClassesViewModel.class);
        viewModel.setContrct(this);
        viewModel.start();

    }

    @Override
    public void initUi() {
        rvCarclasses = getView().findViewById(R.id.rv_car_classes);

    }

    @Override
    public void initRvCarClasses() {

        rvCarclasses.setLayoutManager(new GridLayoutManager(getContext(), 2));
        adapter = new AgencyCarClassesAdapter(carClassObjcet.getCarClasses());
        rvCarclasses.setAdapter(adapter);
        adapter.onItemClickListner(new AgencyCarClassesAdapter.OnItemClickListner() {
            @Override
            public void onClickListner(int position) {
                carModelId = carClassObjcet.getId();
                carclasseId = carClassObjcet.getCarClasses().get(position).getId();
                replaceFragment(agencyId,"Agency",carModelId,carclasseId);
            }
        });

    }
    public void replaceFragment(int agencyId,String modelType,int carModelId,int carClasseId){
        navController= Navigation.findNavController(getView());
        NavDirections directions= AgencyCarClassesFragmentDirections.actionCarClassesFragmentToAgencyVehiclesFragment(agencyId,modelType,carModelId,carClasseId);
        navController.navigate(directions);
    }
}