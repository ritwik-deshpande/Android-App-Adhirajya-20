package com.example.ritwik.ig20;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class Announcements extends Fragment {

    View v;
    List<News> lst;

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
        lst = new ArrayList<News>();
        RecyclerView recyclerView = v.findViewById(R.id.news_recyclerview);

        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),1));

        lst.add(new News("DAY 8: CSE Wins Stage Play","https://nationnext.in/wp-content/uploads/2018/11/28-10-2018-Naalayak-band-@-VNIT-AT-6.jpg"));
        lst.add(new News("DAY 8: CSE Wins Stage Play","https://nationnext.in/wp-content/uploads/2018/11/28-10-2018-Naalayak-band-@-VNIT-AT-6.jpg"));
        lst.add(new News("DAY 8: CSE Wins Stage Play","https://nationnext.in/wp-content/uploads/2018/11/28-10-2018-Naalayak-band-@-VNIT-AT-6.jpg"));

        NewsAdapter newsAdapter = new NewsAdapter(getContext(),lst);

        recyclerView.setAdapter(newsAdapter);



        return v;
    }


}
