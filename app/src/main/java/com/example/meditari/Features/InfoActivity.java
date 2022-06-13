package com.example.meditari.Features;

import android.content.Intent;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.meditari.IntroActivities.HomeActivity;
import com.example.meditari.R;

public class InfoActivity extends AppCompatActivity {

    ImageButton arrow, arrow2, arrow3, arrow4,arrow5, arrow6,arrow7,arrow8,arrow9,arrow10,arrow11,arrow12;
    LinearLayout hiddenView, hiddenView2, hiddenView3, hiddenView4,hiddenView5, hiddenView6,hiddenView7, hiddenView8,hiddenView9,hiddenView10,hiddenView11,hiddenView12;
    CardView cardView, cardView2, cardView3, cardView4,cardView5,cardView6,cardView7,cardView8,cardView9,cardView10,cardView11,cardView12;
    ImageView backInfo;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        backInfo=findViewById(R.id.backInfo);
        backInfo.bringToFront();
        textView=findViewById(R.id.textView12);

        cardView = findViewById(R.id.base_cardview);
        arrow = findViewById(R.id.arrow_button);
        hiddenView = findViewById(R.id.hidden_view);
        cardView2=findViewById(R.id.cardView2);
        arrow2=findViewById(R.id.arrowbutton2);
        hiddenView2=findViewById(R.id.hiddenView2);
        arrow3=findViewById(R.id.arrowbutton3);
        hiddenView3=findViewById(R.id.hiddenView3);
        cardView3=findViewById(R.id.cardView3);
        arrow4=findViewById(R.id.arrowbutton4);
        hiddenView4=findViewById(R.id.hiddenView4);
        cardView4=findViewById(R.id.cardView4);
        arrow5=findViewById(R.id.arrowbutton5);
        hiddenView5=findViewById(R.id.hiddenView5);
        cardView5=findViewById(R.id.cardView5);
        arrow6=findViewById(R.id.arrowbutton6);
        hiddenView6=findViewById(R.id.hiddenView6);
        cardView6=findViewById(R.id.cardView6);
        arrow7=findViewById(R.id.arrowbutton7);
        hiddenView7=findViewById(R.id.hiddenView7);
        cardView7=findViewById(R.id.cardView7);
        arrow8=findViewById(R.id.arrowbutton8);
        hiddenView8=findViewById(R.id.hiddenView8);
        cardView8=findViewById(R.id.cardView8);
        arrow9=findViewById(R.id.arrowbutton9);
        hiddenView9=findViewById(R.id.hiddenView9);
        cardView9=findViewById(R.id.cardView9);
        arrow10=findViewById(R.id.arrowbutton10);
        hiddenView10=findViewById(R.id.hiddenView10);
        cardView10=findViewById(R.id.cardView10);
        arrow11=findViewById(R.id.arrowbutton11);
        hiddenView11=findViewById(R.id.hiddenView11);
        cardView11=findViewById(R.id.cardView11);
        arrow12=findViewById(R.id.arrowbutton12);
        hiddenView12=findViewById(R.id.hiddenView12);
        cardView12=findViewById(R.id.cardView12);

        arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // If the CardView is already expanded, set its visibility
                // to gone and change the expand less icon to expand more.
                if (hiddenView.getVisibility() == View.VISIBLE) {

                    // The transition of the hiddenView is carried out
                    // by the TransitionManager class.
                    // Here we use an object of the AutoTransition
                    // Class to create a default transition.
                    TransitionManager.beginDelayedTransition(cardView,
                            new AutoTransition());
                    hiddenView.setVisibility(View.GONE);
                    arrow.setImageResource(R.drawable.plus);
                }

