package com.example.ritwik.ig20;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.List;

public class EventActivity extends AppCompatActivity {
    List<Event> events ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);


        events = (List<Event>) getIntent().getSerializableExtra("EventsListExtra");
        String title = getIntent().getStringExtra("EventType");
        setTitle(title.toUpperCase());

        RecyclerView recyclerView = findViewById(R.id.event_activity_recyclerview);

        recyclerView.setLayoutManager(new GridLayoutManager(this,2));

        EventsActivityAdapter eventsActivityAdapter = new EventsActivityAdapter(this,events);
        recyclerView.setAdapter(eventsActivityAdapter);


    }
}
