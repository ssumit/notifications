package open.java.example;

import android.app.Activity;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import com.java.R;
import open.java.notification.AppNotifier;
import open.java.notification.StorageFactory;
import open.java.notification.content.NotificationContent;
import open.java.store.IUserPrefStore;

public class SimpleNotificationExampleActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        showNotification();
    }

    private String mTitle = "Title";
    private String mBody = "Body";
    private String mTickerText = "TickerText";

    private void showNotification()
    {
        NotificationContent notificationContent = new NotificationContent(mTitle, mBody, mTickerText, R.drawable.accounts_cross);
        notificationContent.setLargeIcon(((BitmapDrawable) getResources().getDrawable(R.drawable.accounts_cross)).getBitmap());
        IUserPrefStore userPrefStore = new StorageFactory().getUserPrefStore();
        AppNotifier appNotifier = new AppNotifier(getApplicationContext());
        appNotifier.generateNotification(notificationContent);
    }
}
