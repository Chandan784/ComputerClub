package com.oa.computerclub.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ProgressBar;


import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.oa.computerclub.Adapter.HomeAdapter;
import com.oa.computerclub.Model.HomeModel;
import com.oa.computerclub.R;


import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    ImageSlider imageSlider;
    RecyclerView homeRv;
    private HomeAdapter adapter;
    private HomeModel homeModel;
public static ProgressBar progressBar;
    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        imageSlider = view.findViewById(R.id.image_slider);
        homeRv = view.findViewById(R.id.homeRv);
        progressBar = view.findViewById(R.id.progressbar);
        homeRv.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        final List<SlideModel> imageslide = new ArrayList<>();
        FirebaseDatabase.getInstance().getReference().child("slider").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot shot : snapshot.getChildren()) {

                    imageslide.add(new SlideModel(shot.child("imgurl").getValue().toString(), shot.child("title").getValue().toString(), ScaleTypes.FIT));
                    imageSlider.setImageList(imageslide);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        FirebaseRecyclerOptions<HomeModel> options =
                new FirebaseRecyclerOptions.Builder<HomeModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("homeitem"), HomeModel.class)
                        .build();

        adapter = new HomeAdapter(options);
        homeRv.setAdapter(adapter);




      return view;
}


    @Override
    public void onStart() {
        super.onStart();
        adapter.startListening();
    }

}