package com.example.notification.content;

import android.support.v4.app.NotificationCompat;

public class StyleProcessor
{
    public NotificationCompat.Style setAndGetStyle(NotificationContent content)
    {
        NotificationStyle style = content.getStyle();
        if (style.equals(NotificationStyle.NORMAL))
        {
            return null;
        }
        else if (style.equals(NotificationStyle.BIG_PICTURE))
        {
            NotificationCompat.BigPictureStyle bigPictureStyle = new NotificationCompat.BigPictureStyle();
            bigPictureStyle.setBigContentTitle(content.getTitle());
            bigPictureStyle.setSummaryText(content.getSummaryText());
            bigPictureStyle.bigPicture(content.getNotificationIcon());
            return bigPictureStyle;
        }
        else if (style.equals(NotificationStyle.BIG_TEXT))
        {
            NotificationCompat.BigTextStyle bigTextStyle = new NotificationCompat.BigTextStyle();
            bigTextStyle.setBigContentTitle(content.getTitle());
            bigTextStyle.bigText(content.getFullMessageText());
            bigTextStyle.setSummaryText(content.getSummaryText());
            return bigTextStyle;
        }
        else if (style.equals(NotificationStyle.INBOX))
        {
            NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
            inboxStyle.setSummaryText(content.getSummaryText());
            inboxStyle.setBigContentTitle(content.getTitle());
            inboxStyle.addLine(content.getBody());
        }
        else
        {
            throw new IllegalArgumentException("unknown and unsupported style type");
        }
        return null;
    }
}
