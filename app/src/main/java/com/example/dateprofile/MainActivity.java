package com.example.dateprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    EditText fullname, username, useremail, userbio, useroccupation;
    String userbofd;
    //ImageView userimage;
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
        userbio = findViewById(R.id.userbio);
        useroccupation = findViewById(R.id.useroccupation);
        //userimage = findViewById(R.id.userimage);
        register = findViewById(R.id.register);

        dofb = findViewById(R.id.birthDate);
        dofb.setMaxDate(new Date().getTime());

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dataValidation() ){
                    Intent intent = new Intent(MainActivity.this, DatingProfile.class);
                    Bundle b = new Bundle();
                    b.putString(Constants.KEY_FNAME, fullname.getText().toString());
                    b.putString(Constants.KEY_UNAME, username.getText().toString());
                    b.putString(Constants.KEY_UAGE, userbofd);
                    b.putString(Constants.KEY_UBIO, userbio.getText().toString());
                    b.putString(Constants.KEY_UEMAIL, useremail.getText().toString());
                    b.putString(Constants.KEY_UOCCUPATION, useroccupation.getText().toString());
                    intent.putExtras(b);
                    startActivity(intent);
                }
            }
        });
    }

    /*public void onRegister(View view) {
        fullname = findViewById(R.id.fullname);
        username = findViewById(R.id.username);
        useremail = findViewById(R.id.useremail);
        userbio = findViewById(R.id.userbio);
        useroccupation = findViewById(R.id.useroccupation);
        if (dataValidation() ){
            Intent intent = new Intent(MainActivity.this, DatingProfile.class);
            Bundle b = new Bundle();
            b.putString(Constants.KEY_FNAME, fullname.getText().toString());
            b.putString(Constants.KEY_UNAME, username.getText().toString());
            b.putString(Constants.KEY_UBIO, userbio.getText().toString());
            b.putString(Constants.KEY_UEMAIL, useremail.getText().toString());
            b.putString(Constants.KEY_UOCCUPATION, useroccupation.getText().toString());
            intent.putExtras(b);
            startActivity(intent);
        }
    }*/

    boolean validEmail(String text) {
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
        LocalDate dob = LocalDate.of(year, month, day);
        LocalDate today = LocalDate.now();
        Period age = Period.between(dob, today);
        userbofd = age.getYears() + " years old";
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
        if (isEmpty(userbio)){
            check = false;
            Toast t = Toast.makeText(this, "Enter user bio", Toast.LENGTH_SHORT);
            userbio.setError("BIO is required");
            t.show();
        }
        if (isEmpty(useroccupation)){
            check = false;
            Toast t = Toast.makeText(this, "Enter user occupation", Toast.LENGTH_SHORT);
            useroccupation.setError("Occupation is required");
            t.show();
        }
        else if (!validDOB(dofb)) {
            check = false;
            Toast t = Toast.makeText(this, "18 years old or older", Toast.LENGTH_SHORT);
            t.show();
        }
        return check;
    }



}