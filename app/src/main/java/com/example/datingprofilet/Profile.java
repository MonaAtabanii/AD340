package com.example.datingprofilet;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class Profile extends Fragment {


    public Profile() {
        // Required empty public constructor
    }

    TextView fullname, username, useremail, userage, userbio, useroccupation;
    String   fname, uname, uemail, uage, ubio, uoccupation;

    Button back;
    private ContainerActivity.User user;

    @Nullable
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public void onBack(View view) {
        startActivity(new Intent(getActivity(), MainActivity.class));
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_profile, container, false);
        fullname = view.findViewById(R.id.fullName);
        useremail = view.findViewById(R.id.userEmail);
        username = view.findViewById(R.id.userName);
        userage = view.findViewById(R.id.user_dob);
        useroccupation = view.findViewById(R.id.userOccupation);
        userbio = view.findViewById(R.id.userBio);

        Bundle b = getArguments();

        if (b == null) {
            b = savedInstanceState;
        }
        if (b != null) {
            if (b.containsKey(Constants.KEY_FNAME)) {
                fname = (b.getString(Constants.KEY_FNAME));
            }
            if (b.containsKey(Constants.KEY_UEMAIL)) {
                uemail = (b.getString(Constants.KEY_UEMAIL));
            }
            if (b.containsKey(Constants.KEY_UNAME)) {
                uname = (b.getString(Constants.KEY_UNAME));
            }
            if (b.containsKey(Constants.KEY_UAGE)) {
                uage = (b.getString(Constants.KEY_UAGE));
            }
            if (b.containsKey(Constants.KEY_UOCCUPATION)) {
                useroccupation.setText(b.getString(Constants.KEY_UOCCUPATION));
            }
            if (b.containsKey(Constants.KEY_UBIO)) {
                ubio = (b.getString(Constants.KEY_UBIO));
            }
            this.user = new ContainerActivity.User(fname, uemail, uname, uage, ubio, uoccupation);
        }

        if (savedInstanceState != null
                && savedInstanceState.containsKey(Constants.KEY_FNAME)
                && savedInstanceState.containsKey(Constants.KEY_UEMAIL)
                && savedInstanceState.containsKey(Constants.KEY_UNAME)
                && savedInstanceState.containsKey(Constants.KEY_UAGE)
                && savedInstanceState.containsKey(Constants.KEY_UOCCUPATION)
                && savedInstanceState.containsKey(Constants.KEY_UBIO)) {
            fullname.setText(savedInstanceState.getString(Constants.KEY_FNAME));
            useremail.setText(savedInstanceState.getString(Constants.KEY_UEMAIL));
            username.setText(savedInstanceState.getString(Constants.KEY_UNAME));
            userage.setText(savedInstanceState.getString(Constants.KEY_UAGE));
            useroccupation.setText(savedInstanceState.getString(Constants.KEY_UOCCUPATION));
            userbio.setText(savedInstanceState.getString(Constants.KEY_UBIO));
        }

        back = view.findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(getActivity(), MainActivity.class));
            }
        });
        return view;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(Constants.KEY_FNAME, fullname.getText().toString());
        outState.putString(Constants.KEY_UEMAIL, useremail.getText().toString());
        outState.putString(Constants.KEY_UNAME, username.getText().toString());
        outState.putString(Constants.KEY_UAGE, userage.getText().toString());
        outState.putString(Constants.KEY_UOCCUPATION, useroccupation.getText().toString());
        outState.putString(Constants.KEY_UBIO, userbio.getText().toString());

    }

    void setUser(ContainerActivity.User user){
        this.user = user;
    }

}
