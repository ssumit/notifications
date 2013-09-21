package open.java.notification.content;

import android.support.v4.app.NotificationCompat;

public class StyleProcessor
{
    //todo : remove extra null checks
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
            if (content.getTitle() != null)
            {
                bigPictureStyle.setBigContentTitle(content.getTitle());
            }
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
            if (content.getTitle() != null)
            {
                bigTextStyle.setBigContentTitle(content.getTitle());
            }
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
            if (content.getSummaryText() != null)
            {
                inboxStyle.setSummaryText(content.getSummaryText());
            }
            if (content.getTitle() != null)
            {
                inboxStyle.setBigContentTitle(content.getTitle());
            }
            if (content.getBody() != null)
            {
                inboxStyle.addLine(content.getBody());
            }
        }
        else
        {
            throw new IllegalArgumentException("unknown and unsupported style type");
        }
        return null;
    }
}
