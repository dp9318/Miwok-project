package com.example.miwok.Setter;

public class phrase_set {
    private  String mDefaultTranslation;
    private  String mMiwokTranslation;
    private int mAudioResourceId;
    public phrase_set(String defaultTranslation, String miwokTranslation,int AudioResourceId){
        mDefaultTranslation=defaultTranslation;
        mMiwokTranslation=miwokTranslation;
        mAudioResourceId=AudioResourceId;
    }
    public String getDefaultTranslation(){
        return mDefaultTranslation;
    }
    public String getMiwokTranslation(){
        return mMiwokTranslation;
    }
    public int getAudioResourceId(){
        return mAudioResourceId;
    }
}
