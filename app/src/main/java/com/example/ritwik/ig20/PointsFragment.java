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

import java.util.ArrayList;
import java.util.List;

public class PointsFragment extends Fragment {
    View v;
    RecyclerView recyclerView,recyclerView2;
    List<Department> lst;

    public PointsFragment(){

    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        lst = new ArrayList<Department>();
        v= inflater.inflate(R.layout.points_fragment,container,false);
        lst.add(new Department("CSE",new int[]{21,23,43,43,41,21,100,12,122},new int[]{21,23,43,43,41,21,100,12,122}));
        lst.add(new Department("ECE",new int[]{21,23,43,43,41,21,100,12,122},new int[]{21,23,43,43,41,21,100,12,122}));
        lst.add(new Department("EEE",new int[]{21,23,43,43,41,21,100,12,122},new int[]{21,23,43,43,41,21,100,12,122}));

        recyclerView = (RecyclerView)v.findViewById(R.id.points_event_recyclerview);

        Log.d("TAGGGGG","The lst size is"+lst.size());

        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),1));

        PointsAdapter pointsAdapter = new PointsAdapter(getContext(),lst,"Main Events");
        recyclerView.setAdapter(pointsAdapter);

        recyclerView2 =  (RecyclerView)v.findViewById(R.id.enthu_points_event_recyclerview);

        recyclerView2.setLayoutManager(new GridLayoutManager(getContext(),1));
        PointsAdapter pointsAdapter2 = new PointsAdapter(getContext(),lst,"Enthu Points");
        recyclerView2.setAdapter(pointsAdapter2);




        return v;

    }
}
