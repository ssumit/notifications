package com.java.notification.content;

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

    public int getIcon()
    {
        return mIcon;
    }

    public String getTitle()
    {
        return mTitle;
    }

    public PendingIntent getPendingIntent()
    {
        return mPendingIntent;
    }
}
