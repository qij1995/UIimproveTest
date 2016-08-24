package com.example.administrator.uiimprovetest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by qijiajun on 2016/8/16.
 */
public class ItemAdapter extends ArrayAdapter<Item> {
    private int resourceId;
    public ItemAdapter(Context context, int textViewResourceId, List<Item> objects){
        super(context,textViewResourceId,objects);
        resourceId = textViewResourceId;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Item item = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId,null);
        ImageView itemImage = (ImageView)view.findViewById(R.id.image_grid);
        TextView itemText = (TextView)view.findViewById(R.id.text_grid);
        itemImage.setImageResource(item.getImageId());
        itemText.setText(item.getText());
        return view;
    }

}
