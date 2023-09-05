package com.example.miwok.Setter;

public class number_set {
    private  String mDefaultTranslation;
    private  String mMiwokTranslation;
    private int mAudioResourceId;

    private int mImageResourceId;

    public number_set(String defaultTranslation, String miwokTranslation,int ImageResourceId, int AudioResourceId){
        mDefaultTranslation=defaultTranslation;
        mMiwokTranslation=miwokTranslation;
        mImageResourceId=ImageResourceId;
        mAudioResourceId=AudioResourceId;
    }



    public String getDefaultTranslation(){
        return mDefaultTranslation;
    }
    public String getMiwokTranslation(){
        return mMiwokTranslation;
    }
    public int getmImageResourceId(){
        return mImageResourceId;
    }
    public int getAudioResourceId(){
        return mAudioResourceId;
    }

}
