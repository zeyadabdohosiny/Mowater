package com.example.mowater.ui.fragment.SpecialNumbers;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mowater.R;
import com.example.mowater.adapters.SpecialNumbersAdapter;
import com.example.mowater.data.models.SpecialNumbers.Datum;
import com.example.mowater.ui.fragment.SpecialNumbersReservation.SpecialNumbersReservationFragment;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SpecialNumbersFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SpecialNumbersFragment extends Fragment implements SpecialNumberContract.View {

    //Views
    TextView description;
    RecyclerView rvSpecialNumbers;
    ProgressBar progressBar;
    //ViewModle
    SpecialNumberViewModel viewModel;


    private static final String ARG_PARAM2 = "param2";
    // Variables
    private Integer categoryId;
    //Adapter
    SpecialNumbersAdapter specialNumberadapter;
    Datum datum;

    public SpecialNumbersFragment() {
        // Required empty public constructor
    }


    public static SpecialNumbersFragment newInstance(Integer catId) {
        SpecialNumbersFragment fragment = new SpecialNumbersFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM2, catId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            categoryId = getArguments().getInt(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_special_numbers, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = ViewModelProviders.of(getActivity()).get(SpecialNumberViewModel.class);
        viewModel.setViewContract(this);
        viewModel.Start();
        viewModel.getSpecialNumber(categoryId);
    }

    @Override
    public void initUi() {
        rvSpecialNumbers = getView().findViewById(R.id.rv_special_numbers);
        progressBar = getView().findViewById(R.id.progress_bar);
    }

    @Override
    public void initRvSpecialNumbers(MutableLiveData<List<Datum>> specialNumberList) {
        if (getView() != null) {
            rvSpecialNumbers.setLayoutManager(new LinearLayoutManager(getContext()));
            specialNumberList.observe(getViewLifecycleOwner(), new Observer<List<Datum>>() {
                @Override
                public void onChanged(List<Datum> data) {
                    datum = data.get(0);
                    specialNumberadapter = new SpecialNumbersAdapter(data);
                    rvSpecialNumbers.setAdapter(specialNumberadapter);
                    specialNumberadapter.onClickListner(new SpecialNumbersAdapter.OnItemClickListner() {
                        @Override
                        public void onClickListner(int position) {
                            // Send Object From the Special Number to recervation fragment
                            getActivity().getSupportFragmentManager()
                                    .beginTransaction()
                                    .replace(R.id.frame, SpecialNumbersReservationFragment.newInstance(data.get(position)))
                                    .commit();
                        }
                    });

                }
            });
        }
    }


    @Override
    public void showMessage(String message) {
        Snackbar snackbar = Snackbar.make(rvSpecialNumbers, message, BaseTransientBottomBar.LENGTH_INDEFINITE);
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


    @Override
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
    }
}