package com.example.dateprofile;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DatingProfile extends AppCompatActivity {
    TextView fullname, username, useremail, userage, userbio, useroccupation;
    Button back;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        fullname = findViewById(R.id.fullName);
        useremail = findViewById(R.id.userEmail);
        username = findViewById(R.id.userName);
        userage = findViewById(R.id.user_dob);
        useroccupation = findViewById(R.id.userOccupation);
        userbio = findViewById(R.id.userBio);
        back = findViewById(R.id.back);

        Intent intent = getIntent();
        Bundle b = intent.getExtras();

        if (b != null) {
            if (b.containsKey(Constants.KEY_FNAME)) {
                fullname.setText(b.getString(Constants.KEY_FNAME));
            }
            if (b.containsKey(Constants.KEY_UEMAIL)) {
                useremail.setText(b.getString(Constants.KEY_UEMAIL));
            }
            if (b.containsKey(Constants.KEY_UNAME)) {
                username.setText(b.getString(Constants.KEY_UNAME));
            }
            if (b.containsKey(Constants.KEY_UAGE)) {
                userage.setText(b.getString(Constants.KEY_UAGE));
            }
            if (b.containsKey(Constants.KEY_UOCCUPATION)) {
                useroccupation.setText(b.getString(Constants.KEY_UOCCUPATION));
            }
            if (b.containsKey(Constants.KEY_UBIO)) {
                userbio.setText(b.getString(Constants.KEY_UBIO));
            }
        }
    }

    public void onBack(View view) {
        Intent intent = new Intent(DatingProfile.this, MainActivity.class);
        startActivity(intent);
    }

}
