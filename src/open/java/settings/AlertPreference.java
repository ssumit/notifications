package open.java.settings;

import android.net.Uri;

public class AlertPreference
{
    private Uri mSoundUri;
    private LightPreference mLightPreference;
    private long[] mVibratePattern;

    public AlertPreference()
    {
        this(null);
    }

    public AlertPreference(Uri soundPreference)
    {
        mLightPreference = new LightPreference();
        mSoundUri = soundPreference;
        mVibratePattern = new long[]{0, 500, 200, 300, 200, 100};
    }

    public LightPreference getLightPreference()
    {
        return mLightPreference;
    }

    public Uri getSoundUri()
    {
        return mSoundUri;
    }

    public void setSoundUri(Uri uri)
    {
        mSoundUri = uri;
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
