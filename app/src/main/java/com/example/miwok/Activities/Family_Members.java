package com.example.miwok.Activities;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.miwok.Adapter.MembersAdapter;
import com.example.miwok.R;
import com.example.miwok.Setter.family_members_set;

import java.util.ArrayList;

public class Family_Members extends AppCompatActivity {
    private MediaPlayer mMediaPlayer;
    private AudioManager mAudioManager;
    private final MediaPlayer.OnCompletionListener mOnCompletionListener = mediaPlayer -> releaseMediaPlayer();

    AudioManager.OnAudioFocusChangeListener mOnAudioChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if(focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK){
                mMediaPlayer.pause();
                mMediaPlayer.seekTo(0);
            }
            else if (focusChange == AudioManager.AUDIOFOCUS_GAIN){
                mMediaPlayer.start();
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                releaseMediaPlayer();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family_members);

        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        ArrayList<family_members_set> members = new ArrayList<>();
        members.add(new family_members_set("father","әpә",R.drawable.family_father,R.raw.family_father));
        members.add(new family_members_set("mother","әṭa",R.drawable.family_mother,R.raw.family_mother));
        members.add(new family_members_set("son","angsi",R.drawable.family_son,R.raw.family_son));
        members.add(new family_members_set("daughter","tune",R.drawable.family_daughter,R.raw.family_daughter));
        members.add(new family_members_set("older brother","taachi",R.drawable.family_older_brother,R.raw.family_older_brother));
        members.add(new family_members_set("younger brother","chalitti",R.drawable.family_younger_brother,R.raw.family_younger_brother));
        members.add(new family_members_set("older sister","teṭe",R.drawable.family_older_sister,R.raw.family_older_sister));
        members.add(new family_members_set("younger sister","kolliti",R.drawable.family_younger_sister,R.raw.family_younger_sister));
        members.add(new family_members_set("grandmother","ama",R.drawable.family_grandmother,R.raw.family_grandmother));
        members.add(new family_members_set("grandfather","paapa",R.drawable.family_grandfather,R.raw.family_grandfather));
        MembersAdapter adapter = new MembersAdapter(this,members,R.color.category_family_members);
        ListView list = findViewById(R.id.family);
        list.setAdapter(adapter);
        list.setOnItemClickListener((parent, view, position, id) -> {
            family_members_set familyAudio = members.get(position);
            releaseMediaPlayer();
            int result = mAudioManager.requestAudioFocus(mOnAudioChangeListener, AudioManager.STREAM_MUSIC,AudioManager.AUDIOFOCUS_GAIN);
            if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED){
                mMediaPlayer = MediaPlayer.create(Family_Members.this,familyAudio.getAudioResourceId());
                mMediaPlayer.start();
                mMediaPlayer.setOnCompletionListener(mOnCompletionListener);
            }

        });
    }
    @Override
    public void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }
    private void releaseMediaPlayer(){
        if (mMediaPlayer != null) {
            mMediaPlayer.release();
            mMediaPlayer = null;
        }
    }
}