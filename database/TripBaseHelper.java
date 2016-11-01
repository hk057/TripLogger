package com.bignerdranch.android.triplogger.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by harpreet multani on 31/10/2016.
 */
public class TripBaseHelper  extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "tripBase.db";

    public TripBaseHelper (Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table " + TripDbSchema.TripTable.NAME + "(" +
                " _id integer primary key autoincrement, " +
                TripDbSchema.TripTable.Cols.UUID + ", " +
                TripDbSchema.TripTable.Cols.TITLE + ", " +
                TripDbSchema.TripTable.Cols.DATE + ", " +
                TripDbSchema.TripTable.Cols.DESTINATION + ", " +
                TripDbSchema.TripTable.Cols.TRIPTYPE + ", " +
                TripDbSchema.TripTable.Cols.DURATION + ", " +
                TripDbSchema.TripTable.Cols.COMMENT +
                ")"

        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

    }
}
