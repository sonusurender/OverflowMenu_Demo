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
public class OverflowMenuStyleActivity extends AppCompatActivity {


    /**
     * method to open OverflowMenuActivity
     *
     * @param context calling context
     */
    public static void openOverflowMenuStyleActivity(Context context) {
        Intent intent = new Intent(context, OverflowMenuStyleActivity.class);
        context.startActivity(intent);
    }

    private Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overflow_menu_style);
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
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.custom_overflow_menu, menu);
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
