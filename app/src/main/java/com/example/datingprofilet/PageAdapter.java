package com.example.datingprofilet;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PageAdapter extends FragmentPagerAdapter {

    int n;
    public PageAdapter(@NonNull FragmentManager fm, int n) {
        super(fm);
        this.n = n;
    }

    /**
     * Return the Fragment associated with a specified position.
     *
     * @param position
     */
    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0:
                Profile profile = new Profile();
                return profile;
            case 1:
                return new Matches();
            case 2:
                return new Settings();
            default:
                return null;
        }
    }

    /**
     * Return the number of views available.
     */
    @Override
    public int getCount() {
        return n;
    }

    @Override
    public int getItemPosition(@NonNull Object obj) {
        return POSITION_NONE;
    }
}

