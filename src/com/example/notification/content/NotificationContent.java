package com.example.notification.content;

import android.app.PendingIntent;
import android.graphics.Bitmap;
import com.example.util.Utils;

import java.util.UUID;

public class NotificationContent
{
    private String mTitle;
    private String mBody;
    private String mTickerText;
    private String mSummaryText;
    private int mContactId;
    private String mContentInfo;
    private Bitmap mNotificationIcon;
    private String mFullyMessageText;
    private int mId;
    private NotificationStyle mStyle;
    private PendingIntent mContentPendingIntent;
    private PendingIntent mDeletePendingIntent;
    private NotificationAction mNotificationAction;

    public NotificationContent(String title, String body, String tickerText)
    {
        mTitle = title;
        mBody = body;
        mFullyMessageText = body;
        mTickerText = new Utils().trimTickerText(tickerText);
        mSummaryText = "";
        mContactId =0;
        mId = UUID.randomUUID().hashCode();
        mStyle = NotificationStyle.NORMAL;
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

    public int getContactId()
    {
        return mContactId;
    }

    public String getContentInfo()
    {
        return mContentInfo;
    }

    public Bitmap getNotificationIcon()
    {
        return mNotificationIcon;
    }

    public String getFullMessageText()
    {
        return mFullyMessageText;
    }

    public void setSummaryText(String value)
    {
        mSummaryText = value;
    }

    public void setContentInfo(int value)
    {
        mContactId =value;
    }

    public void setContactId(String value)
    {
        mContentInfo =value;
    }

    public void setNotificationIcon(Bitmap value)
    {
        mNotificationIcon = value;
    }

    public void setFullMessageText(String value)
    {
        mFullyMessageText = value;
    }

    public void setStyle(NotificationStyle style)
    {
        mStyle = style;
    }

    public int getId()
    {
        return mId;
    }

    public void setContentIntent(PendingIntent pendingIntent)
    {
        mContentPendingIntent = pendingIntent;
    }

    public PendingIntent getContentIntent()
    {
        return mContentPendingIntent;
    }

    public void setDeleteIntent(PendingIntent pendingIntent)
    {
        mDeletePendingIntent = pendingIntent;
    }

    public PendingIntent getDeleteIntent()
    {
        return mDeletePendingIntent;
    }

    public void setNotificationAction(NotificationAction action)
    {
        mNotificationAction = action;
    }

    public NotificationAction getNotificationAction()
    {
        return mNotificationAction;
    }
}
