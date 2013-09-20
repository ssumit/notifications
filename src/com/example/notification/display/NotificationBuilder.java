package com.example.notification.display;

import android.app.Notification;
import android.content.Context;
import android.media.AudioManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import com.example.notification.content.NotificationContent;
import com.example.notification.content.StyleProcessor;
import com.example.notification.store.IUserPrefStore;

public class NotificationBuilder
{
    private IUserPrefStore mUserPrefStore;
    private Context mContext;
    private NotificationCompat.Builder mBuilder;
    private NotificationContent mContent;

    public NotificationBuilder(Context context, IUserPrefStore userPrefStore)
    {
        mContext = context;
        mUserPrefStore = userPrefStore;
    }

    public Notification buildNotification(NotificationContent content)
    {
        startBuildingNotification(content);
        setAlertSettings();
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
                .setAutoCancel(true);

        return this;
    }

    //todo : make alert setting more generic
    public NotificationBuilder setAlertSettings()
    {
        mBuilder.setLights(0xFF0000FF, 100, 3000);
        mBuilder.setPriority(Notification.PRIORITY_DEFAULT);

        String ringToneUri = mUserPrefStore.getSoundPreference();

        if (ringToneUri != null)
        {
            mBuilder.setSound(Uri.parse(ringToneUri));
        }

        if (vibrateDevice(mUserPrefStore.getVibratePreference()))
        {
            mBuilder.setVibrate(new long[]{0, 500, 200, 300, 200, 100});
        }
        return this;
    }

    public boolean vibrateDevice(String vibratePref)
    {
        AudioManager audioManager = (AudioManager) mContext.getSystemService(Context.AUDIO_SERVICE);
        if (audioManager.getRingerMode() == AudioManager.RINGER_MODE_SILENT)
        {
            return false;
        }
        else
        {
            return (vibratePref != null); //add vibrate off condition
        }
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
