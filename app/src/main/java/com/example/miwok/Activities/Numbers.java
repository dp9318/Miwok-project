package com.example.miwok.Activities;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.RemoteController;
import android.os.Bundle;

import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.miwok.Adapter.WordAdapter;
import com.example.miwok.R;
import com.example.miwok.Setter.number_set;

import java.util.ArrayList;

public class Numbers extends AppCompatActivity {
    private MediaPlayer mMediaPlayer;
    private AudioManager mAudioManager;
    AudioManager.OnAudioFocusChangeListener mOnAudioChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if(focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK){
                mMediaPlayer.pause();
                mMediaPlayer.seekTo(0);
            }

            else if (focusChange== AudioManager.AUDIOFOCUS_LOSS){
                releaseMediaPlayer();
            }
            else if(focusChange == AudioManager.AUDIOFOCUS_GAIN){
                mMediaPlayer.start();
            }
        }
    };

    private final MediaPlayer.OnCompletionListener mOnCompletionListner = mediaPlayer -> releaseMediaPlayer();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

         mAudioManager= (AudioManager) getSystemService(Context.AUDIO_SERVICE);

//        String[] number = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten"};
//        ArrayAdapter<String> numbersets = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,number);
        final ArrayList<number_set> numbersets = new ArrayList<>();
        numbersets.add(new number_set("One","Lutti",R.drawable.number_one,R.raw.number_one));
        numbersets.add(new number_set("two","Otiiko",R.drawable.number_two,R.raw.number_two));
        numbersets.add(new number_set("three","tolookosu",R.drawable.number_three,R.raw.number_three));
        numbersets.add(new number_set("four","oyyisa",R.drawable.number_four,R.raw.number_four));
        numbersets.add(new number_set("five","masokka",R.drawable.number_five,R.raw.number_five));
        numbersets.add(new number_set("six","temokka",R.drawable.number_six,R.raw.number_six));
        numbersets.add(new number_set("seven","kanekaku",R.drawable.number_seven,R.raw.number_seven));
        numbersets.add(new number_set("eight","kawainta",R.drawable.number_eight,R.raw.number_eight));
        numbersets.add(new number_set("nine","wo'e",R.drawable.number_nine,R.raw.number_nine));
        numbersets.add(new number_set("ten","na'accha",R.drawable.number_ten,R.raw.number_ten));
        WordAdapter adapter = new WordAdapter(this, numbersets,R.color.category_numbers);
        ListView list = findViewById(R.id.list);
        list.setAdapter(adapter);
        list.setOnItemClickListener((parent, view, position, id) -> {
            number_set numAudio = numbersets.get(position);
            releaseMediaPlayer();
            int result = mAudioManager.requestAudioFocus(mOnAudioChangeListener, AudioManager.STREAM_MUSIC,AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
            if(result==AudioManager.AUDIOFOCUS_REQUEST_GRANTED){
                mMediaPlayer = MediaPlayer.create(Numbers.this,numAudio.getAudioResourceId());
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