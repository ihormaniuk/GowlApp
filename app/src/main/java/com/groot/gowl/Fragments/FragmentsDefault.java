package com.groot.gowl.Fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.groot.gowl.Activity.SearchActivity;
import com.groot.gowl.ArraysPage.StartPage_Arrays;
import com.groot.gowl.MainActivity;
import com.groot.gowl.R;
import com.groot.gowl.RecycleView_Adapters.StartPage_Adapter;

import java.util.ArrayList;

public class FragmentsDefault extends Fragment {
    private ArrayList<StartPage_Arrays> startPage_arrays ;
    private View view;
    public RecyclerView recyclerView;
    private GridLayoutManager gridLayoutManager;
    public StartPage_Adapter startPage_adapter;
    private boolean aBoolean = false;
    public int pu = 0;
    public FragmentsDefault(ArrayList<StartPage_Arrays> arrays){
        this.startPage_arrays = arrays;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getboolean();
        getrecyclerView();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_default,container,false);
        recyclerView = view.findViewById(R.id.rectangles);
        gridLayoutManager = new GridLayoutManager(container.getContext(),2);
        recyclerView.setLayoutManager(gridLayoutManager);
        startPage_adapter = new StartPage_Adapter(startPage_arrays, container.getContext());
        recyclerView.setAdapter(startPage_adapter);



//        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
//            @Override
//            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
//                super.onScrollStateChanged(recyclerView, newState);
//                if (!recyclerView.canScrollVertically(1)) {
////                    bool = "notPage";
////                    String urlPosChange = "https://uakino.club/page/1/";
////                    StringBuffer stringBuffer = new StringBuffer(urlPosChange);
////                    stringBuffer.replace(25,27, String.valueOf(count++));
////                    nextPage = stringBuffer.toString();
////                    Content content = Content();
////                    content.execute();
////                    recyclerView.setFocusable(true);
////                    recyclerView.setFocusableInTouchMode(true);
//                    pu = 1;
//                    System.out.println("Scroll");
//                    aBoolean = true;
//                }else {
//                    pu = 0;
//                }
//            }
//        });


        return view;
    }

    public boolean getboolean(){
        return aBoolean;
    }
    public RecyclerView getrecyclerView(){
        return recyclerView;
    }
}
