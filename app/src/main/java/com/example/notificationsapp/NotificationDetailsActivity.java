package com.example.notificationsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.notificationsapp.databinding.ActivityMainBinding;
import com.example.notificationsapp.databinding.ActivityNotificationDetailsBinding;

public class NotificationDetailsActivity extends AppCompatActivity {


    ActivityNotificationDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_notification_details);
        binding = ActivityNotificationDetailsBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        Bundle extras = getIntent().getExtras();
        Log.i("TAG", String.valueOf(extras));
        if (extras.containsKey("count")) {
            String title = extras.getString("count");
            Log.i("TAG", title);
            binding.textViewNotificationDetails.setText(title);
        }

    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        //binding.textViewNotificationDetails.setText(intent.getStringExtra("count"));
/*
        Bundle extras = getIntent().getExtras();
        Log.i("TAG", String.valueOf(extras));
        if (extras.containsKey("count")) {
            String title = extras.getString("count");
            Log.i("TAG", title);
        }

 */

    }

}