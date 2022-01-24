package com.example.newapp;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    int tabcount;
    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        tabcount=behavior;
    }
    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0: return new homeFragment();
            case 1: return new SportsFragment();
            case 2: return new ScienceFragment();
            case 3: return new HealthFragment();
            case 4: return new EntertainmentFragment();

        }
        return null;
    }

    @Override
    public int getCount() {
        return tabcount;
    }
}
