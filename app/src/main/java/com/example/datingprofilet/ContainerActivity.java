package com.example.datingprofilet;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class ContainerActivity extends AppCompatActivity {
    TabLayout tablayout;
    ViewPager viewpager;
    TabItem profile, matches, settings;
    PageAdapter adapter;
    String fullname, username, useremail, userage, userbio, useroccupation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);

        Intent intent = getIntent();
        Bundle b = intent.getExtras();

        if (b != null) {
            if (b.containsKey(Constants.KEY_FNAME)) {
                fullname = (b.getString(Constants.KEY_FNAME));
            }
            if (b.containsKey(Constants.KEY_UEMAIL)) {
                useremail = (b.getString(Constants.KEY_UEMAIL));
            }
            if (b.containsKey(Constants.KEY_UNAME)) {
                username = (b.getString(Constants.KEY_UNAME));
            }
            if (b.containsKey(Constants.KEY_UAGE)) {
                userage = (b.getString(Constants.KEY_UAGE));
            }
            if (b.containsKey(Constants.KEY_UOCCUPATION)) {
                useroccupation = (b.getString(Constants.KEY_UOCCUPATION));
            }
            if (b.containsKey(Constants.KEY_UBIO)) {
                userbio = (b.getString(Constants.KEY_UBIO));
            }
        }

        tablayout   = (TabLayout) findViewById(R.id.tablayuot);
        profile     = (TabItem) findViewById(R.id.profileTab);
        matches     = (TabItem) findViewById(R.id.matchesTab);
        settings    = (TabItem) findViewById(R.id.settingsTab);
        viewpager   = findViewById(R.id.viewpager);
        adapter     = new PageAdapter(getSupportFragmentManager(), tablayout.getTabCount());
        viewpager.setAdapter(adapter);
        tablayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewpager.setCurrentItem(tab.getPosition());
                if(tab.getPosition() == 0){
                    User user = new User(Constants.KEY_FNAME, useremail, username, userage, useroccupation,  userbio);
                    adapter.notifyDataSetChanged();
                }
                else if(tab.getPosition() == 1){
                    adapter.notifyDataSetChanged();
                }
                else if(tab.getPosition() == 2){
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewpager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tablayout));
    }

    public static class User {
        String fullname;
        String useremail;
        String username;
        String userage;
        String userbio;
        String useroccupation;

        User(String fullname, String useremail, String username,
             String userage, String useroccupation, String userbio) {
            this.fullname = fullname;
            this.useremail = useremail;
            this.username = username;
            this.userage = userage;
            this.useroccupation = useroccupation;
            this.userbio = userbio;
        }
    }
}
