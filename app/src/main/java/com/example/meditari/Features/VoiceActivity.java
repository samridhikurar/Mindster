package com.example.meditari.Features;

import android.os.Bundle;

import com.alan.alansdk.AlanCallback;
import com.alan.alansdk.AlanConfig;
import com.alan.alansdk.AlanService;
import com.alan.alansdk.button.AlanButton;
import com.alan.alansdk.prefs.AlanPrefs;
import com.example.meditari.R;

import androidx.appcompat.app.AppCompatActivity;


public class VoiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voice);

        AlanButton alanButton = findViewById(R.id.alan_button);

        AlanConfig alanConfig = AlanConfig.builder()
                .setProjectId("Your key here")
                .build();
        alanButton.initWithConfig(alanConfig);
    }
}
