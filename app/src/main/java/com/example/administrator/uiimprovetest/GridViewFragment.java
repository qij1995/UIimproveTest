package com.example.administrator.uiimprovetest;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;


public class GridViewFragment extends Fragment {

    private List<Item> itemList = new ArrayList<Item>();
private int[] ID=new int[]{R.drawable.one, R.drawable.two, R.drawable.
            three, R.drawable.four, R.drawable.five, R.drawable.six};
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
//initItem方法的参数未设置，导致onCreateView方法中创建了View对象而无法使用，进而程序一直报错显示空指针
    private void initItems(View view) {

        Item one = new Item("海德威豪华五件套","￥11216","￥28758", R.drawable.one,ID);
        itemList.add(one);
        Item two = new Item("花园庭院阳台藤椅摇椅扶手配茶几摇椅","￥12563","￥26532", R.drawable.two,ID);
        itemList.add(two);
        Item three = new Item("藤编三件套件庭院阳台茶几休闲藤椅","￥13625","￥25630", R.drawable.three,ID);
        itemList.add(three);
        Item four = new Item("藤编秋千吊椅","￥10235","￥27865", R.drawable.four,ID);
        itemList.add(four);
        Item five = new Item("铸铝桌椅组合","￥12486","￥27320", R.drawable.five,ID);
        itemList.add(five);
        Item six = new Item("藤编秋千吊椅","￥13260","￥29568", R.drawable.six,ID);
        itemList.add(six);
        GridView gridView = (GridView) view.findViewById(R.id.gridview);
        ItemAdapter adapter = new ItemAdapter(getActivity(), R.layout.grid_layout, itemList);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Item item = itemList.get(i);
                Intent intent = new Intent(getActivity(),DetailActivity.class);
                intent.putExtra("resource",ID);
                intent.putExtra("name",item.getText().toString().trim());//trim方法就是去除字符串中空格和25种字符
                intent.putExtra("price",item.getText1().toString().trim());
                intent.putExtra("price2",item.getText2().toString().trim());
                startActivity(intent);
            }
        });
    }


}
