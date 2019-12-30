package com.example.ritwik.ig20;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.ContactsContract;
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

public class AdapterTeam extends RecyclerView.Adapter<AdapterTeam.MyViewHolder>{

    String TAG="RecyclerView";
    private ArrayList<Profile> profiles= new ArrayList<>();
    Context context;

    public AdapterTeam(ArrayList<Profile> profiles, Context context) {
        this.profiles = profiles;
        this.context=context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v;
        v = LayoutInflater.from(context).inflate(R.layout.item_profile,viewGroup,false);

        MyViewHolder myViewHolder= new MyViewHolder(v);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {
        Log.d(TAG,"Setting my View holder");
        Glide.with(context).asBitmap().load(profiles.get(i).getImage_url()).into(myViewHolder.image);
        myViewHolder.name.setText(profiles.get(i).getName());
        myViewHolder.email.setText(profiles.get(i).getEmail());
        myViewHolder.post.setText(profiles.get(i).getPost());
        myViewHolder.number.setText(profiles.get(i).getPhone_number());

        View.OnClickListener callOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                switch (v.getId()) {
                    case R.id.call:
                        intent.setData(Uri.parse("tel:" + profiles.get(i).getPhone_number()));
                        break;
                }
                context.startActivity(intent);
            }
        };

        View.OnClickListener saveOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_INSERT, ContactsContract.Contacts.CONTENT_URI);
                switch (v.getId()) {

                    case R.id.save:
                        intent.putExtra(ContactsContract.Intents.Insert.NAME,profiles.get(i).getName() );
                        intent.putExtra(ContactsContract.Intents.Insert.PHONE, "" + profiles.get(i).getPhone_number());
                        break;

                }
                context.startActivity(intent);
            }
        };
        View.OnClickListener emailOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                switch (v.getId()) {

                    case R.id.send_email:
                        String mail="mailto:"+profiles.get(i).getEmail();
                        intent.setData(Uri.parse(mail));
                        break;

                }
                context.startActivity(intent);
            }
        };
        myViewHolder.call.setOnClickListener(callOnClickListener);
        myViewHolder.save.setOnClickListener(saveOnClickListener);
        myViewHolder.send_email.setOnClickListener(emailOnClickListener);
    }

    @Override
    public int getItemCount() {
        return profiles.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        CircleImageView image;
        TextView name;
        TextView post;
        TextView email;
        TextView number;
        ImageButton call;
        ImageButton save ;
        ImageButton send_email;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            image=(CircleImageView) itemView.findViewById(R.id.dp);
            name=itemView.findViewById(R.id.name);
            post=itemView.findViewById(R.id.post);
            email= itemView.findViewById(R.id.email);
            number=itemView.findViewById(R.id.phone_number);
            call = (ImageButton) itemView.findViewById(R.id.call);
            save= (ImageButton) itemView.findViewById(R.id.save);
            send_email=(ImageButton)itemView.findViewById(R.id.send_email);
        }
    }

}
