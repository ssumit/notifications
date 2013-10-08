package open.java.notification;

import open.java.store.INotificationStore;
import open.java.store.IUserPrefStore;
import open.java.store.NotificationStore;
import open.java.settings.UserPrefStore;

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
