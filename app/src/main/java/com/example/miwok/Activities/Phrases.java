package com.example.miwok.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.ListView;

import com.example.miwok.Adapter.PhraseAdapter;
import com.example.miwok.R;
import com.example.miwok.Setter.phrase_set;

import java.util.ArrayList;

public class Phrases extends AppCompatActivity {
    private MediaPlayer mMediaPlayer;
    private AudioManager mAudioManager;
    AudioManager.OnAudioFocusChangeListener mOnAudioChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if(focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK){
                mMediaPlayer.pause();
                mMediaPlayer.seekTo(0);
            }
            else if(focusChange == AudioManager.AUDIOFOCUS_LOSS){
                releaseMediaPlayer();
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                mMediaPlayer.start();
            }
        }
    };
    private final MediaPlayer.OnCompletionListener mOnCompletionListner = mediaPlayer -> releaseMediaPlayer();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phrases);
        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        ArrayList<phrase_set> phrase = new ArrayList<>();
        phrase.add(new phrase_set("Where are you going?","minto wuksus",R.raw.phrase_where_are_you_going));
        phrase.add(new phrase_set("What is your name?","tinnә oyaase'nә",R.raw.phrase_what_is_your_name));
        phrase.add(new phrase_set("My name is...","oyaaset...",R.raw.phrase_my_name_is));
        phrase.add(new phrase_set("How are you feeling?","michәksәs?",R.raw.phrase_how_are_you_feeling));
        phrase.add(new phrase_set("I’m feeling good.","kuchi achit",R.raw.phrase_im_feeling_good));
        phrase.add(new phrase_set("Are you coming?","әәnәs'aa?",R.raw.phrase_are_you_coming));
        phrase.add(new phrase_set("Yes, I’m coming.","hәә’ әәnәm",R.raw.phrase_yes_im_coming));
        phrase.add(new phrase_set("I’m coming.","әәnәm",R.raw.phrase_im_coming));
        phrase.add(new phrase_set("Let’s go.","yoowutis",R.raw.phrase_lets_go));
        phrase.add(new phrase_set("Come here.","әnni'nem",R.raw.phrase_come_here));
        PhraseAdapter adapter = new PhraseAdapter(this,phrase,R.color.category_phrases);
        ListView phrase_list = findViewById(R.id.phrase_list);
        phrase_list.setAdapter(adapter);
        phrase_list.setOnItemClickListener((parent, view, position, id) -> {
            phrase_set phraseAudio = phrase.get(position);
            releaseMediaPlayer();
            int result = mAudioManager.requestAudioFocus(mOnAudioChangeListener,AudioManager.STREAM_MUSIC,AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
            if(result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED){
                mMediaPlayer = MediaPlayer.create(Phrases.this,phraseAudio.getAudioResourceId());
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