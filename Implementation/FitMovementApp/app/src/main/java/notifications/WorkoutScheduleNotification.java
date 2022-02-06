package notifications;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.vogella.android.fitmovement.R;

import static android.provider.Settings.System.getString;
import static androidx.core.content.ContextCompat.getSystemService;

public class WorkoutScheduleNotification extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "workoutScheduleNotif")
                .setSmallIcon(R.drawable.ic_notifications)
                .setContentTitle("It's Time to Workout!")
                .setContentText("You're working out today bro, get ready and keep grinding!")
//                .setStyle(new NotificationCompat.BigTextStyle()
//                        .bigText("Much longer text that cannot fit one line..."))
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(context);
        notificationManagerCompat.notify(200, builder.build());
        
    }

}
