package com.example.mowater.ui.fragment.More;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.mowater.R;
import com.example.mowater.ui.activities.Mwatery.MwateryActivity;

public class MoreFragment extends Fragment {

    TextView tvProfile,tvMwatery;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_more, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initUi();
        handleClicks();
    }

    private void initUi() {
        tvMwatery=getView().findViewById(R.id.tv_mwatery);
    }

    private void handleClicks() {
        tvMwatery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), MwateryActivity.class));
            }
        });
    }
}