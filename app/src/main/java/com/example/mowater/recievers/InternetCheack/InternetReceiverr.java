package com.example.mowater.recievers.InternetCheack;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.mowater.MainActivity;
import com.example.mowater.R;
import com.example.mowater.ui.activities.Home.HomeActivity;

public class InternetReceiverr extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (Common.isConnectedToInternet(context)) {
            Toast.makeText(context, "Connected", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "noConnected", Toast.LENGTH_SHORT).show();
        //    context.startActivity(new Intent(context, MainActivity.class));
            Dialog dialog=new Dialog(context,R.style.AlertDialog_AppCompat);
            dialog.setContentView(R.layout.connection_alert_dialog);
            Button btn=dialog.findViewById(R.id.btn_reaty);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
              context.startActivity(new Intent(context, HomeActivity.class));
                }
            });
            dialog.show();

        }


    }
}
