package com.bignerdranch.android.triplogger.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by harpreet multani on 31/10/2016.
 */
public class SettingBaseHelper  extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "settingBase.db";


    public SettingBaseHelper(Context context){
        super(context, DATABASE_NAME, null, VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table" + SettingDbSchema.SettingTable.NAME + " (" +
                "_id integer primary key autoincrement, " +
                SettingDbSchema.SettingTable.Cols.ID + ", " +
                SettingDbSchema.SettingTable.Cols.NAME + ", " +
                SettingDbSchema.SettingTable.Cols.GENDER + ", " +
                SettingDbSchema.SettingTable.Cols.EMAIL + ", " +
                SettingDbSchema.SettingTable.Cols.COMMENT + ", " +
                SettingDbSchema.SettingTable.Cols.SID +
                ")"
        );

        db.execSQL("insert into " + SettingDbSchema.SettingTable.NAME +
                // INSERT INTO SettingTable (SID,NAME,GENDER,EMAIL, COMMENT
                " VALUES (null, '98a6d06d-0675-4438-b982-5cd09ad8364a', 'har', '320', 'Female', 'har@gmail.com', 'nice')");


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

    }
}

