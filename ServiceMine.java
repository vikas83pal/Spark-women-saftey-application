
package com.example.sparkwomen;

import android.Manifest;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Location;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.IBinder;
import android.telephony.SmsManager;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;



import java.util.HashSet;
import java.util.Set;

public class ServiceMine extends Service {

    static boolean isRunning = false;

    static MediaPlayer mediaPlayer;

//    FusedLocationProviderClient fusedLocationClient;
//
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    SmsManager manager = SmsManager.getDefault();
    //    WindowManager windowManager;
    String myLocation;
    View view;
    @Override
    public void onCreate() {

        super.onCreate();

     //   mediaPlayer = MediaPlayer.create(getBaseContext(),R.raw.siren);
        mediaPlayer.setLooping(true);



//        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
//        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//            return;
//        }
////        fusedLocationClient.getLastLocation()
//                .addOnSuccessListener(new OnSuccessListener<Location>() {
//                    @Override
//                    public void onSuccess(Location location) {
//                        if (location != null) {
//                            // Logic to handle location object
//                            location.getAltitude();
//                            location.getLongitude();
//                            myLocation = "http://maps.google.com/maps?q=loc:"+location.getLatitude()+","+location.getLongitude();
//                        }else {
//                            myLocation = "Unable to Find Location :(";
//                        }
//                    }
//                });



//       windowManager= (WindowManager) getSystemService(WINDOW_SERVICE);
//
//        WindowManager.LayoutParams params= null;
//        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
//            params = new WindowManager.LayoutParams(
//                    WindowManager.LayoutParams.WRAP_CONTENT,
//                    WindowManager.LayoutParams.WRAP_CONTENT,
//                    WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY,
//                    WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
//                    PixelFormat.TRANSLUCENT);
//        }
//
//        params.gravity = Gravity.START;
//        params.x = 0;
//        params.y = 100;
//
//        LayoutInflater inflater = (LayoutInflater)   getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        view = inflater.inflate(R.layout.floating_menu, null);
//        Button panic = view.findViewById(R.id.panicService);
//        panic.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                mediaPlayer.start();
//
//
//                SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref",MODE_PRIVATE);
//                Set<String> oldNumbers = sharedPreferences.getStringSet("enumbers", new HashSet<>());
//                if(!oldNumbers.isEmpty()){
//                    for(String ENUM : oldNumbers)
//                        manager.sendTextMessage(ENUM,null,"Im in Trouble!\nSending My Location :\n"+myLocation,null,null);
//                }
//
//            }
//        });
//
//        windowManager.addView(view,params);



       // ShakeDetector.create(this, () -> {

            mediaPlayer.start();


            SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref",MODE_PRIVATE);
            Set<String> oldNumbers = sharedPreferences.getStringSet("numbers", new HashSet<>());
            if(!oldNumbers.isEmpty()){
                for(String ENUM : oldNumbers)
                    manager.sendTextMessage(ENUM,null,"Im in Trouble!\nSending My Location :\n"+myLocation,null,null);
            }


    }



    @Override
    public void onDestroy() {
        mediaPlayer.stop();
        mediaPlayer.release();
        super.onDestroy();
    }
}