package com.example.mowater.ui.activities.Register;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ProgressBar;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModelProviders;

import com.example.mowater.R;
import com.example.mowater.data.api.ApiClient;
import com.example.mowater.data.models.register.Data;
import com.example.mowater.ui.activities.Home.HomeActivity;
import com.example.mowater.ui.dialogs.ErrorDialog.DatePickerFragment;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class RegisterActivity extends AppCompatActivity implements RegisterContract.View, DatePickerDialog.OnDateSetListener {
    //Variables

    public static final String TAG = "Register_Activity";
    String name, password, confirmPassword, mail, phone, dateOfBirth, gender;
    String token;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    //Views
    TextInputEditText etName, etPassword, etConfirmPassword, etMail, etPhone;
    RadioGroup rgGender;
    ProgressBar progressBar;
    AppCompatButton btnDateOfBirth, btnRegister;
    DatePickerDialog datePickerDialog;
    //ViewModel
    RegisterViewModel viewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        viewModel = ViewModelProviders.of(this).get(RegisterViewModel.class);
        viewModel.setContract(this);
        viewModel.start();

    }

    @Override
    public void initUi() {
        etName = findViewById(R.id.et_register_name);
        etPassword = findViewById(R.id.et_register_password);
        etConfirmPassword = findViewById(R.id.et_register_confirm_password);
        etMail = findViewById(R.id.et_register_mail);
        etPhone = findViewById(R.id.et_register_phone);
        rgGender = findViewById(R.id.rg_gender);
        btnDateOfBirth = findViewById(R.id.btn_date_of_birth);
        btnRegister = findViewById(R.id.btn_register);
        progressBar = findViewById(R.id.progress_bar_register);
    }

    @Override
    public void handleClicks() {
        rgGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                if (checkedId == R.id.rb_male) {
                    gender = "male";
                } else if (checkedId == R.id.rb_female) {
                    gender = "female";
                }
            }
        });
        btnDateOfBirth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerFragment().show(getSupportFragmentManager(), "Date");
            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                register();
            }
        });


    }

    @Override
    public void initSharedPreferences(Data data,String token) {
        preferences = getSharedPreferences("zeyad", MODE_PRIVATE);
        editor = preferences.edit();
        Gson gson= new GsonBuilder().create();
        String userData=gson.toJson(data);
        editor.putString("user_data",userData);
        editor.putString("token",token);
        editor.commit();
    }

    @Override
    public void register() {
         getDataFromViews();
        if (name.matches("")) {
            etName.setError("error");
        } else if (password.matches("")) {
            etPassword.setError("error");
        } else if (!password.equalsIgnoreCase(confirmPassword)) {
            etConfirmPassword.setError("error");
        } else if (phone.matches("") || phone.length() < 3) {
            etPhone.setError("error");
        } else if (mail.matches("") || !mail.contains("@") || !mail.contains(".com")) {
            etMail.setError("error");
        } else if (gender == null || dateOfBirth == null) {
            showMessage("error");
        } else {
            viewModel.registerbyEmailAndPassword(name, password, mail, phone, dateOfBirth, gender);
        }

    }

    @Override
    public void getDataFromViews() {
        name = etName.getText().toString();
        password = etPassword.getText().toString();
        confirmPassword = etConfirmPassword.getText().toString();
        mail = etMail.getText().toString();
        phone = etPhone.getText().toString();

    }

    @Override
    public void goIntent() {
        startActivity(new Intent(getApplicationContext(),HomeActivity.class));
        this.finish();
    }

    @Override
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
        btnRegister.setVisibility(View.GONE);
    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
        btnRegister.setVisibility(View.VISIBLE);
    }

    @Override
    public void showMessage(String message) {
        Snackbar snackbar = Snackbar.make(btnDateOfBirth, message, BaseTransientBottomBar.LENGTH_INDEFINITE);
        snackbar.setDuration(4000);
        snackbar.setBackgroundTint(ContextCompat.getColor(getApplicationContext(), R.color.snack_bar_color));
        snackbar.setAction("تجاهل", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                snackbar.dismiss();
            }
        });
        snackbar.show();

    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
        i1++;
        dateOfBirth=i+"/"+i1+"/"+i2;
        btnDateOfBirth.setText(dateOfBirth);
    }

}