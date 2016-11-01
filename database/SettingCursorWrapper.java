package com.bignerdranch.android.triplogger.database;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.bignerdranch.android.triplogger.Setting;

import java.util.UUID;

/**
 * Created by harpreet multani on 31/10/2016.
 */
public class SettingCursorWrapper extends CursorWrapper {
    public SettingCursorWrapper(Cursor cursor){
        super(cursor);
    }

    public Setting getSetting() {
        String uuidString = getString(getColumnIndex(SettingDbSchema.SettingTable.Cols.ID));
        String name = getString(getColumnIndex(SettingDbSchema.SettingTable.Cols.NAME));
        String sid = getString(getColumnIndex(SettingDbSchema.SettingTable.Cols.SID));
        String gender = getString(getColumnIndex(SettingDbSchema.SettingTable.Cols.GENDER));
        String email = getString(getColumnIndex(SettingDbSchema.SettingTable.Cols.EMAIL));
        String comment = getString(getColumnIndex(SettingDbSchema.SettingTable.Cols.COMMENT));

        Setting setting = new Setting(UUID.fromString(uuidString));
        setting.setName(name);
        setting.setGender(gender);
        setting.setEmail(email);
        setting.setComment(comment);
        setting.setSID(sid);

        return setting;
    }
}
