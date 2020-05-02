package com.example.androidexam;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.androidexam.Adapter.PageAdapter;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class Accomodation_fragment extends Fragment {

    TabLayout tabLayout;
    ViewPager viewPager;
    TabItem life, work, map;
    PageAdapter pageAdapter; // switch between pages


    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_accomodation, container, false);

        tabLayout = view.findViewById(R.id.tablayout);
        viewPager = view.findViewById(R.id.viewPager);
        life = view.findViewById(R.id.tabViewId_life);
        work = view.findViewById(R.id.tabViewId_work);
        map = view.findViewById(R.id.tabViewId_map);

        pageAdapter = new PageAdapter(getFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pageAdapter);

        //setup the tablayout to be cliked on
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                switch (tab.getPosition()){
                    case 0 :
                        pageAdapter.notifyDataSetChanged();
                        break;
                    case 1 :
                        pageAdapter.notifyDataSetChanged();
                        break;
                    case 2 :
                        pageAdapter.notifyDataSetChanged();
                        break;

                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));


        return view;
    }
}
