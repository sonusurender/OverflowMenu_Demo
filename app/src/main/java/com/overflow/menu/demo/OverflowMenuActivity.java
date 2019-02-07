package com.overflow.menu.demo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

/**
 * Created by sonu on 11:42, 10/01/19
 * Copyright (c) 2019 . All rights reserved.
 */
public class OverflowMenuActivity extends AppCompatActivity {

    private static final String EXTRA_IS_CUSTOM = "is_custom_overflow_menu";

    /**
     * method to open OverflowMenuActivity
     *
     * @param context              calling context
     * @param isCustomOverflowMenu param to check which overflow menu has to be show
     */
    public static void openOverflowMenuActivity(Context context, boolean isCustomOverflowMenu) {
        Intent intent = new Intent(context, OverflowMenuActivity.class);
        intent.putExtra(EXTRA_IS_CUSTOM, isCustomOverflowMenu);
        context.startActivity(intent);
    }

    private Toolbar toolbar;
    private boolean isCustomOverflowMenu;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overflow_menu);

        //get the boolean value
        isCustomOverflowMenu = getIntent().getBooleanExtra(EXTRA_IS_CUSTOM, false);

        setUpToolbar();
    }

    /**
     * set up toolbar
     */
    private void setUpToolbar() {
        toolbar = findViewById(R.id.overflow_menu_toolbar);
        setSupportActionBar(toolbar);

        //get the actionbar
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            //enable the back button
            actionBar.setDisplayHomeAsUpEnabled(true);

            //change the title on basis of boolean value
            if (isCustomOverflowMenu) {
                actionBar.setTitle("Custom Overflow Menu");
            } else {
                actionBar.setTitle("Default Overflow Menu");
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //inflate the menu on the basis of boolean value
        if (isCustomOverflowMenu) {
            getMenuInflater().inflate(R.menu.custom_overflow_menu, menu);
        } else {
            getMenuInflater().inflate(R.menu.overflow_menu, menu);
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_contact_us:
                Toast.makeText(this, "Contact us clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_terms_conditions:
                Toast.makeText(this, "Terms and Conditions clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_logout:
                Toast.makeText(this, "Logout clicked", Toast.LENGTH_SHORT).show();
                break;
            case android.R.id.home:
                //click event of back arrow button to finish activity
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
