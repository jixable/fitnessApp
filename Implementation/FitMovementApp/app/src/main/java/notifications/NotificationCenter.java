package notifications;
import android.app.NotificationManager;
import android.app.NotificationChannel;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;

import com.vogella.android.fitmovement.R;

import static android.provider.Settings.System.getString;
import static androidx.core.content.ContextCompat.getSystemService;

public class NotificationCenter extends ContextWrapper {

    private static final String TAG = "NotificationCenter";

    public NotificationCenter(Context base) {
        super(base);
        createNotificationChannel();
    }
//    private String CHANNEL_NAME = "Workout Schedule Notification Channel";
    private String CHANNEL_ID = "workoutScheduleNotif";

    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Workout Schedule Notification Channel";
            int importance = android.app.NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            android.app.NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
}
