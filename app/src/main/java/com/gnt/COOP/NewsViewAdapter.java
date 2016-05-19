package com.gnt.COOP;

import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gnt.COOP.models.*;
import java.util.List;


import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Roger-1 on 5/17/2016.
 */
public class NewsViewAdapter extends RecyclerView.Adapter<NewsViewAdapter.MyViewHolder> {

    List<News> list;

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        CircleImageView imageView;
        TextView title;
        TextView desc;
        CardView cardView;

        public MyViewHolder(CardView itemView) {
            super(itemView);

            cardView = itemView;
            imageView = (CircleImageView)itemView.findViewById(R.id.news_imageView);
            title = (TextView)itemView.findViewById(R.id.news_title);
            desc = (TextView)itemView.findViewById(R.id.news_desc);
        }
    }

    public NewsViewAdapter(List<News> ls)
    {
        list = ls;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        CardView view = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.news_cardview, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        TextView title = holder.title;
        TextView desc = holder.desc;
        CircleImageView imageView = holder.imageView;

        title.setText(list.get(position).getTitle());
        desc.setText(list.get(position).getDesc());
        imageView.setImageResource(list.get(position).getImageId());

        CardView cardView = holder.cardView;

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String title = list.get(position).getTitle();
                String desc = list.get(position).getDesc();
                int image = list.get(position).getImageId();

                Intent intent = new Intent(v.getContext(), DetailsActivity.class);
                intent.putExtra("list_title", title);
                intent.putExtra("list_desc", desc);
                intent.putExtra("list_image", image);

                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

}
