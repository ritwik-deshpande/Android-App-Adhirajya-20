package com.example.ritwik.ig20;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

public class Developers extends AppCompatActivity {

    String TAG ="DevelopersActivity";
    View v;
    private RecyclerView recyclerView;
    private RecyclerViewAdapterDev r;

    ArrayList<Developer> lst = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developers);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        setTitle("DEVELOPERS");
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        initDeveloper();

    }

    void initDeveloper(){
        lst.add(new Developer("Ritwik Deshpande","4th Year CSE",R.drawable.ritwik,"https://www.linkedin.com/in/ritwik-deshpande-ba4b51170","https://github.com/ritwik-deshpande","ritwikdeshpande01@gmail.com","App Developer"));

        lst.add(new Developer("Saurabh Pujari","3rd Year CSE",R.drawable.sourav,"https://www.linkedin.com/in/saurabh-pujari-525420192","https://github.com/saurabh0719","saurabhpuj99@gmail.com","Web Developer"));
        initRecyclerView();
        //callandSave("Sathish","9820188402");

    }



    void initRecyclerView(){
        Log.d(TAG,"Inisde Init Recycler View"+lst.size());
        recyclerView= findViewById(R.id.dev_recyclerview);
        r=new RecyclerViewAdapterDev(lst,this);
        recyclerView.setAdapter(r);
        recyclerView.setLayoutManager(new GridLayoutManager(this,1));

    }
}
