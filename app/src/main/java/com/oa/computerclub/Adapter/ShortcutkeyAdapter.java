package com.oa.computerclub.Adapter;

import static com.oa.computerclub.Activity.ShortcutKeyActivity.progressBar;

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
import com.oa.computerclub.Model.ShortcutkeyModel;
import com.oa.computerclub.R;

public class ShortcutkeyAdapter extends FirebaseRecyclerAdapter<ShortcutkeyModel,ShortcutkeyAdapter.ViewHolder > {

    public ShortcutkeyAdapter(@NonNull FirebaseRecyclerOptions<ShortcutkeyModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull ShortcutkeyModel model) {
        Glide.with(holder.imageview.getContext()).load(model.getImgurl()).into(holder.imageview);
        progressBar.setVisibility(View.GONE);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.imageview.getContext(), WebviewActivity.class);
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
        return new ShortcutkeyAdapter.ViewHolder(view);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageview;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageview = itemView.findViewById(R.id.homeIv);
        }
    }
}
