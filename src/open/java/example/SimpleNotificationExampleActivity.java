package open.java.example;

import android.app.Activity;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import com.java.R;
import open.java.notification.AppNotifier;
import open.java.notification.StorageFactory;
import open.java.notification.content.NotificationContent;
import open.java.settings.AlertPreference;
import open.java.settings.ISettingManager;
import open.java.settings.SettingsManager;
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

    private void showNotification()
    {
        IUserPrefStore userPrefStore = new StorageFactory().getUserPrefStore();
        ISettingManager settingManager = new SettingsManager(this, userPrefStore);
        AlertPreference alertPreference = settingManager.getAlertPreference();
        String mTitle = "Title";
        String mBody = "Body";
        String mTickerText = "TickerText";
        NotificationContent notificationContent = new NotificationContent(mTitle, mBody, mTickerText, R.drawable.accounts_cross);
        notificationContent.setLargeIcon(((BitmapDrawable) getResources().getDrawable(R.drawable.accounts_cross)).getBitmap());
        notificationContent.setAlertPreference(alertPreference);
        AppNotifier appNotifier = new AppNotifier(getApplicationContext());
        appNotifier.generateNotification(notificationContent);
    }
}
