package com.example.mowater.ui.fragment.Home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.mowater.R;
import com.example.mowater.adapters.SectionsAdapter;
import com.example.mowater.adapters.VideoSliderAdapter;
import com.example.mowater.data.models.Sections.Datum;
import com.example.mowater.data.models.Video.Videoo;
import com.example.mowater.ui.activities.RentalOffices.RentalofficesActivity;
import com.example.mowater.ui.activities.agency.AgencyActivity;
import com.example.mowater.ui.fragment.SpecialNumbersCategory.SpecialNumberCategoryFragment;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment implements HomeFragmentContract.View {
    // Views
    ProgressBar progressBar;
    RecyclerView rvSections;
    ViewPager2 viewPager2;
    // Variables
    String sectionName;
    HomeFragmentViewModel homeViewModel;
    //Adapters
    VideoSliderAdapter adapter;
    SectionsAdapter sectionsAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        homeViewModel = ViewModelProviders.of(getActivity()).get(HomeFragmentViewModel.class);
        homeViewModel.HomeFragmentViewModell(this);
        homeViewModel.start();
        homeViewModel.getSections();
        videoTest();

    }

    private void videoTest() {
        ArrayList<Videoo> list = new ArrayList<>();
        String firstVideo = "android.resource://" + getActivity().getPackageName() + "/" + R.raw.video;
        String secondVideo = "android.resource://" + getActivity().getPackageName() + "/" + R.raw.production_4568812;
        list.add(new Videoo(firstVideo));
        list.add(new Videoo(secondVideo));
        adapter = new VideoSliderAdapter(list, viewPager2);
        viewPager2.setOffscreenPageLimit(list.size());
        viewPager2.setAdapter(adapter);
    }

    @Override
    public void initUi() {
        viewPager2 = getView().findViewById(R.id.viewPager2);
        progressBar = getView().findViewById(R.id.progress_bar);
        rvSections = getView().findViewById(R.id.rv_sections);
    }


    @Override
    public void initrvSections(MutableLiveData<List<Datum>> data) {
        if (getView() != null) {
            rvSections.setLayoutManager(new LinearLayoutManager(getContext()));
            data.observe(getViewLifecycleOwner(), new Observer<List<Datum>>() {
                @Override
                public void onChanged(List<Datum> data) {
                    sectionsAdapter = new SectionsAdapter(data);
                    rvSections.setAdapter(sectionsAdapter);
                    sectionsAdapter.onClickListner(new SectionsAdapter.OnItemClickListner() {
                        @Override
                        public void clickListner(int position) {
                            sectionName = data.get(position).getRefName();
                            switch (sectionName) {
                                case "Agencies":
                                    startActivity(new Intent(getContext(), AgencyActivity.class));
                                    break;
                                case "SpecialNumbers":
                                    replaceFragment(new SpecialNumberCategoryFragment());
                                    break;
                                case "RentalOffices":
                                    startActivity(new Intent(getContext(), RentalofficesActivity.class));
                                    break;
                            }

                        }
                    });
                }
            });


        }
    }

    public  void replaceFragment(Fragment fragment) {
        FragmentManager manager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.frame,fragment);
        transaction.commit();
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

