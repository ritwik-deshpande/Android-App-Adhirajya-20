package com.example.ritwik.ig20;

import android.os.Bundle;
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

        setTitle("COUNCIL 19-20");
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
        lst.add(new Profile("Yogesh Patil",R.drawable.yogesh,"council@students.vnit.ac.in","9890692331","General Secretary"));
        lst.add(new Profile("Vaishnavi Shringi",R.drawable.vaishnavi,"ladiesrep@students.vnit.ac.in","8007337374","Ladies Representative"));
        lst.add(new Profile("Chaitya Chheda",R.drawable.chaitya2,"sportsec@students.vnit.ac.in","8655947800","Sports Secretary"));
        lst.add(new Profile("Mohit Rathi",R.drawable.mohit,"cultsec@students.vnit.ac.in","9765969288","Cultural Secretary"));
        lst.add(new Profile("Ayush Singh",R.drawable.ayush,"techsec@students.vnit.ac.in","9423539982","Technical Secretary"));
        lst.add(new Profile("Aditya Kumar",R.drawable.aditya,"ugacad@students.vnit.ac.in","9820188402","UG Academic Secretary"));
        lst.add(new Profile("Sanket Joag",R.drawable.sanket,"litsec@students.vnit.ac.in","7738558574","Literary Affairs Secretary"));
        lst.add(new Profile("Jidnyasa Badwaik",R.drawable.jidnyasa,"tnpsec@students.vnit.ac.in","8975755615","Training and Placement Secretary"));
        lst.add(new Profile("Gyan Pratik",R.drawable.gyan,"alumnisec.vnit@gmail.com","9472595746","Alumni Secretary"));
        lst.add(new Profile("Shuvendu Ranabijuli",R.drawable.shuvendu,"boyshostelsec@students.vnit.ac.in","9172637632","Hostel Affairs Secretary(Boys)"));
        lst.add(new Profile("Prachi Janorkar",R.drawable.prachi,"girlshostelsec@students.vnit.ac.in","7020085641","Hostel Affairs Secretary(Girls)"));
        lst.add(new Profile("Saurabh Dharmare",R.drawable.saurabh,"socialsec@students.vnit.ac.in","9112357473","Social Affairs Secretary"));
        lst.add(new Profile("Mohsin Khan",R.drawable.mohsin,"pgcult@students.vnit.ac.in","8802440140","PG Sports and Cultural Secretary"));
        lst.add(new Profile("Saurabh Khairnar",R.drawable.khainair,"pgacad@students.vnit.ac.in","8975502598","PG Academic Secretary"));


        //        lst.add(new Profile("Yogesh Patil",R.drawable.yogesh,"ritwikdeshpande01@gmail.com","9820188402","General Secretary"));
//        lst.add(new Profile("Yogesh Patil",R.drawable.yogesh,"ritwikdeshpande01@gmail.com","9820188402","General Secretary"));
//        lst.add(new Profile("Yogesh Patil",R.drawable.yogesh,"ritwikdeshpande01@gmail.com","9820188402","General Secretary"));
//        lst.add(new Profile("Yogesh Patil",R.drawable.yogesh,"ritwikdeshpande01@gmail.com","9820188402","General Secretary"));
//        lst.add(new Profile("Yogesh Patil",R.drawable.yogesh,"ritwikdeshpande01@gmail.com","9820188402","General Secretary"));
//        lst.add(new Profile("Yogesh Patil",R.drawable.yogesh,"ritwikdeshpande01@gmail.com","9820188402","General Secretary"));
//        lst.add(new Profile("Yogesh Patil",R.drawable.yogesh,"ritwikdeshpande01@gmail.com","9820188402","General Secretary"));
//        lst.add(new Profile("Yogesh Patil",R.drawable.yogesh,"ritwikdeshpande01@gmail.com","9820188402","General Secretary"));

        //        lst.add(new Profile("Chaitya Chheda",R.drawable.ic_launcher_background,"ritwikdeshpande01@gmail.com","9820188402","Sports Secretary"));
//        lst.add(new Profile("Mohit Rathi",R.drawable.ic_launcher_background,"ritwikdeshpande01@gmail.com","9820188402","Cultural Secrtary"));
//       // lst.add(new Profile("Sathish",R.drawable.sathish,"ritwikdeshpande01@gmail.com","9820188402","Treasurer"));
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
