package com.ust.jupiter.jupiter.activity;

import android.Manifest;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.ust.jupiter.jupiter.R;
import com.ust.jupiter.jupiter.fragment.CUJoiningFragment;
import com.ust.jupiter.jupiter.fragment.CUManagementFragment;
import com.ust.jupiter.jupiter.fragment.CUCreationFragment;
import com.ust.jupiter.jupiter.fragment.DigitalAssetFragment;
import com.ust.jupiter.jupiter.fragment.MainFragment;
import com.ust.jupiter.jupiter.fragment.OverviewFragment;
import com.ust.jupiter.jupiter.fragment.ReceiveTokenFragment;
import com.ust.jupiter.jupiter.fragment.TransferTokenFragment;
import com.vondear.rxtools.RxActivityTool;
import com.vondear.rxtools.RxPermissionsTool;
import com.vondear.rxtools.RxTool;
import com.vondear.rxtools.activity.ActivityScanerCode;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private MainActivity mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        replaceFragment(new MainFragment());
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mContext= this;
        RxPermissionsTool.
                with(mContext).
                addPermission(Manifest.permission.CAMERA).
                initPermission();


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.action_camera:
                RxActivityTool.skipActivity(mContext, ActivityScanerCode.class);
                return true;
            case R.id.action_settings:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_cu_management) {
            replaceFragment(new CUManagementFragment());
        } else if (id == R.id.nav_join_cu) {
            replaceFragment(new CUJoiningFragment());
        } else if (id == R.id.nav_overview) {
            replaceFragment(new OverviewFragment());
        } else if (id == R.id.nav_transfer_token) {
            replaceFragment(new TransferTokenFragment());
        } else if (id == R.id.nav_receive_token) {
            replaceFragment(new ReceiveTokenFragment());
        } else if (id == R.id.nav_digital_asset) {
            replaceFragment(new DigitalAssetFragment());
        }  else if (id == R.id.nav_cu_overview) {
            replaceFragment(new CUCreationFragment());
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment_main, fragment);
        transaction.commit();
    }


}
