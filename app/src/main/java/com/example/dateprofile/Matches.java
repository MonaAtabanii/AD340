package com.example.dateprofile;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class Matches extends Fragment {
    View v;
    RecyclerView recycler;
    List<MatchesProfiles> matches;

    public Matches() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_matches, container, false);
        recycler = v.findViewById(R.id.matches_recyclerview);
        GridLayoutManager gridView = new GridLayoutManager(getActivity(), 3, GridLayoutManager.VERTICAL, false);
        recycler.setLayoutManager(gridView);
        createList();
        CardsAdapter card = new CardsAdapter(getContext(), matches);
        recycler.setAdapter(card);
        return v;
    }

    public void onCreate(@NonNull Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    public void createList(){
        matches = new ArrayList<>();
        matches.add(new MatchesProfiles("Matches 1", "25 years old, Seattle", R.drawable.match1));
        matches.add(new MatchesProfiles("Matches 2", "45 years old, Seattle", R.drawable.match2));
        matches.add(new MatchesProfiles("Matches 3", "30 years old, Seattle", R.drawable.match3));
        matches.add(new MatchesProfiles("Matches 4", "29 years old, Seattle", R.drawable.match4));
        matches.add(new MatchesProfiles("Matches 5", "35 years old, Seattle", R.drawable.match5));
        matches.add(new MatchesProfiles("Matches 6", "25 years old, Seattle", R.drawable.match6));
    }

}