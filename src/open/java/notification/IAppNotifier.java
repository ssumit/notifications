package open.java.notification;

import open.java.notification.content.NotificationContent;

public interface IAppNotifier
{
    void generateNotification(NotificationContent content);

    void removeNotification(int id);
}
