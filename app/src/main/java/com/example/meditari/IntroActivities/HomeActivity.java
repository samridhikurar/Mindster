package com.example.meditari.IntroActivities;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import com.example.meditari.Features.ProfileActivity;
import com.example.meditari.FillerActivities.InfoFiller;
import com.example.meditari.FillerActivities.JournalFiller;
import com.example.meditari.FillerActivities.MeditationFiller;
import com.example.meditari.FillerActivities.MoodFiller;
import com.example.meditari.FillerActivities.VoiceFiller;
import com.example.meditari.R;
import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity extends AppCompatActivity {

    CardView card1, card2, card3, card4, card5, card6;
    public static final String NOTIFICATION_CHANNEL_ID="Notification";
    public static NotificationManagerCompat compat;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        loadNotification(this);
        auth= FirebaseAuth.getInstance();

        if(auth.getCurrentUser()==null){
            startActivity(new Intent(HomeActivity.this, RegisterActivity.class));
        }


        card1=findViewById(R.id.card1);
        card2=findViewById(R.id.card2);
        card3=findViewById(R.id.card3);
        card4=findViewById(R.id.card4);
        card5=findViewById(R.id.card5);
        card6=findViewById(R.id.card6);

        card1.setCardBackgroundColor(getResources().getColor(R.color.card1));
        card2.setCardBackgroundColor(getResources().getColor(R.color.card2));
        card3.setCardBackgroundColor(getResources().getColor(R.color.card3));
        card4.setCardBackgroundColor(getResources().getColor(R.color.card4));
        card5.setCardBackgroundColor(getResources().getColor(R.color.card5));
        card6.setCardBackgroundColor(getResources().getColor(R.color.card6));

        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(HomeActivity.this, InfoFiller.class);
                startActivity(intent);
            }
        });

        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(HomeActivity.this, MeditationFiller.class);
                startActivity(intent);
            }
        });

        card3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(HomeActivity.this, MoodFiller.class);
                startActivity(intent);
            }
        });

        card4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(HomeActivity.this, JournalFiller.class);
                startActivity(intent);
            }
        });

        card5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(HomeActivity.this, VoiceFiller.class);
                startActivity(intent);
            }
        });

        card6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(HomeActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static void loadNotification(Context context){
        NotificationChannel notificationChannel=
                new NotificationChannel(NOTIFICATION_CHANNEL_ID, NOTIFICATION_CHANNEL_ID,
                        NotificationManager.IMPORTANCE_DEFAULT);

        NotificationManager manager= context.getSystemService(NotificationManager.class);

        notificationChannel.setImportance(NotificationManager.IMPORTANCE_DEFAULT);
        notificationChannel.enableLights(false);
        notificationChannel.setBypassDnd(false);
        notificationChannel.enableVibration(true);
        manager.createNotificationChannel(notificationChannel);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context,NOTIFICATION_CHANNEL_ID);
        builder.setContentTitle("Mindster says:")
                .setContentText("Keep calm, you got this. I'm here to help")
                .setContentIntent(PendingIntent
                        .getActivity(context,0,new Intent(context,HomeActivity.class),
                                PendingIntent.FLAG_UPDATE_CURRENT))
                .setOngoing(true)
                .setSmallIcon(R.drawable.ic_baseline_profile)
                .setPriority(Notification.PRIORITY_DEFAULT);

        Notification notification=builder.build();

        compat=NotificationManagerCompat.from(context);
        compat.notify(1,notification);

    }
}