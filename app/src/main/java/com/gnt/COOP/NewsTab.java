package com.gnt.COOP;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import java.util.ArrayList;
import java.util.List;

import com.gnt.COOP.models.News;


/**
 * A simple {@link Fragment} subclass.
 */

public class NewsTab extends Fragment {

    List<News> list = new ArrayList<News>();

    public NewsTab() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        FrameLayout frameLayout = (FrameLayout) inflater.inflate(R.layout.fragment_news_tab, container, false);
        RecyclerView recyclerView = (RecyclerView) frameLayout.findViewById(R.id.news_recycler);

        //populating placeholder
        populatePlaceHolder();

        NewsViewAdapter adapter = new NewsViewAdapter(list);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);

        FloatingActionButton fab = (FloatingActionButton)frameLayout.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String url = "http://www.google.com";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);

            }
        });


        return frameLayout;
    }

    private void populatePlaceHolder() {

        for(int c = 0; c < 20; c++)
        {
            News n = new News("My News Title", "Lorem ipsum blah blah blah blah blah blah blah blah blah blah blah blah", R.drawable.placeholder_news_image1);
            list.add(n);
        }
    }



}
