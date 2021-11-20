package com.oa.computerclub.Adapter;

import static com.oa.computerclub.Fragment.HomeFragment.progressBar;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Switch;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.oa.computerclub.Activity.AbbrevationActivity;
import com.oa.computerclub.Activity.GlossaryActivity;
import com.oa.computerclub.Activity.NoteActivity;
import com.oa.computerclub.Activity.QuestionActivity;
import com.oa.computerclub.Activity.ShortcutKeyActivity;
import com.oa.computerclub.Activity.WebviewActivity;
import com.oa.computerclub.Model.HomeModel;
import com.oa.computerclub.R;

public class HomeAdapter extends FirebaseRecyclerAdapter <HomeModel,HomeAdapter.ViewHolder> {
    public HomeAdapter(@NonNull FirebaseRecyclerOptions<HomeModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull HomeModel model) {
        Glide.with(holder.itemView.getContext()).load(model.getImgurl()).into(holder.imageView);
      progressBar.setVisibility(View.GONE);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(holder.getAdapterPosition()){
                    case 0:
                        Intent intent1 = new Intent(holder.imageView.getContext(), NoteActivity.class);
                        holder.itemView.getContext().startActivity(intent1);
                        break;
                    case 1:
                        Intent intent2 = new Intent(holder.imageView.getContext(), QuestionActivity.class);
                        holder.itemView.getContext().startActivity(intent2);
                        break;
                    case 2:
                        Intent intent3 = new Intent(holder.imageView.getContext(), WebviewActivity.class);
                        intent3.putExtra("title",model.getTitle().toString());
                        intent3.putExtra("noteUrl",model.getUrl());
                        holder.itemView.getContext().startActivity(intent3);
                        break;
                    case 3:
                        Intent intent4 = new Intent(holder.imageView.getContext(), ShortcutKeyActivity.class);
                      //  intent4.putExtra("title",model.getTitle().toString());
                       // intent4.putExtra("url",model.getUrl());
                        holder.itemView.getContext().startActivity(intent4);
                        break;
                    case 4:
                        Intent intent5 = new Intent(holder.imageView.getContext(), WebviewActivity.class);
                         intent5.putExtra("title",model.getTitle().toString());
                         intent5.putExtra("noteUrl",model.getUrl());
                        holder.itemView.getContext().startActivity(intent5);
                        break;
                }
            }
        });
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.home_single_item, parent, false);
        return new HomeAdapter.ViewHolder(view);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            imageView = itemView.findViewById(R.id.homeIv);
        }
    }
}