                // If the CardView is not expanded, set its visibility
                // to visible and change the expand more icon to expand less.
                else {

                    TransitionManager.beginDelayedTransition(cardView,
                            new AutoTransition());
                    hiddenView.setVisibility(View.VISIBLE);
                    arrow.setImageResource(R.drawable.minus);
                }
            }
        });

        arrow2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // If the CardView is already expanded, set its visibility
                // to gone and change the expand less icon to expand more.
                if (hiddenView2.getVisibility() == View.VISIBLE) {

                    // The transition of the hiddenView is carried out
                    // by the TransitionManager class.
                    // Here we use an object of the AutoTransition
                    // Class to create a default transition.
                    TransitionManager.beginDelayedTransition(cardView2,
                            new AutoTransition());
                    hiddenView2.setVisibility(View.GONE);
                    arrow2.setImageResource(R.drawable.plus);
                }

                // If the CardView is not expanded, set its visibility
                // to visible and change the expand more icon to expand less.
                else {

                    TransitionManager.beginDelayedTransition(cardView2,
                            new AutoTransition());
                    hiddenView2.setVisibility(View.VISIBLE);
                    arrow2.setImageResource(R.drawable.minus);
                }
            }
        });

        arrow3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // If the CardView is already expanded, set its visibility
                // to gone and change the expand less icon to expand more.
                if (hiddenView3.getVisibility() == View.VISIBLE) {

                    // The transition of the hiddenView is carried out
                    // by the TransitionManager class.
                    // Here we use an object of the AutoTransition
                    // Class to create a default transition.
                    TransitionManager.beginDelayedTransition(cardView3,
                            new AutoTransition());
                    hiddenView3.setVisibility(View.GONE);
                    arrow3.setImageResource(R.drawable.plus);
                }

                // If the CardView is not expanded, set its visibility
                // to visible and change the expand more icon to expand less.
                else {

                    TransitionManager.beginDelayedTransition(cardView3,
                            new AutoTransition());
                    hiddenView3.setVisibility(View.VISIBLE);
                    arrow3.setImageResource(R.drawable.minus);
                }
            }
        });

        arrow4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // If the CardView is already expanded, set its visibility
                // to gone and change the expand less icon to expand more.
                if (hiddenView4.getVisibility() == View.VISIBLE) {

                    // The transition of the hiddenView is carried out
                    // by the TransitionManager class.
                    // Here we use an object of the AutoTransition
                    // Class to create a default transition.
                    TransitionManager.beginDelayedTransition(cardView4,
                            new AutoTransition());
                    hiddenView4.setVisibility(View.GONE);
                    arrow4.setImageResource(R.drawable.plus);
                }

                // If the CardView is not expanded, set its visibility
                // to visible and change the expand more icon to expand less.
                else {

                    TransitionManager.beginDelayedTransition(cardView4,
                            new AutoTransition());
                    hiddenView4.setVisibility(View.VISIBLE);
                    arrow4.setImageResource(R.drawable.minus);
                }
            }
        });

        arrow5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // If the CardView is already expanded, set its visibility
                // to gone and change the expand less icon to expand more.
                if (hiddenView5.getVisibility() == View.VISIBLE) {

                    // The transition of the hiddenView is carried out
                    // by the TransitionManager class.
                    // Here we use an object of the AutoTransition
                    // Class to create a default transition.
                    TransitionManager.beginDelayedTransition(cardView5,
                            new AutoTransition());
                    hiddenView5.setVisibility(View.GONE);
                    arrow5.setImageResource(R.drawable.plus);
                }

                // If the CardView is not expanded, set its visibility
                // to visible and change the expand more icon to expand less.
                else {

                    TransitionManager.beginDelayedTransition(cardView5,
                            new AutoTransition());
                    hiddenView5.setVisibility(View.VISIBLE);
                    arrow5.setImageResource(R.drawable.minus);
                }
            }
        });

        arrow6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // If the CardView is already expanded, set its visibility
                // to gone and change the expand less icon to expand more.
                if (hiddenView6.getVisibility() == View.VISIBLE) {

                    // The transition of the hiddenView is carried out
                    // by the TransitionManager class.
                    // Here we use an object of the AutoTransition
                    // Class to create a default transition.
                    TransitionManager.beginDelayedTransition(cardView6,
                            new AutoTransition());
                    hiddenView6.setVisibility(View.GONE);
                    arrow6.setImageResource(R.drawable.plus);
                }

                // If the CardView is not expanded, set its visibility
                // to visible and change the expand more icon to expand less.
                else {

                    TransitionManager.beginDelayedTransition(cardView6,
                            new AutoTransition());
                    hiddenView6.setVisibility(View.VISIBLE);
                    arrow6.setImageResource(R.drawable.minus);
                }
            }
        });

        arrow7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // If the CardView is already expanded, set its visibility
                // to gone and change the expand less icon to expand more.
                if (hiddenView7.getVisibility() == View.VISIBLE) {

                    // The transition of the hiddenView is carried out
                    // by the TransitionManager class.
                    // Here we use an object of the AutoTransition
                    // Class to create a default transition.
                    TransitionManager.beginDelayedTransition(cardView7,
                            new AutoTransition());
                    hiddenView7.setVisibility(View.GONE);
                    arrow7.setImageResource(R.drawable.plus);
                }

                // If the CardView is not expanded, set its visibility
                // to visible and change the expand more icon to expand less.
                else {

                    TransitionManager.beginDelayedTransition(cardView7,
                            new AutoTransition());
                    hiddenView7.setVisibility(View.VISIBLE);
                    arrow7.setImageResource(R.drawable.minus);
                }
            }
        });

        arrow8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // If the CardView is already expanded, set its visibility
                // to gone and change the expand less icon to expand more.
                if (hiddenView8.getVisibility() == View.VISIBLE) {

                    // The transition of the hiddenView is carried out
                    // by the TransitionManager class.
                    // Here we use an object of the AutoTransition
                    // Class to create a default transition.
                    TransitionManager.beginDelayedTransition(cardView8,
                            new AutoTransition());
                    hiddenView8.setVisibility(View.GONE);
                    arrow8.setImageResource(R.drawable.plus);
                }

                // If the CardView is not expanded, set its visibility
                // to visible and change the expand more icon to expand less.
                else {

                    TransitionManager.beginDelayedTransition(cardView8,
                            new AutoTransition());
                    hiddenView8.setVisibility(View.VISIBLE);
                    arrow8.setImageResource(R.drawable.minus);
                }
            }
        });

        arrow9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // If the CardView is already expanded, set its visibility
                // to gone and change the expand less icon to expand more.
                if (hiddenView9.getVisibility() == View.VISIBLE) {

                    // The transition of the hiddenView is carried out
                    // by the TransitionManager class.
                    // Here we use an object of the AutoTransition
                    // Class to create a default transition.
                    TransitionManager.beginDelayedTransition(cardView9,
                            new AutoTransition());
                    hiddenView9.setVisibility(View.GONE);
                    arrow9.setImageResource(R.drawable.plus);
                }

                // If the CardView is not expanded, set its visibility
                // to visible and change the expand more icon to expand less.
                else {

                    TransitionManager.beginDelayedTransition(cardView9,
                            new AutoTransition());
                    hiddenView9.setVisibility(View.VISIBLE);
                    arrow9.setImageResource(R.drawable.minus);
                }
            }
        });

        arrow10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // If the CardView is already expanded, set its visibility
                // to gone and change the expand less icon to expand more.
                if (hiddenView10.getVisibility() == View.VISIBLE) {

                    // The transition of the hiddenView is carried out
                    // by the TransitionManager class.
                    // Here we use an object of the AutoTransition
                    // Class to create a default transition.
                    TransitionManager.beginDelayedTransition(cardView10,
                            new AutoTransition());
                    hiddenView10.setVisibility(View.GONE);
                    arrow10.setImageResource(R.drawable.plus);
                }

                // If the CardView is not expanded, set its visibility
                // to visible and change the expand more icon to expand less.
                else {

                    TransitionManager.beginDelayedTransition(cardView10,
                            new AutoTransition());
                    hiddenView10.setVisibility(View.VISIBLE);
                    arrow10.setImageResource(R.drawable.minus);
                }
            }
        });

        arrow11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // If the CardView is already expanded, set its visibility
                // to gone and change the expand less icon to expand more.
                if (hiddenView11.getVisibility() == View.VISIBLE) {

                    // The transition of the hiddenView is carried out
                    // by the TransitionManager class.
                    // Here we use an object of the AutoTransition
                    // Class to create a default transition.
                    TransitionManager.beginDelayedTransition(cardView11,
                            new AutoTransition());
                    hiddenView11.setVisibility(View.GONE);
                    arrow11.setImageResource(R.drawable.plus);
                }

                // If the CardView is not expanded, set its visibility
                // to visible and change the expand more icon to expand less.
                else {

                    TransitionManager.beginDelayedTransition(cardView11,
                            new AutoTransition());
                    hiddenView11.setVisibility(View.VISIBLE);
                    arrow11.setImageResource(R.drawable.minus);
                }
            }
        });

        arrow12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // If the CardView is already expanded, set its visibility
                // to gone and change the expand less icon to expand more.
                if (hiddenView12.getVisibility() == View.VISIBLE) {

                    // The transition of the hiddenView is carried out
                    // by the TransitionManager class.
                    // Here we use an object of the AutoTransition
                    // Class to create a default transition.
                    TransitionManager.beginDelayedTransition(cardView12,
                            new AutoTransition());
                    hiddenView12.setVisibility(View.GONE);
                    arrow12.setImageResource(R.drawable.plus);
                }

                // If the CardView is not expanded, set its visibility
                // to visible and change the expand more icon to expand less.
                else {

                    TransitionManager.beginDelayedTransition(cardView12,
                            new AutoTransition());
                    textView.setText("The National Institute of Mental Health and Neuro-Sciences (NIMHANS) has launched a toll-free number 080-46110007 to provide necessary mental health support.\nYou can also reach out to this website: https://www.thelivelovelaughfoundation.org"+ " for more details.");
                    hiddenView12.setVisibility(View.VISIBLE);
                    arrow12.setImageResource(R.drawable.minus);
                }
            }
        });

        backInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(InfoActivity.this, HomeActivity.class));
            }
        });

    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(InfoActivity.this, HomeActivity.class));
    }
}
