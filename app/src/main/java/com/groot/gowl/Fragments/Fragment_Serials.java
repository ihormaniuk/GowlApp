package com.groot.gowl.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.groot.gowl.ArraysPage.StartPage_Arrays;
import com.groot.gowl.R;
import com.groot.gowl.RecycleView_Adapters.StartPage_Adapter;

import java.util.ArrayList;

public class Fragment_Serials extends Fragment {
    private ArrayList<StartPage_Arrays> startPage_arrays ;
    private View view;
    public RecyclerView recyclerView;
    private GridLayoutManager gridLayoutManager;
    public StartPage_Adapter startPage_adapter;

    public Fragment_Serials(ArrayList<StartPage_Arrays> arrays){
        this.startPage_arrays = arrays;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment__serials, container, false);

        recyclerView = view.findViewById(R.id.rectangles);
        gridLayoutManager = new GridLayoutManager(container.getContext(),2);
        recyclerView.setLayoutManager(gridLayoutManager);
        startPage_adapter = new StartPage_Adapter(startPage_arrays, container.getContext());
        recyclerView.setAdapter(startPage_adapter);

        return view;
    }
}