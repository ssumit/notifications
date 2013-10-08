package open.java.settings;

import android.content.Context;
import android.media.AudioManager;
import open.java.store.IUserPrefStore;

public class SettingsManager implements ISettingManager
{
    private final Context mContext;
    private final IUserPrefStore mStore;

    public SettingsManager(Context mContext, IUserPrefStore store)
    {
        this.mContext = mContext;
        mStore = store;
    }

    @Override
    public AlertPreference getAlertPreference()
    {
        AudioManager manager = (AudioManager) mContext.getSystemService(Context.AUDIO_SERVICE);
        AlertPreference preference = new AlertPreference();
        int ringerMode = manager.getRingerMode();
        switch (ringerMode)
        {
            case AudioManager.RINGER_MODE_NORMAL:
                preference.setSoundUri(mStore.getSoundUri());
                preference.setVibratePattern(null);
                break;
            case AudioManager.RINGER_MODE_SILENT:
                preference.setSoundUri(mStore.getSilentSoundUri());
                preference.setVibratePattern(null);
                break;
            case AudioManager.RINGER_MODE_VIBRATE:
                preference.setSoundUri(mStore.getSilentSoundUri());
                preference.setVibratePattern(new long[]{0, 100, 200});
                break;
        }
        return preference;
    }
}
