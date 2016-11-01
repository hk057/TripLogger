package com.bignerdranch.android.triplogger;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.bignerdranch.android.triplogger.database.SettingBaseHelper;
import com.bignerdranch.android.triplogger.database.SettingCursorWrapper;
import com.bignerdranch.android.triplogger.database.SettingDbSchema;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by harpreet multani on 31/10/2016.
 */
public class SettingLab {
    private static SettingLab sSettingLab;

    private List<Setting> mSettings;
    private Context mContext;
    private SQLiteDatabase mDatabase;

    public static SettingLab get(Context context) {
        if (sSettingLab == null){
            sSettingLab = new SettingLab(context);
        }
        return sSettingLab;
    }
    private SettingLab (Context context) {
        mContext = context.getApplicationContext();
        mDatabase = new SettingBaseHelper(mContext)
                .getWritableDatabase();


    }
    public List<Setting> getSettings(){
        List<Setting> settings = new ArrayList<>();

        SettingCursorWrapper cursor = querySettings(null, null);

        try {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                settings.add(cursor.getSetting());
                cursor.moveToNext();
            }
        } finally {
            cursor.close();

        }

        return settings;
    }
    public Setting getSetting() {
        SettingCursorWrapper cursor = querySettings(null, null);

        try {
            if (cursor.getCount() == 0) {
                return null;

            }
            cursor.moveToFirst();
            return cursor.getSetting();
        }
        finally {

            cursor.close();

        }
    }



    public void updateSetting(Setting setting){
        String uuid = setting.getID().toString();
        ContentValues values = getContentValues(setting);


        mDatabase.update(SettingDbSchema.SettingTable.NAME, values,
                SettingDbSchema.SettingTable.Cols.SID + " = ?",
                new String[] {uuid});
    }


    public void addSetting(Setting st) {
        ContentValues values = getContentValues(st);
        mDatabase.insert(SettingDbSchema.SettingTable.NAME,null, values);
    }

    private static ContentValues getContentValues(Setting setting) {
        ContentValues values = new ContentValues();

        values.put(SettingDbSchema.SettingTable.Cols.SID, setting.getSID().toString());
        values.put(SettingDbSchema.SettingTable.Cols.NAME, setting.getName());
        values.put(SettingDbSchema.SettingTable.Cols.ID, setting.getID().toString());
        values.put(SettingDbSchema.SettingTable.Cols.GENDER, setting.getGender());
        values.put(SettingDbSchema.SettingTable.Cols.EMAIL, setting.getEmail());
        values.put(SettingDbSchema.SettingTable.Cols.COMMENT, setting.getComment());

        return values;
    }

    private SettingCursorWrapper querySettings(String whereClause, String[] whereArgs) {
        Cursor cursor = mDatabase.query(
                SettingDbSchema.SettingTable.NAME,
                null,  // Columns - null selects all columns
                whereClause,
                whereArgs,
                null, // groupBy
                null, // having
                null // orederBy
        );


        return new SettingCursorWrapper(cursor);
    }


}
