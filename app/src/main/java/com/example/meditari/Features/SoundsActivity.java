package com.example.meditari.Features;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.meditari.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class SoundsActivity extends AppCompatActivity {

    TextView category, timerTxt, durationTxt;
    ImageButton playImageBtn, backImg;
    FirebaseDatabase db;
    String sound;
    MediaPlayer mediaPlayer;
    String audioUrl;
    DatabaseReference reference;
    private Handler handler=new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sounds);

        category=findViewById(R.id.category);
        timerTxt=findViewById(R.id.timerTxt);
        durationTxt=findViewById(R.id.durationTxt);
        playImageBtn=findViewById(R.id.playImageBtn);
        backImg=findViewById(R.id.BackImg);
        db=FirebaseDatabase.getInstance();

        Intent intent= getIntent();
        sound=intent.getStringExtra("soundno");

        mediaPlayer=new MediaPlayer();

        reference= db.getReference().child("sounds").child(sound);

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String ctg= snapshot.child("category").getValue().toString();
                String duration= snapshot.child("duration").getValue().toString();
                audioUrl= snapshot.child("url").getValue().toString();

                category.setText(ctg);
                durationTxt.setText(milliSecondsToTimer(Long.parseLong(duration)));

                try{
                    mediaPlayer.setDataSource(audioUrl);
                    mediaPlayer.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        
        playImageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!mediaPlayer.isPlaying()){
                    mediaPlayer.start();
                    updateTimer();
                    mediaPlayer.setVolume(250,250); //set volume takes two paramater

                    playImageBtn.setImageResource(R.drawable.ic_baseline_pause_circle_outline_24);
                }else{
                    mediaPlayer.pause();
                    playImageBtn.setImageResource(R.drawable.ic_baseline_play_circle_outline_24);
                    handler.removeCallbacks(updater);
                }
            }
        });

        backImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.reset();
                finish();
            }
        });

    }

        private Runnable updater= new Runnable() {
            @Override
            public void run() {
                updateTimer();
                long currentDuration= mediaPlayer.getCurrentPosition();
                timerTxt.setText(milliSecondsToTimer(currentDuration));
            }
        };

    private void updateTimer() {
        handler.postDelayed(updater,1000);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(updater);
        clearMediaPlayer();
    }

    private void clearMediaPlayer(){
        mediaPlayer.reset();
        mediaPlayer.stop();
        mediaPlayer.release();
        mediaPlayer=null;
    }

    private String milliSecondsToTimer(long milliseconds){
        String timerString="";
        String secondsString;

        int hour= (int) (milliseconds/ (1000*60*60));
        int minutes= (int) (milliseconds % (1000*60*60))/ (1000*60);
        int seconds= (int) ((milliseconds % (1000*60*60)) % (1000*60) / 1000);

        if(hour>0){
            timerString=hour+":";
        }

        if(seconds<10){
            secondsString="0"+seconds;
        }else {
            secondsString=""+seconds;
        }

        timerString= timerString+minutes+":"+secondsString;
        return timerString;
    }

}