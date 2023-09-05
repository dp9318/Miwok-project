package com.example.miwok.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import com.example.miwok.R;
import com.example.miwok.Setter.color_set;

import java.util.ArrayList;

public class ColorsAdapter extends ArrayAdapter<color_set> {
    private  int mColorResourceId;
    public  ColorsAdapter(Activity context, ArrayList<color_set> colors,int ColorResourceId){
        super(context,0,colors);
        mColorResourceId=ColorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View ListItemView = convertView;
        if(ListItemView==null){
            ListItemView= LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }
        color_set currentcolor = getItem(position);


        TextView miwokTextView = ListItemView.findViewById(R.id.miwok_text_view);
        miwokTextView.setText(currentcolor.getMiwokTranslation());


        TextView defaultTextView = ListItemView.findViewById(R.id.default_text_view);
        defaultTextView.setText(currentcolor.getDefaultTranslation());


        ImageView miwokImageView = ListItemView.findViewById(R.id.miwok_image_view);
        miwokImageView.setImageResource(currentcolor.getmImageResourceId());


        View textContainer= ListItemView.findViewById(R.id.miwok_container);
        int color = ContextCompat.getColor(getContext(),mColorResourceId);
        textContainer.setBackgroundColor(color);


        return  ListItemView;
    }
}
