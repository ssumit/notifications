package com.java.notification;

import com.java.notification.content.NotificationContent;

public interface IAppNotifier
{
    void generateNotification(NotificationContent content);

    void removeNotification(int id);
}
