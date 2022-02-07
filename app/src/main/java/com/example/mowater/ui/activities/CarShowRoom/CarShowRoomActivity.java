package com.example.mowater.ui.activities.CarShowRoom;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import com.example.mowater.R;

public class CarShowRoomActivity extends AppCompatActivity {
    NavController navController;
    NavHostFragment navHostFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_show_room);
        initUi();
    }

    private void initUi() {
        navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.car_show_room_nav_host);
        navController = navHostFragment.getNavController();
    }
}