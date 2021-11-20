package com.oa.computerclub.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ProgressBar;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.firebase.database.FirebaseDatabase;
import com.oa.computerclub.Adapter.NoteAdapter;
import com.oa.computerclub.Adapter.QuestionAdapter;
import com.oa.computerclub.Model.NoteModel;
import com.oa.computerclub.Model.QuestionModel;
import com.oa.computerclub.R;

public class QuestionActivity extends AppCompatActivity {
 public  static  ProgressBar progressBar;
 RecyclerView questionrRv;
private QuestionAdapter adapter;
private AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        progressBar = findViewById(R.id.progressbar);
        questionrRv = findViewById(R.id.questionRv);
        questionrRv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));
        FirebaseRecyclerOptions<QuestionModel> options =
                new FirebaseRecyclerOptions.Builder<QuestionModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("question"), QuestionModel.class)
                        .build();
        adapter = new QuestionAdapter(options);
        questionrRv.setAdapter(adapter);
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


    }
    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }
}