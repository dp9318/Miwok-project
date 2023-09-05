package com.example.miwok.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import com.example.miwok.R;
import com.example.miwok.Setter.phrase_set;

import java.util.ArrayList;

public class PhraseAdapter extends ArrayAdapter<phrase_set> {
    private int mColorResourceId;
    public  PhraseAdapter(Activity context, ArrayList<phrase_set> phrases, int ColorResourceId){
        super(context,0,phrases);
        mColorResourceId=ColorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View ListItemView = convertView;
        if(ListItemView==null){
            ListItemView= LayoutInflater.from(getContext()).inflate(R.layout.list_phrase,parent,false);
        }
        phrase_set currentphrase = getItem(position);


        TextView miwokTextView = ListItemView.findViewById(R.id.miwok_phrase_view);
        miwokTextView.setText(currentphrase.getMiwokTranslation());


        TextView defaultTextView = ListItemView.findViewById(R.id.default_phrase_view);
        defaultTextView.setText(currentphrase.getDefaultTranslation());


        View textContainer= ListItemView.findViewById(R.id.miwok_container_phrase);
        int color = ContextCompat.getColor(getContext(),mColorResourceId);
        textContainer.setBackgroundColor(color);

        return  ListItemView;
    }
}
