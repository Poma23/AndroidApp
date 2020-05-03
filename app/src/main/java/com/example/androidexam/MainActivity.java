package com.example.androidexam;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawerLayout;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);   //setting the toolbar in stead of actionbar

        drawerLayout = findViewById(R.id.drawerLayout);
        firebaseAuth = FirebaseAuth.getInstance();

        // to listen to our navigation events we need a reference to nv:
        NavigationView navigationView = findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(this);



        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.navigation_open_drawer, R.string.navigation_close_drawer);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState(); // take care of rotating the hamburger

        if (savedInstanceState == null) {
            // where to start from
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new Home_fragment()).commit();
            navigationView.setCheckedItem(R.id.navbar_home);
        }
    }

    // here we pass the item that has been selected
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {

            case R.id.navbar_accomodation:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new Accomodation_fragment()).commit();
                break;
            case R.id.navbar_home:
                getSupportFragmentManager().beginTransaction()
                      .replace(R.id.fragment_container, new Home_fragment()).commit();
                break;
            case R.id.navbar_login:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new Login_fragment()).commit();
                break;
            case R.id.navbar_bookSearch:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new BookSearch_fragment()).commit();
                break;
          /*  case R.id.navbar_teachinStyle:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new Teachingstyle_fragment()).commit();
                break;*/
            case R.id.navbar_studyOption:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new StudyOption_fragment()).commit();
                break;
            case R.id.navbar_applicationDeadline:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new ApplicationDeadline_fragment()).commit();
                break;
            case R.id.navbar_logOut:
                if(firebaseAuth.getCurrentUser() != null) {
                    firebaseAuth.signOut();
                    finish();
                    Toast.makeText(getApplicationContext(), " Thank you for visiting Study in Denmark", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }else
                {Toast.makeText(getApplicationContext(), " You are not logged in yet", Toast.LENGTH_SHORT).show();}

               // FirebaseAuth.getInstance().signOut();
               // Toast.makeText(getApplicationContext(), "Your are now logged out ", Toast.LENGTH_LONG).show();
                //getSupportFragmentManager().beginTransaction()
                  //      .replace(R.id.fragment_container, new Logout_fragment()).commit();
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {   // if the drawer is open , close it
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
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





