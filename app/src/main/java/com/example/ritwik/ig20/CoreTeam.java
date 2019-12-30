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

public class CoreTeam extends AppCompatActivity {

    String TAG ="CoreTeamActivity";
    View v;
    private RecyclerView recyclerView;
    private AdapterTeam r;

    ArrayList<Profile> lst = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_core_team);
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

        setTitle("STUDENT COUNCIL");
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        initProfile();

//        runAnimation(0);

    }

    void initProfile(){
        lst.add(new Profile("Yogesh Patil",R.drawable.ic_launcher_background,"ritwikdeshpande01@gmail.com","9820188402","General Secretary"));
        lst.add(new Profile("Chaitya Chheda",R.drawable.ic_launcher_background,"ritwikdeshpande01@gmail.com","9820188402","Sports Secretary"));
        lst.add(new Profile("Mohit Rathi",R.drawable.ic_launcher_background,"ritwikdeshpande01@gmail.com","9820188402","Cultural Secrtary"));
       // lst.add(new Profile("Sathish",R.drawable.sathish,"ritwikdeshpande01@gmail.com","9820188402","Treasurer"));
        initRecyclerView();
        //callandSave("Sathish","9820188402");

    }



    void initRecyclerView(){
        Log.d(TAG,"Inisde Init Recycler View");
        recyclerView= findViewById(R.id.ct_recyclerview);
        r=new AdapterTeam(lst,this);
        recyclerView.setAdapter(r);
        recyclerView.setLayoutManager(new GridLayoutManager(this,1));

    }

//    private void runAnimation(int type) {
//
//
//
//        Context context = recyclerView.getContext();
//        LayoutAnimationController controller=null;
//
//        // 0 denotes fall_down animation
//        if(type==0){
//            controller= AnimationUtils.loadLayoutAnimation(this,R.anim.item_falldown_animation);
//        }
//
//
//        //Set animations
//        Log.d("CoreTeam","Setting Animations");
//        recyclerView.setLayoutAnimation(controller);
//        recyclerView.getAdapter().notifyDataSetChanged();
//        recyclerView.scheduleLayoutAnimation();
//
//    }
}
