package com.bignerdranch.android.triplogger;

import java.util.UUID;

/**
 * Created by harpreet multani on 31/10/2016.
 */
public class Setting {
    private UUID mID;
    private String mName;
    private String mGender;
    private String mEmail;
    private String mComment;
    private String mSID;


    public Setting() {
        this(UUID.randomUUID());

    }
    public Setting(UUID id) {
        mID = id;
    }
    public UUID getID(){
        return mID;
    }

    public void setID(UUID ID){
        mID = ID;
    }

    public String getName(){
        return mName;
    }
    public void setName(String name) {
        mName = name;
    }
    public String getGender(){
        return mGender;
    }
    public void setGender(String gender){
        mGender = gender;
    }
    public String getEmail(){
        return mEmail;
    }
    public void setEmail(String email){
        mEmail = email;
    }
    public String getComment(){
        return mComment;
    }
    public void setComment(String comment){
        mComment = comment;
    }
    public String getSID(){
        return mSID;
    }
    public void setSID(String sid){
        mSID = sid;
    }



}
