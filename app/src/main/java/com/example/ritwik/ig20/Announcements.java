package com.example.ritwik.ig20;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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
import java.util.List;


public class Announcements extends Fragment {

    View v;
    List<News> lst;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference().child("News");
    ValueEventListener valueEventListener;
    ProgressDialog dialog;

    public Announcements() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_announcements, container, false);
        dialog= new ProgressDialog(getContext());
        dialog.setMessage("Loading....");
        dialog.show();

        Announcements.FetchEventList fel = new Announcements.FetchEventList();
        fel.execute();



        return v;
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

                    lst = new ArrayList<News>();
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                        lst.add(snapshot.getValue(News.class));


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

    private void updateUI() {
        dialog.hide();

        RecyclerView recyclerView = v.findViewById(R.id.news_recyclerview);

        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),1));

//        lst.add(new News("DAY 8: CSE Wins Stage Play","https://nationnext.in/wp-content/uploads/2018/11/28-10-2018-Naalayak-band-@-VNIT-AT-6.jpg"));
//        lst.add(new News("DAY 8: CSE Wins Stage Play","https://nationnext.in/wp-content/uploads/2018/11/28-10-2018-Naalayak-band-@-VNIT-AT-6.jpg"));
//        lst.add(new News("DAY 8: CSE Wins Stage Play","https://nationnext.in/wp-content/uploads/2018/11/28-10-2018-Naalayak-band-@-VNIT-AT-6.jpg"));

        NewsAdapter newsAdapter = new NewsAdapter(getContext(),lst);

        recyclerView.setAdapter(newsAdapter);
    }


}
