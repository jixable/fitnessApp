package com.vogella.android.fitmovement.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import notifications.WorkoutScheduleNotification;
import notifications.NotificationCenter;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import com.vogella.android.fitmovement.R;

import java.time.DayOfWeek;
import java.util.Calendar;

public class WorkoutScheduleActivity extends AppCompatActivity {

    Button done, cancel;
    TextView monday, tuesday, wednesday, thursday, friday, saturday, sunday;
    TimePicker time;
    Intent myIntent;
    PendingIntent pendingIntent;
    int id = 115;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_schedule);
        createNotificationChannel();
        myIntent = new Intent(getBaseContext(), WorkoutScheduleNotification.class);
        myIntent.putExtra("id", id);
        pendingIntent = PendingIntent.getBroadcast(getBaseContext(), id, myIntent, 0);

        monday = findViewById(R.id.textMonday);
        tuesday = findViewById(R.id.textTuesday);
        wednesday = findViewById(R.id.textWednesday);
        thursday = findViewById(R.id.textThursday);
        friday = findViewById(R.id.textFriday);
        saturday = findViewById(R.id.textSaturday);
        sunday = findViewById(R.id.textSunday);
        time = findViewById(R.id.tpSelectedTime);



        done = findViewById(R.id.saveButton1);
        cancel = findViewById(R.id.cancelbutton1);

        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        monday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                calendar.set(Calendar.DAY_OF_WEEK, 2);
                calendar.set(Calendar.HOUR, time.getHour());
                calendar.set(Calendar.MINUTE, time.getMinute());
                calendar.set(Calendar.SECOND, 0);
                calendar.set(Calendar.MILLISECOND, 0);

                alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),AlarmManager.INTERVAL_DAY * 7, pendingIntent);

            }
        });

        tuesday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                calendar.set(Calendar.DAY_OF_WEEK, 3);
                calendar.set(Calendar.HOUR, time.getHour());
                calendar.set(Calendar.MINUTE, time.getMinute());
                calendar.set(Calendar.SECOND, 0);
                calendar.set(Calendar.MILLISECOND, 0);

                alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),AlarmManager.INTERVAL_DAY * 7, pendingIntent);

            }
        });

        wednesday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                calendar.set(Calendar.DAY_OF_WEEK, 4);
                calendar.set(Calendar.HOUR, time.getHour());
                calendar.set(Calendar.MINUTE, time.getMinute());
                calendar.set(Calendar.SECOND, 0);
                calendar.set(Calendar.MILLISECOND, 0);

                alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),AlarmManager.INTERVAL_DAY * 7, pendingIntent);

            }
        });

        thursday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                calendar.set(Calendar.DAY_OF_WEEK, 5);
                calendar.set(Calendar.HOUR, time.getHour());
                calendar.set(Calendar.MINUTE, time.getMinute());
                calendar.set(Calendar.SECOND, 0);
                calendar.set(Calendar.MILLISECOND, 0);

                alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),AlarmManager.INTERVAL_DAY * 7, pendingIntent);

            }
        });

        friday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                calendar.set(Calendar.DAY_OF_WEEK, 6);
                calendar.set(Calendar.HOUR, time.getHour());
                calendar.set(Calendar.MINUTE, time.getMinute());
                calendar.set(Calendar.SECOND, 0);
                calendar.set(Calendar.MILLISECOND, 0);

                alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),AlarmManager.INTERVAL_DAY * 7, pendingIntent);

            }
        });

        saturday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                calendar.set(Calendar.DAY_OF_WEEK, 7);
                calendar.set(Calendar.HOUR, time.getHour());
                calendar.set(Calendar.MINUTE, time.getMinute());
                calendar.set(Calendar.SECOND, 0);
                calendar.set(Calendar.MILLISECOND, 0);

                alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),AlarmManager.INTERVAL_DAY * 7, pendingIntent);

            }
        });

        sunday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                calendar.set(Calendar.DAY_OF_WEEK, 8);
                calendar.set(Calendar.HOUR, time.getHour());
                calendar.set(Calendar.MINUTE, time.getMinute());
                calendar.set(Calendar.SECOND, 0);
                calendar.set(Calendar.MILLISECOND, 0);

                alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),AlarmManager.INTERVAL_DAY * 7, pendingIntent);

            }
        });

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent reminderSett = new Intent(getApplicationContext(), ProfileActivity.class);
                WorkoutScheduleActivity.this.startActivity(reminderSett);
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goBack = new Intent(getApplicationContext(), ProfileActivity.class);
                WorkoutScheduleActivity.this.startActivity(goBack);
            }
        });


    }

    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Workout Schedule Notification Channel";
            int importance = android.app.NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("workoutScheduleNotif", name, importance);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            android.app.NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
}