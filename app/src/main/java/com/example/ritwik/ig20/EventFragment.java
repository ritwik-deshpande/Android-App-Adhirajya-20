package com.example.ritwik.ig20;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class EventFragment extends Fragment {
    View v;
    List<EventGroup> lst;
    RecyclerView recyclerView;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference().child("Events");
    List<Fixture> fixtures;
    List<Event> eventlst;

    public EventFragment(){

    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v= inflater.inflate(R.layout.event_fragment,container,false);
//
//        lst = new ArrayList<EventGroup>();
//
//        eventlst =  new ArrayList<Event>();
//         eventlst.add(new Event("StreetPlay","Some Description","0","Rules",20,20,20,20,20,20,20,20));
//        eventlst.add(new Event("StagPlay","Some Description","0","Rules",20,20,20,20,20,20,20,20));
//        eventlst.add(new Event("Mime","Some Description","0","Rules",20,20,20,20,20,20,20,20));
//
//        lst.add(new EventGroup("Cultural","https://nationnext.in/wp-content/uploads/2018/11/28-10-2018-Naalayak-band-@-VNIT-AT-6.jpg",eventlst));
//
//
//        myRef.child("Cultural").setValue(lst.get(0));
//
//
//        eventlst =  new ArrayList<Event>();
//        eventlst.add(new Event("Cricket","Some Description","0","Rules",20,20,20,20,20,20,20,20));
//        eventlst.add(new Event("Football","Some Description","0","Rules",20,20,20,20,20,20,20,20));
//        eventlst.add(new Event("BasketBall","Some Description","0","Rules",20,20,20,20,20,20,20,20));
//
//       // eventlst.add(new Event("Mime","Some Description","0",fixtures));
//
//        lst.add(new EventGroup("Sports","https://nationnext.in/wp-content/uploads/2018/11/28-10-2018-Naalayak-band-@-VNIT-AT-6.jpg",eventlst));
//
//
//
//        myRef.child("Sports").setValue(lst.get(1));
//
//
//        eventlst =  new ArrayList<Event>();
//        eventlst.add(new Event("Flag Design","Some Description","0","Rules",0,0,0,20,20,20,20,20));
//        eventlst.add(new Event("Campus Decor","Some Description","0","Rules",20,20,20,20,20,20,20,20));
//        eventlst.add(new Event("Rangoli","Some Description","0","Rules",20,20,20,20,20,20,20,20));
//
//        lst.add(new EventGroup("Art Events","https://nationnext.in/wp-content/uploads/2018/11/28-10-2018-Naalayak-band-@-VNIT-AT-6.jpg",eventlst));
//
//
//        myRef.child("Art").setValue(lst.get(2));
//
//
//
//        eventlst =  new ArrayList<Event>();
//        eventlst.add(new Event("Dota","Some Description","0","Rules",20,20,20,20,20,20,20,20));
//        eventlst.add(new Event("PUPG","Some Description","0","Rules",20,20,20,20,20,20,20,20));
//        eventlst.add(new Event("Call of Duty","Some Description","0","Rules",20,20,20,20,20,20,20,20));
//
//        lst.add(new EventGroup("Indoor Events","https://nationnext.in/wp-content/uploads/2018/11/28-10-2018-Naalayak-band-@-VNIT-AT-6.jpg",eventlst));
//
//
//        myRef.child("Indoor Events").setValue(lst.get(3));
//
//
//        eventlst =  new ArrayList<Event>();
//        eventlst.add(new Event("JAM","Some Description","0","Rules",20,20,20,20,20,20,20,20));
//        eventlst.add(new Event("Creative Writing","Some Description","0","Rules",20,20,20,20,20,20,20,20));
//        eventlst.add(new Event("Debate","Some Description","0","Rules",20,20,20,20,20,20,20,20));
//
//        lst.add(new EventGroup("Literary Events","https://nationnext.in/wp-content/uploads/2018/11/28-10-2018-Naalayak-band-@-VNIT-AT-6.jpg",eventlst));
//
//
//        myRef.child("Literary Events").setValue(lst.get(4));

        getData();


        return v;

    }

    private void getData() {
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                Log.d("TAG","DATA GETIING FILLED");

                lst = new ArrayList<EventGroup>();
                for(DataSnapshot snapshot:dataSnapshot.getChildren()){

                    lst.add(snapshot.getValue(EventGroup.class));



                }
                updateUI();
                Log.d("TAG","The size of list "+lst.size());

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.d("TAG", "Failed to read value.", error.toException());
            }
        });






    }

    private void updateUI() {
        recyclerView = (RecyclerView)v.findViewById(R.id.event_recyclerview);

        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));

        EventsAdapter eventsAdapter = new EventsAdapter(getContext(),lst);
        recyclerView.setAdapter(eventsAdapter);
    }


}
