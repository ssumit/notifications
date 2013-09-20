package com.java.notification;

import android.app.NotificationManager;
import android.content.Context;
import com.java.notification.content.NotificationContent;
import com.java.notification.display.NotificationBuilder;

public class AppNotifier implements IAppNotifier
{
    private final Context mContext;
    private final NotificationManager mNotificationManager;
    private NotificationBuilder mBuilder;

    public AppNotifier(Context context)
    {
        mContext = context;
        mBuilder = new NotificationBuilder(context);
        mNotificationManager = (NotificationManager) mContext.getSystemService(Context.NOTIFICATION_SERVICE);
    }

    public void generateMessageNotification(NotificationContent content)
    {
        if (content != null)
        {
            mNotificationManager.notify(content.getId(), mBuilder.buildNotification(content));
        }
    }

    public void removeMessageNotification(int id)
    {
        mNotificationManager.cancel(id);
    }
}
