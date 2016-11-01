package com.bignerdranch.android.triplogger.database;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.bignerdranch.android.triplogger.Trip;

import java.util.Date;
import java.util.UUID;

/**
 * Created by harpreet multani on 31/10/2016.
 */
public class TripCursorWrapper extends CursorWrapper {
    public TripCursorWrapper(Cursor cursor) {
        super(cursor);
    }
    public Trip getTrip(){
        String uuidString = getString(getColumnIndex(TripDbSchema.TripTable.Cols.UUID));
        String title = getString(getColumnIndex(TripDbSchema.TripTable.Cols.TITLE));
        long date = getLong(getColumnIndex(TripDbSchema.TripTable.Cols.DATE));
        String destination = getString(getColumnIndex(TripDbSchema.TripTable.Cols.DESTINATION));
        String trip_type = getString(getColumnIndex(TripDbSchema.TripTable.Cols.TRIPTYPE));
        String duration = getString(getColumnIndex(TripDbSchema.TripTable.Cols.DURATION));
        String comment = getString(getColumnIndex(TripDbSchema.TripTable.Cols.COMMENT));


        Trip trip = new Trip(UUID.fromString(uuidString));
        trip.setTitle(title);
        trip.setDate(new Date(date));
        trip.setDestination(destination);
        trip.setTripType(trip_type);
        trip.setDuration(duration);
        trip.setComment(comment);


        return trip;
    }

}
