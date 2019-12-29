package com.example.ritwik.ig20;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
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

public class PointsFragment extends Fragment {
    View v;
    RecyclerView recyclerView,recyclerView2;
    List<Department> departmentlist;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference().child("Points");

    public PointsFragment(){

    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v= inflater.inflate(R.layout.points_fragment,container,false);
        getData();

//        departmentlist.add(new Department("CSE",new int[]{21,23,43,43,41,21,100,12,122},new int[]{21,23,43,43,41,21,100,12,122}));
//        departmentlist.add(new Department("ECE",new int[]{21,23,43,43,41,21,100,12,122},new int[]{21,23,43,43,41,21,100,12,122}));
//        departmentlist.add(new Department("EEE",new int[]{21,23,43,43,41,21,100,12,122},new int[]{21,23,43,43,41,21,100,12,122}));


//        List<Integer> lst= new ArrayList<>();
//
//        lst.add(0);
//        lst.add(0);
//        lst.add(0);
//        lst.add(0);
//        lst.add(0);
//        lst.add(0);
//        lst.add(0);
//        lst.add(0);
//        lst.add(0);
//        lst.add(0);



        //departmentlist.add(new Department("CSE",lst ,lst));
//        myRef.child("CSE").setValue(new Department("CSE",lst ,lst));
//        myRef.child("EEE").setValue(new Department("CSE",lst ,lst));
//        myRef.child("ECE").setValue(new Department("CSE",lst ,lst));
//        myRef.child("MECH").setValue(new Department("CSE",lst ,lst));
//        myRef.child("CHEM-MINE").setValue(new Department("CSE",lst ,lst));
//        myRef.child("META").setValue(new Department("CSE",lst ,lst));
//        myRef.child("ARCHI").setValue(new Department("CSE",lst ,lst));
//        myRef.child("CIVIL").setValue(new Department("CSE",lst ,lst));









        return v;

    }

    private void getData() {
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                Log.d("TAG","DATA GETIING FILLED");

                departmentlist = new ArrayList<Department>();
                for(DataSnapshot snapshot:dataSnapshot.getChildren()){

                    departmentlist.add(snapshot.getValue(Department.class));



                }
                updateUI();
                Log.d("TAG","The size of list "+departmentlist.size());

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.d("TAG", "Failed to read value.", error.toException());
            }
        });






    }

    private void updateUI() {
        recyclerView = (RecyclerView)v.findViewById(R.id.points_event_recyclerview);

        Log.d("TAGGGGG","The lst size is"+departmentlist.size());

        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),1));

        PointsAdapter pointsAdapter = new PointsAdapter(getContext(),departmentlist,"Main Events");
        recyclerView.setAdapter(pointsAdapter);

        recyclerView2 =  (RecyclerView)v.findViewById(R.id.enthu_points_event_recyclerview);

        recyclerView2.setLayoutManager(new GridLayoutManager(getContext(),1));
        PointsAdapter pointsAdapter2 = new PointsAdapter(getContext(),departmentlist,"Enthu Points");
        recyclerView2.setAdapter(pointsAdapter2);

//        departmentlist.clear();
    }
}
