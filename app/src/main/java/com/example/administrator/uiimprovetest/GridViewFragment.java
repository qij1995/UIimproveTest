package com.example.administrator.uiimprovetest;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;


public class GridViewFragment extends Fragment {

    private List<Item> itemList = new ArrayList<Item>();


    public GridViewFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_grid_view, container, false);
        initItems(view);

        return view;
    }

//    @Override
//    public void onStart() {
//        super.onStart();
//        View view =this.(R.id.gridview);
//    }

    private void initItems(View view) {
        Item one = new Item("海德威豪华五件套", R.drawable.one);
        itemList.add(one);
        Item two = new Item("花园庭院阳台藤椅摇椅扶手配茶几摇椅", R.drawable.two);
        itemList.add(two);
        Item three = new Item("藤编三件套件庭院阳台茶几休闲藤椅", R.drawable.three);
        itemList.add(three);
        Item four = new Item("藤编秋千吊椅", R.drawable.four);
        itemList.add(four);
        Item five = new Item("铸铝桌椅组合", R.drawable.five);
        itemList.add(five);
        Item six = new Item("藤编秋千吊椅", R.drawable.six);
        itemList.add(six);
        GridView gridView = (GridView) view.findViewById(R.id.gridview);
     //   gridView = (GridView) gridView.findViewById(R.id.gridview);
        ItemAdapter adapter = new ItemAdapter(getActivity(), R.layout.grid_layout, itemList);
//        GridView gridView = (GridView) findViewById(R.id.gridview);
        gridView.setAdapter(adapter);
    }


}
