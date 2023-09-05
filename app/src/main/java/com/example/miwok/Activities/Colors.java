package com.example.miwok.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.ListView;

import com.example.miwok.Adapter.ColorsAdapter;
import com.example.miwok.R;
import com.example.miwok.Setter.color_set;

import java.util.ArrayList;

public class Colors extends AppCompatActivity {
    private MediaPlayer mMediaPlayer;
    private AudioManager mAudioManager;
    private final MediaPlayer.OnCompletionListener mOnCompletionListner = mediaPlayer -> releaseMediaPlayer();
    AudioManager.OnAudioFocusChangeListener mOnAudioChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if(focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK){
                mMediaPlayer.pause();
                mMediaPlayer.seekTo(0);
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                mMediaPlayer.start();
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                releaseMediaPlayer();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);

        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        ArrayList<color_set> colors = new ArrayList<>(); //create a new arraylist data structure and add item like below
        //ArrayList<contact> contact = new ArrayLost<>()
        //contact.add(new contact("AMIT", 9187728822);
        //contact.add(new contact("AMIT", 9187728822);
        colors.add(new color_set("red","weṭeṭṭi",R.drawable.color_red,R.raw.color_red));
        colors.add(new color_set("green","chokokki",R.drawable.color_green,R.raw.color_green));
        colors.add(new color_set("browm","ṭakaakki",R.drawable.color_brown,R.raw.color_brown));
        colors.add(new color_set("gray","ṭopoppi",R.drawable.color_gray,R.raw.color_gray));
        colors.add(new color_set("black","kululli",R.drawable.color_black,R.raw.color_black));
        colors.add(new color_set("white", "kelelli",R.drawable.color_white,R.raw.color_white));
        colors.add(new color_set("dusty yellow","ṭopiisә",R.drawable.color_dusty_yellow,R.raw.color_dusty_yellow));
        colors.add(new color_set("mustard yellow","chiwiiṭә",R.drawable.color_mustard_yellow,R.raw.color_mustard_yellow));

        ColorsAdapter adapter = new ColorsAdapter(this,colors,R.color.category_colors);
        // create a contact adapter
        ListView colorview = findViewById(R.id.colors);
        colorview.setAdapter(adapter);
        colorview.setOnItemClickListener((parent, view, position, id) -> {
            color_set colorAudio = colors.get(position);
            releaseMediaPlayer();
            int result = mAudioManager.requestAudioFocus(mOnAudioChangeListener,AudioManager.STREAM_MUSIC,AudioManager.AUDIOFOCUS_GAIN);
            if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED){
                mMediaPlayer = MediaPlayer.create(Colors.this,colorAudio.getAudioResourceId());
                mMediaPlayer.start();
                mMediaPlayer.setOnCompletionListener(mOnCompletionListner);
            }
        });
    }
    @Override
    public void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }
    private void releaseMediaPlayer(){
        if (mMediaPlayer != null){
            mMediaPlayer.release();
            mMediaPlayer=null;
            mAudioManager.abandonAudioFocus(mOnAudioChangeListener);
        }
    }
}