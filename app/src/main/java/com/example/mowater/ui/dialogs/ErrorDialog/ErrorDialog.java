package com.example.mowater.ui.dialogs.ErrorDialog;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.mowater.R;

public class ErrorDialog extends DialogFragment {
   OnSubmitclickListner listner;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_error_dialog, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button button=view.findViewById(R.id.mybtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listner.onClickListner("Succes");
                dismiss();
            }
        });

    }


    public interface OnSubmitclickListner {
        public void onClickListner(String name);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        listner= (OnSubmitclickListner) context;
    }
}