package com.java.notification.display;

import android.app.Notification;
import android.content.Context;
import android.media.AudioManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import com.java.notification.content.*;

public class NotificationBuilder
{
    private Context mContext;
    private NotificationCompat.Builder mBuilder;
    private NotificationContent mContent;

    public NotificationBuilder(Context context)
    {
        mContext = context;
    }

    public Notification buildNotification(NotificationContent content)
    {
        startBuildingNotification(content);
        setAlertSettings();
        if (content.getNotificationAction() != null)
        {
            addAction();
        }
        if (content.getTickerText() != null)
        {
            setTickerText();
        }
        if (mContent.getNotificationIcon() != null)
        {
            setLargeIcon();
        }
        if (mContent.getContentInfo() != null)
        {
            setContentInfo();
        }
        if (mContent.getContentIntent() != null)
        {
            setContentIntent();
        }
        if (mContent.getStyle() != null)
        {
            setStyle();
        }
        if (mContent.getIcon() != -1)
        {
            setSmallIcon();
        }
        if (mContent.getFullScreenIntent() != null)
        {
            setFullScreenIntent();
        }
        Notification notification = build();
        clear();
        return notification;
    }

    public NotificationBuilder startBuildingNotification(NotificationContent content)
    {
        mContent = content;
        mBuilder = new NotificationCompat.Builder(mContext)
                .setContentTitle(mContent.getTitle())
                .setContentText(mContent.getBody())
                .setSmallIcon(1)
                .setAutoCancel(true)
                .setPriority(Notification.PRIORITY_DEFAULT);

        return this;
    }

    public NotificationBuilder setAlertSettings()
    {
        AudioManager audioManager = (AudioManager) mContext.getSystemService(Context.AUDIO_SERVICE);
        AlertPreference alertPreference = mContent.getAlertPreference();
        mBuilder.setOnlyAlertOnce(alertPreference.isAlertOnce());
        LightPreference lightPreference = alertPreference.getLightPreference();
        mBuilder.setLights(lightPreference.getArgb(), lightPreference.getOnMs(), lightPreference.getOffMs());
        if (alertPreference.shouldSound(audioManager))
        {
            String soundPref = alertPreference.getSoundPref();
            mBuilder.setSound(Uri.parse(soundPref));
        }
        if (alertPreference.shouldVibrate(audioManager))
        {
            mBuilder.setVibrate(alertPreference.getVibratePattern());
        }
        return this;
    }

    public NotificationBuilder addAction()
    {
        NotificationAction action = mContent.getNotificationAction();
        mBuilder.addAction(action.getIcon(), action.getTitle(), action.getPendingIntent());
        return this;
    }

    public NotificationBuilder setTickerText()
    {
        mBuilder.setTicker(mContent.getBody());
        return this;
    }

    public NotificationBuilder setLargeIcon()
    {
        mBuilder.setLargeIcon(mContent.getNotificationIcon());
        return this;
    }

    public NotificationBuilder setContentInfo()
    {
        mBuilder.setContentInfo(mContent.getContentInfo());
        return this;
    }

    public NotificationBuilder setContentIntent()
    {
        mBuilder.setContentIntent(mContent.getContentIntent());
        return this;
    }

    public Notification build()
    {
        return mBuilder.build();
    }

    public void clear()
    {
        mContent = null;
        mBuilder = null;
    }

    public NotificationBuilder setStyle()
    {
        new StyleProcessor().setAndGetStyle(mContent);
        return this;
    }

    public NotificationBuilder setDeleteContent()
    {
        mBuilder.setDeleteIntent(mContent.getDeleteIntent());
        return this;
    }

    public NotificationBuilder setFullScreenIntent()
    {
        mBuilder.setFullScreenIntent(mContent.getFullScreenIntent(), mContent.isFullScreenPriorityHigh());
        return this;
    }

    public NotificationBuilder setSmallIcon()
    {
        mBuilder.setSmallIcon(mContent.getIcon());
        return this;
    }

}
