package open.java.notification;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class NotificationBroadcastReceiver extends BroadcastReceiver
{

    @Override
    public void onReceive(Context context, Intent intent)
    {
        if(validateIntentData(intent))
        {
        }
    }

    private boolean validateIntentData(Intent intent)
    {
        return intent != null && intent.getAction() != null;
    }

}
