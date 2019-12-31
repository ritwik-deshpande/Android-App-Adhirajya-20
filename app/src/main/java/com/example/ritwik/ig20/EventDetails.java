package com.example.ritwik.ig20;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class EventDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        final Event event = (Event) getIntent().getSerializableExtra("EventExtra");

        setTitle(event.getEventName().toUpperCase());
        ImageView event_img = findViewById(R.id.event_img);
        Glide.with(this).load(event.getImage()).into(event_img);

        AppCompatTextView eventInfo = findViewById(R.id.description_textView);
        eventInfo.setText(event.getDesc());

        AppCompatTextView eventVenue = findViewById(R.id.venue);
        eventVenue.setText(event.getVenue());

        ImageButton map = findViewById(R.id.map);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri gmmIntentUri = Uri.parse("geo:0,0?q="+ Uri.encode(event.getVenue()));
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);

            }
        });

        List<AppCompatTextView> depts = new ArrayList<>();
        List<AppCompatTextView> pts = new ArrayList<>();
        for(int i=1;i<=8;i++){
            String dname = "points_dept_"+i;
            String dpts = "points_textView_"+i;
            int id1 = getResources().getIdentifier(dname,"id",getPackageName());
            if (id1!=0){
                depts.add((AppCompatTextView) findViewById(id1));

            }
            int id2 = getResources().getIdentifier(dpts,"id",getPackageName());
            if (id2!=0){
                pts.add((AppCompatTextView) findViewById(id2));

            }

        }

        HashMap<String, Integer> hm = new HashMap<String, Integer>();

        // enter data into hashmap
        hm.put("CSE", event.getCsePts());
        hm.put("CHEM-MIN", event.getChemPts());
        hm.put("META", event.getMetaPts());
        hm.put("MECH", event.getmechPts());
        hm.put("ARCHI", event.getArchiPts());
        hm.put("CIVIL", event.getCivPts());
        hm.put("EEE", event.getEeePts());
        hm.put("ECE", event.getEcePts());
        Map<String, Integer> hm1 = sortByValue(hm);

        String points = "";

        int counter = 0;
        // print the sorted hashmap
        for (Map.Entry<String, Integer> en : hm1.entrySet()) {


            depts.get(counter).setText(en.getKey());
//            pts.get(counter).setText(en.getValue());
            counter = counter + 1;
        }

    }

    public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm)
    {
        // Create a list from elements of HashMap
        List<Map.Entry<String, Integer> > list =
                new LinkedList<Map.Entry<String, Integer> >(hm.entrySet());

        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2)
            {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        // put data from sorted list to hashmap
        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }
}
