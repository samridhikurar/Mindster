package com.example.meditari.FillerActivities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.meditari.IntroActivities.HomeActivity;
import com.example.meditari.R;
import com.example.meditari.Features.VoiceActivity;

public class VoiceFiller extends AppCompatActivity {

    AppCompatButton yes, no;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voice_filler);

        yes=findViewById(R.id.yesVoiceBtn);
        no=findViewById(R.id.noVoiceBtn);

        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(VoiceFiller.this, VoiceActivity.class);
                startActivity(intent);
            }
        });

        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(VoiceFiller.this, HomeActivity.class);
                startActivity(intent);
            }
        });

    }
}