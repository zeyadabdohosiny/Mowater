package com.example.mowater.ui.activities.Home;

import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;



public class HomeAvtivityViewModle extends ViewModel {
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    String deviceToken;


    public void getDeviceToken(String token) {
//        FirebaseMessaging.getInstance().getToken().addOnCompleteListener(new OnCompleteListener<String>() {
//            @Override
//            public void onComplete(@NonNull Task<String> task) {
//                if (!task.isSuccessful()) {
//                    Log.w("TAG", "Fetching FCM registration token failed", task.getException());
//                    return;
//                }
//                deviceToken = task.getResult();
//                editor.putString("device_token", deviceToken);
//                editor.commit();
//                registerToken(deviceToken,token);
//            }
//        });
    }
   public void registerToken(String deviceToken,String token){


   }
}
