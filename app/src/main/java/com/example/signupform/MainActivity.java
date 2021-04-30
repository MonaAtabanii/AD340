package com.example.signupform;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.PersistableBundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.content.Intent;


import android.os.Bundle;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    static TextView user;

    private TextView thanksMessage, user_dob;

    CalendarView birthDate;

    EditText fullname, username, useremail;
    Button register;
    DatePicker dofb;
    Calendar calendar = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fullname = findViewById(R.id.fullname);
        username = findViewById(R.id.username);
        useremail = findViewById(R.id.useremail);
        register = findViewById(R.id.register);

        dofb = findViewById(R.id.birthDate);
        dofb.setMaxDate(new Date().getTime());

        thanksMessage = findViewById(R.id.thanks);

        register.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View register) {
                if (dataValidation()) {
                    Intent intent = new Intent(MainActivity.this, ThanksRegistered.class);
                    Bundle bundle = new Bundle();
                    user = findViewById(R.id.username);
                    String result = "Thanks for Signing Up, ";
                    bundle.putString(Constants.RESULT, result);
                    bundle.putString(Constants.KEY_NAME, user.getText().toString());
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            }
        });
    }


    static boolean validEmail(String text) {
        CharSequence email = text;
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }

    boolean isEmpty(EditText text) {
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }

    boolean validDOB(DatePicker dofb){
        int year = dofb.getYear();
        int month = dofb.getMonth() + 1;
        int day = dofb.getDayOfMonth();
        return ((year<=2003) && (month<= calendar.get(Calendar.MONTH + 1)) && (day <= calendar.get(Calendar.DAY_OF_MONTH)));
    }

    boolean dataValidation() {
        boolean check = true;
        if (isEmpty(fullname)){
            check = false;
            Toast t = Toast.makeText(this, "Enter full name", Toast.LENGTH_SHORT);
            fullname.setError("Full name is required");
            t.show();
        }
        else if (validEmail(useremail.getText().toString()) == false) {
            check = false;
            Toast t = Toast.makeText(this, "Enter user email", Toast.LENGTH_SHORT);
            useremail.setError("Enter valid email!");
            t.show();
        }
        else if (isEmpty(username)) {
            check = false;
            Toast t = Toast.makeText(this, "Enter user name", Toast.LENGTH_SHORT);
            username.setError("User name is required");
            t.show();
        }
        else if (!validDOB(dofb)) {
            check = false;
            Toast t = Toast.makeText(this, "18 years old or older", Toast.LENGTH_SHORT);
            //user_dob.setError("Age should be at least 18 years old");
            t.show();
        }
        return check;
    }


    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);

        outState.putString(Constants.KEY_TEXTVIEW_TEXT, thanksMessage.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        if(savedInstanceState.containsKey(Constants.KEY_TEXTVIEW_TEXT)) {
            thanksMessage.setText(savedInstanceState.getString(Constants.KEY_TEXTVIEW_TEXT));
        }
    }


     /*@Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy()");
    }

   public void onRegister(View view) {

        Intent intent = new Intent(MainActivity.this, ThanksRegistered.class);
        Bundle bundle = new Bundle();
        TextView user = findViewById(R.id.username);
        bundle.putString(Constants.KEY_NAME, user.getText().toString());
        intent.putExtras(bundle);
        startActivity(intent);
    }*/
}