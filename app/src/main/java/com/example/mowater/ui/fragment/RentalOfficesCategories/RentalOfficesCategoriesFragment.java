package com.example.mowater.ui.fragment.RentalOfficesCategories;

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
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mowater.R;
import com.example.mowater.adapters.RentalOfficesCategoriesAdapter;
import com.example.mowater.data.models.RentalOffiecesCategories.Data;


public class RentalOfficesCategoriesFragment extends Fragment implements RentalOfficesCategoriesContract.View {
    //Views
    NavController navController;
    RecyclerView rvRentalOfficesCategories;
    ProgressBar progressBar;
    // ViewModle
    RentalOfficesCategoriesViewModel viewModel;
    // Adapter
    RentalOfficesCategoriesAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_rental_offices_categories, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = ViewModelProviders.of(getActivity()).get(RentalOfficesCategoriesViewModel.class);
        viewModel.setContract(this);
        viewModel.start();
        viewModel.getRentalOfficesCategoriesList();


    }

    @Override
    public void initUi() {
        rvRentalOfficesCategories = getActivity().findViewById(R.id.rv_rental_oficces_categories);
        progressBar = getView().findViewById(R.id.progress_bar);
    }

    @Override
    public void initRvRentalOfficesCategories(MutableLiveData<Data> rentalOfficesCategoriesList) {
        if (getView() != null) {
            rentalOfficesCategoriesList.observe(getViewLifecycleOwner(), new Observer<Data>() {
                @Override
                public void onChanged(Data data) {

                    rvRentalOfficesCategories.setLayoutManager(new GridLayoutManager(getActivity(), 2));
                    adapter = new RentalOfficesCategoriesAdapter(data.getData());
                    rvRentalOfficesCategories.setAdapter(adapter);
                    adapter.setOnItemClickListner(new RentalOfficesCategoriesAdapter.onItemClickListner() {
                        @Override
                        public void onClickListner(int position) {
                            RentalOfficesCategoriesFragment.this.ReplaceFragment(data.getData().get(position).getId());
                        }
                    });
                }
            });

        }
    }

    @Override
    public void ReplaceFragment(int id) {
        navController = Navigation.findNavController(getView());
        NavDirections directions = RentalOfficesCategoriesFragmentDirections.actionRentalOfficesCategoriesFragmentToRentalOfficesFragment2(id);
        navController.navigate(directions);
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