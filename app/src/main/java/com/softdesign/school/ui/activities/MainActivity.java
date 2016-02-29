package com.softdesign.school.ui.activities;

<<<<<<< HEAD
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
=======
<<<<<<< HEAD
<<<<<<< HEAD
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
>>>>>>> master

import com.softdesign.school.R;
import com.softdesign.school.ui.fragments.ContactsFragment;
import com.softdesign.school.ui.fragments.ProfileFragment;
import com.softdesign.school.ui.fragments.SettingsFragment;
import com.softdesign.school.ui.fragments.TasksFragment;
import com.softdesign.school.ui.fragments.TeamFragment;
import com.softdesign.school.utils.Lg;

<<<<<<< HEAD
public class MainActivity extends AppCompatActivity {

    public final static String EXTRA_IMAGE = "extra_image";
    private String TAG;
    private Toolbar mToolbar;
    private NavigationView mNavigationView;
    private DrawerLayout mNavigationDrawer;
    private Fragment mFragment;
    private FrameLayout mFrameContainer;
    private CollapsingToolbarLayout mCollapsingToolbarLayout;
    private AppBarLayout mAppBar;

    private boolean isCollapsed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TAG = this.getClass().getSimpleName();

        setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme theme = this.getTheme();
            theme.resolveAttribute(R.color.colorPrimaryDark, typedValue, true);
            int color = typedValue.data;

            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(color);
        }

        mAppBar = (AppBarLayout) findViewById(R.id.app_bar_layout);
        mNavigationView = (NavigationView) findViewById(R.id.navigation_view);
        mNavigationDrawer = (DrawerLayout) findViewById(R.id.navigation_drawer);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mFrameContainer = (FrameLayout) findViewById(R.id.main_frame_container);

        setupToolbar();
        setupDrawer();

        if (savedInstanceState == null) {
            mFragment = new ProfileFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.main_frame_container, mFragment).commit();
            isCollapsed = false;
        }
    }

=======

public class MainActivity extends AppCompatActivity {

