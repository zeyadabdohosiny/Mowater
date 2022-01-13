package com.example.mowater.ui.fragment.Agency.AgencyCategories;

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
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mowater.R;
import com.example.mowater.adapters.AgencyCategoriesAdapter;
import com.example.mowater.data.models.agencyCategories.Data;
import com.example.mowater.data.models.agencyCategories.Datum;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;


public class AgencyCategoriesFragment extends Fragment implements AgencyCategoriesContract.View {
    //Views
    NavController navController;
    RecyclerView rvAgencyCategories;
    ProgressBar progressBar;
    // ViewModle
    AgencyCategoriesVIewModel viewModel;
    // Adapter
    AgencyCategoriesAdapter adapter;
    //Variables
    int agencyId;
    List<Datum> agencyCategoriesList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_agency_categories, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = ViewModelProviders.of(getActivity()).get(AgencyCategoriesVIewModel.class);
        viewModel.setContract(this);
        viewModel.start();
        viewModel.getAgentCategories();
    }

    @Override
    public void initUi() {
        rvAgencyCategories = getActivity().findViewById(R.id.rv_agency_categories);
        progressBar = getView().findViewById(R.id.progress_bar);
    }

    @Override
    public void initRvAgentCategories(MutableLiveData<Data> agentCategoriesList) {
        if (getView() != null) {
            rvAgencyCategories.setLayoutManager(new GridLayoutManager(getActivity(), 2));
            agentCategoriesList.observe(getViewLifecycleOwner(), new Observer<Data>() {
                @Override
                public void onChanged(Data data) {
                    agencyCategoriesList=data.getData();
                    adapter = new AgencyCategoriesAdapter(data.getData());
                    rvAgencyCategories.setAdapter(adapter);


                }
            });
            adapter.onItemClickListner(new AgencyCategoriesAdapter.OnItemClickListner() {
                @Override
                public void getItemPosition(int position) {
                    agencyId =agencyCategoriesList.get(position).getId();
                    replaceFragment(agencyId);
                }
            });
        }

    }

    @Override
    public void replaceFragment(int id) {
        navController = Navigation.findNavController(getView());
        NavDirections directions = AgencyCategoriesFragmentDirections.actionAgencyCategoriesFragmentToAgencyDetailsFragment(id);
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
        Snackbar snackbar = Snackbar.make(rvAgencyCategories, message, BaseTransientBottomBar.LENGTH_INDEFINITE);
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