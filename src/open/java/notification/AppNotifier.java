package open.java.notification;

import android.app.NotificationManager;
import android.content.Context;
import open.java.notification.content.NotificationContent;
import open.java.notification.builder.NotificationBuilder;

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

    @Override
    public void generateNotification(NotificationContent content)
    {
        if (content != null)
        {
            mNotificationManager.notify(content.getId(), mBuilder.buildNotification(content));
        }
    }

    @Override
    public void removeNotification(int id)
    {
        mNotificationManager.cancel(id);
    }
}
