package com.example.mowater.ui.activities.Mwatery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.os.Bundle;

import com.example.mowater.R;

public class MwateryActivity extends AppCompatActivity {
    NavController navController;
    NavHostFragment navHostFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mwatery);
        initUi();
    }
    private void initUi() {
        navHostFragment= (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.my_cars_nav);
        navController=navHostFragment.getNavController();
    }
}