package com.example.mowater.ui.dialogs.ErrorDialog;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

public class DatePickerFragment extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        return new DatePickerDialog(getActivity()  , AlertDialog.THEME_HOLO_LIGHT ,(DatePickerDialog.OnDateSetListener) getActivity() , year , month , day);
//        return new DatePickerDialog(getActivity() , R.style.DialogTheme, (DatePickerDialog.OnDateSetListener) getActivity() , year , month , day);
    }
}
