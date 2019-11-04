package com.example.ola;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        NavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);


        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new BookRideFrag()).commit();
        navigationView.setCheckedItem(R.id.navbar_book_ride);


        drawerLayout = findViewById(R.id.nav_drawer_layout);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,
                toolbar, R.string.nav_drawer_open,R.string.nav_drawer_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }

    @Override
    public void onBackPressed() {

        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId())
        {
            case R.id.navbar_book_ride:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new BookRideFrag()).commit();
                break;
        }
        switch (menuItem.getItemId())
        {
            case R.id.navbar_your_ride:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new YourRideFrag()).commit();
                break;
        }
        switch (menuItem.getItemId())
        {
            case R.id.navbar_rate_card:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new RateCardFrag()).commit();
                break;
        }
        switch (menuItem.getItemId())
        {
            case R.id.navbar_payment:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new PaymentFrag()).commit();
                break;
        }
        switch (menuItem.getItemId())
        {
            case R.id.navbar_refer_earn:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new ReferFrag()).commit();
                break;
        }
        switch (menuItem.getItemId())
        {
            case R.id.navbar_support:
                Intent intent = new Intent(this,Support.class);
                startActivity(intent);

                break;
        }
        switch (menuItem.getItemId())
        {
            case R.id.navbar_about:

                Intent intent = new Intent(this,About.class);
                startActivity(intent);

                break;
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
