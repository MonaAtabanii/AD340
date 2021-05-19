package com.example.dateprofile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class ContainerActivity extends AppCompatActivity {
    TabLayout tablayout;
    ViewPager viewpager;
    TabItem profile, matches, settings;
    PageAdapter adapter;
    FragmentManager manager;
    String fullname, useremail, username, userage, userbio, useroccupation;
    Intent intent;
    Bundle b;
    User user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);

        intent = getIntent();
        b = intent.getExtras();

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
        manager = getSupportFragmentManager();
        tablayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewpager.setCurrentItem(tab.getPosition());
                if(tab.getPosition() == 0){
                    Profile profile = (Profile) adapter.getItem(0);
                    profile.setUser(new User(fullname, useremail, username, userage, useroccupation,  userbio));
                    FragmentTransaction trans = manager.beginTransaction();
                    trans.add(R.id.viewpager, profile, "profile");
                    trans.commit();
                    //user = new User(Constants.KEY_FNAME, useremail, username, userage, useroccupation,  userbio);
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
        tablayout.getTabAt(0).setIcon(R.drawable.ic_profile);
        tablayout.getTabAt(1).setIcon(R.drawable.ic_matches);
        tablayout.getTabAt(2).setIcon(R.drawable.ic_settings);
        viewpager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tablayout));
    }

    void sendDataToFragment(View v){
        Profile pro = new Profile();
        user = new User(Constants.KEY_FNAME, useremail, username, userage, useroccupation,  userbio);
        pro.setUser(user);
        FragmentTransaction trans = manager.beginTransaction();
        trans.add(pro, "profile");
        trans.commit();
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
