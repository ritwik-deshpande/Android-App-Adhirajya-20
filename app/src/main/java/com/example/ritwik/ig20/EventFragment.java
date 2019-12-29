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

        lst = new ArrayList<EventGroup>();

        eventlst =  new ArrayList<Event>();
        fixtures = new ArrayList<Fixture>();
        fixtures.add(new Fixture("Round1","26/02/19 2:40pm","CSE WINS","CSE VS MECH"));
        fixtures.add(new Fixture("Round1","26/02/19 2:40pm","CSE WINS","CSE VS MECH"));
        fixtures.add(new Fixture("Round1","26/02/19 2:40pm","CSE WINS","CSE VS MECH"));
        eventlst.add(new Event("StreetPlay","Some Description","0",fixtures));
        eventlst.add(new Event("StagPlay","Some Description","0",fixtures));
        eventlst.add(new Event("Mime","Some Description","0",fixtures));

        lst.add(new EventGroup("Cultural","https://nationnext.in/wp-content/uploads/2018/11/28-10-2018-Naalayak-band-@-VNIT-AT-6.jpg",eventlst));


        myRef.child("Cultural").setValue(lst.get(0));


        eventlst =  new ArrayList<Event>();
        fixtures = new ArrayList<Fixture>();
        fixtures.add(new Fixture("Round1","26/02/19 2:40pm","CSE WINS","CSE VS MECH"));
        fixtures.add(new Fixture("Round1","26/02/19 2:40pm","CSE WINS","CSE VS MECH"));
        fixtures.add(new Fixture("Round1","26/02/19 2:40pm","CSE WINS","CSE VS MECH"));
        eventlst.add(new Event("StreetPlay","Some Description","0",fixtures));
        eventlst.add(new Event("StagPlay","Some Description","0",fixtures));
        eventlst.add(new Event("Mime","Some Description","0",fixtures));

        lst.add(new EventGroup("Sports","https://nationnext.in/wp-content/uploads/2018/11/28-10-2018-Naalayak-band-@-VNIT-AT-6.jpg",eventlst));



        myRef.child("Sports").setValue(lst.get(1));


        eventlst =  new ArrayList<Event>();
        fixtures = new ArrayList<Fixture>();
        fixtures.add(new Fixture("Round1","26/02/19 2:40pm","CSE WINS","CSE VS MECH"));
        fixtures.add(new Fixture("Round1","26/02/19 2:40pm","CSE WINS","CSE VS MECH"));
        fixtures.add(new Fixture("Round1","26/02/19 2:40pm","CSE WINS","CSE VS MECH"));
        eventlst.add(new Event("StreetPlay","Some Description","0",fixtures));
        eventlst.add(new Event("StagPlay","Some Description","0",fixtures));
        eventlst.add(new Event("Mime","Some Description","0",fixtures));

        lst.add(new EventGroup("Art Events","https://nationnext.in/wp-content/uploads/2018/11/28-10-2018-Naalayak-band-@-VNIT-AT-6.jpg",eventlst));


        myRef.child("Art").setValue(lst.get(2));



        eventlst =  new ArrayList<Event>();
        fixtures = new ArrayList<Fixture>();
        fixtures.add(new Fixture("Round1","26/02/19 2:40pm","CSE WINS","CSE VS MECH"));
        fixtures.add(new Fixture("Round1","26/02/19 2:40pm","CSE WINS","CSE VS MECH"));
        fixtures.add(new Fixture("Round1","26/02/19 2:40pm","CSE WINS","CSE VS MECH"));
        eventlst.add(new Event("StreetPlay","Some Description","0",fixtures));
        eventlst.add(new Event("StagPlay","Some Description","0",fixtures));
        eventlst.add(new Event("Mime","Some Description","0",fixtures));

        lst.add(new EventGroup("Indoor Events","https://nationnext.in/wp-content/uploads/2018/11/28-10-2018-Naalayak-band-@-VNIT-AT-6.jpg",eventlst));


        myRef.child("Indoor Events").setValue(lst.get(2));







//        eventlst =  new ArrayList<Event>();
//        eventlst.add(new Event("Cricket","Some Description","data:image/jpeg;base64,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"));

//        eventlst.add(new Event("Football","Some Description",new Hashtable<String,Integer>(){{ put("CSE", 100); put("EEE", 20);}}));
//
//        eventlst.add(new Event("Mime","Some Description",new Hashtable<String,Integer>(){{ put("CSE", 100); put("EEE", 20);}}));

//
//        lst.add(new EventGroup("Sports","https://www.google.com/imgres?imgurl=https%3A%2F%2Fnationnext.in%2Fwp-content%2Fuploads%2F2018%2F11%2F28-10-2018-Naalayak-band-%40-VNIT-AT-6.jpg&imgrefurl=https%3A%2F%2Fnationnext.in%2Fnaalayak-band-rocking-ending-vnit-cultural-fest-aarohi-2018-nagpur%2F&docid=GYg_nXfODvdeLM&tbnid=A34rFuMBru9khM%3A&vet=10ahUKEwiVoqWksNjmAhV-zzgGHQUlCrQQMwhWKAswCw..i&w=800&h=521&bih=641&biw=1301&q=vnit%20nagpur%20cultural%20fest&ved=0ahUKEwiVoqWksNjmAhV-zzgGHQUlCrQQMwhWKAswCw&iact=mrc&uact=8",eventlst));



        recyclerView = (RecyclerView)v.findViewById(R.id.event_recyclerview);

        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));

        EventsAdapter eventsAdapter = new EventsAdapter(getContext(),lst);
        recyclerView.setAdapter(eventsAdapter);

        return v;

    }


}
