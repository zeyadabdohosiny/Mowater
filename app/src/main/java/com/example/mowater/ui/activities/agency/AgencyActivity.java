package com.example.mowater.ui.activities.agency;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.os.Bundle;

import com.example.mowater.R;

public class AgencyActivity extends AppCompatActivity {
    NavController navController;
    NavHostFragment navHostFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agency);
        initUi();
    }
    private void initUi() {
        navHostFragment= (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.agency_nav_host);
        navController=navHostFragment.getNavController();
    }
}