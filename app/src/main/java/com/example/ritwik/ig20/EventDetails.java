package com.example.ritwik.ig20;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

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
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        Event event = (Event) getIntent().getSerializableExtra("EventExtra");

        setTitle(event.getEventName());
        ImageView event_img = findViewById(R.id.event_img);
        Glide.with(this).load(event.getImage()).into(event_img);

        AppCompatTextView eventInfo = findViewById(R.id.description_textView);
        eventInfo.setText(event.getDesc());

        AppCompatTextView eventRules = findViewById(R.id.rules_textView);
        eventRules.setText(event.getRules());

        AppCompatTextView eventPoints = findViewById(R.id.points_textView);

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

        int rank = 1;
        // print the sorted hashmap
        for (Map.Entry<String, Integer> en : hm1.entrySet()) {

            points = points + Integer.toString(rank) + "."+en.getKey()+ ":     "+en.getValue()+ "\n";
            rank = rank + 1;
//            System.out.println("Key = " + en.getKey() +
//                    ", Value = " + en.getValue());
        }
        eventPoints.setText(points);


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
