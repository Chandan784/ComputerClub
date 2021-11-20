package com.oa.computerclub.Activity;

import androidx.appcompat.app.ActionBar;
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
import com.oa.computerclub.Model.NoteModel;
import com.oa.computerclub.R;

public class NoteActivity extends AppCompatActivity {
RecyclerView noteRv;
public static ProgressBar progressBar;
private NoteAdapter adapter;
private AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
        noteRv = findViewById(R.id.noteRv);

        progressBar = findViewById(R.id.progressbar);
        noteRv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));
        FirebaseRecyclerOptions<NoteModel> options =
                new FirebaseRecyclerOptions.Builder<NoteModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("note"), NoteModel.class)
                        .build();
        adapter = new NoteAdapter(options);
        noteRv.setAdapter(adapter);
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