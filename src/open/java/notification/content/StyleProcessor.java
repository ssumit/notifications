package open.java.notification.content;

import android.support.v4.app.NotificationCompat;

public class StyleProcessor
{
    //todo : remove extra null checks
    public NotificationCompat.Style setAndGetStyle(NotificationContent content)
    {
        NotificationStyle style = content.getStyle();
        if (style.equals(NotificationStyle.BIG_PICTURE))
        {
            NotificationCompat.BigPictureStyle bigPictureStyle = new NotificationCompat.BigPictureStyle();
            bigPictureStyle.setBigContentTitle(content.getTitle());
            if (content.getSummaryText() != null)
            {
                bigPictureStyle.setSummaryText(content.getSummaryText());
            }
            if (content.getLargeIcon() != null)
            {
                bigPictureStyle.bigPicture(content.getLargeIcon());
            }
            return bigPictureStyle;
        }
        else if (style.equals(NotificationStyle.BIG_TEXT))
        {
            NotificationCompat.BigTextStyle bigTextStyle = new NotificationCompat.BigTextStyle();
            bigTextStyle.setBigContentTitle(content.getTitle());
            if (content.getFullMessageText() != null)
            {
                bigTextStyle.bigText(content.getFullMessageText());
            }
            if (content.getSummaryText() != null)
            {
                bigTextStyle.setSummaryText(content.getSummaryText());
            }
            return bigTextStyle;
        }
        else if (style.equals(NotificationStyle.INBOX))
        {
            NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
            inboxStyle.setBigContentTitle(content.getTitle());
            if (content.getSummaryText() != null)
            {
                inboxStyle.setSummaryText(content.getSummaryText());
            }
            if (content.getBody() != null)
            {
                inboxStyle.addLine(content.getBody());
            }
            return inboxStyle;
        }
        else
        {
            throw new IllegalArgumentException("unknown and unsupported style type");
        }
    }
}
