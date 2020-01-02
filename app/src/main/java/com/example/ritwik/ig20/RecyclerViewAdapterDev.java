package com.example.ritwik.ig20;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewAdapterDev extends RecyclerView.Adapter<RecyclerViewAdapterDev.MyViewHolder>{

    String TAG="RecyclerView";
    private ArrayList<Developer> developers= new ArrayList<>();
    Context context;

    public RecyclerViewAdapterDev(ArrayList<Developer> developers,Context context) {
        this.developers = developers;
        this.context=context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v;
        v = LayoutInflater.from(context).inflate(R.layout.dev_item,viewGroup,false);

        MyViewHolder myViewHolder= new MyViewHolder(v);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {
        Log.d(TAG,"Setting my View holder");
        Glide.with(context).asBitmap().load(developers.get(i).getImage()).into(myViewHolder.image);
        myViewHolder.name.setText(developers.get(i).getName());
        //myViewHolder.email.setText(Developers.get(i).getEmail());
        myViewHolder.year.setText(developers.get(i).getYear());
        myViewHolder.post.setText(developers.get(i).getPost());
        //myViewHolder.number.setText(Developers.get(i).getPhone_number());
        myViewHolder.ld.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = developers.get(i).getLd();
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                context.startActivity(i);
            }
        });
        myViewHolder.git.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = developers.get(i).getGit();
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                context.startActivity(i);
            }
        });
        myViewHolder.gmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mail="mailto:"+developers.get(i).getGmail();

                Intent intent = new Intent(Intent.ACTION_SENDTO);

                intent.setData(Uri.parse(mail));
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        Log.d("TAG","The size of list is"+developers.size());
        return developers.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        CircleImageView image;
        TextView name;
        TextView year;
        TextView post;
        ImageButton ld;
        ImageButton gmail ;
        ImageButton git;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            image=(CircleImageView) itemView.findViewById(R.id.pic);
            name = itemView.findViewById(R.id.name);
            year=itemView.findViewById(R.id.year_dept);
            //email= itemView.findViewById(R.id.email);
            //number=itemView.findViewById(R.id.phone_number);
            post = itemView.findViewById(R.id.post);
            git = (ImageButton) itemView.findViewById(R.id.github);
            ld= (ImageButton) itemView.findViewById(R.id.linkedin);
            gmail = (ImageButton) itemView.findViewById(R.id.gmail);
        }
    }

}
