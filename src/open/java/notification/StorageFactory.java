package open.java.notification;

import open.java.notification.store.INotificationStore;
import open.java.notification.store.IUserPrefStore;
import open.java.notification.store.NotificationStore;
import open.java.notification.store.UserPrefStore;

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
