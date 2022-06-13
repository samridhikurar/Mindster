package com.example.meditari.Articles;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.meditari.Features.MeditateActivity;
import com.example.meditari.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class Article extends AppCompatActivity {

    FirebaseDatabase db;
    ImageView headerImg;
    ImageButton backBtn;
    TextView title, text;
    String articleno;
    String value;

    private static final String TAG="Article Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);

        backBtn=findViewById(R.id.aBackBtn);
        title=findViewById(R.id.articleTitle);
        text=findViewById(R.id.articleText);
        headerImg=findViewById(R.id.articleImage);

        db=FirebaseDatabase.getInstance();

        Intent intent=getIntent();
        articleno=intent.getStringExtra("articleno");

        if(articleno.equalsIgnoreCase("article1")){
            headerImg.setImageResource(R.drawable.article1);
        }

        if(articleno.equalsIgnoreCase("article2")){
            headerImg.setImageResource(R.drawable.article2);
        }

        if(articleno.equalsIgnoreCase("article3")){
            headerImg.setImageResource(R.drawable.article3);
        }

        DatabaseReference databaseReference= db.getReference().child("articles").child(articleno);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String txt= snapshot.child("text").getValue().toString();
                value=snapshot.child("title").getValue().toString();

                title.setText(value);
                text.setText(txt.replaceAll("/n","\n"));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent articleHome= new Intent(Article.this, MeditateActivity.class);
                startActivity(articleHome);
            }
        });

    }
}
