package com.example.datingprofilew4;

import android.os.Bundle;
import com.google.android.material.tabs.TabLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.widget.FrameLayout;


import androidx.appcompat.app.AppCompatActivity;


public class ContainerActivity extends AppCompatActivity {
    FrameLayout simpleFrameLayout;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        simpleFrameLayout = (FrameLayout) findViewById(R.id.simpleFrameLayout);
        tabLayout = (TabLayout) findViewById(R.id.simpleTabLayout);

        TabLayout.Tab profileTab = tabLayout.newTab();
        profileTab.setText("Profile");
        profileTab.setIcon(R.mipmap.ic_launcher);
        tabLayout.addTab(profileTab);

        TabLayout.Tab matchesTab = tabLayout.newTab();
        matchesTab.setText("Matches");
        matchesTab.setIcon(R.mipmap.ic_launcher);
        tabLayout.addTab(matchesTab);

        TabLayout.Tab settingsTab = tabLayout.newTab();
        settingsTab.setText("Settings");
        settingsTab.setIcon(R.mipmap.ic_launcher);
        tabLayout.addTab(settingsTab);


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Fragment fragment = null;
                switch (tab.getPosition()) {
                    case 0:
                        fragment = new Profile();
                        break;
                    case 1:
                        fragment = new Matches();
                        break;
                    case 2:
                        fragment = new Settings();
                        break;
                }
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.simpleFrameLayout, fragment);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft.commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}


