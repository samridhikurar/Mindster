package com.example.meditari.FillerActivities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.meditari.IntroActivities.HomeActivity;
import com.example.meditari.Features.MeditateActivity;
import com.example.meditari.R;

public class MeditationFiller extends AppCompatActivity {

    AppCompatButton yes, no;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meditation_filler);

        yes=findViewById(R.id.yesMediBtn);
        no=findViewById(R.id.noMediBtn);

        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MeditationFiller.this, MeditateActivity.class);
                startActivity(intent);
            }
        });

        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MeditationFiller.this, HomeActivity.class);
                startActivity(intent);
            }
        });

    }
}