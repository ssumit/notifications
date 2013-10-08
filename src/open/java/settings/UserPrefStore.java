package open.java.settings;

import android.net.Uri;
import open.java.store.INotificationStore;
import open.java.store.IUserPrefStore;

public class UserPrefStore implements IUserPrefStore
{
    private INotificationStore mNotificationStore;

    public UserPrefStore(INotificationStore notificationStore)
    {
        mNotificationStore = notificationStore;
    }

    @Override
    public Uri getSoundUri()
    {
        String customSoundUri = mNotificationStore.get(StoreKeys.NOTIFICATION_SOUND_PREFERENCE_KEY.toString());
        return (customSoundUri == null || customSoundUri.equals("")) ?
                null : Uri.parse(customSoundUri);
    }

    @Override
    public Uri getSilentSoundUri()
    {
        return Uri.parse("SILENT");
    }
}

