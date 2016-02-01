package com.softdesign.school.ui.activities;

import android.content.Intent;
import android.support.v7.app.ActionBar;
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
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (itemId = item.getItemId()) {
            case android.R.id.home:
                Toast.makeText(this, "Menu Clicked!", Toast.LENGTH_SHORT).show();
                break;

            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
