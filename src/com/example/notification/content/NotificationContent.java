package com.example.notification.content;

import android.graphics.Bitmap;
import com.example.util.Utils;

import java.util.UUID;

public class NotificationContent
{
    private String mTitle;
    private String mBody;
    private String mTickerText;
    private String mSummaryText;
    private int mContentInfo;
    private String mContactId;
    private Bitmap mNotificationIcon;
    private String mFullyMessageText;
    private int mId;

    public NotificationContent(String title, String body, String tickerText)
    {
        mTitle = title;
        mBody = body;
        mFullyMessageText = body;
        mTickerText = new Utils().trimTickerText(tickerText);
        mSummaryText = "";
        mContentInfo=0;
        mId = UUID.randomUUID().hashCode();
    }

    public String getTitle()
    {
        return mTitle;
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

    public String getContactId()
    {
        return mContactId;
    }

    public int getContentInfo()
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
        mContentInfo =value;
    }

    public void setContactId(String value)
    {
        mContactId =value;
    }

    public void setNotificationIcon(Bitmap value)
    {
        mNotificationIcon = value;
    }

    public void setFullMessageText(String value)
    {
        mFullyMessageText = value;
    }

    public int getId()
    {
        return mId;
    }
}
