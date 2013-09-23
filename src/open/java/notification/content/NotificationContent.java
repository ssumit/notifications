package open.java.notification.content;

import android.app.PendingIntent;
import android.graphics.Bitmap;
import open.java.util.Utils;

import java.util.UUID;

public class NotificationContent
{
    private String mTitle;
    private String mBody;
    private String mTickerText;
    private String mSummaryText;
    private String mContentInfo;
    private Bitmap mLargeIcon;
    private String mFullyMessageText;
    private int mId;
    private NotificationStyle mStyle;
    private PendingIntent mContentPendingIntent;
    private PendingIntent mDeletePendingIntent;
    private NotificationAction mNotificationAction;
    private PendingIntent mFullScreenIntent;
    private boolean mFullScreenPriority;
    private int mIcon;
    private AlertPreference mAlertPreference;

    public NotificationContent(String title, String body, String tickerText, int icon)
    {
        mTitle = title;
        mBody = body;
        mFullyMessageText = body;
        mTickerText = new Utils().trimTickerText(tickerText);
        mSummaryText = "";
        mIcon = icon;
        mId = UUID.randomUUID().hashCode();
        mStyle = NotificationStyle.NORMAL;
        mAlertPreference = new AlertPreference();
    }

    public String getTitle()
    {
        return mTitle;
    }

    public NotificationStyle getStyle()
    {
        return mStyle;
    }

    public String getBody()
    {
        return mBody;
    }

    public String getTickerText()
    {
        return mTickerText;
    }

    public String getSummaryText()
    {
        return mSummaryText;
    }

    public String getContentInfo()
    {
        return mContentInfo;
    }

    public Bitmap getLargeIcon()
    {
        return mLargeIcon;
    }

    public String getFullMessageText()
    {
        return mFullyMessageText;
    }

    public NotificationContent setSummaryText(String value)
    {
        mSummaryText = value;
        return this;
    }

    public NotificationContent setContactInfo(String value)
    {
        mContentInfo =value;
        return this;
    }

    public NotificationContent setLargeIcon(Bitmap value)
    {
        mLargeIcon = value;
        return this;
    }

    public NotificationContent setFullMessageText(String value)
    {
        mFullyMessageText = value;
        return this;
    }

    public NotificationContent setStyle(NotificationStyle style)
    {
        mStyle = style;
        return this;
    }

    public int getId()
    {
        return mId;
    }

    public NotificationContent setContentIntent(PendingIntent pendingIntent)
    {
        mContentPendingIntent = pendingIntent;
        return this;
    }

    public PendingIntent getContentIntent()
    {
        return mContentPendingIntent;
    }

    public NotificationContent setDeleteIntent(PendingIntent pendingIntent)
    {
        mDeletePendingIntent = pendingIntent;
        return this;
    }

    public PendingIntent getDeleteIntent()
    {
        return mDeletePendingIntent;
    }

    public NotificationContent setNotificationAction(NotificationAction action)
    {
        mNotificationAction = action;
        return this;
    }

    public NotificationAction getNotificationAction()
    {
        return mNotificationAction;
    }

    public PendingIntent getFullScreenIntent()
    {
        return mFullScreenIntent;
    }

    public NotificationContent setFullScreenIntentAndPriority(PendingIntent pendingIntent, boolean priority)
    {
        mFullScreenIntent = pendingIntent;
        mFullScreenPriority = priority;
        return this;
    }

    public boolean isFullScreenPriorityHigh()
    {
        return mFullScreenPriority;
    }

    public int getIcon()
    {
        return mIcon;
    }

    public NotificationContent setIcon(int icon)
    {
        mIcon = icon;
        return this;
    }

    public NotificationContent setAlertPreference(AlertPreference alertPreference)
    {
        mAlertPreference = alertPreference;
        return this;
    }

    public AlertPreference getAlertPreference()
    {
        return mAlertPreference;
    }
}
