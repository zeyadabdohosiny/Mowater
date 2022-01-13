package com.example.mowater.ui.activities.RentalOffices;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavHostController;
import androidx.navigation.fragment.NavHostFragment;

import android.os.Bundle;
import android.widget.TextView;

import com.example.mowater.R;

public class RentalofficesActivity extends AppCompatActivity {
    //Views
    TextView tvheaderTittle;
    NavController navController;
    NavHostFragment navHostFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rentaloffices);
        initUi();

    }

    private void initUi() {
        navHostFragment= (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.rental_offices_nav_host);
        navController=navHostFragment.getNavController();
        tvheaderTittle=findViewById(R.id.tv_rental_offices_tittle);
    }

   public void setTittleText(String tittle){
        tvheaderTittle.setText(tittle);
   }
}