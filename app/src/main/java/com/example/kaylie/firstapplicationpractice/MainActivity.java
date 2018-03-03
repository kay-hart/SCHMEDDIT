package com.example.kaylie.firstapplicationpractice;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.util.Log;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    private ActionBar navBar;
    boolean menuShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);

        NavigationView navVeiw = findViewById(R.id.nav_view);
        navVeiw.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        item.setChecked(true);
                        mDrawerLayout.closeDrawers();

                        switch (item.getItemId()) {
                            case R.id.profile:
                                Log.d("Navmenu", "profile pressed");
                                break;
                            case R.id.lists:
                                //setContentView(R.layout.activity_list_tabs);
                                Log.d("Navmenu", "lists pressed");
                                break;
                            case R.id.leaderboard:
                                Log.d("Navmenu", "leaderboards pressed");
                                break;
                            case R.id.settings:
                                Log.d("Navmenu", "settings pressed");
                                break;
                            case R.id.about:
                                Log.d("Navmenu", "about pressed");
                                break;
                            case R.id.help:
                                Log.d("Navment", "help pressed");
                                break;
                            default:
                                Log.d("mytag", "Test");
                        }
                        return true;
                    }
                }
        );

        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(mToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
