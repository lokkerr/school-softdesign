package com.softdesign.school.ui.activities;

import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.softdesign.school.R;
import com.softdesign.school.ui.fragments.ContactsFragment;
import com.softdesign.school.ui.fragments.ProfileFragment;
import com.softdesign.school.ui.fragments.SettingsFragment;
import com.softdesign.school.ui.fragments.TasksFragment;
import com.softdesign.school.ui.fragments.TeamFragment;
import com.softdesign.school.utils.Lg;


public class MainActivity extends AppCompatActivity {

    private static final String LOG = MainActivity.class.getName();
    private Toolbar mToolbar;
    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("School lesson 3");
        if (null == savedInstanceState) {
            getSupportFragmentManager().beginTransaction().replace(R.id.main_frame_container, new ProfileFragment()).commit();
        }
    }

    private void setupNavigation() {
        mDrawerLayout = (DrawerLayout) findViewById(R.id.navigation_drawer);
        mNavigationView = (NavigationView) findViewById(R.id.navigation_view);
        mNavigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem item) {
                        Fragment fragment = null;
                        switch (item.getItemId()) {
                            case R.id.navigation_contacts:
                                fragment = new ContactsFragment();
                                break;

                            case R.id.navigation_profile:
                                fragment = new ProfileFragment();
                                break;

                            case R.id.navigation_settings:
                                fragment = new SettingsFragment();
                                break;

                            case R.id.navigation_tasks:
                                fragment = new TasksFragment();
                                break;

                            case R.id.navigation_team:
                                fragment = new TeamFragment();
                                break;

                            default:
                                break;
                        }
                        if (fragment!=null) {
                            getSupportFragmentManager().beginTransaction().replace(R.id.main_frame_container, fragment).addToBackStack(null).commit();
                        }
                        mDrawerLayout.closeDrawers();
                        return true;
                    }
                });
    }

    private void setupToolbar() {
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar!=null) {
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_24dp);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        mDrawerLayout.openDrawer(GravityCompat.START);
        return super.onOptionsItemSelected(item);
    }

    public void setMenuCheck(int itemId) {
        mNavigationView.getMenu().findItem(itemId).setChecked(true);
    }
}
