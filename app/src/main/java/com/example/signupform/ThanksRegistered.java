package com.example.signupform;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class ThanksRegistered extends AppCompatActivity {

    TextView thanksMessage;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thanks_registered);

        thanksMessage = findViewById(R.id.thanks);
        StringBuilder result = new StringBuilder(Constants.RESULT);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String username = " ";
        if (bundle.containsKey((Constants.KEY_NAME))) {
            username = bundle.getString(Constants.KEY_NAME);
        }

        result.append(username);
        thanksMessage.setText(result);
    }

    public void goBack(View back) {
        startActivity(new Intent(this, MainActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
    }


}