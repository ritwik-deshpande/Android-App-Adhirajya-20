package com.example.ritwik.ig20;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class PointsAdapter extends  RecyclerView.Adapter<PointsAdapter.MyViewHolder>{

    Context context;
    List<Department> list;
    String label;

    public PointsAdapter(Context context, List<Department> list,String label) {
        this.context = context;
        this.list = list;
        this.label = label;
        Log.d("TAGGGGG","The list size in Adpater is"+list.size());
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup,int i) {

        View v;

        v = LayoutInflater.from(context).inflate(R.layout.item_points_event,viewGroup,false);

        MyViewHolder myViewHolder=new MyViewHolder(v,context);


        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {

        Log.d("TAGGGGG","The deprtmnet name "+list.get(i).getDepartmentName());
        myViewHolder.departmentName.setText(list.get(i).getDepartmentName());

        if(label.equals("Main Events")){
            int totalScore = 0;
            for (int j=0;j<10;j++){
               // Log.d("TAGGGGG","The Score is "+Integer.toString(list.get(i).getDailyScores()[j]));
                myViewHolder.dailyScores.get(j).setText(Long.toString(list.get(i).getDailyScores().get(j)));
                totalScore = totalScore + (list.get(i).getDailyScores().get(j)).intValue();
            }
            myViewHolder.totalScore.setText(Integer.toString(totalScore));

        }
        else if(label.equals("Enthu Points")){
            int totalScore = 0;
            for (int j=0;j<10;j++){
//                Log.d("TAGGGGG","The Score is "+Integer.toString(list.get(i).getEnthuPoints()[j]));
                myViewHolder.dailyScores.get(j).setText(Integer.toString(list.get(i).getEnthuPoints().get(j)));
                totalScore = totalScore + list.get(i).getEnthuPoints().get(j);
            }
            myViewHolder.totalScore.setText(Integer.toString(totalScore));
        }

//        myViewHolder.day1score.setText(Integer.toString(list.get(i).getDay1score()));


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView departmentName;
        private TextView totalScore;
        List<TextView> dailyScores = new ArrayList<TextView>();
        public MyViewHolder(@NonNull View itemView,Context context) {
            super(itemView);

            departmentName = (TextView)itemView.findViewById(R.id.department_name);
            totalScore = (TextView)itemView.findViewById(R.id.total);
            for (int i=1;i<=10;i++){
                String name = "day_"+i;
                int id = itemView.getResources().getIdentifier(name,"id",context.getPackageName());
                if (id!=0){
                    dailyScores.add((TextView) itemView.findViewById(id));
                }

            }
//            day1score = (TextView)itemView.findViewById(R.id.day_1);
        }
    }

}
