package com.example.miwok.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import com.example.miwok.Setter.family_members_set;
import com.example.miwok.R;

import java.util.ArrayList;

public class MembersAdapter extends ArrayAdapter<family_members_set> {
    private int mColorResourceId;

    public  MembersAdapter(Activity context, ArrayList<family_members_set> members,int ColorResourceId){
        super(context,0,members);
        mColorResourceId=ColorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View ListItemView = convertView;
        if(ListItemView==null){
            ListItemView= LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }
        family_members_set currentMember = getItem(position);


        TextView miwokTextView = ListItemView.findViewById(R.id.miwok_text_view);
        miwokTextView.setText(currentMember.getMiwokTranslation());


        TextView defaultTextView = ListItemView.findViewById(R.id.default_text_view);
        defaultTextView.setText(currentMember.getDefaultTranslation());


        ImageView miwokImageView = ListItemView.findViewById(R.id.miwok_image_view);
        miwokImageView.setImageResource(currentMember.getmImageResourceId());


        View textContainer= ListItemView.findViewById(R.id.miwok_container);
        int color = ContextCompat.getColor(getContext(),mColorResourceId);
        textContainer.setBackgroundColor(color);

        return  ListItemView;
    }
}
