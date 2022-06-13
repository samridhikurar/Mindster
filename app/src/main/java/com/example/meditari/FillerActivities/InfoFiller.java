package com.example.meditari.FillerActivities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.meditari.Features.InfoActivity;
import com.example.meditari.IntroActivities.HomeActivity;
import com.example.meditari.R;

public class InfoFiller extends AppCompatActivity {

    AppCompatButton yes, no;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_filler);

        yes=findViewById(R.id.yesInfoBtn);
        no=findViewById(R.id.noInfoBtn);

        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(InfoFiller.this, InfoActivity.class);
                startActivity(intent);
            }
        });

        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(InfoFiller.this, HomeActivity.class);
                startActivity(intent);
            }
        });
    }
}