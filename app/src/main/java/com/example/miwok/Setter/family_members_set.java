package com.example.miwok.Setter;

public class family_members_set {
    private  String mDefaultTranslation;
    private  String mMiwokTranslation;
    private int mImageResourceId;
    private int mAudioResiurceId;
    public family_members_set(String defaultTranslation, String miwokTranslation,int ImageResourceId, int AudioResourceId){
        mDefaultTranslation=defaultTranslation;
        mMiwokTranslation=miwokTranslation;
        mImageResourceId=ImageResourceId;
        mAudioResiurceId=AudioResourceId;
    }
    public String getDefaultTranslation(){
        return mDefaultTranslation;
    }
    public String getMiwokTranslation(){
        return mMiwokTranslation;
    }
    public int getmImageResourceId(){
        return  mImageResourceId;
    }
    public int getAudioResourceId(){
        return  mAudioResiurceId;
    }
}
