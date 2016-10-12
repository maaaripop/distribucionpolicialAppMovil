package com.example.mariella.distribucionpolicialapp;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.mariella.distribucionpolicialapp.fragments.ImportFragment;
import com.example.mariella.distribucionpolicialapp.fragments.LoginFragment;
import com.example.mariella.distribucionpolicialapp.fragments.MainFragment;
import com.example.mariella.distribucionpolicialapp.fragments.MapFragment;
import com.example.mariella.distribucionpolicialapp.fragments.TipoDelitoFragment;
import com.example.mariella.distribucionpolicialapp.services.ApiServiceAdapter;
import com.example.mariella.distribucionpolicialapp.services.ServiceEndPoints;

import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    public static final int FRAGMENT_TIPO_DELITO=0;
    public static ServiceEndPoints service=null;
    int previousBackStackCount;
    long lastBackPressTime;
    private FragmentManager.OnBackStackChangedListener backStackListener = new FragmentManager.OnBackStackChangedListener() {
        @Override
        public void onBackStackChanged() {
            int backStackEntryCount = getSupportFragmentManager().getBackStackEntryCount();
            boolean noStack = backStackEntryCount == 0;
            //setNavIcon(noStack);

            if (backStackEntryCount < previousBackStackCount) {
                //Se sacó un elemento
                Fragment fragment = getTopFragment();
                invalidateOptionsMenu();
            }
            previousBackStackCount = backStackEntryCount;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setVisibility(View.GONE);


        /*Retrofit config*/
        service=ApiServiceAdapter.getInstance().create(ServiceEndPoints.class);
        /**/
        FragmentManager fm = getSupportFragmentManager();
        getSupportFragmentManager().addOnBackStackChangedListener(backStackListener);
        fm.beginTransaction().replace(R.id.content_frame, new LoginFragment()).commit();


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
            return;
        }
        // initialize variables


        // check to see if stack is empty
        Fragment topFragment = getTopFragment();
        if (topFragment == null || (topFragment instanceof MainFragment) || (topFragment instanceof LoginFragment)) {
            if (this.lastBackPressTime < System.currentTimeMillis() - 4000) {
                Toast.makeText(MainActivity.this, "Presione atrás nuevamente para salir", Toast.LENGTH_LONG).show();//.makeText(this, "Nochmal drücken zum Beenden!", 4000).show();
                this.lastBackPressTime = System.currentTimeMillis();
            } else {
                finish();
                System.exit(0);
            }

        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        FragmentManager fm= getSupportFragmentManager();
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            fm.beginTransaction().replace(R.id.content_frame, new ImportFragment()).addToBackStack(null).commit();

        } else if (id == R.id.nav_gallery) {
            fm.beginTransaction().replace(R.id.content_frame, new MapFragment()).addToBackStack(null).commit();
        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        } else if(id== R.id.nav_tipo_delitos){
            fm.beginTransaction().replace(R.id.content_frame, new TipoDelitoFragment()).addToBackStack(null).commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void accessAppMainFragment() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setVisibility(View.VISIBLE);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().replace(R.id.content_frame, new MainFragment()).addToBackStack(null).commit();


    }

    private Fragment getTopFragment() {
        List<Fragment> fragments = getSupportFragmentManager().getFragments();
        if (fragments != null) {
            for (int i = fragments.size() - 1; i >= 0; i--) {
                Fragment fragment = fragments.get(i);
                if (fragment != null && (fragment instanceof Fragment)) {
                    return (Fragment) fragment;
                }
            }
        }
        return null;
    }


}
