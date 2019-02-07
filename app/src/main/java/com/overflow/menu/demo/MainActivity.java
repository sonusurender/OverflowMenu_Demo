package com.overflow.menu.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpToolbar();
    }

    /* set up toolbar */
    private void setUpToolbar() {
        Toolbar toolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);
    }

    /**
     * open default overflow menu activity
     *
     * @param view
     */
    public void openDefaultOverflowMenu(View view) {
        OverflowMenuActivity.openOverflowMenuActivity(this, false);
    }

    /**
     * open custom overflow menu activity
     *
     * @param view
     */
    public void openCustomOverflowMenu(View view) {
        OverflowMenuActivity.openOverflowMenuActivity(this, true);
    }

    /**
     * open styled overflow menu activity
     *
     * @param view
     */
    public void openStyledOverflowMenu(View view) {
        OverflowMenuStyleActivity.openOverflowMenuStyleActivity(this);
    }
}
