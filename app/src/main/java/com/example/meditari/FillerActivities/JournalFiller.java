package com.example.meditari.FillerActivities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.meditari.IntroActivities.HomeActivity;
import com.example.meditari.Features.NoteActivity;
import com.example.meditari.R;

public class JournalFiller extends AppCompatActivity {

    AppCompatButton yes,no;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_journal_filler);

        yes=findViewById(R.id.yesDiaryBtn);
        no=findViewById(R.id.noDiaryBtn);

        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(JournalFiller.this, NoteActivity.class);
                startActivity(intent);
            }
        });

        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(JournalFiller.this, HomeActivity.class);
                startActivity(intent);
            }
        });


    }
}