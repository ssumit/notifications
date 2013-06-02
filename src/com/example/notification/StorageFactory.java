package com.example.notification;

import com.example.notification.store.INotificationStore;
import com.example.notification.store.IUserPrefStore;
import com.example.notification.store.NotificationStore;
import com.example.notification.store.UserPrefStore;

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
