package com.example.meditari.Features;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.meditari.IntroActivities.HomeActivity;
import com.example.meditari.Mood.moodCalendarAdapter;
import com.example.meditari.Mood.moodCalendarModel;
import com.example.meditari.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class MoodTracker extends AppCompatActivity {

    private static final String TAG="Mood";
    View v;

    TextView date, mtMonth;
    static CardView happy,sad,stressed,angry;
    RecyclerView recyclerView;
    ImageButton mBack;

    SharedPreferences userPref;

    ArrayList<moodCalendarModel> moodCalendarModelArrayList;
    moodCalendarAdapter adapter;

    FirebaseFirestore db;

    static String retrievedMood, selectedMood, retrievedDocId, retrieveUID;
    int extraDays;

    Calendar c= Calendar.getInstance();

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mood_tracker);

        db= FirebaseFirestore.getInstance();

        userPref= getSharedPreferences("Meditari", Context.MODE_PRIVATE);

        retrieveUID= userPref.getString("UID", FirebaseAuth.getInstance().getCurrentUser().getUid());

        int todayDate= Integer.parseInt(new SimpleDateFormat("d").format(c.getTime()));

        getTodayMood(db,c,retrieveUID,todayDate);

        moodCalendarModelArrayList= new ArrayList<>();

        Calendar cal= Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH,1);

        extraDays= blankDays(new SimpleDateFormat("E").format(cal.getTime()));

        for(int i=1; i<=extraDays; i++){
            moodCalendarModelArrayList.add(new moodCalendarModel("","blank"));
        }

        for(int day=1; day<=todayDate; day++){
            moodCalendarModelArrayList.add(new moodCalendarModel(Integer.toString(day),"blank"));
        }

        date= findViewById(R.id.datetxt);
        date.setText(getDateTime());
        mBack=findViewById(R.id.mBack);
        happy=findViewById(R.id.happyCard);
        sad=findViewById(R.id.sadCard);
        stressed=findViewById(R.id.stressedCard);
        angry=findViewById(R.id.angryCard);
        mtMonth=findViewById(R.id.currentMonth);
        mtMonth.setText(new SimpleDateFormat("MMMM YYYY").format(c.getTime()));
        recyclerView= findViewById(R.id.moodCalendarRecycler);

        adapter= new moodCalendarAdapter(MoodTracker.this,moodCalendarModelArrayList);
        recyclerView.setLayoutManager(new GridLayoutManager(MoodTracker.this,7));
        recyclerView.setAdapter(adapter);

        happy.setCardBackgroundColor(Color.parseColor("#C9E4DE"));
        stressed.setCardBackgroundColor(Color.parseColor("#FAEDCB"));
        sad.setCardBackgroundColor(Color.parseColor("#C6DEF1"));
        angry.setCardBackgroundColor(Color.parseColor("#F7DC94"));

        getMoodMonth(db, c, retrieveUID, moodCalendarModelArrayList, adapter, extraDays);

        happy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG,"Happy clicked");
                selectedMood="Happy";

                happy.setCardBackgroundColor(Color.parseColor("#C9E4DE"));
                sad.setCardBackgroundColor(Color.parseColor("#EDEDEB"));
                stressed.setCardBackgroundColor(Color.parseColor("#EDEDEB"));
                angry.setCardBackgroundColor(Color.parseColor("#EDEDEB"));

                if(retrievedDocId==null){
                    writeMood(db, selectedMood, c, retrieveUID);
                }else{
                    replaceMood(db, selectedMood, c, retrieveUID);
                }

                updateMoodTable(moodCalendarModelArrayList,"Happy",extraDays);
                adapter.notifyDataSetChanged();
            }
        });

        sad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG,"Sad clicked");
                selectedMood="Sad";

                happy.setCardBackgroundColor(Color.parseColor("#EDEDEB"));
                sad.setCardBackgroundColor(Color.parseColor("#C6DEF1"));
                stressed.setCardBackgroundColor(Color.parseColor("#EDEDEB"));
                angry.setCardBackgroundColor(Color.parseColor("#EDEDEB"));

                if(retrievedDocId==null){
                    writeMood(db, selectedMood, c, retrieveUID);
                }else{
                    replaceMood(db, selectedMood, c, retrieveUID);
                }

                updateMoodTable(moodCalendarModelArrayList,"Sad",extraDays);
                adapter.notifyDataSetChanged();
            }
        });

        stressed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG,"Stressed clicked");
                selectedMood="Stressed";

                happy.setCardBackgroundColor(Color.parseColor("#EDEDEB"));
                sad.setCardBackgroundColor(Color.parseColor("#EDEDEB"));
                stressed.setCardBackgroundColor(Color.parseColor("#FAEDCB"));
                angry.setCardBackgroundColor(Color.parseColor("#EDEDEB"));

                if(retrievedDocId==null){
                    writeMood(db, selectedMood, c, retrieveUID);
                }else{
                    replaceMood(db, selectedMood, c, retrieveUID);
                }

                updateMoodTable(moodCalendarModelArrayList,"Stressed",extraDays);
                adapter.notifyDataSetChanged();
            }
        });

        angry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG,"Angry clicked");
                selectedMood="Angry";

                happy.setCardBackgroundColor(Color.parseColor("#EDEDEB"));
                sad.setCardBackgroundColor(Color.parseColor("#EDEDEB"));
                stressed.setCardBackgroundColor(Color.parseColor("#EDEDEB"));
                angry.setCardBackgroundColor(Color.parseColor("#F7D9C4"));

                if(retrievedDocId==null){
                    writeMood(db, selectedMood, c, retrieveUID);
                }else{
                    replaceMood(db, selectedMood, c, retrieveUID);
                }

                updateMoodTable(moodCalendarModelArrayList,"Angry",extraDays);
                adapter.notifyDataSetChanged();
            }
        });

        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MoodTracker.this, HomeActivity.class);
                startActivity(intent);
            }
        });

    }

    public int blankDays(String day){
        if(day.equals("Tue")){
            return 1;
        }
        else if(day.equals("Wed")){
            return 2;
        }
        else if(day.equals("Thu")){
            return 3;
        }
        else if(day.equals("Fri")){
            return 4;
        }
        else if(day.equals("Sat")){
            return 5;
        }
        else if(day.equals("Sun")){
            return 6;
        }else{
            return 0;
        }
    }

    public static String getDateTime(){
        Calendar calendar=Calendar.getInstance();
        String currentDate= DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());
        return currentDate;
    }

    private static void getTodayMood(FirebaseFirestore db, Calendar c, String uid, int date){
        if(FirebaseAuth.getInstance().getCurrentUser()!=null){
            db.collection("users").document(uid).collection("mood")
                    .whereEqualTo("filter", new SimpleDateFormat("MMMM YYYY").format(c.getTime()))
                    .whereEqualTo("date",Integer.toString(date))
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if(task.isSuccessful()){
                                for(QueryDocumentSnapshot document: task.getResult()){
                                    Log.d("TAG", document.getId()+"=>"+document.getData());

                                    retrievedDocId= document.getId();

                                    retrievedMood= document.getString("mood");
                                    System.out.println(retrievedMood);

                                    selectedMood=retrievedMood;

                                    if(retrievedMood.equalsIgnoreCase("Happy")){
                                        happy.setCardBackgroundColor(Color.parseColor("#C9E4DE"));
                                    }else if(retrievedMood.equalsIgnoreCase("Sad")){
                                        sad.setCardBackgroundColor(Color.parseColor("#C6DEF1"));
                                    }else if(retrievedMood.equalsIgnoreCase("Stressed")){
                                        sad.setCardBackgroundColor(Color.parseColor("#FAEDCB"));
                                    }else if(retrievedMood.equalsIgnoreCase("Angry")){
                                        sad.setCardBackgroundColor(Color.parseColor("#F7D9C4"));
                                    }else{
                                        //
                                    }
                                }
                            }else{
                                Log.w(TAG,"Error getting documents",task.getException());

                                retrievedDocId=null;
                                retrievedMood=null;
                            }
                        }
                    });
        }
    }

    private static void writeMood(FirebaseFirestore db, String mood, Calendar c, String uid){
        Map<String, Object> moodObj= new HashMap<>();
        moodObj.put("date", new SimpleDateFormat("d").format(c.getTime()));
        moodObj.put("mood",mood);
        moodObj.put("filter",new SimpleDateFormat("MMMM YYYY").format(c.getTime()));
        moodObj.put("timestamp", FieldValue.serverTimestamp());

        db.collection("users").document(uid).collection("mood")
                .add(moodObj)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d(TAG,"DocumentSnapshot added with ID: "+documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG,"Error adding document",e);
                    }
                });
    }

    private static void replaceMood(FirebaseFirestore db, String mood,Calendar c, String uid){
        Map<String, Object> moodObj= new HashMap<>();
        moodObj.put("date", new SimpleDateFormat("d").format(c.getTime()));
        moodObj.put("mood",mood);
        moodObj.put("filter",new SimpleDateFormat("MMMM YYYY").format(c.getTime()));
        moodObj.put("timestamp", FieldValue.serverTimestamp());

        db.collection("users").document(uid).collection("mood").document(retrievedDocId)
                .set(moodObj)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Log.i(TAG,"DocumentSnapshot successfully written");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.i(TAG, "Error writing document",e);
                    }
                });
    }

    private static void getMoodMonth(FirebaseFirestore db, Calendar c, String uid, final ArrayList moodCalendarModelArrayList,
                                     final moodCalendarAdapter adapter, final int extra){

        db.collection("users").document(uid).collection("mood")
                .whereEqualTo("filter",new SimpleDateFormat("MMMM YYYY").format(c.getTime()))
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()){
                            for(QueryDocumentSnapshot document: task.getResult()){
                                Log.d(TAG, document.getId()+"=>"+document.getData());
                                int index= Integer.parseInt(document.getString("date"));
                                moodCalendarModelArrayList.set(index-1+extra, new moodCalendarModel(Integer.toString(index),
                                        document.getString("mood")));
                            }
                            adapter.notifyDataSetChanged();
                        }else{
                            Log.w(TAG,"Error getting documents",task.getException());
                        }
                    }
                });
    }

    public static void updateMoodTable(ArrayList moodCalendarModelArrayList, String mood, int extraDays) {
        if (mood.equalsIgnoreCase("Happy")) {
            moodCalendarModelArrayList.set(moodCalendarModelArrayList.size() - 1,
                    new moodCalendarModel(Integer.toString(moodCalendarModelArrayList.size() - extraDays), "Happy"));
        } else if (mood.equalsIgnoreCase("Sad")) {
            moodCalendarModelArrayList.set(moodCalendarModelArrayList.size() - 1,
                    new moodCalendarModel(Integer.toString(moodCalendarModelArrayList.size() - extraDays), "Sad"));
        } else if (mood.equalsIgnoreCase("Stressed")) {
            moodCalendarModelArrayList.set(moodCalendarModelArrayList.size() - 1,
                    new moodCalendarModel(Integer.toString(moodCalendarModelArrayList.size() - extraDays), "Stressed"));
        } else if (mood.equalsIgnoreCase("Angry")) {
            moodCalendarModelArrayList.set(moodCalendarModelArrayList.size() - 1,
                    new moodCalendarModel(Integer.toString(moodCalendarModelArrayList.size() - extraDays), "Angry"));
        }
    }


}