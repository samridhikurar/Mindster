package com.example.meditari.Features;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.meditari.Articles.Article;
import com.example.meditari.IntroActivities.HomeActivity;
import com.example.meditari.R;
import com.example.meditari.Extras.RandomQuotes;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

public class MeditateActivity extends AppCompatActivity {


    TextView quote, author;
    String retrievedQuote, retrievedAuthor;
    LinearLayout article1, article2, article3;
    LinearLayout sound1, sound2, sound3;
    ImageButton mBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meditate);

        SharedPreferences homePref= getSharedPreferences("meditari", Context.MODE_PRIVATE);
        String retrievedDate= homePref.getString("Date","");

        if(!retrievedDate.equalsIgnoreCase(getDateTime())){
            randomQuote(homePref);
        }

        retrievedQuote=homePref.getString("Quote","To the mind that is still, the whole universe surrenders");
        retrievedAuthor=homePref.getString("Author","~Lao-Tzu");

        quote=findViewById(R.id.quoteText);
        author=findViewById(R.id.authorText);

        quote.setText(retrievedQuote);
        author.setText(retrievedAuthor);

        article1=findViewById(R.id.article1);
        article2=findViewById(R.id.article2);
        article3=findViewById(R.id.article3);
        sound1=findViewById(R.id.sound1);
        sound2=findViewById(R.id.sound2);
        sound3=findViewById(R.id.sound3);
        mBack=findViewById(R.id.mBack);

        article1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent articleActivity= new Intent(MeditateActivity.this, Article.class);
                articleActivity.putExtra("articleno","article1");
                startActivity(articleActivity);
            }
        });

        article2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent articleActivity= new Intent(MeditateActivity.this, Article.class);
                articleActivity.putExtra("articleno","article2");
                startActivity(articleActivity);
            }
        });

        article3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent articleActivity= new Intent(MeditateActivity.this, Article.class);
                articleActivity.putExtra("articleno","article3");
                startActivity(articleActivity);
            }
        });

        sound1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent soundActivity= new Intent(MeditateActivity.this, SoundsActivity.class);
                soundActivity.putExtra("soundno","sound1");
                startActivity(soundActivity);
            }
        });

        sound2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent soundActivity= new Intent(MeditateActivity.this, SoundsActivity.class);
                soundActivity.putExtra("soundno","sound2");
                startActivity(soundActivity);
            }
        });

        sound3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent soundActivity= new Intent(MeditateActivity.this, SoundsActivity.class);
                soundActivity.putExtra("soundno","sound3");
                startActivity(soundActivity);
            }
        });

        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MeditateActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

    }


    public static String getDateTime(){
        Calendar calendar= Calendar.getInstance();
        String current= DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());
        return current;
    }

    public static void randomQuote(SharedPreferences homePref) {
        ArrayList<RandomQuotes> quoteList= new ArrayList<>();
        quoteList.add(new RandomQuotes("Meditate. Slow down. There's no rush","~Maxime Lagace"));
        quoteList.add(new RandomQuotes("When there is peace and meditation, there is neither anxiety nor doubt","~St. Francis de Sales"));
        quoteList.add(new RandomQuotes("Meditation is not evasion. It is a serene encounter with reality","~Thich Nhat Hanh"));

        Random random= new Random();
        int index= random.nextInt(quoteList.size());
        homePref.edit().putString("Date",getDateTime()).apply();
        homePref.edit().putString("Quote",quoteList.get(index).getQuote()).apply();
        homePref.edit().putString("Author",quoteList.get(index).getAuthor()).apply();
    }
}