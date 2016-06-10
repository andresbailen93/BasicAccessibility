package com.example.andres.myapplication.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.andres.myapplication.R;
import com.example.andres.myapplication.adapter.RecyclerViewAdapter;
import com.example.andres.myapplication.model.Noticia;

import java.util.ArrayList;

/**
 * Created by andres on 10/06/2016.
 */
public class ListFragment extends Fragment {
    private View view;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<Noticia> noticiaArrayList;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_news_list, container, false);

        Bundle bundle = getArguments();
        noticiaArrayList = bundle.getParcelableArrayList("noticiasArrayList");

        mRecyclerView = (RecyclerView) view.findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new RecyclerViewAdapter(this.getContext(), noticiaArrayList);
        mRecyclerView.setAdapter(mAdapter);

        return view;
    }
}
