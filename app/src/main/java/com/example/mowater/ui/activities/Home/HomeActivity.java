package com.example.mowater.ui.activities.Home;

import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.mowater.R;
import com.example.mowater.recievers.InternetCheack.InternetReceiverr;
import com.example.mowater.ui.fragment.Cards.PackageFragment;
import com.example.mowater.ui.fragment.CarsForSale.CarsForSaleFragment;
import com.example.mowater.ui.fragment.Home.HomeFragment;
import com.example.mowater.ui.fragment.More.MoreFragment;
import com.example.mowater.ui.fragment.Offers.OffersFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class HomeActivity extends AppCompatActivity implements HomeActivityContract.View{
    // Views
    BottomNavigationView bottomNavigationView;
    // Variables
    public static final String TAG = "Home_Activity";
    HomeFragment homeFragment;
    String token,deviceToken;
    // SharedPreferences
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    //
    InternetReceiverr receiver =new InternetReceiverr();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        preferences=getSharedPreferences("zeyad",MODE_PRIVATE);
        token=preferences.getString("token","");
        Log.d(TAG, "onCreate: "+token);
        initButtomNavigation();


    }

    private void initButtomNavigation() {
        homeFragment = new HomeFragment();
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_home:
                        replaceFragment(homeFragment);
                        item.setChecked(true);
                        break;
                    case R.id.nav_package:
                        replaceFragment(new PackageFragment());
                        item.setChecked(true);
                        break;
                    case R.id.nav_cars_for_sale:
                        replaceFragment(new CarsForSaleFragment());
                        item.setChecked(true);
                        break;
                    case R.id.nav_offers:
                        replaceFragment(new OffersFragment());
                        item.setChecked(true);
                        break;
                    case R.id.nav_more:
                        replaceFragment(new MoreFragment());
                        item.setChecked(true);
                        break;
                }
                return false;
            }
        });
        bottomNavigationView.setSelectedItemId(R.id.nav_home);
    }


    public void replaceFragment(Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        Fragment currentFragment = manager.findFragmentById(R.id.frame);
        if (currentFragment != null && currentFragment.getClass().equals(fragment.getClass())) {
            return;
        } else {
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.replace(R.id.frame, fragment);
            transaction.commit();
        }
    }

    @Override
    public void onBackPressed() {
        Fragment currentFragment = getSupportFragmentManager().findFragmentById(R.id.frame);
        int count = 0;
        FragmentManager fm = getSupportFragmentManager();
        count = fm.getBackStackEntryCount();
        if (getSupportFragmentManager().getBackStackEntryCount() > 1) {
            super.onBackPressed();
            for (int i = 0; i < count; ++i) {
                fm.popBackStack();
            }
        } else {
            if (bottomNavigationView.getSelectedItemId() == R.id.nav_home && currentFragment.getClass().equals(homeFragment.getClass())) {
                super.onBackPressed();
            } else {
                bottomNavigationView.setSelectedItemId(R.id.nav_home);
            }

        }

    }


    @Override
    public void initSharedPreferance() {
        preferences=getSharedPreferences("Zeyad",MODE_PRIVATE);
        editor=preferences.edit();
    }

    @Override
    protected void onStart() {
//        IntentFilter filter=new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
//        registerReceiver(receiver,filter);
        super.onStart();
    }

    @Override
    protected void onDestroy() {
     //   unregisterReceiver(receiver);
        super.onDestroy();
    }
}
