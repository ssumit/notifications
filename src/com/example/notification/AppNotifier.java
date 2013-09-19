package com.example.notification;

import android.app.NotificationManager;
import android.content.Context;
import android.support.v4.app.NotificationCompat;
import com.example.notification.content.NotificationContent;
import com.example.notification.content.StyleProcessor;import com.example.notification.display.NotificationBuilder;
import com.example.notification.store.IUserPrefStore;

public class AppNotifier implements IAppNotifier
{
    private final Context mContext;
    private final NotificationManager mNotificationManager;
    private static boolean mMessageNotificationVisibleState;
    private NotificationBuilder mBuilder;
    private final StyleProcessor mStyleProcessor;

    public AppNotifier(Context context, IUserPrefStore userPrefStore)
    {
        mContext = context;
        mBuilder = new NotificationBuilder(context, userPrefStore);
        mNotificationManager = (NotificationManager) mContext.getSystemService(Context.NOTIFICATION_SERVICE);
        mStyleProcessor = new StyleProcessor();
    }

    public void generateMessageNotification(NotificationContent content, boolean mustFireAndAlert)
    {
        if (content != null)
        {
            NotificationCompat.Builder builder = mBuilder.getNotificationBuilder(content.getTitle(), content.getBody(), mustFireAndAlert)
                    .setTicker(content.getTickerText()).setLargeIcon(content.getNotificationIcon());

            builder.setStyle(mStyleProcessor.setAndGetStyle(content));

            if (mMessageNotificationVisibleState || mustFireAndAlert)
            {
                mMessageNotificationVisibleState = true;
                mNotificationManager.notify(content.getId(), builder.build());
            }
        }
    }

    public void removeMessageNotification(int id)
    {
        mNotificationManager.cancel(id);
        mMessageNotificationVisibleState = false;
    }

    public void setMessageNotificationVisibleState(boolean value)
    {
        mMessageNotificationVisibleState = value;
    }
}
