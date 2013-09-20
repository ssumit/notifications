package com.java.notification;

import com.java.notification.store.INotificationStore;
import com.java.notification.store.IUserPrefStore;
import com.java.notification.store.NotificationStore;
import com.java.notification.store.UserPrefStore;

public class StorageFactory
{
    private INotificationStore mNotificationStore;

    public StorageFactory()
    {
        mNotificationStore = new NotificationStore();
    }

    public StorageFactory(INotificationStore mNotificationStore)
    {
        this.mNotificationStore = mNotificationStore;
    }

    public IUserPrefStore getUserPrefStore()
    {
        return new UserPrefStore(mNotificationStore);
    }
}
