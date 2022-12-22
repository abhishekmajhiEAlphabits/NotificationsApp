package com.example.notificationsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.notificationsapp.databinding.ActivityMainBinding;
import com.example.notificationsapp.databinding.ActivityNotificationDetailsBinding;

public class NotificationDetailsActivity extends AppCompatActivity {

    TextView textViewNotificationDetails;

    ActivityNotificationDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_notification_details);
        binding = ActivityNotificationDetailsBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        textViewNotificationDetails.setText(intent.getStringExtra("count"));
    }

}