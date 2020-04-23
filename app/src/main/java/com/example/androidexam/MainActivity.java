package com.example.androidexam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.androidexam.R;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar= findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);   //setting the toolbar in stead of actionbar

        drawerLayout = findViewById(R.id.drawerLayout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,
                R.string.navigation_open_drawer, R.string.navigation_close_drawer);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState(); // take care of rotating the hamburger
    }

    @Override
    public void onBackPressed() {   // if the drawer is open , close it
        if(drawerLayout.isDrawerOpen(GravityCompat.START))
        {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else
        {
            super.onBackPressed();
        }
    }
}

//*********************************************************************************************//








/*        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);




        //reference to the top navigation
        NavigationView topNav= findViewById(R.id.drawer_layout);
        //pass the listener created below to my top navigation
        //Called when an item in the navigation menu is selected
        topNav.setNavigationItemSelectedListener(topNavListener); */


//reference to the bottomNavigation
//   BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
//pass the listener created below to my navigation
//   bottomNav.setOnNavigationItemSelectedListener(navListener);
// }

//*******************************************ButtomNavigation*************************************************/


//react to the clicks on the items
  /*
    BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override

                //get the item selected to switch inbetween
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                    //reference to our fragment
                    Fragment selectedFragment = null;

                    switch (item.getItemId()) {
                        case R.id.nav_home:
                            selectedFragment = new Home_fragment();
                            break;

                        case R.id.nav_mail:
                            selectedFragment = new Email_fragment();
                            break;

                        case R.id.nav_search:
                            selectedFragment = new Search_fragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().
                            replace(R.id.fragment_container, selectedFragment).commit();

                    return true; //because we want to select the item

                }
            };
}


//****************************************TopNavigation****************************************/
/*
    //react to the clicks on the items
    private NavigationView.OnNavigationItemSelectedListener topNavListener =
            new NavigationView.OnNavigationItemSelectedListener() {
                @Override

                //get the item selected to switch inbetween
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                    //reference to our fragment
                    Fragment fragmentTopNav = null;

                    switch (item.getItemId()){
                        case R.id.navbar_login:
                            fragmentTopNav = new Login_fragment();
                            break;

                       /* case R.id.nav_accomodation:
                            fragmentTopNav = new Accomodation_fragment();
                            break;*/
 /*                   }
                   getSupportFragmentManager().beginTransaction().
                            replace(R.id.fragment_container, fragmentTopNav).commit();

                    return true; //because we want to select the item

                }
            };
}
  */





