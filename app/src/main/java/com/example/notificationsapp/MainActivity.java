package com.example.notificationsapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.PendingIntent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.notificationsapp.databinding.ActivityMainBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.google.firebase.messaging.FirebaseMessaging;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    MyAppsNotificationManager myAppsNotificationManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        myAppsNotificationManager = MyAppsNotificationManager.getInstance(this);
        myAppsNotificationManager.registerNotificationChannelChannel(
                getString(R.string.NEWS_CHANNEL_ID),
                getString(R.string.CHANNEL_NEWS),
                getString(R.string.CHANNEL_DESCRIPTION));


        FirebaseMessaging.getInstance().setAutoInitEnabled(true);

        FirebaseMessaging.getInstance().subscribeToTopic("notification");

        FirebaseInstanceId.getInstance().getInstanceId().addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
            @Override
            public void onComplete(@NonNull Task<InstanceIdResult> task) {
                if (!task.isSuccessful()) {
                    Log.i(getString(R.string.DEBUG_TAG), "Task Failed");
                    return;
                }
                Log.i(getString(R.string.DEBUG_TAG), "The result: " + task.getResult().getToken());
            }
        });


        binding.buttonTriggerNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                myAppsNotificationManager.triggerNotificationWithBackStack(NotificationDetailsActivity.class,
                        getString(R.string.NEWS_CHANNEL_ID),
                        "Sample Notification",
                        "This is a sample notification app",
                        "This is a sample notification created by Codetutor for demonstration of how to trigger notifications in Android app ",
                        NotificationCompat.PRIORITY_HIGH,
                        true,
                        getResources().getInteger(R.integer.notificationId),
                        PendingIntent.FLAG_UPDATE_CURRENT);

            }
        });

        binding.buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myAppsNotificationManager.updateWithPicture(NotificationDetailsActivity.class,
                        "Updated Notification",
                        "This is updatedNotification",
                        getString(R.string.NEWS_CHANNEL_ID),
                        getResources().getInteger(R.integer.notificationId),
                        "This is a updated information for bigpicture String",
                        PendingIntent.FLAG_UPDATE_CURRENT);

            }
        });

        binding.buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myAppsNotificationManager.cancelNotification(getResources().getInteger(R.integer.notificationId));

            }
        });

    }
}