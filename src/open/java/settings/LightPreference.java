package open.java.settings;

public class LightPreference
{
    int argb;
    int onMs;
    int offMs;

    public LightPreference()
    {
        argb = 0xFF0000FF;
        onMs = 100;
        offMs = 3000;
    }

    public int getArgb()
    {
        return argb;
    }

    public void setArgb(int argb)
    {
        this.argb = argb;
    }

    public int getOnMs()
    {
        return onMs;
    }

    public void setOnMs(int onMs)
    {
        this.onMs = onMs;
    }

    public int getOffMs()
    {
        return offMs;
    }

    public void setOffMs(int offMs)
    {
        this.offMs = offMs;
    }
}
