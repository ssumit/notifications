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

    public String getSoundPreference()
    {
        String customSoundUri = mNotificationStore.get(StoreKeys.NOTIFICATION_SOUND_PREFERENCE_KEY.toString());
        return (customSoundUri == null || customSoundUri.equals("")) ?
                null : customSoundUri;
    }

    public String getVibratePreference()
    {
        String vibratePref = mNotificationStore.get(StoreKeys.NOTIFICATION_VIBRATE_PREFERENCE_KEY.toString());
        return (vibratePref == null || vibratePref.equals("")) ?
                null : vibratePref;
    }

    @Override
    public Uri getSoundUri() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Uri getSilentSoundUri() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}

