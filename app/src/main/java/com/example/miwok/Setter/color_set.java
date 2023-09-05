package com.example.miwok.Setter;

public class color_set { // create contact class
    private  String mDefaultTranslation; // take 2 values private line name and number
    private  String mMiwokTranslation;
    private int mImageResourceId;
    private int mAudioResourceId;
    public color_set(String defaultTranslation, String miwokTranslation){ // create a constructure and create getter methods
        mDefaultTranslation=defaultTranslation;
        mMiwokTranslation=miwokTranslation;
    }
    public color_set(String defaultTranslation, String miwokTranslation,int ImageResourceId, int AudioResourceId){
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
        return  mImageResourceId;
    }
    public int getAudioResourceId(){
        return  mAudioResourceId;
    }
}
