package com.example.mowater.ui.fragment.CarsForSale;

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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mowater.R;
import com.example.mowater.adapters.CarsForSaleAdapter;
import com.example.mowater.data.models.CarsForSale.Datum;

import java.util.List;


public class CarsForSaleFragment extends Fragment implements CarsForSaleContract {

    public static final String TAG = "Cars_for_sale_Fragment";
    // Views
    ProgressBar progressBar;
    //variables
    CarsForSaleVIewModel viewModel;

    // RecycleView
    RecyclerView rvCarsForSale;
    CarsForSaleAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cars_for_sale, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = ViewModelProviders.of(getActivity()).get(CarsForSaleVIewModel.class);
        viewModel.setContract(this);
        viewModel.start();
        viewModel.getCarsForSale();
    }

    @Override
    public void initUi() {
        progressBar = getView().findViewById(R.id.progress_bar);
        rvCarsForSale = getView().findViewById(R.id.rv_cars_for_sale);
    }

    @Override
    public void initRvCarsForSale(MutableLiveData<List<Datum>> carsForSaleList) {
        if (getView() != null) {
            carsForSaleList.observe(getViewLifecycleOwner(), new Observer<List<Datum>>() {
                @Override
                public void onChanged(List<Datum> data) {
                    rvCarsForSale.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new CarsForSaleAdapter(data);
                    rvCarsForSale.setAdapter(adapter);
                }
            });
        }

    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
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