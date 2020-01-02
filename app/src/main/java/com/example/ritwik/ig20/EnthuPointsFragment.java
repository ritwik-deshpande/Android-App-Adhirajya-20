package com.example.ritwik.ig20;

import android.app.ProgressDialog;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
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
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EnthuPointsFragment extends Fragment {
    View v;
    RecyclerView recyclerView2;
    List<Department> departmentlist2;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference().child("Points");

    public EnthuPointsFragment(){
    }



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.enthu_fragment, container, false);
        getData();

        return v;
    }
    private void getData() {
        final ProgressDialog dialog = new ProgressDialog(getContext());
        dialog.setMessage("Loading....");
        dialog.show();
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                Log.d("TAG","DATA GETIING FILLED");


                departmentlist2 = new ArrayList<Department>();
                for(DataSnapshot snapshot:dataSnapshot.getChildren()){


                    departmentlist2.add(snapshot.getValue(Department.class));



                }
                dialog.hide();
                updateUI();
                //   Log.d("TAG","The size of list "+departmentlist.size());

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.d("TAG", "Failed to read value.", error.toException());
            }
        });






    }

    private void updateUI() {
        recyclerView2 = (RecyclerView)v.findViewById(R.id.enthu_points_event_recyclerview);

        //   Log.d("TAGGGGG","The lst size is"+departmentlist.size());

        recyclerView2.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL,false));

        order("Main Events");

        for(int i=0;i<8;i++) {
            Log.d("TAG", "Dname:" + departmentlist2.get(i).getDepartmentName() );
        }
        PointsAdapter pointsAdapter = new PointsAdapter(getContext(),departmentlist2,"Enthu Points",R.layout.item_points_event);
        recyclerView2.setAdapter(pointsAdapter);

//        recyclerView2 =  (RecyclerView)v.findViewById(R.id.enthu_points_event_recyclerview);
//
//        recyclerView2.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL,false));
//        order("Enthu Points");
//        PointsAdapter pointsAdapter2 = new PointsAdapter(getContext(),departmentlist2,"Enthu Points");
//        recyclerView2.setAdapter(pointsAdapter2);

//        departmentlist.clear();
    }


    public void order(final String label){

            Collections.sort(departmentlist2, new Comparator<Department>() {
                @RequiresApi(api = Build.VERSION_CODES.KITKAT)
                @Override
                public int compare(Department department, Department t1) {


                    double totalScore1 = 0.0;
                    for (int j=0;j<10;j++){
                        totalScore1 = totalScore1 + (department.getEnthuPoints().get(j));
                    }
                    double totalScore2 = 0.0;
                    for (int j=0;j<10;j++){
                        totalScore2 = totalScore2 + (t1.getEnthuPoints().get(j));
                    }
                    if (totalScore2>totalScore1)
                        return 1;
                    else if(totalScore2<totalScore1)
                        return -1;
                    return 0;



                }
            });
    }
}
