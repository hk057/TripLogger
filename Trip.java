package com.bignerdranch.android.triplogger;

import java.util.Date;
import java.util.UUID;

/**
 * Created by harpreet multani on 31/10/2016.
 */
public class Trip {
    private UUID mId;
    private String mTitle;
    private Date mDate;
    private String mDestination;
    private String mTripType;
    private String mDuration;
    private String mComment;


    public Trip() {             // Constructor
        // Generate unique identifier
        this(UUID.randomUUID());

    }

    public Trip(UUID id) {
        mId = id;
        mDate = new Date();
    }

    public UUID getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {      // Initialise the title
        mTitle = title;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }


    public String getDestination() {
        return mDestination;

    }

    public void setDestination(String destination) {
        mDestination = destination;
    }

    public String getTripType() {
        return mTripType;

    }

    public void setTripType(String triptype) {
        mTripType = triptype;
    }

    public String getDuration() {
        return mDuration;

    }

    public void setDuration(String duration) {
        mDuration = duration;
    }

    public String getComment() {
        return mComment;

    }

    public void setComment(String comment) {
        mComment = comment;
    }






    public String getPhotoFilename() {
        return "IMG_" + getId().toString() + ".jpg";
    }

    public void setId(UUID Id

    ) {
        mId = Id;
    }

}

