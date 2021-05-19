package com.example.dateprofile;

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
    ContainerActivity.User user;

    @Nullable
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*if (savedInstanceState != null) {
            if (savedInstanceState.containsKey(Constants.KEY_FNAME)) {
                fname = (savedInstanceState.getString(Constants.KEY_FNAME));
            }
            if (savedInstanceState.containsKey(Constants.KEY_UEMAIL)) {
                uemail = (savedInstanceState.getString(Constants.KEY_UEMAIL));
            }
            if (savedInstanceState.containsKey(Constants.KEY_UNAME)) {
                uname = (savedInstanceState.getString(Constants.KEY_UNAME));
            }
            if (savedInstanceState.containsKey(Constants.KEY_UAGE)) {
                uage = (savedInstanceState.getString(Constants.KEY_UAGE));
            }
            if (savedInstanceState.containsKey(Constants.KEY_UOCCUPATION)) {
                uoccupation = (savedInstanceState.getString(Constants.KEY_UOCCUPATION));
            }
            if (savedInstanceState.containsKey(Constants.KEY_UBIO)) {
                ubio = (savedInstanceState.getString(Constants.KEY_UBIO));
            }
            ContainerActivity.User user = new ContainerActivity.User(fname, uemail, uname, uage, uoccupation, ubio);
            this.setUser(user);
        }*/

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
                && savedInstanceState.containsKey(Constants.KEY_UBIO) ) {
            fullname.setText(savedInstanceState.getString(Constants.KEY_FNAME));
            useremail.setText(savedInstanceState.getString(Constants.KEY_UEMAIL));
            username.setText(savedInstanceState.getString(Constants.KEY_UNAME));
            userage.setText(savedInstanceState.getString(Constants.KEY_UAGE));
            useroccupation.setText(savedInstanceState.getString(Constants.KEY_UOCCUPATION));
            userbio.setText(savedInstanceState.getString(Constants.KEY_UBIO));
        }

        /*fullname.setText(this.user.fullname);
        useremail.setText(this.user.useremail);
        username.setText(this.user.username);
        userage.setText(this.user.userage);
        useroccupation.setText(this.user.useroccupation);
        userbio.setText(this.user.userbio);*/

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
        outState.putString(Constants.KEY_FNAME, user.fullname);
        outState.putString(Constants.KEY_UEMAIL, user.useremail);
        //outState.putString(Constants.KEY_UEMAIL, useremail.getText().toString());
        outState.putString(Constants.KEY_UNAME, user.username);
        outState.putString(Constants.KEY_UAGE, user.userage);
        outState.putString(Constants.KEY_UOCCUPATION, user.useroccupation);
        outState.putString(Constants.KEY_UBIO, user.userbio);

        /*outState.putString(Constants.KEY_FNAME, uname);
        outState.putString(Constants.KEY_UEMAIL, uemail);
        outState.putString(Constants.KEY_UNAME, uname);
        outState.putString(Constants.KEY_UAGE, uage);
        outState.putString(Constants.KEY_UOCCUPATION, uoccupation);
        outState.putString(Constants.KEY_UBIO, ubio);*/

    }

    void setUser(ContainerActivity.User user){
        this.user = user;
    }

}
