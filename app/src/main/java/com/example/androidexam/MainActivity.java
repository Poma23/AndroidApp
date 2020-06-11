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

import com.firebase.ui.auth.AuthUI;
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
                        .replace(R.id.fragment_container, new GoogleBookSearch()).commit();
                break;

            case R.id.navbar_studyOption:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new StudyOption_fragment()).commit();
                break;
            case R.id.navbar_applicationDeadline:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new ApplicationDeadline_fragment()).commit();
                break;
            case R.id.navbar_logOut:
                if (AuthUI.getInstance() != null) {
                    AuthUI.getInstance().signOut(this).addOnCompleteListener(
                            task -> {
                                Toast.makeText(getApplicationContext(), "You are now signed out",
                                        Toast.LENGTH_LONG).show();
                                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                                finish();
                            });
                } else {
                    Toast.makeText(getApplicationContext(), " You are not logged in yet", Toast.LENGTH_SHORT).show();
                }
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
