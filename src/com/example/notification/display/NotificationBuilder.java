package com.example.notification.display;

import android.app.Notification;
import android.content.Context;
import android.media.AudioManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import com.example.notification.store.IUserPrefStore;

public class NotificationBuilder
{
    private IUserPrefStore mUserPrefStore;
    private Context mContext;

    public NotificationBuilder(Context context, IUserPrefStore userPrefStore)
    {
        mContext = context;
        mUserPrefStore = userPrefStore;
    }

    public NotificationCompat.Builder getNotificationBuilder(String title, String body, boolean alertFlag)
    {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(mContext)
                .setContentTitle(title)
                .setContentText(body)
                .setSmallIcon(1)
                .setAutoCancel(true);

        if (alertFlag)
        {
            builder.setTicker(body);
            builder.setLights(0xFF0000FF, 100, 3000);
            builder.setPriority(Notification.PRIORITY_DEFAULT);

            String ringToneUri = mUserPrefStore.getSoundPreference();

            if (ringToneUri != null)
            {
                builder.setSound(Uri.parse(ringToneUri));
            }

            if (vibrateDevice(mUserPrefStore.getVibratePreference()))
            {
                builder.setVibrate(new long[]{0, 500, 200, 300, 200, 100});
            }
        }

        return builder;
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

}
