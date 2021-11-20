package com.oa.computerclub.Adapter;



import static com.oa.computerclub.Activity.QuestionActivity.progressBar;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.oa.computerclub.Activity.WebviewActivity;
import com.oa.computerclub.Model.QuestionModel;
import com.oa.computerclub.R;

public class QuestionAdapter extends FirebaseRecyclerAdapter<QuestionModel,QuestionAdapter.ViewHolder> {

    public QuestionAdapter(@NonNull FirebaseRecyclerOptions<QuestionModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull QuestionModel model) {
        Glide.with(holder.imageView.getContext()).load(model.getImgurl()).into(holder.imageView);
      progressBar.setVisibility(View.GONE);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.imageView.getContext(), WebviewActivity.class);
                intent.putExtra("title",model.getTitle().toString());
                intent.putExtra("noteUrl",model.getUrl());
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.home_single_item, parent, false);
        return new QuestionAdapter.ViewHolder(view);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.homeIv);
        }

    }
}
