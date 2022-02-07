package com.example.mowater.ui.activities.TestDrive;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mowater.R;
import com.example.mowater.adapters.AvailableTimesAdapter;
import com.example.mowater.ui.dialogs.ErrorDialog.DatePickerFragment;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class TestDriveActivity extends AppCompatActivity implements TestDriveContract.View, DatePickerDialog.OnDateSetListener {



    //Views
    AppCompatButton btnDate;
    ProgressBar testDriveProgessBa,availableTimesProgressBar;
    // Variables
    int vehicaleId;
    int agencyId;
    // RecyclerView
    RecyclerView rvAvailableTimes;
    AvailableTimesAdapter adapter;
    // ViewModle
    TestDriveViewModel viewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_drive);
        rvAvailableTimes = findViewById(R.id.rv_available_time);
        btnDate = findViewById(R.id.btn_test_Drive_date);
        availableTimesProgressBar=findViewById(R.id.progress_bar_available_times);
//        rvAvailableTimes.setLayoutManager(new GridLayoutManager(getApplicationContext(), 3));
//        ArrayList<String> mylist=new ArrayList<>();
//        mylist.add("yasta");
//        mylist.add("mohamed");
//        mylist.add("zeyad");
//        mylist.add("ahmed");
//        adapter = new AvailableTimesAdapter(mylist);
//        rvAvailableTimes.setAdapter(adapter);

//        btnDate.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                int position=adapter.getItemChecked();
//                if (position==-1){
//                    Toast.makeText(getApplicationContext(), "من فضضلت قم بتحديد الوقت", Toast.LENGTH_SHORT).show();
//                }else {
//                    Toast.makeText(getApplicationContext(), "تمام"+position, Toast.LENGTH_SHORT).show();
//                }
//            }
//        });

        viewModel = ViewModelProviders.of(this).get(TestDriveViewModel.class);
        viewModel.setContract(this);
        viewModel.start();


    }

    @Override
    public void initUi() {
        rvAvailableTimes = findViewById(R.id.rv_available_time);
        btnDate = findViewById(R.id.btn_test_Drive_date);
        availableTimesProgressBar=findViewById(R.id.progress_bar_available_times);
    }

    @Override
    public void handleClicks() {
        btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerFragment().show(getSupportFragmentManager(), "Date");
            }
        });

    }

    @Override
    public void getDataFromIntent() {

        agencyId=getIntent().getIntExtra("agency_id",0);
        vehicaleId=getIntent().getIntExtra("vehicale_id",0);
    }

    @Override
    public void initRvAvailableTimes(MutableLiveData<List<String>> availableTimeList) {
        availableTimeList.observe(this, new Observer<List<String>>() {
            @Override
            public void onChanged(List<String> strings) {
                rvAvailableTimes.setLayoutManager(new GridLayoutManager(getApplicationContext(), 3));
                adapter = new AvailableTimesAdapter(strings);
                rvAvailableTimes.setAdapter(adapter);
            }
        });


    }

    @Override
    public void showMessage(String name) {
        Snackbar snackbar = Snackbar.make(btnDate, name, BaseTransientBottomBar.LENGTH_INDEFINITE);
        snackbar.setDuration(8000);
        snackbar.setBackgroundTint(ContextCompat.getColor(this, R.color.snack_bar_color));
        snackbar.setAction("تجاهل", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                snackbar.dismiss();
            }
        });
        snackbar.show();
    }

    @Override
    public void showAvailableTimesProgressBar() {
        availableTimesProgressBar.setVisibility(View.VISIBLE);
        rvAvailableTimes.setVisibility(View.GONE);
    }

    @Override
    public void hideAvailableTimesProgressBar() {
        availableTimesProgressBar.setVisibility(View.GONE);
        rvAvailableTimes.setVisibility(View.VISIBLE);
    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
        month = month + 1;
        String date = year + "-" + month + "-" + day;
        btnDate.setText(date);
        viewModel.getAvailableTimes(agencyId, date);
    }
}