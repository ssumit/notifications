package com.example;

import android.app.Activity;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import com.example.notification.AppNotifier;
import com.example.notification.StorageFactory;
import com.example.notification.content.NotificationContent;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        showNotification();
    }

    private String mTitle = "Title";
    private String mBody = "Body";
    private String mTickerText = "TickerText";

    private void showNotification()
    {
        NotificationContent notificationContent = new NotificationContent(mTitle, mBody, mTickerText);
        notificationContent.setNotificationIcon(((BitmapDrawable)getResources().getDrawable(R.drawable.ic_launcher)).getBitmap());
        AppNotifier appNotifier = new AppNotifier(getApplicationContext(), new StorageFactory().getUserPrefStore());
        appNotifier.generateMessageNotification(notificationContent, true);
    }
}
