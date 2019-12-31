package com.example.ritwik.ig20;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.design.widget.Snackbar;
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
import android.widget.Toast;

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
    ValueEventListener valueEventListener;


    public EventFragment(){

    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        final ProgressDialog dialog= new ProgressDialog(getContext());

        v= inflater.inflate(R.layout.event_fragment,container,false);

        ConnectivityManager conMan = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);

        //mobile
        NetworkInfo.State mobile = conMan.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState();

        //wifi
        NetworkInfo.State wifi = conMan.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState();

        if (mobile == NetworkInfo.State.CONNECTED || wifi == NetworkInfo.State.CONNECTED) {

        } else  {
            try {
                Snackbar.make(getActivity().findViewById(R.id.nav_view),"No Internet Connection",Snackbar.LENGTH_LONG).show();
            }catch (Exception e)
            {           }

            Toast.makeText(getActivity(),"Unable to fetch latest data",Toast.LENGTH_SHORT).show();

        }
        EventFragment.FetchEventList fel = new EventFragment.FetchEventList();
        fel.execute();


//        lst = new ArrayList<EventGroup>();
//
//        eventlst =  new ArrayList<Event>();
//        for(int i=0;i<15;i++) {
//            eventlst.add(new Event("Street Play", "Some Description", "0", "CRC", 20, 20, 20, 20, 20, 20, 20, 20));
//        }
//        lst.add(new EventGroup("Cultural","https://nationnext.in/wp-content/uploads/2018/11/28-10-2018-Naalayak-band-@-VNIT-AT-6.jpg",eventlst));
//
//
//        myRef.child("Cultural").setValue(lst.get(0));
//
//
//        eventlst =  new ArrayList<Event>();
//        for(int i=0;i<39;i++){
//            eventlst.add(new Event("Cricket","Some Description","0","VNIT Sports Ground",20,20,20,20,20,20,20,20));
//
//        }
//        lst.add(new EventGroup("Sports","https://nationnext.in/wp-content/uploads/2018/11/28-10-2018-Naalayak-band-@-VNIT-AT-6.jpg",eventlst));
//
//
//
//        myRef.child("Sports").setValue(lst.get(1));
//
//
//        eventlst =  new ArrayList<Event>();
//        for(int i=0;i<12;i++){
//            eventlst.add(new Event("Flag Design","Some Description","0","VNIT CRC",0,0,0,20,20,20,20,20));
//        }
//        lst.add(new EventGroup("Art Events","https://nationnext.in/wp-content/uploads/2018/11/28-10-2018-Naalayak-band-@-VNIT-AT-6.jpg",eventlst));
//
//
//        myRef.child("Art").setValue(lst.get(2));
//
//
//
//        eventlst =  new ArrayList<Event>();
//        for(int i=0;i<16;i++) {
//            eventlst.add(new Event("Dota", "Some Description", "0", "VNIT CRC", 20, 20, 20, 20, 20, 20, 20, 20));
//        }
//
//        lst.add(new EventGroup("Indoor Events","https://nationnext.in/wp-content/uploads/2018/11/28-10-2018-Naalayak-band-@-VNIT-AT-6.jpg",eventlst));
//
//
//        myRef.child("Indoor Events").setValue(lst.get(3));
//
//
//        eventlst =  new ArrayList<Event>();
//        for(int i=0;i<12;i++) {
//            eventlst.add(new Event("JAM", "Some Description", "0", "Rules", 20, 20, 20, 20, 20, 20, 20, 20));
//        }
//        lst.add(new EventGroup("Literary Events","https://nationnext.in/wp-content/uploads/2018/11/28-10-2018-Naalayak-band-@-VNIT-AT-6.jpg",eventlst));
//
//
//        myRef.child("Literary Events").setValue(lst.get(4));

      //  getData();



//        dialog.setMessage("Loading....");
//        dialog.show();


        return v;

    }

    private void getData() {







    }

    private void updateUI() {
//        dialog.hide();
        recyclerView = (RecyclerView)v.findViewById(R.id.event_recyclerview);

        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));

        EventsAdapter eventsAdapter = new EventsAdapter(getContext(),lst);
        recyclerView.setAdapter(eventsAdapter);
    }

    public class FetchEventList extends AsyncTask<Void,Void,ArrayList<Event>> {

        @Override
        protected void onPreExecute() {
            //bar.setVisibility(View.VISIBLE);
        }

        @Override
        protected ArrayList<Event> doInBackground(Void... params) {



            valueEventListener = new ValueEventListener() {


                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    Log.d("TAG", "DATA GETIING FILLED");

                    lst = new ArrayList<EventGroup>();
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                        lst.add(snapshot.getValue(EventGroup.class));


                    }

                    updateUI();
                    Log.d("TAG", "The size of list " + lst.size());

                }

                @Override
                public void onCancelled(DatabaseError error) {
                    // Failed to read value
                    Log.d("TAG", "Failed to read value.", error.toException());
                }

            };
            myRef.addListenerForSingleValueEvent(valueEventListener);
            return null;
        }
    }


}
