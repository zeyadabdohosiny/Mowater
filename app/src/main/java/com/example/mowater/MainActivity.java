package com.example.mowater;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mowater.ui.activities.Home.HomeActivity;
import com.example.mowater.ui.activities.TestDrive.TestDriveActivity;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    public static final String TAG="Main_Activity";
    TextView tv;
    ImageView imageView;
    DatePickerDialog mydialog;
    ExtendedFloatingActionButton myfab;
    private FloatingActionButton fabMainicon;
    boolean isCheacked;
    SharedPreferences preferences;
    boolean isLogin;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        tv = findViewById(R.id.date_id);
//        Button button = findViewById(R.id.btn);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                new DatePickerFragment().show(getSupportFragmentManager(),"Date");
//            }
//        });
        preferences=getSharedPreferences("zeyad",MODE_PRIVATE);
        String token = preferences.getString("token", "");
        Log.d(TAG, token);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (token.matches("")) {
                    startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                    finish();
                } else {
                    startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                    finish();
                }
            }
        }, 1000);
//        myfab = findViewById(R.id.fabMainicon);
//        fabMainicon=findViewById(R.id.fabCall);
//        myfab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                   if (!isCheacked) {
//                       fabMainicon.setVisibility(View.VISIBLE);
//                       myfab.extend();
//                       isCheacked=true;
//                   }else {
//                       myfab.shrink();
//                       fabMainicon.setVisibility(View.GONE);
//                       isCheacked=false;
//                   }
//            }
//        });

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void initDatePicker() {
        DatePickerDialog.OnDateSetListener dialog = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                Toast.makeText(getApplicationContext(), "jjj" + year + month + day, Toast.LENGTH_SHORT).show();
            }

        };
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int style = AlertDialog.THEME_HOLO_LIGHT;
        mydialog = new DatePickerDialog(this, style, dialog, year, month, day);
    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
    }


}