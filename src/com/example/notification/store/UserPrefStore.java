package com.example.notification.store;

public class UserPrefStore implements IUserPrefStore
{
    private INotificationStore mNotificationStore;

    public UserPrefStore(INotificationStore notificationStore)
    {
        mNotificationStore = notificationStore;
    }

    @Override
    public String getSoundPreference()
    {
        String customSoundUri = mNotificationStore.get(StoreKeys.NOTIFICATION_SOUND_PREFERENCE_KEY.toString());
        return (customSoundUri == null || customSoundUri.equals("")) ?
                null : customSoundUri;
    }

    @Override
    public String getVibratePreference()
    {
        String vibratePref = mNotificationStore.get(StoreKeys.NOTIFICATION_VIBRATE_PREFERENCE_KEY.toString());
        return (vibratePref == null || vibratePref.equals("")) ?
                null : vibratePref;
    }

}

