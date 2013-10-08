package open.java.settings;

import android.media.AudioManager;

public class AlertPreference
{
    private String mSoundPreference;
    private LightPreference mLightPreference;
    private String mVibratePreference;
    private boolean mAlertOnce;
    private long[] mVibratePattern;

    public AlertPreference()
    {
        this(null, null);
    }

    public AlertPreference(String soundPreference, String vibratePreference)
    {
        mLightPreference = new LightPreference();
        mSoundPreference = soundPreference;
        mVibratePreference = vibratePreference;
        mVibratePattern = new long[]{0, 500, 200, 300, 200, 100};
    }

    public boolean shouldVibrate(AudioManager audioManager)
    {
        return audioManager.getRingerMode() != AudioManager.RINGER_MODE_SILENT && (mVibratePreference != null);
    }

    public boolean shouldSound(AudioManager audioManager)
    {
        return audioManager.getRingerMode() == AudioManager.RINGER_MODE_NORMAL && (mSoundPreference != null);
    }

    public LightPreference getLightPreference()
    {
        return mLightPreference;
    }

    public boolean isAlertOnce()
    {
        return mAlertOnce;
    }

    public void setAlertOnce(boolean alertOnce)
    {
        mAlertOnce = alertOnce;
    }

    public String getSoundPref()
    {
        return mSoundPreference;
    }

    public void setVibratePattern(long[] pattern)
    {
        mVibratePattern = pattern;
    }

    public long[] getVibratePattern()
    {
        return mVibratePattern;
    }
}
