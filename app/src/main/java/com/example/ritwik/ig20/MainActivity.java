package com.example.ritwik.ig20;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.iid.FirebaseInstanceId;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private TabLayout tabLayout;
    ViewPagerAdapter viewPagerAdapter;
    ViewPager viewPager;
    ImageButton fb;
    ImageButton insta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        setTitle("");

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        insta = findViewById(R.id.insta);

        insta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://www.instagram.com/igvnit/";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

//        FirebaseDatabase database = FirebaseDatabase.getInstance();
//        DatabaseReference myRef = database.getReference("Events").child("Literary Events").child("events");
//
//        Log.d("TAG","Writing to Firebase");
//
//
//        for(int i =0;i<=15;i++){
//            myRef.child(Integer.toString(i)).child("csePts").setValue(0);
//            myRef.child(Integer.toString(i)).child("civPts").setValue(0);
//            myRef.child(Integer.toString(i)).child("eeePts").setValue(0);
//            myRef.child(Integer.toString(i)).child("ecePts").setValue(0);
//            myRef.child(Integer.toString(i)).child("metaPts").setValue(0);
//            myRef.child(Integer.toString(i)).child("mechPts").setValue(0);
//            myRef.child(Integer.toString(i)).child("chemPts").setValue(0);
//            myRef.child(Integer.toString(i)).child("archiPts").setValue(0);
//        }
//
//        final String[] value = new String[1];
//
//        final int[] a = new int[1];
//
//        myRef2.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                // This method is called once with the initial value and again
//                // whenever data at this location is updated.
//
//               // value[0] = (String) dataSnapshot.getValue(String.class);
//
//              //  Toast.makeText(this,"retrieving data"+value[0],Toast.LENGTH_SHORT).show();
//
////                a[0] = ((Long)dataSnapshot.child("d1").child("dailyScore").child("0").getValue()).intValue();
////
////                Log.d("TAG", "Value is: " + a[0]);
//            }
//
//            @Override
//            public void onCancelled(DatabaseError error) {
//                // Failed to read value
//                Log.d("TAG", "Failed to read value.", error.toException());
//            }
//        });
//
//
//        Toast.makeText(this,"retrieving data"+value[0],Toast.LENGTH_SHORT).show();




        String token = FirebaseInstanceId.getInstance().getToken();

        //for now we are displaying the token in the log
        //copy it as this method is called only when the new token is generated
        //and usually new token is only generated when t
        // he app is reinstalled or the data is cleared
        Log.d("TAG", "Token is"+token);

       // d40xcmwyODk:APA91bGUxdL0xPbwk4qrbp186ukC86RsZyIlkgsK1E2-zH5D68zUMNmX05e6EmC3BMnPKGORHYdaikHyS3oHveXwPZ7Gq0toUgGD6vfRcz7lXbu-aVFWyFpKXv9rQDN3wIEjwzOVQrQm





        tabLayout = (TabLayout) findViewById(R.id.tabLayout_id);
        tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#FF0000"));
        tabLayout.setSelectedTabIndicatorHeight((int) (5 * getResources().getDisplayMetrics().density));
        tabLayout.setTabTextColors(Color.parseColor("#727272"), Color.parseColor("#ffffff"));
        viewPager = (ViewPager) findViewById(R.id.viewpager_id);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        // Adding Fragments

        viewPagerAdapter.addFragment(new Announcements(), "announcements");
        viewPagerAdapter.addFragment(new EventFragment(), "EVENTS");
//        viewPagerAdapter.addFragment(new EventFragment(), "departments");
        viewPagerAdapter.addFragment(new PointsFragment(), "scoreboard");
        viewPagerAdapter.addFragment(new EnthuPointsFragment(), "enthu points");



        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
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
//        if (id == R.id.action_settings) {
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_about) {
            // Handle the camera action
        } else if (id == R.id.nav_team) {
            Intent i = new Intent(MainActivity.this, CoreTeam.class);
            startActivity(i);

        } else if (id == R.id.nav_rules) {
            String url = "https://drive.google.com/file/d/15AnUx4BuKR6_TThkdRpF3BWDrHeyLXWr/view?usp=sharing";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);

        }else if (id == R.id.nav_dev) {
            Intent i = new Intent(MainActivity.this, Developers.class);
            startActivity(i);

        }

        else if (id == R.id.nav_schedule) {

            String url = "https://drive.google.com/file/d/15AnUx4BuKR6_TThkdRpF3BWDrHeyLXWr/view?usp=sharing";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
