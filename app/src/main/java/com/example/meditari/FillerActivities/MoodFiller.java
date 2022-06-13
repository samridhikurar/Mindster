package com.example.meditari.FillerActivities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.meditari.IntroActivities.HomeActivity;
import com.example.meditari.Features.MoodTracker;
import com.example.meditari.R;

public class MoodFiller extends AppCompatActivity {

    AppCompatButton yes,no;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mood_filler);

        yes=findViewById(R.id.yesMoodBtn);
        no=findViewById(R.id.noMoodBtn);

        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MoodFiller.this, MoodTracker.class);
                startActivity(intent);
            }
        });

        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MoodFiller.this, HomeActivity.class);
                startActivity(intent);
            }
        });


    }
}