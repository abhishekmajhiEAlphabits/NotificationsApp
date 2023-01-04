package com.example.notificationsapp;

import android.app.PendingIntent;
import android.util.Log;

import androidx.core.app.NotificationCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFireBaseMessagingService extends FirebaseMessagingService {

    MyAppsNotificationManager myAppsNotificationManager;

    private static final String TAG = MyFireBaseMessagingService.class.getSimpleName();

    @Override
    public void onNewToken(String s) {
        super.onNewToken(s);
        Log.i(getString(R.string.DEBUG_TAG), "New Token: " + s);
    }

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        Log.i(getString(R.string.DEBUG_TAG), "Message received!!");

        myAppsNotificationManager.triggerNotification(NotificationDetailsActivity.class,
                getString(R.string.NEWS_CHANNEL_ID),
                remoteMessage.getNotification().getTitle(),
                remoteMessage.getNotification().getBody(),
                "This is a sample notification created by Codetutor for demonstration of how to trigger notifications in Android app ",
                NotificationCompat.PRIORITY_HIGH,
                true,
                getResources().getInteger(R.integer.notificationId),
                PendingIntent.FLAG_UPDATE_CURRENT);
    }
}
