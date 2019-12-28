package com.example.ritwik.ig20;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.MyViewHolder> {


    View v;
    Context context;
    List<News> news;
    public NewsAdapter(Context context,List<News> news){
        this.context = context;
        this.news = news;

    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        v = LayoutInflater.from(context).inflate(R.layout.item_news,viewGroup,false);

        MyViewHolder myViewHolder = new MyViewHolder(v);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, final int i) {
        myViewHolder.news_content.setText(news.get(i).getNews_text());

        Glide.with(context).asBitmap().load(news.get(i).getNews_image()).into(myViewHolder.news_image);


    }

    @Override
    public int getItemCount() {
        return news.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView news_image;
        TextView news_content;

        public MyViewHolder(View itemView) {
            super(itemView);

            news_image = itemView.findViewById(R.id.news_img);
            news_content = itemView.findViewById(R.id.news_content);
        }
    }
}
