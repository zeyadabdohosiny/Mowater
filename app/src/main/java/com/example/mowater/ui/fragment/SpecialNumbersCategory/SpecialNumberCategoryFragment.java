package com.example.mowater.ui.fragment.SpecialNumbersCategory;

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
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mowater.R;
import com.example.mowater.adapters.SpecialNumberCategoriesAdapter;
import com.example.mowater.data.models.SpecialNumbersCategories.Data;
import com.example.mowater.ui.fragment.SpecialNumbers.SpecialNumbersFragment;


public class SpecialNumberCategoryFragment extends Fragment implements SpecialNumberCategoryContract.View {
    // Rv && Adapter
    RecyclerView rvSpecialNumbersCategires;
    SpecialNumberCategoriesAdapter adapter;
    // Views
    ProgressBar progressBar;
    // ViewModle
    SpecialNumberCategotyFragmentViewModel specialNumberCategotyFragmentViewModel;
    // Variables
    int specialNumberCategoryId;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_special_number, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        specialNumberCategotyFragmentViewModel = ViewModelProviders.
                of(getActivity()).get(SpecialNumberCategotyFragmentViewModel.class);
        specialNumberCategotyFragmentViewModel.contract(this);
        specialNumberCategotyFragmentViewModel.start();
        specialNumberCategotyFragmentViewModel.getSpecialNumbers();
    }

    @Override
    public void initUi() {
        progressBar = getView().findViewById(R.id.progress_bar);
        rvSpecialNumbersCategires = getView().findViewById(R.id.rv_special_number);
    }


    @Override
    public void initRvSpecialNumbersCategories(MutableLiveData<Data> specialNumberList) {
        if (getView() != null) {
            specialNumberList.observe(getViewLifecycleOwner(), new Observer<Data>() {
                @Override
                public void onChanged(Data data) {
                    hideProgressBar();
                    rvSpecialNumbersCategires.setLayoutManager(new GridLayoutManager(getActivity(), 2));
                    adapter = new SpecialNumberCategoriesAdapter(data.getData());
                    rvSpecialNumbersCategires.setAdapter(adapter);
                    adapter.setOnItemClickListner(new SpecialNumberCategoriesAdapter.onItemClickListner() {
                        @Override
                        public void onClickListner(int position) {
                            getActivity().getSupportFragmentManager()
                                    .beginTransaction()
                                    .replace(R.id.frame,SpecialNumbersFragment.newInstance(3))
                                    .commit();
                        }
                    });

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