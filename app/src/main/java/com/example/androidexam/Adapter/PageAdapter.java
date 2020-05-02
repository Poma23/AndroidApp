package com.example.androidexam.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.androidexam.Accomodation_tab1;
import com.example.androidexam.Accomodation_tab2;
import com.example.androidexam.Accomodation_tab3;

public class PageAdapter extends FragmentPagerAdapter {
    int numberOfTabs;


    public PageAdapter(@NonNull FragmentManager fm, int numberOfTabs) {
        super(fm);
        this.numberOfTabs = numberOfTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new Accomodation_tab1();
            case 1:
                return  new Accomodation_tab2();
            case 2:
                return new Accomodation_tab3();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numberOfTabs;
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        return POSITION_NONE;
    }
}
