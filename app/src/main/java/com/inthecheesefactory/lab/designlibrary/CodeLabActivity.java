package com.inthecheesefactory.lab.designlibrary;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class CodeLabActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle;
    //    private FrameLayout rootLayout;
    private CoordinatorLayout rootLayout;
    private FloatingActionButton plusButton;
    private Toolbar toolbar;
//    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code_lab);

        initToolbar();
//        initTabLayout();
        initInstances();
    }

    private void initToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

//    private void initTabLayout() {
//        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
//        if (tabLayout != null) {
//            tabLayout.addTab(tabLayout.newTab().setText("TAB 1"));
//            tabLayout.addTab(tabLayout.newTab().setText("TAB 2"));
//            tabLayout.addTab(tabLayout.newTab().setText("TAB 3"));
//        }
//    }

    private void initInstances() {
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        drawerToggle = new ActionBarDrawerToggle(CodeLabActivity.this, drawerLayout, R.string.hello_world, R.string.hello_world);
//        drawerLayout.setDrawerListener(drawerToggle);
        drawerLayout.addDrawerListener(drawerToggle);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

//        rootLayout = (FrameLayout) findViewById(R.id.rootLayout);
        rootLayout = (CoordinatorLayout) findViewById(R.id.rootLayout);

        plusButton = (FloatingActionButton) findViewById(R.id.plus_fab);
        plusButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Snackbar.make(rootLayout, "Hello, I'm a Snackbar !", Snackbar.LENGTH_SHORT)
                        .setAction("Undo", new View.OnClickListener() {

                            @Override
                            public void onClick(View v) {

                            }
                        }).show();
            }
        });
    }

    @Override
    public void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_code_lab, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (drawerToggle.onOptionsItemSelected(item))
            return true;

        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
