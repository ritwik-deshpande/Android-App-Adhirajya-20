package com.example.ritwik.ig20;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.io.Serializable;
import java.util.List;

public class EventsActivityAdapter extends  RecyclerView.Adapter<EventsActivityAdapter.MyViewHolder> {
    View v;
    Context context;
    List<Event> lst;



    public EventsActivityAdapter(Context context, List<Event> lst) {
        this.context = context;
        this.lst =  lst;

    }

    @Override
    public EventsActivityAdapter.MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        v = LayoutInflater.from(context).inflate(R.layout.item_event,viewGroup,false);

        MyViewHolder myViewHolder=new MyViewHolder(v);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(EventsActivityAdapter.MyViewHolder myViewHolder, final int i) {

        myViewHolder.eventName.setText(lst.get(i).getEventName());

        Log.d("TAG","The image is"+lst.get(i).getImage());

        Glide.with(context).asBitmap().load(lst.get(i).getImage()).into(myViewHolder.eventImage);

        myViewHolder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,EventDetails.class);

                intent.putExtra("EventExtra", (Serializable) lst.get(i));
                context.startActivity(intent);


            }
        });


//        Glide.with(context).load(img).into(myViewHolder.eventImg);
//        Glide.with(context).load(img).into(myViewHolder.eventImg);
//


    }



    @Override
    public int getItemCount() {
        return lst.size();
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView eventName;
        ImageView eventImage;
        private LinearLayout parentLayout;

        public MyViewHolder(View itemView) {
            super(itemView);


            eventName = itemView.findViewById(R.id.event_name);
            eventImage = itemView.findViewById(R.id.event_img);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }
}