    private static final String LOG = MainActivity.class.getName();
    private Toolbar mToolbar;
    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;

=======
=======
import android.content.Intent;
import android.support.v7.app.ActionBar;
>>>>>>> 4a2a4a2a849f4771ede8027f34811bdd87c21b97
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.softdesign.school.R;
import com.softdesign.school.utils.Lg;


public class MainActivity
        extends AppCompatActivity
        implements View.OnClickListener {

    private static final String LOG_TAG = MainActivity.class.getName();

    private static final String KEY_EDIT_TEXT_VISIBLE = "KEY_EDIT_TEXT_VISIBLE";
    private static final String KEY_THEME_NAME = "KEY_THEME_NAME";

    private String currentTheme;
    private Toolbar mToolbar;
    private CheckBox mCheckBox;
    private EditText mEditTextTop;
    private EditText mEditTextBottom;
    private Button mButtonRed;
    private Button mButtonGreen;
    private Button mButtonBlue;


>>>>>>> master
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Lg.i(LOG_TAG, "On Create");

        currentTheme = "default";
        if (savedInstanceState!=null) {
            String themeName = savedInstanceState.getString(KEY_THEME_NAME, "default");
            if ("red".equals(themeName)) {
                setTheme(R.style.AppRedTheme);
                currentTheme = "red";
            } else if ("green".equals(themeName)) {
                setTheme(R.style.AppGreenTheme);
                currentTheme = "green";
            }
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
<<<<<<< HEAD
<<<<<<< HEAD
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
=======

        setTitle("School lesson 1");

        mCheckBox = (CheckBox) findViewById(R.id.check_box);
        mCheckBox.setOnClickListener(this);

        mEditTextTop = (EditText) findViewById(R.id.edit_text_top);

        mEditTextBottom = (EditText) findViewById(R.id.edit_text_bottom);

        mButtonRed = (Button) findViewById(R.id.button_red);
        mButtonRed.setOnClickListener(this);

        mButtonGreen = (Button) findViewById(R.id.button_green);
        mButtonGreen.setOnClickListener(this);

        mButtonBlue = (Button) findViewById(R.id.button_blue);
        mButtonBlue.setOnClickListener(this);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setupToolbar();
>>>>>>> 4a2a4a2a849f4771ede8027f34811bdd87c21b97
    }
>>>>>>> master

    private void setupToolbar() {
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
<<<<<<< HEAD
        if (actionBar != null) {
            Lg.i(TAG, "action bar creation");
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_24dp);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        ViewCompat.setTransitionName(findViewById(R.id.app_bar_layout), EXTRA_IMAGE);
        mCollapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
    }

    private void setupDrawer() {
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.drawer_profile:
                        mFragment = new ProfileFragment();
                        mCollapsingToolbarLayout.setTitle(getString(R.string.fragment_profile_text_name));
                        mNavigationView.getMenu().findItem(R.id.drawer_profile).setChecked(true);
                        break;
                    case R.id.drawer_contacts:
                        mFragment = new ContactsFragment();
                        mCollapsingToolbarLayout.setTitle(getString(R.string.drawer_contacts));
                        mNavigationView.getMenu().findItem(R.id.drawer_contacts).setChecked(true);
                        break;
                    case R.id.drawer_team:
                        mFragment = new TeamFragment();
                        mCollapsingToolbarLayout.setTitle(getString(R.string.drawer_team));
                        mNavigationView.getMenu().findItem(R.id.drawer_team).setChecked(true);
                        break;
                    case R.id.drawer_tasks:
                        mFragment = new TasksFragment();
                        mCollapsingToolbarLayout.setTitle(getString(R.string.drawer_tasks));
                        mNavigationView.getMenu().findItem(R.id.drawer_tasks).setChecked(true);
                        break;
                    case R.id.drawer_setting:
                        mFragment = new SettingsFragment();
                        mCollapsingToolbarLayout.setTitle(getString(R.string.drawer_setting));
                        mNavigationView.getMenu().findItem(R.id.drawer_setting).setChecked(true);
                        break;
                }

                if (mFragment != null) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.main_frame_container, mFragment).addToBackStack(null).commit();
                }

                mNavigationDrawer.closeDrawers();
                return true;
            }
        });
    }

    public void lockAppBar(boolean collapse) {
        if (isCollapsed != collapse) {
            isCollapsed = collapse;
            mAppBar.setExpanded(!collapse, !collapse);
            setDrag(!collapse, mAppBar);
        }
    }

    private void setDrag(final boolean isDrag, AppBarLayout appBar) {
        Lg.d(TAG, "Drag is " + isDrag);
        ((CoordinatorLayout.LayoutParams) appBar.getLayoutParams()).setBehavior(new AppBarLayout.Behavior());

        CoordinatorLayout.LayoutParams lp = (CoordinatorLayout.LayoutParams) appBar.getLayoutParams();

        AppBarLayout.Behavior behavior = (AppBarLayout.Behavior) lp.getBehavior();
        behavior.setDragCallback(new AppBarLayout.Behavior.DragCallback() {
            @Override
            public boolean canDrag(@NonNull AppBarLayout appBarLayout) {
                return isDrag;
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        switch (mFrameContainer.getChildAt(0).getId()) {
            case R.id.fragment_profile:
                mNavigationView.getMenu().findItem(R.id.drawer_profile).setChecked(true);
                break;
            case R.id.fragment_contacts:
                mNavigationView.getMenu().findItem(R.id.drawer_contacts).setChecked(true);
                break;
            case R.id.fragment_tasks:
                mNavigationView.getMenu().findItem(R.id.drawer_tasks).setChecked(true);
                break;
            case R.id.fragment_team:
                mNavigationView.getMenu().findItem(R.id.drawer_team).setChecked(true);
                break;
            case R.id.fragment_settings:
                mNavigationView.getMenu().findItem(R.id.drawer_setting).setChecked(true);
=======
        if (actionBar!=null) {
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_24dp);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
<<<<<<< HEAD
    public boolean onOptionsItemSelected(MenuItem item) {
        mDrawerLayout.openDrawer(GravityCompat.START);
        return super.onOptionsItemSelected(item);
    }

    public void setMenuCheck(int itemId) {
        mNavigationView.getMenu().findItem(itemId).setChecked(true);
=======
>>>>>>> master
=======
    protected void onSaveInstanceState(Bundle outState) {
        Lg.i(LOG_TAG, "On Save Instance State");
        super.onSaveInstanceState(outState);
        outState.putBoolean(KEY_EDIT_TEXT_VISIBLE, (mEditTextBottom.getVisibility() == View.VISIBLE));
        outState.putString(KEY_THEME_NAME, currentTheme);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        Lg.i(LOG_TAG, "On Restore Instance State");
        super.onRestoreInstanceState(savedInstanceState);
        final int visibleState = savedInstanceState.getBoolean(KEY_EDIT_TEXT_VISIBLE, false) ? View.VISIBLE : View.INVISIBLE;
        mEditTextBottom.setVisibility(visibleState);
    }

    @Override
    protected void onStart() {
        Lg.i(LOG_TAG, "On Start");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Lg.i(LOG_TAG, "On Resume");
        super.onResume();
    }

    @Override
    protected void onRestart() {
        Lg.i(LOG_TAG, "On Restart");
        super.onRestart();
    }

    @Override
    protected void onPause() {
        Lg.i(LOG_TAG, "On Pause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Lg.i(LOG_TAG, "On Stop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Lg.i(LOG_TAG, "On Destroy");
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.check_box:
                Toast.makeText(this, "CheckBox Clicked!", Toast.LENGTH_SHORT).show();
                if (mCheckBox.isChecked()) {
                    mEditTextBottom.setVisibility(View.INVISIBLE);
                } else {
                    mEditTextBottom.setVisibility(View.VISIBLE);
                }
                break;

            case R.id.button_red:
                if (! "red".equals(currentTheme)) {
                    currentTheme = "red";
                    recreate();
                }
                break;

            case R.id.button_green:
                if (! "green".equals(currentTheme)) {
                    currentTheme = "green";
                    recreate();
                }
                break;

            case R.id.button_blue:
                if (! ("default".equals(currentTheme) ||  "blue".equals(currentTheme))) {
                    currentTheme = "blue";
                    recreate();
                }
                break;

            default:
>>>>>>> master
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
<<<<<<< HEAD
        if (item.getItemId() == android.R.id.home) {
            mNavigationDrawer.openDrawer(GravityCompat.START);
        }
        return super.onOptionsItemSelected(item);
=======
        switch (itemId = item.getItemId()) {
            case android.R.id.home:
                Toast.makeText(this, "Menu Clicked!", Toast.LENGTH_SHORT).show();
                break;

            default:
                break;
        }
        return super.onOptionsItemSelected(item);
>>>>>>> 4a2a4a2a849f4771ede8027f34811bdd87c21b97
>>>>>>> master
    }
}
