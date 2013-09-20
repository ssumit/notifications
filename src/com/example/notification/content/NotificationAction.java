package com.example.notification.content;

import android.app.PendingIntent;

public class NotificationAction
{
    private int mIcon;
    private String mTitle;
    private PendingIntent mPendingIntent;

    public NotificationAction(int icon, String title, PendingIntent pendingIntent)
    {
        mIcon = icon;
        mTitle = title;
        mPendingIntent = pendingIntent;
    }
}
