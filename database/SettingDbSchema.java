package com.bignerdranch.android.triplogger.database;

/**
 * Created by harpreet multani on 31/10/2016.
 */
public class SettingDbSchema {
    public static final class SettingTable {
        public static final String NAME = "settings";

        public static final class Cols {
            public static final String ID = "settingId";
            public static final String NAME = "name";
            public static final String GENDER = "gender";
            public static final String EMAIL = "email";
            public static final String COMMENT = "comment";
            public static final String SID = "sid";

        }
    }



}
