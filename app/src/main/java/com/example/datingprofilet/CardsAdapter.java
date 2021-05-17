package com.example.datingprofilet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

public class CardsAdapter extends RecyclerView.Adapter<CardsAdapter.MyViewHolder> {

    Context context;
    List<MatchesProfiles> matches;

    public CardsAdapter(Context context, List<MatchesProfiles> matches) {
        this.context = context;
        this.matches = matches;
    }

    public CardsAdapter(List<MatchesProfiles> matches) {
        this.matches = matches;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       if (context == null) {
            context = parent.getContext();
        }
        View v = LayoutInflater.from(context).inflate(R.layout.matches_profiles, parent, false);
        MyViewHolder holder = new MyViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        MatchesProfiles match = matches.get(position);
        holder.pic.setImageResource(match.getPic());
        holder.name.setText(match.getName());
        holder.bio.setText(match.getBio());
    }

    @Override
    public int getItemCount() {
        return matches.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        //CardView card;
        TextView name;
        TextView bio;
        ImageView pic;
        ImageButton fav;

        public MyViewHolder(View matches){
            super(matches);
            //card = (CardView) matches;
            pic = matches.findViewById(R.id.m_pic);
            name = matches.findViewById(R.id.m_name);
            bio = matches.findViewById(R.id.m_bio);
            fav = matches.findViewById(R.id.fav);

            fav.setOnClickListener(view -> {
                Toast t = Toast.makeText(view.getContext(), "You've added " + name.getText().toString() + " to you fav list", Toast.LENGTH_LONG);
                t.show();
            });
        }
    }
}
