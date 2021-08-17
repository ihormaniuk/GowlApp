package com.groot.gowl;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.groot.gowl.ArraysPage.StartPage_Arrays;
import com.groot.gowl.RecycleView_Adapters.StartPage_Adapter;

import java.util.ArrayList;


public class FirstFragment extends Fragment {

    private View view;
    private ArrayList<StartPage_Arrays> startPage_arrays ;
    public RecyclerView recyclerView;
    private GridLayoutManager gridLayoutManager;
    public StartPage_Adapter startPage_adapter;
    private boolean aBoolean = false;

    public FirstFragment(ArrayList<StartPage_Arrays> arrays){
        this.startPage_arrays = arrays;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getrecyclerView();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_first, container, false);
        recyclerView = view.findViewById(R.id.rectangles);
        gridLayoutManager = new GridLayoutManager(container.getContext(),2);
        recyclerView.setLayoutManager(gridLayoutManager);
        startPage_adapter = new StartPage_Adapter(startPage_arrays, container.getContext());
        recyclerView.setAdapter(startPage_adapter);
        return view;
    }

    public RecyclerView getrecyclerView(){
        return recyclerView;
    }
}